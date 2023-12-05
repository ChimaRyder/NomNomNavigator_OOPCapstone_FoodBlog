import java.sql.Array;
import java.util.ArrayList;

public class restaurant {
    private String name;
    private String location;
    private ArrayList<String> cuisineTags;
    private int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getCuisineTags() {
        return cuisineTags;
    }

    public void setCuisineTags(ArrayList<String> cuisineTags) {
        this.cuisineTags = cuisineTags;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public restaurant(String name, String location, ArrayList<String> cuisineTags, int rating) {
        this.name = name;
        this.location = location;
        this.cuisineTags = cuisineTags;
        this.rating = rating;
    }

    String starRating() {
        String stars = "";

        for (int i = 0; i < 5; i++) {
            if (i <= getRating()) {
                stars = stars.concat("★");
            } else {
                stars = stars.concat("☆");
            }
        }

        return stars;
    }

    @Override
    public String toString() {
        return starRating() + " | " + getName();
    }
}
