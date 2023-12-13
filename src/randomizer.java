import javax.swing.*;
import java.awt.*;

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
            ByTag tag = new ByTag();
            tag.setSize(500,300);
            tag.setVisible(true);
        });

        byLocationButton.addActionListener(e->{
            ByLocation loc = new ByLocation();
            loc.setSize(500,300);
            loc.setVisible(true);
        });

        surpriseMeButton.addActionListener(e->{

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
        randomizer dialog = new randomizer();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(500,100);
        System.exit(0);

    }

}
