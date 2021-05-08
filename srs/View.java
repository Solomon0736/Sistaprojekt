import javax.swing.*;

public class View {
    private JTextArea textArea1;
    private JTextField spara;
    private JTextField visa;
    private JPanel third;

    public View() {
        JFrame frame = new JFrame("");
        frame.setContentPane(this.third);
        frame.setTitle(" loggboken projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        View view = new View();

    }
}