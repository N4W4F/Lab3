public class AcademicBook extends Book {

    private String subject;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String getMediaType() {
        if (getAverageRating() >= 4.5)
            return "Bestselling AcademicBook";
        return "AcademicBook";
    }

    public String toString() {
        return super.toString() + "\nSubject: " + getSubject() +
                "\nMedia Type: " + getMediaType();
    }
}
