public class Book {
    private final String name;
    private final String author;
    private final String genre;
    private final int year;
    private static int IDcounter = 1;
    private final int ID;


    public Book(String name, String author, String genre, int year){
        this.ID = IDcounter;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        IDcounter++;
    }


    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }
}
