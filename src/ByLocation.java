import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ByLocation extends JDialog {
    private JPanel contentPane;
    private JComboBox locationCB;
    private JButton generateButton;
    private JButton buttonOK;

    public ByLocation() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        centerDialog();

        generateButton.addActionListener(e->{
            String selectedLoc = (String) locationCB.getSelectedItem();
            String loc = "";
            restaurant r = null;
            Random rand = new Random();
            int ctr = 0;
            while (!selectedLoc.equals(loc) && ctr < Main.getRestaurants().size())
            {

                int idx = rand.nextInt(Main.getRestaurants().size()-1);
                r = Main.getRestaurants().get(idx);
                loc = r.getLocation();
                System.out.println("running");
                ctr++;
            }

            System.out.println(r.toString());

        });

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
        ByLocation dialog = new ByLocation();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
