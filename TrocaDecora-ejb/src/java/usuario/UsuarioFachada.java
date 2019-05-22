/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;

import java.sql.SQLIntegrityConstraintViolationException;
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
public class UsuarioFachada {
    @PersistenceContext(unitName = "TrocaDecora-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    // Metodo que retorna a lista de usuarios armazenada na tabela Usuario
    public List<usuario.Usuario> getListaUsuarios() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }
    
    public Integer getIdUltimoUsuario() {
        List<Usuario> usuarios = em.createNamedQuery("Usuario.findDesc").getResultList();
        if(usuarios.isEmpty()) {
            return 1;
        } else {
            return usuarios.get(0).getId();
        }
    }
    
    public Usuario findByEmailAndSenha(String email, String senha) {
        try {
            return (Usuario) em.createNamedQuery("Usuario.findByEmailAndSenha").setParameter("email", email).setParameter("senha", senha).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
}
