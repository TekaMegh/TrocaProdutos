/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import produto_troca.ProdutoTroca;
import usuario.Usuario;

/**
 *
 * @author raquel
 */
@Stateless
@LocalBean
public class ChatFachada {
    @PersistenceContext(unitName = "TrocaDecora-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    // Metodo que retorna a lista de conversa armazenada na tabela Conversas
    public List<chat.Conversa> getListaConversas() {
        Query query = em.createNamedQuery("Conversa.findAll");
        return query.getResultList();
    }
    
    public Conversa findConversa(Usuario user1, Usuario user2, ProdutoTroca produto) {
        try{
            return (Conversa) em.createNamedQuery("Conversa.findByUser1User2AndProduto").setParameter("user1", user1).setParameter("user2", user2).setParameter("produto", produto).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
    
    public Integer getIdUltimaConversa() {
        List<Conversa> conversas = em.createNamedQuery("Conversa.findDesc").getResultList();
        if(conversas.isEmpty()) {
            return 1;
        } else {
            return conversas.get(0).getId();
        }
    }
}
