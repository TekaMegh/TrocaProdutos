package chat;

import chat.Conversa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import usuario.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-22T18:22:04")
@StaticMetamodel(Mensagem.class)
public class Mensagem_ { 

    public static volatile SingularAttribute<Mensagem, String> texto;
    public static volatile SingularAttribute<Mensagem, Usuario> idUsuario;
    public static volatile SingularAttribute<Mensagem, Conversa> idConversa;
    public static volatile SingularAttribute<Mensagem, Integer> id;
    public static volatile SingularAttribute<Mensagem, Date> dataEnvio;

}