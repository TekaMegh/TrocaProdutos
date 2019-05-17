/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import usuario.Usuario;

/**
 *
 * @author raquel
 */
@Entity
@Table(name = "MENSAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagem.findAll", query = "SELECT m FROM Mensagem m"),
    @NamedQuery(name = "Mensagem.findById", query = "SELECT m FROM Mensagem m WHERE m.id = :id"),
    @NamedQuery(name = "Mensagem.findByTexto", query = "SELECT m FROM Mensagem m WHERE m.texto = :texto"),
    @NamedQuery(name = "Mensagem.findByDataEnvio", query = "SELECT m FROM Mensagem m WHERE m.dataEnvio = :dataEnvio")})
public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TEXTO")
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_ENVIO")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;
    @JoinColumn(name = "ID_CONVERSA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Conversa idConversa;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Mensagem() {
    }

    public Mensagem(Integer id) {
        this.id = id;
    }

    public Mensagem(Integer id, String texto, Date dataEnvio) {
        this.id = id;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Conversa getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Conversa idConversa) {
        this.idConversa = idConversa;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Mensagem)) {
            return false;
        }
        Mensagem other = (Mensagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chat.Mensagem[ id=" + id + " ]";
    }
    
}
