import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
            dataLoaded = true;
        });
        RestaurantList.addListSelectionListener(e -> {
            restaurant r = null;
            for (restaurant res : Main.getRestaurants()) {
                if (res.toString().equals(RestaurantList.getSelectedValue())) {
                    r = res;
                }
            }

            RestaurantViewer rv = new RestaurantViewer();

            rv.getRestaurantName().setText(r.getName());
            rv.getLocationData().setText(r.getLocation());
            rv.getRating().setText(r.starRating());

            for (String s : r.getCuisineTags()) {
                rv.getNotesArea().append(s + " ");
            }

            rv.setSize(400, 300);
            rv.setVisible(true);
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
