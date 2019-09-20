public class BookTester {
    public static void main(String[] args) {
        Book book1 =  new Book();
        Book book2 = new Book(25,"Small Book","Crummy Author");
        System.out.println(book1);
        System.out.println(book2);
    }
}

