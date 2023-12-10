import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RestaurantBlog extends JFrame{
    JPanel mainPanel;
    private JButton addButton;
    private JList RestaurantList;
    private JButton saveListButton;
    private JButton loadListButton;
    private boolean dataLoaded = false;

    public JList getRestaurantList() {
        return RestaurantList;
    }

    public RestaurantBlog() {

        addButton.addActionListener(e -> {
            restaurantEditor re = new restaurantEditor();
            re.setSize(400, 300);
            re.setVisible(true);
        });
        saveListButton.addActionListener(e -> {
            try{
                if (!dataLoaded) {
                    Main.loadDataToFile();
                    dataLoaded = true;
                }
                Main.saveDataToFile();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        });
        loadListButton.addActionListener(e -> {
            try {
                if(!dataLoaded){
                    Main.loadDataToFile();
                    dataLoaded = true;
                }
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        RestaurantBlog rb = new RestaurantBlog();

        rb.setContentPane(rb.mainPanel);
        rb.setSize(500,1000);
        rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rb.setVisible(true);
        rb.setTitle("Restaurant Blog");

    }
}
