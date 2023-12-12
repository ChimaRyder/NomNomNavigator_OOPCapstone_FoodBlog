import javax.swing.*;
import java.io.IOException;

public class RestaurantBlog extends JFrame{
    JPanel mainPanel;
    private JButton addButton;
    private JList RestaurantList;
    private JButton saveListButton;
    private JButton loadListButton;
    private JLabel NNN;
    private JButton randomizerButton;
    private boolean dataSaved = true;


    public void setDataSaved(boolean dataSaved) {
        this.dataSaved = dataSaved;
    }

    public JList getRestaurantList() {
        return RestaurantList;
    }

    public RestaurantBlog() {

//        ImageIcon backgroundImage = new ImageIcon("1.png");
//        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance()

        addButton.addActionListener(e -> {
            restaurantEditor re = new restaurantEditor();
            re.setSize(400, 300);
            re.setVisible(true);
        });

        saveListButton.addActionListener(e -> {
            try{
                Main.saveDataToFile();
                dataSaved = true;
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        });

        loadListButton.addActionListener(e -> {
            try {
                if(!dataSaved){
                    switch (JOptionPane.showConfirmDialog(this, "Your progress has not been saved. Any unsaved progress will be lost. Would you like to save?")) {
                        case JOptionPane.OK_OPTION:
                            Main.saveDataToFile();
                            dataSaved = true;
                        case JOptionPane.NO_OPTION:
                        case JOptionPane.CANCEL_OPTION:
                            break;
                    }
                }

                Main.loadDataToFile();
            } catch (IOException ie) {
                ie.printStackTrace();

            }
        });

        randomizerButton.addActionListener(e ->{
           randomizer ran = new randomizer();
           ran.setSize(500,100);
           ran.setVisible(true);

        });


        RestaurantList.addListSelectionListener(e -> {
            restaurant r = null;
            for (restaurant res : Main.getRestaurants()) {
                if (res.toString().equals(RestaurantList.getSelectedValue())) {
                    r = res;
                }
            }

            RestaurantViewer rv = new RestaurantViewer();

            if (r == null) {
                rv.dispose();
                return;
            }
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
