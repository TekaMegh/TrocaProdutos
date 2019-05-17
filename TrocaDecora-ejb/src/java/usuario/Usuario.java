/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;

import chat.Conversa;
import chat.Mensagem;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import produto_troca.ProdutoTroca;

/**
 *
 * @author raquel
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "Usuario.findByCidade", query = "SELECT u FROM Usuario u WHERE u.cidade = :cidade"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByBairro", query = "SELECT u FROM Usuario u WHERE u.bairro = :bairro")})
public class Usuario implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Mensagem> mensagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario2")
    private Collection<Conversa> conversaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario1")
    private Collection<Conversa> conversaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<ProdutoTroca> produtoTrocaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SENHA")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "BAIRRO")
    private String bairro;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String senha, String email, String telefone, String cidade, String estado, String bairro) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuario.Usuario[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ProdutoTroca> getProdutoTrocaCollection() {
        return produtoTrocaCollection;
    }

    public void setProdutoTrocaCollection(Collection<ProdutoTroca> produtoTrocaCollection) {
        this.produtoTrocaCollection = produtoTrocaCollection;
    }

    @XmlTransient
    public Collection<Mensagem> getMensagemCollection() {
        return mensagemCollection;
    }

    public void setMensagemCollection(Collection<Mensagem> mensagemCollection) {
        this.mensagemCollection = mensagemCollection;
    }

    @XmlTransient
    public Collection<Conversa> getConversaCollection() {
        return conversaCollection;
    }

    public void setConversaCollection(Collection<Conversa> conversaCollection) {
        this.conversaCollection = conversaCollection;
    }

    @XmlTransient
    public Collection<Conversa> getConversaCollection1() {
        return conversaCollection1;
    }

    public void setConversaCollection1(Collection<Conversa> conversaCollection1) {
        this.conversaCollection1 = conversaCollection1;
    }
    
}
