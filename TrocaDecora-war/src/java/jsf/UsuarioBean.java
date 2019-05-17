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
import usuario.Usuario;
import usuario.UsuarioFachada;

/**
 *
 * @author raquel
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    @EJB
    private UsuarioFachada usuarioFachada;
    
    private Usuario logado;
    private Usuario novo;
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public List<Usuario> getListaUsuarios() {
        return usuarioFachada.getListaUsuarios();
    }
    
    public void logout() {
        this.logado = new Usuario();
    }

    public Usuario getLogado() {
        return logado;
    }

    public void setLogado(Usuario logado) {
        this.logado = logado;
    }

    public Usuario getNovo() {
        return novo;
    }

    public void setNovo(Usuario novo) {
        this.novo = novo;
    }
}
