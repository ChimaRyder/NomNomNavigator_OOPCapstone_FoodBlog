import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class restaurantEditor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField restaurantName;
    private JTextField textField1;

    public restaurantEditor() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
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
