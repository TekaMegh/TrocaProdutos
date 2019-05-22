/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import produto_troca.ProdutoFachada;
import produto_troca.ProdutoTroca;

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
        produtos = produtoFachada.getListaProdutosTroca();
        return produtos;
    }
    
    public void search() {
        produtos = produtoFachada.getProdutosByNome(filtro);
    }
    
    public void solicitarTroca() {
        
    }

    public void save() {
        
    }
    
    public String cadastrarRedirect() throws IOException {
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
