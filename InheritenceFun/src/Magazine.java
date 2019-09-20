public class Magazine extends Publication {

    protected String pubFreq;

    public Magazine()
    {
        pubFreq = "NEVER";
    }

    public Magazine(String newTitle, String newPublisher, int newPages, double newPrice, String newFreq) {
        super(newTitle, newPublisher, newPages, newPrice);
        pubFreq = newFreq;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPublication Freqency: " + pubFreq + "\n~~~~~\n";
    }

    @Override
    public String generateCopyright() {
        return "Here's a magazine copyright";
    }
}
