/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

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

    /**
     * Creates a new instance of ProdutoTrocaBean
     */
    public ProdutoTrocaBean() {
    }
    
    public List<ProdutoTroca> getListaProdutos() {
        return produtoFachada.getListaProdutosTroca();
    }
}
