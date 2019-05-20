package usuario;

import chat.Conversa;
import chat.Mensagem;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import produto_troca.ProdutoTroca;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-20T15:16:31")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, String> telefone;
    public static volatile SingularAttribute<Usuario, String> cidade;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile CollectionAttribute<Usuario, ProdutoTroca> produtoTrocaCollection;
    public static volatile CollectionAttribute<Usuario, Conversa> conversaCollection;
    public static volatile SingularAttribute<Usuario, String> bairro;
    public static volatile CollectionAttribute<Usuario, Mensagem> mensagemCollection;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile CollectionAttribute<Usuario, Conversa> conversaCollection1;
    public static volatile SingularAttribute<Usuario, String> email;

}