package Test;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Demo {
    private JFrame frame;
    private JScrollPane scrollPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Demo window = new Demo();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Demo() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 582, 437);
        frame.getContentPane().setLayout(null);
        scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 13, 536, 337);
        frame.getContentPane().add(scrollPane);
        JButton button = new JButton("\u67E5\u627E"); // ≤È’“
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	
            	
            }
        });
        button.setBounds(260, 366, 63, 23);
        frame.getContentPane().add(button);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
}