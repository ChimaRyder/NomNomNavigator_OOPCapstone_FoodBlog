import javax.swing.*;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    private static ArrayList<restaurant> restaurants;
    private static DefaultListModel<String> Titles;
    private static RestaurantBlog instance;

    public static void addRestaurant(restaurant e) {
        restaurants.add(e);
        Titles.addElement(e.toString());
        getInstance().getRestaurantList().setModel(Titles);
    }

    public Main() {

    }

    public static RestaurantBlog getInstance() {
        if (instance == null) {
            instance = new RestaurantBlog();
        }

        return instance;
    }

    public static void main(String[] args) {
        RestaurantBlog rb = getInstance();
        restaurants = new ArrayList<>();
        Titles = new DefaultListModel<>();

        rb.setContentPane(rb.mainPanel);
        rb.setSize(500,500);
        rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rb.setVisible(true);
        rb.setTitle("Restaurant Blog");

    }
}
