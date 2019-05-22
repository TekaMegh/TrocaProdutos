package chat;

import chat.Mensagem;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import produto_troca.ProdutoTroca;
import usuario.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-22T14:28:00")
@StaticMetamodel(Conversa.class)
public class Conversa_ { 

    public static volatile SingularAttribute<Conversa, Usuario> idUsuario1;
    public static volatile SingularAttribute<Conversa, Usuario> idUsuario2;
    public static volatile SingularAttribute<Conversa, ProdutoTroca> idProduto;
    public static volatile CollectionAttribute<Conversa, Mensagem> mensagemCollection;
    public static volatile SingularAttribute<Conversa, Integer> id;

}