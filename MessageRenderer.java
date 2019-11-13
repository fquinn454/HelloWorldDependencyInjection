public class MessageRenderer implements Renderer {
    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException();
        }
        System.out.println(messageProvider.getMessage());

    }
    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;

    }

}
