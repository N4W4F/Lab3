public class Novel extends Book {

    private String genre;

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String getMediaType() {
        if (getAverageRating() >= 4.5)
            return "Bestselling Novel";
        return "Novel";
    }

    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + getGenre() +
                "\nMedia Type: " + getMediaType();
    }

}
