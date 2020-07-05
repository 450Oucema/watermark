import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private JButton submit;
    private JPanel panelmain;

    public Interface() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser input = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images","jpg", "png");
                input.setFileFilter(filter);
                int returnVal = input.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Tu as choisi ce fichier : " + input.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(new Interface().panelmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
