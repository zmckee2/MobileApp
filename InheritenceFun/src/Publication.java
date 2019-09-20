public abstract class Publication implements Comparable<Publication>{
    protected String title;
    protected String publisher;
    protected int numPages;
    protected double price;

    public Publication()
    {
        title = "NO_TITLE";
        publisher = "NO_PUBLISHER";
        numPages = -1;
        price = -1.0;
    }

    public Publication(String newTitle, String newPublisher, int newPages, double newPrice)
    {
        title = newTitle;
        publisher = newPublisher;
        numPages = newPages;
        price = newPrice;
    }

    @Override
    public String toString()
    {
        return "~~~~~\nTitle: " + title + "\nPublisher: " + publisher + "\nNumber of pages: " + numPages + "\nPrice: " + price;
    }

    @Override
    public int compareTo(Publication o) {
        int compTitles = this.title.compareTo(o.title);
        if (compTitles != 0)
            return compTitles;
        return this.publisher.compareTo(o.publisher);
    }

    public abstract String generateCopyright();
}
