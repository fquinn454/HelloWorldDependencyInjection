public class HelloWorldDI {

    public static void main(String[] args) {
        MessageRenderer renderer = (MessageRenderer) MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider provider = (MessageProvider) MessageSupportFactory.getInstance().getMessageProvider();
        renderer.setMessageProvider(provider);
        renderer.render();

    }
}
