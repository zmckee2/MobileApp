package com.example.adapterviewfun;

public class Book {
    // collection of state and behavior that describe something
    private int numPages;
    private String title;
    private String author;

    // default value constructor (DVC): the one created by default
    // defining a new constructor overrides the default one

    public Book()
    {
        numPages = -1;
        title = "BLANK";
        author = "BLANK";
    }

    public Book(int paramNumPages, String paramTitle, String paramAuthor)
    {
        title = paramTitle;
        numPages = paramNumPages;
        author = paramAuthor;
    }


    public void setAuthor(String newAuthor)
    {
        author = newAuthor;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public String getTitle()
    {
        return title;
    }

    public void setNumPages(int newNumPages)
    {
        numPages = newNumPages;
    }

    public int getNumPages()
    {
        return numPages;
    }
    //Annotations (@Override @Depricated @SuppressWarnings)
    //Purely metadata that only helps readability and IDE

    @Override // <-- for fancy coders
    public String toString()
    {
        return "Title: " + title + "\nAuthor: " +  author + "\nNumber of pages: " + numPages + "\n~~~~~~~~~~";
    }
}
