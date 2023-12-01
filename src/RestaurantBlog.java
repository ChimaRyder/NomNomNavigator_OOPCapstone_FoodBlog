import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantBlog extends JFrame{
    private JPanel mainPanel;
    private JButton addButton;

    public RestaurantBlog() {

        addButton.addActionListener(e -> {
            restaurantEditor re = new restaurantEditor();
            re.setSize(300, 200);
            re.setVisible(true);

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
