import javax.swing.*;
import java.util.ArrayList;

public class RestaurantBlog extends JFrame{
    private JPanel mainPanel;
    private JButton addButton;
    private JList RestaurantList;

    private ArrayList<restaurant> restaurants;

    public ArrayList<restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public RestaurantBlog() {

        addButton.addActionListener(e -> {
            restaurantEditor re = new restaurantEditor();
            re.setSize(400, 300);
            re.setVisible(true);


            //RestaurantList.setListData(getRestaurants());
        });
    }

    public static void main(String[] args) {
        RestaurantBlog rb = new RestaurantBlog();

        rb.setContentPane(rb.mainPanel);
        rb.setSize(500,500);
        rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rb.setVisible(true);
        rb.setTitle("Restaurant Blog");

    }
}
