import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class randomizer extends JDialog {
    private JPanel contentPane;
    private JButton byTagButton;
    private JButton surpriseMeButton;
    private JButton byLocationButton;
    private JButton buttonOK;

    public randomizer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        centerDialog();
        byTagButton.addActionListener(e->{
            dispose();
            ByTag tag = new ByTag();
            tag.setSize(700,500);
            tag.setVisible(true);

        });

        byLocationButton.addActionListener(e->{
            dispose();
            ByLocation loc = new ByLocation();
            loc.setSize(700,500);
            loc.setVisible(true);

        });

        surpriseMeButton.addActionListener(e->{

            restaurant r = null;
            Random rand = new Random();
            int ctr = 0;
            while ( ctr < Main.getRestaurants().size())
            {

                int idx = rand.nextInt(Main.getRestaurants().size()-1);
                r = Main.getRestaurants().get(idx);
                System.out.println("running");
                ctr++;
            }


            //System.out.println(r.toString());
            String res = r.toString();
            JOptionPane.showMessageDialog(null, res, "Surprise! ", JOptionPane.INFORMATION_MESSAGE);



        });



    }

    private void centerDialog() {
        GraphicsEnvironment center = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = center.getDefaultScreenDevice();
        Rectangle bounds = defaultScreen.getDefaultConfiguration().getBounds();
        int x = bounds.x + (bounds.width - getWidth()) / 4;
        int y = bounds.y + (bounds.height - getHeight()) / 4;
        setLocation(x, y);
    }
    public static void main(String[] args) {
        randomizer dialog = new randomizer();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }

}
