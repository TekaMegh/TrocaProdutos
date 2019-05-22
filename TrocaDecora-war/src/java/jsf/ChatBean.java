/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import chat.ChatFachada;
import chat.Conversa;
import chat.Mensagem;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import produto_troca.ProdutoTroca;
import usuario.Usuario;

/**
 *
 * @author raquel
 */
@ManagedBean
@SessionScoped
public class ChatBean {

    @EJB
    private ChatFachada chatFachada;

    private Conversa novaConversa;
    private String novaMensagem = "";

    /**
     * Creates a new instance of ChatBean
     */
    public ChatBean() {
    }

    public List<Conversa> getListaConversas() {
        return chatFachada.getListaConversas();
    }

    public String conversasRedirect() throws IOException {
        return "/chat/conversas.xhtml?faces-redirect=true";
    }

    public String getNovaMensagem() {
        return novaMensagem;
    }

    public void setNovaMensagem(String novaMensagem) {
        this.novaMensagem = novaMensagem;
    }

    public String criarNovaConversa(Usuario user1, Usuario user2, ProdutoTroca produto) {
        novaConversa = new Conversa();
        novaConversa.setIdUsuario1(user1);
        novaConversa.setIdUsuario2(user2);
        novaConversa.setIdProduto(produto);
        Conversa conversa = chatFachada.findConversa(novaConversa.getIdUsuario1(), novaConversa.getIdUsuario2(), novaConversa.getIdProduto());
        if (conversa == null) {
            if (novaConversa.getIdUsuario1() != null) {
                save();
                return "/chat/chat.xhtml?faces-redirect=true";
            }
        } else {
            novaConversa = conversa;
            return "/chat/chat.xhtml?faces-redirect=true";
        }
        return "";
    }
    
    public void enviaMsg(){
        Mensagem mensagem = new Mensagem();
        mensagem.setTexto(novaMensagem);
        mensagem.setIdUsuario(novaConversa.getIdUsuario1());
        mensagem.setIdConversa(novaConversa);
        mensagem.setDataEnvio(new Date());
        novaConversa.adicionaMensagem(mensagem);
    }

    public void save() {
        try {
            novaConversa.setId(chatFachada.getIdUltimaConversa() + 1);
            chatFachada.persist(novaConversa);
        } catch (EJBException e) {
            FacesContext.getCurrentInstance().addMessage("clientId", new FacesMessage("Erro ao iniciar conversa"));
        }
    }

    public Conversa getNovaConversa() {
        return novaConversa;
    }

    public void setNovaConversa(Conversa novaConversa) {
        this.novaConversa = novaConversa;
    }
}
