import java.util.ArrayList;
import java.util.List;

public class Music extends Media {

    private String artist;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void listen(User user) {
        user.addToCart(this);
        user.checkOut();
    }

    public ArrayList<Music> generatePlayList(List<Music> musicCatalog) {
        ArrayList<Music> generatedList = new ArrayList<Music>();
        for (Music music : musicCatalog)
            if (!music.equals(this) && music.getArtist().equals(this.getArtist()))
                generatedList.add(music);
        return generatedList;
    }

    @Override
    public String getMediaType() {
        if (getPrice() >= 10)
            return "Premium Music";
        return "Music";
    }

    @Override
    public String toString() {
        return super.toString() + "\nArtist: " + getArtist() +
                "\nMedia Type: " + getMediaType();
    }

}
