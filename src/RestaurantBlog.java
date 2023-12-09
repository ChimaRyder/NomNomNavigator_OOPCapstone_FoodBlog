import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantBlog extends JFrame{
    JPanel mainPanel;
    private JButton addButton;
    private JList RestaurantList;
    private JButton saveListButton;
    private JButton loadListButton;

    public JList getRestaurantList() {
        return RestaurantList;
    }

    public RestaurantBlog() {

        addButton.addActionListener(e -> {
            restaurantEditor re = new restaurantEditor();
            re.setSize(400, 300);
            re.setVisible(true);
        });
        saveListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.saveDataToFile();
            }
        });
        loadListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.loadDataToFile();
            }
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
