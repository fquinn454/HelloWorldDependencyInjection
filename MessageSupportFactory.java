import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties props;
    private MessageProvider provider;
    private MessageRenderer renderer;

    private MessageSupportFactory(){
        final String file = "helloWorldDi/resources/hello.properties";

        final Properties props = new Properties();
        try{
            props.load(Files.newInputStream(Paths.get(file)));
            final String rendererClass = props.getProperty("renderer.class");
            final String providerClass = props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static{
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public Renderer getMessageRenderer(){
        return renderer;
    }

    public Provider getMessageProvider(){
        return provider;
    }
}
