import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Store
        Store store = new Store();

        // Create Users
        User user1 = new User();
        user1.setUsername("Nawaf");
        user1.setEmail("nawaf@gmail.com");

        User user2 = new User();
        user2.setUsername("Husam");
        user2.setEmail("husam@outlook.com");

        store.addUser(user1);
        store.addUser(user2);

        // Create Media (Books, Movies, Music)
        Book book1 = new Book();
        book1.setTitle("Effective Java");
        book1.setAuteur("Joshua Bloch");
        book1.setISBN("9780134685991");
        book1.setPrice(45.0);
        book1.setStock(5);

        Book book2 = new Book();
        book2.setTitle("Clean Code");
        book2.setAuteur("Robert C. Martin");
        book2.setISBN("9780132350884");
        book2.setPrice(50.0);
        book2.setStock(3);

        Movie movie1 = new Movie();
        movie1.setTitle("Inception");
        movie1.setAuteur("Christopher Nolan");
        movie1.setISBN("MOVIE123");
        movie1.setPrice(20.0);
        movie1.setDuration(148);

        Movie movie2 = new Movie();
        movie2.setTitle("The Dark Knight");
        movie2.setAuteur("Christopher Nolan");
        movie2.setISBN("MOVIE456");
        movie2.setPrice(18.0);
        movie2.setDuration(152);

        Movie movie3 = new Movie();
        movie3.setTitle("Interstellar");
        movie3.setAuteur("Christopher Nolan");
        movie3.setISBN("MOVIE789");
        movie3.setPrice(25.0);
        movie3.setDuration(169);

        Music music1 = new Music();
        music1.setTitle("Thriller");
        music1.setArtist("Michael Jackson");
        music1.setISBN("MJTHRILLER1982");
        music1.setPrice(12.0);

        Music music2 = new Music();
        music2.setTitle("Beat It");
        music2.setArtist("Michael Jackson");
        music2.setISBN("MJBEATIT1982");
        music2.setPrice(10.0);

        Music music3 = new Music();
        music3.setTitle("Billie Jean");
        music3.setArtist("Michael Jackson");
        music3.setISBN("MJBILLIEJEAN1982");
        music3.setPrice(11.0);

        // Add Media to Store
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(movie1);
        store.addMedia(movie2);
        store.addMedia(movie3);
        store.addMedia(music1);
        store.addMedia(music2);
        store.addMedia(music3);

        // User 1: Adds to cart, checks out, and leaves reviews
        user1.addToCart(book1);
        user1.addToCart(movie1);
        user1.checkOut();
        System.out.println("User 1 purchases:");
        displayMediaList(user1.getPurchaseMediaList());

        // User 1 leaves reviews for books
        Review review1 = new Review();
        review1.setUsername("Nawaf");
        review1.setRating(5.0);
        review1.setComment("An essential guide for Java developers!");
        book1.addReview(review1);

        Review review2 = new Review();
        review2.setUsername("Nawaf");
        review2.setRating(4.5);
        review2.setComment("Very practical, easy to follow.");
        book2.addReview(review2);

        System.out.println("\nReviews for 'Effective Java':\n" + formatReviews(book1.getReview()));
        System.out.println("Average Rating for 'Effective Java': " + book1.getAverageRating());
        System.out.println("Is 'Effective Java' a bestseller? " + (book1.isBestSeller() ? "Yes" : "No"));

        System.out.println("\nReviews for 'Clean Code':\n" + formatReviews(book2.getReview()));
        System.out.println("Average Rating for 'Clean Code': " + book2.getAverageRating());
        System.out.println("Is 'Clean Code' a bestseller? " + (book2.isBestSeller() ? "Yes" : "No"));

        System.out.println("---------------------------------");

        // User 2: Adds a music item and checks out
        user2.addToCart(music1);
        user2.checkOut();
        System.out.println("User 2 purchases:");
        displayMediaList(user2.getPurchaseMediaList());

        // Display all media in the store
        System.out.println("\nAvailable Media in Store:");
        displayMediaList(store.getMedia());

        // Searching for a book by title
        String searchTitle = "Effective Java";
        Media foundMedia = store.searchBook(searchTitle);
        if (foundMedia != null) {
            System.out.println("\nSearch result for '" + searchTitle + "':");
            System.out.println(foundMedia.toString());
        } else {
            System.out.println("\n'" + searchTitle + "' not found in store.");
        }

        // Recommend similar movies based on auteur
        System.out.println("\nSimilar movies to 'Inception':");
        List<Movie> movieCatalog = new ArrayList<>();
        movieCatalog.add(movie1);
        movieCatalog.add(movie2);
        movieCatalog.add(movie3);
        List<Movie> similarMovies = movie1.recommendSimilarMovies(movieCatalog);
        displayMediaList(similarMovies);

        // Generate playlist of similar music
        System.out.println("\nPlaylist similar to 'Thriller':");
        List<Music> musicCatalog = new ArrayList<>();
        musicCatalog.add(music1);
        musicCatalog.add(music2);
        musicCatalog.add(music3);
        List<Music> playlist = music1.generatePlayList(musicCatalog);
        displayMediaList(playlist);
    }

    // Helper method to display a list of media
    private static void displayMediaList(List<? extends Media> mediaList) {
        for (Media media : mediaList) {
            System.out.println(media);
            System.out.println("---------------------------------");
        }
    }

    // Helper method to format and display reviews
    private static String formatReviews(ArrayList<Review> reviews) {
        String formattedReviews = "";
        for (Review review : reviews) {
            formattedReviews += "User: " + review.getUsername() + "\n";
            formattedReviews += "Rating: " + review.getRating() + "\n";
            formattedReviews += "Comment: " + review.getComment() + "\n";
            formattedReviews += "-------------------------\n";
        }
        return formattedReviews;
    }
}
