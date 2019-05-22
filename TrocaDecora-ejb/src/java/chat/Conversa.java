/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import produto_troca.ProdutoTroca;
import usuario.Usuario;

/**
 *
 * @author raquel
 */
@Entity
@Table(name = "CONVERSA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversa.findAll", query = "SELECT c FROM Conversa c"),
    @NamedQuery(name = "Conversa.findByUser1User2AndProduto", query = "SELECT c FROM Conversa c WHERE c.idUsuario1 = :user1 AND c.idUsuario2 = :user2 AND c.idProduto = :produto"),
    @NamedQuery(name = "Conversa.findDesc", query = "SELECT c FROM Conversa c ORDER BY c.id desc"),
    @NamedQuery(name = "Conversa.findById", query = "SELECT c FROM Conversa c WHERE c.id = :id")})
public class Conversa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConversa")
    private Collection<Mensagem> mensagemCollection;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoTroca idProduto;
    @JoinColumn(name = "ID_USUARIO_2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario2;
    @JoinColumn(name = "ID_USUARIO_1", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario1;

    public Conversa() {
    }

    public Conversa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Mensagem> getMensagemCollection() {
        return mensagemCollection;
    }

    public void setMensagemCollection(Collection<Mensagem> mensagemCollection) {
        this.mensagemCollection = mensagemCollection;
    }

    public ProdutoTroca getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(ProdutoTroca idProduto) {
        this.idProduto = idProduto;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversa)) {
            return false;
        }
        Conversa other = (Conversa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chat.Conversa[ id=" + id + " ]";
    }
    
}
