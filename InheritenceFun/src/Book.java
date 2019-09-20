public class Book extends Publication {

    protected String author;
    public Book()
    {
        //super(); <- implicit
        author = "NO_AUTOR";
    }

    public  Book(String newAuthor)
    {
        author = newAuthor;
    }

    public Book(String newTitle, String newPublisher, int newPages, double newPrice, String newAuthor)
    {
        super(newTitle, newPublisher, newPages, newPrice);
        author = newAuthor;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nAuthor: " + author +  "\n~~~~~\n";
    }

    @Override
    public String generateCopyright()
    {
        return "--------\nPublisher: " + publisher + "\n--------";
    }
}
