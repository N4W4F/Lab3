import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book extends Media {

    private double stock;
    private ArrayList<Review> reviews = new ArrayList<>();

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getStock() {
        return stock;
    }

    public ArrayList<Review> getReview() {
        return reviews;
    }

    public String reviewToString() {
        String reviewString = "";
        //
        return ArrayList.toString(reviews);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        double sum = 0;
        for (Review review : reviews)
            sum += review.getRating();
        return sum / reviews.size();
    }

    public void purchase(User user) {
        if (stock > 0) {
            stock--;
            user.getPurchaseMediaList().add(this); // Add directly to purchased list
        } else {
            System.out.println("Out of stock");
        }
    }

    public boolean isBestSeller() {
        return getAverageRating() >= 4.5;
    }

    public void restock(int quantity) {
        stock += quantity;
    }

    @Override
    public String getMediaType() {
        if (isBestSeller())
            return "Bestselling Book";
        return "Book";
    }

    @Override
    public String toString() {
        return super.toString() + "\nStock: " + getStock() +
                "\nReviews: " + reviewToString() + "\nMedia Type: " + getMediaType();
    }
}
