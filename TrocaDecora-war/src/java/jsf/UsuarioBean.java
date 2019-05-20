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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
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
    
    public String logout() {
        this.logado = new Usuario();
        return "/produto_troca/search.xhtml?faces-redirect=true";
    }
    
    public void login() {
        
    }

    public void save() {
        
    }
    
    public String cancelarRedirect() throws IOException {
        return "/produto_troca/search.xhtml?faces-redirect=true";
    }
    
    public String cadastrarRedirect() throws IOException {
        return "/usuario/create.xhtml?faces-redirect=true";
    }
    
    public String entrarRedirect() throws IOException {
        return "/usuario/login.xhtml?faces-redirect=true";
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
