import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  public class Pizza extends JFrame implements ActionListener {
  JTextField txtName = new JTextField(15);
  JTextField txtPhone = new JTextField(15);
  JRadioButton jrbSmall = new JRadioButton("Small");
  JRadioButton jrbMed = new JRadioButton("Medium");
  JRadioButton jrbLarge = new JRadioButton("Large");
  JCheckBox toppings[] = new JCheckBox[4];
  JTextField txtTotal = new JTextField(10);
  
  public Pizza(){
	  super("Java Pizza"); //this must be the first line
	  
	  JTabbedPane tab = new JTabbedPane();
	  JLabel l1 = new JLabel("             Welcome to Java Pizza             ", SwingConstants.CENTER);
	  JPanel p1 =  new JPanel();
	  p1.add(l1);
	  p1.add(new JLabel("             Name:             ", SwingConstants.CENTER));
	  p1.add(txtName);
	  p1.add(new JLabel("Phone Number:"));
	  p1.add(txtPhone);
	  tab.addTab("Customer",  null, p1, "Customer info");;
	  //construct the second pane
	  JLabel l2 = new JLabel("                    What size pizza?                            ", SwingConstants.CENTER);
	  JPanel p2 = new JPanel();
	  p2.add(l2);
	  p2.add(jrbSmall);
	  p2.add(jrbMed);
	  p2.add(jrbLarge);
	  tab.addTab("Size", null, p2, "What Size?");
	  //Constructing the third panel
	  JLabel l3 = new JLabel("               What topping would you like?       ", SwingConstants.CENTER);
	  JPanel p3 = new JPanel();
	  p3.add(l3);
	  for (int i = 0; i <4; ++i)
	  {
		  toppings[i] = new JCheckBox();
		  p3.add(toppings[i]);
	  }
	  toppings[0].setText("Pepperoni");
	  toppings[1].setText("Sausage");
	  toppings[2].setText("Green Pepper");
	  toppings[3].setText("Onion");
	  tab.addTab("Topping", null, p3, "What Topping?");
	  //construct the fourth panel
	  JLabel l4 = new JLabel("              Total Due          ", SwingConstants.CENTER);
	  JPanel p4 = new JPanel();
	  p4.add(l4);
	  p4.add(new JLabel("Total"));
	  p4.add(txtTotal);
	  JButton button1 = new JButton("Order Summary");
	  p4.add(button1);
	  tab.addTab("Total", null, p4, "How much do you owe?");
	  //add JtabbedPan to container
	  getContentPane().add(tab);
	  setSize(270, 200);
	  setVisible(true);
	  button1.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e){
	  String size, topping = "", name, phone;
	  double total = 0;
	  name = txtName.getText();
	  phone = txtPhone.getText();
	  if (jrbSmall.isSelected()){
		  size = "Small";
		  total += 8;
	  } else if (jrbMed.isSelected()){
		  size = "Medium";
		  total += 10;
	  }
	  else
	  {  size = "Large";
	  total += 12;		  
	  }
	  
	  for (int i = 0; i < 4; i++) {
		  if (toppings[i].isSelected()){
			  total += 2;
			  topping = topping + toppings[i].getText();
			  topping += " ";
		  }		  
	  }
	  
	  txtTotal.setText(String.valueOf(total));
	  OrderSummary os = new OrderSummary(name, phone, topping, size, total);
  }
  public static void main(String args[]){
	  Pizza pizzaObject = new Pizza();
	  pizzaObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  class OrderSummary extends JFrame{
	  public OrderSummary(String n, String p, String t, String s, double total){
		  super("Order Summary");
		  JPanel jp1 = new JPanel();
		  this.add(jp1);
		  JTextArea jta = new JTextArea(10, 25);
		  jp1.add(jta);
		  jta.setText("Customer Name: "+n + "\nPhone Number: " + p + "\nSize:" + s + "\nToppings: " 
		  + t + "\nTotal:" + total);
		  		setSize(350,250);
		  		setVisible(true);
	  }	 	  
  }
	  	 	 	  
  }
