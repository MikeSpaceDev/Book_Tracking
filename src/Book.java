public class Book {
    private final String name;
    private final String author;
    private final String genre;
    private final int year;
    private int id;



    public Book(String name, String author, String genre, int year){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public Book(String name, String author, String genre, int year, int id){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
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

    public int getID() {
        return id;
    }
}
