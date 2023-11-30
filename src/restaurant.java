import java.sql.Array;
import java.util.ArrayList;

public class restaurant {
    private String name;
    private String location;
    private ArrayList<String> cuisineTags;
    private int rating;

    public restaurant(String name, String location, ArrayList<String> cuisineTags, int rating) {
        this.name = name;
        this.location = location;
        this.cuisineTags = cuisineTags;
        this.rating = rating;
    }


}
