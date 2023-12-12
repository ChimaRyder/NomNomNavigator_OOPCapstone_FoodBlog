import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ByTag extends JDialog {
    private JPanel contentPane;
    private JComboBox tagCB;
    private JButton generateBtn;
    private JButton buttonOK;


    public ByTag() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedTag = (String) tagCB.getSelectedItem();
              String tag = "";
              restaurant r = null;
              Random rand = new Random();
              int ctr = 0;
              while (!selectedTag.equals(tag) && ctr < Main.getRestaurants().size())
              {

                  int idx = rand.nextInt(Main.getRestaurants().size()-1);
                  r = Main.getRestaurants().get(idx);
                  for (String t : r.getCuisineTags()) {
                      if (t.equals(selectedTag))
                      {
                          tag = t;
                          break;
                      }
                  }
                  System.out.println("running");
                  ctr++;
              }

                System.out.println(r.toString());

            }
        });
    }

    public static void main(String[] args) {
        ByTag dialog = new ByTag();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
