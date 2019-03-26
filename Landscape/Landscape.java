import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Landscape extends JFrame implements ActionListener {

    JTextField nameTextField, addressTextField, lengthTextField, widthTextField, areaTextField, costTextField, installationTextField; // Text fields
    JButton calculateAreaButton = new JButton("Calculate Area"); // Calculate Area Button
    JButton calculateCostButton = new JButton("Calculate Cost"); // Calculate Cost Button
    JButton submitButton = new JButton("Submit Order"); // Submit Button
    JButton summaryButton = new JButton("Display Summary"); // Summary Button
    ButtonGroup btngroup = new ButtonGroup();
    JTextArea summaryTextArea = new JTextArea(5, 25); // dispay summary
    JTextArea customerList = new JTextArea(10, 25); // dispay summary
    JFrame frmCustomerList;    
    String grassType = "";
    int cost;

    Landscape() {
        super("Landscape Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        setSize(450, 200);
        //pack();
        setVisible(true);
    }

    public void addComponentsToPane(Container contentPane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add customer tab to the frame
        JPanel customerPanel = customerTab();
        tabbedPane.addTab("Customer", customerPanel);
        
        //Add installation tab to the fram
        JPanel installationPanel = installationTab();
        tabbedPane.addTab("Installation", installationPanel);

        // Add yarding tab to the frame
        JPanel landscapePanel = landscapeTab();
        tabbedPane.addTab("Landscape", landscapePanel);

        // Add yarding tab to the frame
        JPanel yardAreaPanel = yardDimensionsTab();
        tabbedPane.addTab("Yard Area", yardAreaPanel);

        
        // Add calculate tab to the frame
        JPanel calculatePanel = calculateTab();
        tabbedPane.addTab("Calculate", calculatePanel);

       add(tabbedPane);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
      
        if (action.equalsIgnoreCase("Calculate Area")) {
            calculateArea();
        }

        if (action.equalsIgnoreCase("Calculate Cost")) {
            calculateCost();
        }
        
       
        if(action.equalsIgnoreCase("Display Summary")){
        	// Get type of the yard
            ButtonModel b = btngroup.getSelection();
            if (b != null) {
                grassType = b.getActionCommand();
            }

            String result = "Customer name: " + nameTextField.getText() + "\nCustomer Address: " + addressTextField.getText() + "\nInstallation Date: " + installationTextField.getText() + "\nGrass Type: " + grassType + "\nYard Length: " + lengthTextField.getText() 
                    + " ft" + "\nYard Width: " + widthTextField.getText() + " ft" + "\nLandscape Cost: " + costTextField.getText() + "\nLandscape Area: " + areaTextField.getText();
            summaryTextArea.setText(result);
        	JOptionPane.showMessageDialog(null, summaryTextArea,"Summary",1);
        }
    }


    public void calculateArea() {
        // Area = length x width
        int length, width, area;

        // Get type of the yard
        ButtonModel b = btngroup.getSelection();
        if (b != null) {
            grassType = b.getActionCommand();
        }

        try {
            length = Integer.parseInt(lengthTextField.getText());
            width = Integer.parseInt(widthTextField.getText());
            area = length * width;
            areaTextField.setText(String.valueOf(area) + " ft2");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid Length and Width of yard");
            return;
        }
    }
    
    public void calculateCost() {
        // Area = length x width
        int length, width, area;

        // Get type of the yard
        ButtonModel b = btngroup.getSelection();
        if (b != null) {
            grassType = b.getActionCommand();
        }

        try {
            length = Integer.parseInt(lengthTextField.getText());
            width = Integer.parseInt(widthTextField.getText());
            area = length * width;            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid Length and Width of yard");
            return;
        }

        if (grassType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select type of grass");
        } else {
            if (grassType.equalsIgnoreCase("Dwarf Fescue")) {
                cost = area * 20;
                costTextField.setText("$" + String.valueOf(area * 20));
                //area*20
            } else {
                cost = area * 10;
                costTextField.setText("$" + String.valueOf(area * 10));
                //area*10
            }
        }
    }
    public JPanel customerTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Welcome to Landscape Application"));
        panel.add(new JLabel("Please Enter Customer Name: "));
        nameTextField = new JTextField(15);
        panel.add(nameTextField);
        panel.add(new JLabel("Please Enter Customer Address: "));
        addressTextField = new JTextField(15);
        panel.add(addressTextField);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));

        return panel;
    }
    public JPanel installationTab() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Please Enter Installation Date: "));
        installationTextField = new JTextField(15);
        panel.add(installationTextField);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));

        return panel;
    }

    public JPanel landscapeTab() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
        panel1.setLayout(new GridLayout(0, 2));
        panel2.add(panel, BorderLayout.CENTER);
        panel2.add(panel1, BorderLayout.NORTH);
        panel.add(new JLabel("                   Please Select A Grass Type:                              ", JLabel.CENTER));
        JRadioButton smallOption = new JRadioButton("Tall Fescue / $10 per sq ft");
        smallOption.setSelected(true);
        smallOption.setActionCommand("Tall Fescue");
        JRadioButton mediumOption = new JRadioButton("Dwarf Fescue / $20 per sq ft");
        mediumOption.setActionCommand("Dwarf Fescue");
        btngroup.add(smallOption);
        btngroup.add(mediumOption);
       
        panel.add(smallOption);
        panel.add(mediumOption);

        return panel2;
    }

    public JPanel yardDimensionsTab() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
        panel1.setLayout(new GridLayout(0, 2));
        panel2.add(panel1, BorderLayout.NORTH);
        panel1.add(new JLabel("Please Enter Yard Length: "));
        lengthTextField = new JTextField(15);
        panel1.add(lengthTextField);
        panel1.add(new JLabel("Please Enter Yard Width: "));
        widthTextField = new JTextField(15);
        panel1.add(widthTextField);

        return panel2;
    }

    public JPanel calculateTab() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(0, 2));
        panel2.setLayout(new GridLayout(2,2));
        panel1.add(new JLabel("Total Yard Area: "));
        areaTextField = new JTextField(15);
        panel1.add(areaTextField);
        panel1.add(new JLabel("Total Landscape Cost: "));
        costTextField = new JTextField(15);
        panel1.add(costTextField);
        panel2.add(calculateAreaButton);
        panel2.add(calculateCostButton);
        calculateAreaButton.addActionListener(this);
        calculateCostButton.addActionListener(this);
        summaryButton.addActionListener(this);
        panel2.add(summaryButton);
        panel.add(panel1, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.SOUTH);     
        return panel;
    }

    public JPanel summaryTab() {
        JPanel panel = new JPanel();
        panel.add(summaryTextArea);
        return panel;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		Landscape yard = new Landscape();

    }
}
