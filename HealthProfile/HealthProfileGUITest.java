import javax.swing.JFrame;

public class HealthProfileGUITest 
{
    
    public static void main(String args[] ){
        HealthProfileGUI frame = new HealthProfileGUI();
        frame.setSize(300, 450); // these numbers are in pixels
        frame.setVisible(true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
}
