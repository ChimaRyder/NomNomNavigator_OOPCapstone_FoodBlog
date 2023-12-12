import javax.swing.*;

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

    public static void main(String[] args) {
        randomizer dialog = new randomizer();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(500,100);
        System.exit(0);
    }
}
