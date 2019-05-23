/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produto_troca;

import chat.Conversa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import usuario.Usuario;

/**
 *
 * @author raquel
 */
@Entity
@Table(name = "PRODUTO_TROCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoTroca.findAll", query = "SELECT p FROM ProdutoTroca p order by p.id desc"),
    @NamedQuery(name = "ProdutoTroca.findById", query = "SELECT p FROM ProdutoTroca p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutoTroca.findByDataCriacao", query = "SELECT p FROM ProdutoTroca p WHERE p.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "ProdutoTroca.findByNome", query = "SELECT p FROM ProdutoTroca p WHERE upper(p.nome) like upper(:nome) and p.idUsuario.id != :idLogado"),
    @NamedQuery(name = "ProdutoTroca.findByCategoria", query = "SELECT p FROM ProdutoTroca p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "ProdutoTroca.findByPeso", query = "SELECT p FROM ProdutoTroca p WHERE p.peso = :peso"),
    @NamedQuery(name = "ProdutoTroca.findByAltura", query = "SELECT p FROM ProdutoTroca p WHERE p.altura = :altura"),
    @NamedQuery(name = "ProdutoTroca.findByLargura", query = "SELECT p FROM ProdutoTroca p WHERE p.largura = :largura"),
    @NamedQuery(name = "ProdutoTroca.findByProfundidade", query = "SELECT p FROM ProdutoTroca p WHERE p.profundidade = :profundidade"),
    @NamedQuery(name = "ProdutoTroca.findByMaterial", query = "SELECT p FROM ProdutoTroca p WHERE p.material = :material"),
    @NamedQuery(name = "ProdutoTroca.findByCor", query = "SELECT p FROM ProdutoTroca p WHERE p.cor = :cor"),
    @NamedQuery(name = "ProdutoTroca.findByMarca", query = "SELECT p FROM ProdutoTroca p WHERE p.marca = :marca"),
    @NamedQuery(name = "ProdutoTroca.findByEstado", query = "SELECT p FROM ProdutoTroca p WHERE p.estado = :estado"),
    @NamedQuery(name = "ProdutoTroca.findByObservacoes", query = "SELECT p FROM ProdutoTroca p WHERE p.observacoes = :observacoes"),
    @NamedQuery(name = "ProdutoTroca.findByProdutosDesejados", query = "SELECT p FROM ProdutoTroca p WHERE p.produtosDesejados = :produtosDesejados")})
public class ProdutoTroca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_CRIACAO")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CATEGORIA")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private BigDecimal peso;
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @Column(name = "PROFUNDIDADE")
    private BigDecimal profundidade;
    @Size(max = 200)
    @Column(name = "MATERIAL")
    private String material;
    @Size(max = 100)
    @Column(name = "COR")
    private String cor;
    @Size(max = 40)
    @Column(name = "MARCA")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 40)
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @Size(max = 400)
    @Column(name = "PRODUTOS_DESEJADOS")
    private String produtosDesejados;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public ProdutoTroca() {
    }

    public ProdutoTroca(Integer id) {
        this.id = id;
    }

    public ProdutoTroca(Integer id, Date dataCriacao, String nome, Serializable foto, String categoria, String estado) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
        this.foto = foto;
        this.categoria = categoria;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(BigDecimal profundidade) {
        this.profundidade = profundidade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getProdutosDesejados() {
        return produtosDesejados;
    }

    public void setProdutosDesejados(String produtosDesejados) {
        this.produtosDesejados = produtosDesejados;
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
        if (!(object instanceof ProdutoTroca)) {
            return false;
        }
        ProdutoTroca other = (ProdutoTroca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produto_troca.ProdutoTroca[ id=" + id + " ]";
    }
    
}
