import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Socks extends JFrame{
    private static JPanel sockTop, sockBottom, sockPanel;
    private static JLabel sockQuestion, sockAnswer, sockImage;
    private static JButton sockButton;
    private static BufferedImage carrot;
    
    public Socks () {
        Container c = this.getContentPane();
        c.setLayout (new BorderLayout ());
        
        sockPanel = new JPanel (new BorderLayout ());
        
        // Top Panel
        sockTop = new JPanel (new FlowLayout());
        try {
            carrot = ImageIO.read(new File("Carrot.jpg"));   
        } catch (IOException ex) {
            // lol
        }   
        sockImage = new JLabel(new ImageIcon(carrot));
        sockTop.add(sockImage);        
        sockPanel.add(sockTop, BorderLayout.CENTER);
        
        // Bottom Pannel
        sockBottom = new JPanel (new FlowLayout());
        sockButton = new JButton ("Is this a Banana?");
        sockButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog (null, "No, It's a Carrot.", "..", JOptionPane.ERROR_MESSAGE);
            }
        });        
        sockBottom.add(sockButton);
        sockPanel.add(sockBottom, BorderLayout.SOUTH);
        
        c.add(sockPanel, "Center");
        
    }
    
    public static void main (String args[]) {
        JFrame frame = new Socks();
		frame.setSize( 450, 450 );
		frame.setVisible( true );
		frame.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
    }
}