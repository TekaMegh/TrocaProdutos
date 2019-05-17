/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import chat.ChatFachada;
import chat.Conversa;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author raquel
 */
@ManagedBean
@SessionScoped
public class ChatBean {
    @EJB
    private ChatFachada chatFachada;

    /**
     * Creates a new instance of ChatBean
     */
    public ChatBean() {
    }
    
    public List<Conversa> getListaConversas() {
        return chatFachada.getListaConversas();
    }
}
