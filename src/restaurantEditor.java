import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class restaurantEditor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField restaurantName;

    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb5;
    private JRadioButton rb4;
    private JPanel mainEditor;
    private JTabbedPane Tabs;
    private JTextArea NotesArea;
    private JCheckBox fastFoodCheckBox;
    private JCheckBox seafoodCheckBox;
    private JCheckBox saladsCheckBox;
    private JCheckBox pizzaCheckBox;
    private JCheckBox burgerCheckBox;
    private JCheckBox milkteaCheckBox;
    private JCheckBox coffeeCheckBox;
    private JCheckBox iceCreamCheckBox;
    private JCheckBox cakesCheckBox;
    private JCheckBox friesCheckBox;
    private JLabel NameErrorLabel;
    private JLabel LocationErrorLabel;
    private JLabel RatingErrorLabel;
    private JComboBox cbLocation;


    public restaurantEditor() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        NameErrorLabel.setVisible(false);
        LocationErrorLabel.setVisible(false);
        RatingErrorLabel.setVisible(false);
        String selectedLocation = (String) cbLocation.getSelectedItem();
        centerDialog();
        buttonOK.addActionListener(e -> {
            boolean restaurantConfirmed = false;

            try {
                if (restaurantName.getText().isBlank()){
                    NameErrorLabel.setVisible(true);
                    throw new IllegalArgumentException("Error: Restaurant must have a name.");
                }
                NameErrorLabel.setVisible(false);

                if ( cbLocation.getSelectedIndex()== 0){
                    LocationErrorLabel.setVisible(true);
                    throw new IllegalArgumentException("Error: Restaurant must have a location.");
                }
                LocationErrorLabel.setVisible(false);

                if (!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected() && !rb4.isSelected() && !rb5.isSelected()){
                    RatingErrorLabel.setVisible(true);
                    throw new IllegalArgumentException("Error: Restaurant must have a location.");
                }
                RatingErrorLabel.setVisible(false);

                restaurantConfirmed = true;
            } catch (IllegalArgumentException iae) {
                buttonOK.setToolTipText(iae.getMessage());
            }


            if (restaurantConfirmed == true)
            {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onOK() {
        ArrayList<String> List = new ArrayList<>();
        ArrayList<JCheckBox> Checkboxes = new ArrayList<>();

        Checkboxes.add(fastFoodCheckBox);
        Checkboxes.add(seafoodCheckBox);
        Checkboxes.add(saladsCheckBox);
        Checkboxes.add(pizzaCheckBox);
        Checkboxes.add(burgerCheckBox);
        Checkboxes.add(milkteaCheckBox);
        Checkboxes.add(coffeeCheckBox);
        Checkboxes.add(iceCreamCheckBox);
        Checkboxes.add(cakesCheckBox);
        Checkboxes.add(friesCheckBox);

        for (JCheckBox c : Checkboxes) {
            if (c.isSelected()) {
                List.add(c.getText());
            }
        }
        int rating = 0;

        if (rb1.isSelected()) {
            rating = 1;
        }
        if (rb2.isSelected()) {
            rating = 2;
        }
        if (rb3.isSelected()) {
            rating = 3;
        }
        if (rb4.isSelected()) {
            rating = 4;
        }
        if (rb5.isSelected()) {
            rating = 5;
        }

        String selectedLocation = null;
        if (cbLocation.getSelectedIndex() != 0) {
            selectedLocation = (String) cbLocation.getSelectedItem();
        }


        restaurant rest = new restaurant(restaurantName.getText(), selectedLocation, List, rating);
        Main.addRestaurant(rest);
        dispose();
    }

    private void onCancel() {
        // add your code here
        dispose();
    }
    private void centerDialog() {
        GraphicsEnvironment center = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = center.getDefaultScreenDevice();
        Rectangle bounds = defaultScreen.getDefaultConfiguration().getBounds();
        int x = bounds.x + (bounds.width - getWidth()) / 3;
        int y = bounds.y + (bounds.height - getHeight()) / 3;
        setLocation(x, y);
    }
    public static void main(String[] args) {
        restaurantEditor dialog = new restaurantEditor();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);


    }
}
