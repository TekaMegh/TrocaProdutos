/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import produto_troca.ProdutoFachada;
import produto_troca.ProdutoTroca;
import usuario.Usuario;

/**
 *
 * @author raquel
 */
@ManagedBean
@SessionScoped
public class ProdutoTrocaBean {
    @EJB
    private ProdutoFachada produtoFachada;

    private ProdutoTroca produtoTroca;
    private List<ProdutoTroca> produtos;
    private String filtro;
    
    /**
     * Creates a new instance of ProdutoTrocaBean
     */
    public ProdutoTrocaBean() {
    }
    
    public List<ProdutoTroca> getListaProdutos() {
        return produtoFachada.getListaProdutosTroca();
    }
    
    public void search() {
        //produtos = produtoFachada.getProdutosByDescricao(filtro);
    }
    
    public void solicitarTroca() {
        
    }

    public void save(Usuario logado) {
        try {
            produtoTroca.setId(produtoFachada.getIdUltimoProduto()+1);
            produtoTroca.setDataCriacao(new Date());
            produtoTroca.setIdUsuario(logado);
            produtoFachada.persist(produtoTroca);
            produtoTroca = new ProdutoTroca();
            FacesContext.getCurrentInstance().addMessage("clientId",  new FacesMessage("Produto cadastrado com sucesso!"));
        } catch (EJBException e) {
            FacesContext.getCurrentInstance().addMessage("clientId",  new FacesMessage("Falha no cadastro!"));
        }
    }
    
    public String cadastrarRedirect() throws IOException {
        produtoTroca = new ProdutoTroca();
        return "/produto_troca/create.xhtml?faces-redirect=true";
    }
    
    public ProdutoTroca getProdutoTroca() {
        return produtoTroca;
    }

    public void setProdutoTroca(ProdutoTroca produtoTroca) {
        this.produtoTroca = produtoTroca;
    }

    public List<ProdutoTroca> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoTroca> produtos) {
        this.produtos = produtos;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
