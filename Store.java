import java.util.ArrayList;

public class Store {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Media> media = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayUsers() {
        for (User u : users)
            System.out.println(u);
    }

    public void addMedia(Media media) {
        this.media.add(media);
    }

    public void displayMedia() {
        for (Media m : media)
            System.out.println(m);
    }

    public Media searchBook(String title) {
        for (Media m : media)
            if (m.getTitle().equalsIgnoreCase(title))
                return m;
        return null;
    }
}
