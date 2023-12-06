import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class restaurantEditor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField restaurantName;
    private JTextField LocationData;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb5;
    private JRadioButton rb4;
    private JPanel mainEditor;
    private JTabbedPane Tabs;
    private JTextArea NotesArea;

    public restaurantEditor() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        ArrayList<String> test = new ArrayList<>();

        int rating = 0;

        if (rb1.isSelected()) {
            rating = 1;
        } else if (rb2.isSelected()) {
            rating = 2;
        } else if (rb3.isSelected()) {
            rating = 3;
        } else if (rb4.isSelected()) {
            rating = 4;
        } else if (rb5.isSelected()){
            rating = 5;
        }

        restaurant rest = new restaurant(restaurantName.getText(), LocationData.getText(), test, rating);
        Main.addRestaurant(rest);
        dispose();
    }

    private void onCancel() {
        // add your code here
        dispose();
    }



    public static void main(String[] args) {
        restaurantEditor dialog = new restaurantEditor();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
