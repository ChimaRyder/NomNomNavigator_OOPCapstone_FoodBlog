import javax.swing.*;
import java.awt.event.*;

public class RestaurantViewer extends JDialog {
    private JPanel contentPane;

    private JButton buttonCancel;
    private JTabbedPane Tabs;
    private JPanel mainEditor;
    private JTextField restaurantName;
    private JTextField LocationData;
    private JTextArea NotesArea;
    private JCheckBox fastFoodCheckBox;
    private JCheckBox seafoodCheckBox;
    private JCheckBox saladsCheckBox;
    private JCheckBox pizzaCheckBox;
    private JCheckBox burgerCheckBox;
    private JCheckBox friesCheckBox;
    private JCheckBox cakesCheckBox;
    private JCheckBox iceCreamCheckBox;
    private JCheckBox coffeeCheckBox;
    private JCheckBox milkteaCheckBox;
    private JLabel Rating;

    public JTextField getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(JTextField restaurantName) {
        this.restaurantName = restaurantName;
    }

    public JTextField getLocationData() {
        return LocationData;
    }

    public void setLocationData(JTextField locationData) {
        LocationData = locationData;
    }

    public JTextArea getNotesArea() {
        return NotesArea;
    }

    public void setNotesArea(JTextArea notesArea) {
        NotesArea = notesArea;
    }

    public JCheckBox getFastFoodCheckBox() {
        return fastFoodCheckBox;
    }

    public void setFastFoodCheckBox(JCheckBox fastFoodCheckBox) {
        this.fastFoodCheckBox = fastFoodCheckBox;
    }

    public JCheckBox getSeafoodCheckBox() {
        return seafoodCheckBox;
    }

    public void setSeafoodCheckBox(JCheckBox seafoodCheckBox) {
        this.seafoodCheckBox = seafoodCheckBox;
    }

    public JCheckBox getSaladsCheckBox() {
        return saladsCheckBox;
    }

    public void setSaladsCheckBox(JCheckBox saladsCheckBox) {
        this.saladsCheckBox = saladsCheckBox;
    }

    public JCheckBox getPizzaCheckBox() {
        return pizzaCheckBox;
    }

    public void setPizzaCheckBox(JCheckBox pizzaCheckBox) {

        this.pizzaCheckBox = pizzaCheckBox;
    }

    public JCheckBox getBurgerCheckBox() {

        return burgerCheckBox;
    }

    public void setBurgerCheckBox(JCheckBox burgerCheckBox) {

        this.burgerCheckBox = burgerCheckBox;
    }

    public JCheckBox getFriesCheckBox() {

        return friesCheckBox;
    }

    public void setFriesCheckBox(JCheckBox friesCheckBox) {

        this.friesCheckBox = friesCheckBox;
    }

    public JCheckBox getCakesCheckBox() {

        return cakesCheckBox;
    }

    public void setCakesCheckBox(JCheckBox cakesCheckBox) {

        this.cakesCheckBox = cakesCheckBox;
    }

    public JCheckBox getIceCreamCheckBox() {

        return iceCreamCheckBox;
    }

    public void setIceCreamCheckBox(JCheckBox iceCreamCheckBox) {

        this.iceCreamCheckBox = iceCreamCheckBox;
    }

    public JCheckBox getCoffeeCheckBox() {

        return coffeeCheckBox;
    }

    public void setCoffeeCheckBox(JCheckBox coffeeCheckBox) {
        this.coffeeCheckBox = coffeeCheckBox;
    }

    public JCheckBox getMilkteaCheckBox() {

        return milkteaCheckBox;
    }

    public void setMilkteaCheckBox(JCheckBox milkteaCheckBox) {

        this.milkteaCheckBox = milkteaCheckBox;
    }

    public JLabel getRating() {

        return Rating;
    }

    public void setRating(JLabel rating) {

        Rating = rating;
    }

    public RestaurantViewer() {
        setContentPane(contentPane);
        setModal(true);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        //remove Restaurant from list
        Main.removeRestaurant(restaurantName.getText());
        dispose();
    }

    public static void main(String[] args) {
        RestaurantViewer dialog = new RestaurantViewer();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
