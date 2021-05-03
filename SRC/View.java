import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class View {
        private JLabel name;
        private JLabel word;
        private JTextField textField1;
        private JPasswordField passwordField1;
        private JPanel Backgrund;

    public View() {
            JFrame frame = new JFrame("facebok ");
            frame.setContentPane(this.Backgrund);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            Backgrund.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent componentEvent) {
                    super.componentResized(componentEvent);
                }
            });
        }
    }


