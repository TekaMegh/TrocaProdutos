package produto_troca;

import chat.Conversa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import usuario.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-22T14:28:00")
@StaticMetamodel(ProdutoTroca.class)
public class ProdutoTroca_ { 

    public static volatile SingularAttribute<ProdutoTroca, String> estado;
    public static volatile SingularAttribute<ProdutoTroca, BigDecimal> largura;
    public static volatile SingularAttribute<ProdutoTroca, BigDecimal> peso;
    public static volatile SingularAttribute<ProdutoTroca, String> produtosDesejados;
    public static volatile SingularAttribute<ProdutoTroca, String> categoria;
    public static volatile SingularAttribute<ProdutoTroca, String> cor;
    public static volatile SingularAttribute<ProdutoTroca, Usuario> idUsuario;
    public static volatile SingularAttribute<ProdutoTroca, String> nome;
    public static volatile SingularAttribute<ProdutoTroca, BigDecimal> profundidade;
    public static volatile SingularAttribute<ProdutoTroca, String> marca;
    public static volatile SingularAttribute<ProdutoTroca, String> observacoes;
    public static volatile SingularAttribute<ProdutoTroca, Serializable> foto;
    public static volatile SingularAttribute<ProdutoTroca, String> material;
    public static volatile CollectionAttribute<ProdutoTroca, Conversa> conversaCollection;
    public static volatile SingularAttribute<ProdutoTroca, BigDecimal> altura;
    public static volatile SingularAttribute<ProdutoTroca, Integer> id;
    public static volatile SingularAttribute<ProdutoTroca, Date> dataCriacao;

}