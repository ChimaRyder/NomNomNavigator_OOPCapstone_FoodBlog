import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    private static RestaurantBlog Restaurantblog;

    private static ArrayList<restaurant> restaurants;

    public static ArrayList<restaurant> getRestaurants() {

        return restaurants;
    }

    public static void setRestaurants(ArrayList<restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public static RestaurantBlog getInstance() {
        if (Restaurantblog == null) {
            Restaurantblog = new RestaurantBlog();
        }

        return Restaurantblog;
    }


    public static void main(String[] args) {
        RestaurantBlog rb = getInstance();

        rb.setContentPane(rb.mainPanel);
        rb.setSize(500,500);
        rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rb.setVisible(true);
        rb.setTitle("Restaurant Blog");

    }
}
