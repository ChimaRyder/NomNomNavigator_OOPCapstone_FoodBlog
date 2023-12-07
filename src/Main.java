import javax.swing.*;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    /*
    Purpose of this class is to create a singleton pattern for the RestaurantBlog Panel.
    That way, ArrayList restaurants and ListModel Titles are completely static without affecting
    the non-static fields of RestaurantBlog.

    Call getInstance() to change any values inside RestaurantBlog from here, such as setting the Model for RestaurantList.
    Since getInstance() only returns one instance of RestaurantBlog that is static, we can use our static fields here to
    change any values inside RestaurantBlog.

    This is necessary since GUI components cannot be static and fields like restaurants and Titles need to be global for
    the restaurantEditor to add new restaurants to the JList.
     */
    private static ArrayList<restaurant> restaurants;
    private static DefaultListModel<String> Titles;
    private static RestaurantBlog instance;

    public static void addRestaurant(restaurant e) {
        restaurants.add(e);
        Titles.addElement(e.toString());
        getInstance().getRestaurantList().setModel(Titles); //
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
