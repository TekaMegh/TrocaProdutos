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
    
    private List<Conversa> conversas;

    /**
     * Creates a new instance of ChatBean
     */
    public ChatBean() {
    }
    
    public List<Conversa> getListaConversas() {
        return chatFachada.getListaConversas();
    }

    public void initChat(Usuario logado) throws IOException {
        conversas = chatFachada.getConversasByUsuario(logado.getId());
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

    public String criarNovaConversa() {
        return criarNovaConversa(novaConversa.getIdUsuario1(), novaConversa.getIdUsuario2(), novaConversa.getIdProduto());
    }
    
    public String criarNovaConversa(Usuario user1, Usuario user2, ProdutoTroca produto) {
        novaMensagem = null;
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
    
    public void enviaMsg(Usuario logado){
        Mensagem mensagem = new Mensagem();
        mensagem.setTexto(novaMensagem);
        mensagem.setIdUsuario(logado);
        mensagem.setIdConversa(novaConversa);
        mensagem.setDataEnvio(new Date());
        mensagem.setId(chatFachada.getIdUltimaMensagem() +1);
        novaConversa.adicionaMensagem(mensagem);
        chatFachada.merge(novaConversa);
        novaMensagem = null;
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

    public List<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }
}
