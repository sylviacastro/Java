import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")

public class HealthProfileGUI extends JFrame implements ActionListener
{ 
    JTextField txtName = new JTextField(15);
    JTextField txtAge = new JTextField(15);
    JTextField txtWeight = new JTextField(15);
    JTextField txtHeightFt = new JTextField(15);
    JTextField txtHeightIn = new JTextField(15);
    
    JButton btnDisplay = new JButton("Display");
    JButton btnClear = new JButton("Clear");
    
    JTextField txtBMI = new JTextField(15);
    JTextField txtCategory = new JTextField(15);
    JTextField txtMaxHR = new JTextField(15);
    private HealthProfile hp;
    
    public HealthProfileGUI()
    {
        super ( "Health Profile " );
        hp = new HealthProfile();
        setLayout(new GridLayout(0,2));
        
        add (new JLabel("Name "));
        add(txtName);
        add (new JLabel("Age "));
        add(txtAge);
        add (new JLabel("Weight "));
        add(txtWeight);
        add (new JLabel("Height-feet "));
        add(txtHeightFt);
        add (new JLabel("Height-inches "));
        add(txtHeightIn);
        add(btnDisplay);
        add(btnClear);
        add (new JLabel("BMI"));
        add(txtBMI);
        add (new JLabel("Category"));
        add(txtCategory);
        add (new JLabel("Max Heart Rate"));
        add(txtMaxHR);
        
        setVisible( true );
        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);              
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnClear)
        {
            System.out.println("clear pressed");
            txtName.setText("");
            txtAge.setText("");
            txtWeight.setText("");
            txtHeightFt.setText("");
            txtHeightIn.setText("");
            txtBMI.setText("");
            txtCategory.setText("");
            txtMaxHR.setText("");
        }
        if (e.getSource() == btnDisplay)
        {
            if (txtName.getText().isEmpty() ||
                txtAge.getText().isEmpty() ||
                txtHeightFt.getText().isEmpty() ||
                txtHeightIn.getText().isEmpty() ||
                txtWeight.getText().isEmpty()) //missing input
            {
                JOptionPane.showMessageDialog(null, "Please provide all input");
                return;
            }
            hp.setName(txtName.getText());
            try
            {
                hp.setAge(Integer.parseInt(txtAge.getText()));
                int ft = Integer.parseInt(txtHeightFt.getText());
                int in = Integer.parseInt(txtHeightIn.getText());
                hp.setHeight(ft,in);
                hp.setWeight(Integer.parseInt(txtWeight.getText()));
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Age, Weight, Inches and feet must all be numberic");
                return;
            }           
            double d = hp.getBMI();
            d = d * 10;
            d = Math.round(d);
            d = d / 10;
            txtBMI.setText(" " + d);
            double dd = hp.getBMI();
            
            txtCategory.setText(hp.getCategory());
            txtMaxHR.setText(" " + hp.getMaxHR());
        }
    }
}
    
