/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produto_troca;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author raquel
 */
@Stateless
@LocalBean
public class ProdutoFachada {
    @PersistenceContext(unitName = "TrocaDecora-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    // Metodo que retorna a lista de Produtos armazenada na tabela Produto_Troca
    public List<produto_troca.ProdutoTroca> getListaProdutosTroca() {
        Query query = em.createNamedQuery("ProdutoTroca.findAll");
        return query.getResultList();
    }
    
    public List<produto_troca.ProdutoTroca> getProdutosByNome(String nome) {
        nome = "%"+nome+"%";
        Query query = em.createNamedQuery("ProdutoTroca.findByNome").setParameter("nome", nome);
        return query.getResultList();
    }
}
