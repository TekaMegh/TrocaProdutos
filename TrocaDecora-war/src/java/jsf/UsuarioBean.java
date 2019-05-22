/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.primefaces.context.RequestContext;
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
        this.logado = null;
        return "/produto_troca/search.xhtml?faces-redirect=true";
    }
    
    public String login() {
        logado = usuarioFachada.findByEmailAndSenha(logado.getEmail(), logado.getSenha());
        if(logado == null) {            
            return "/usuario/login.xhtml?faces-redirect=true";
        } else {
            return "/produto_troca/search.xhtml?faces-redirect=true";
        }
    }

    public void save() {
        try {
            novo.setId(usuarioFachada.getIdUltimoUsuario()+1);
            usuarioFachada.persist(novo);
            novo = new Usuario();
            FacesContext.getCurrentInstance().addMessage("clientId",  new FacesMessage("Usuário cadastrado com sucesso!"));
        } catch (EJBException e) {
            FacesContext.getCurrentInstance().addMessage("clientId",  new FacesMessage("Falha no cadastro! Email já cadastrado!"));
        }
    }
    
    public String cancelarRedirect() throws IOException {
        return "/produto_troca/search.xhtml?faces-redirect=true";
    }
    
    public String cadastrarRedirect() throws IOException {
        this.novo = new Usuario();
        return "/usuario/create.xhtml?faces-redirect=true";
    }
    
    public String entrarRedirect() throws IOException {
        logado = new Usuario();
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
