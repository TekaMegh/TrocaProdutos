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
        Query query = em.createNamedQuery("Conversas.findAll");
        return query.getResultList();
    }
}
