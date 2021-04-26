import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class View {
    private JLabel name;
    private JLabel word;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel Backgrund;


    public JLabel getName() {
        return name;
    }

    public void setName(JLabel name) {
        this.name = name;
    }

    public JLabel getWord() {
        return word;
    }

    public void setWord(JLabel word) {
        this.word = word;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public View() {

            name.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent componentEvent) {
                    super.componentResized(componentEvent);
                }
            });
        JFrame frame = new JFrame("facebok ");
        frame.setContentPane(this.Backgrund);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    }

