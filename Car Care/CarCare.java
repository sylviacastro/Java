import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 *
 * @author sylvi
 */
public class CarCare extends JFrame implements ActionListener
{
    JMenuBar jmb = new JMenuBar();
    JMenu oilMenu = new JMenu("Oil Change");
    JMenu washMenu = new JMenu("Car Wash");
    JMenu totalMenu = new JMenu("Total/Clear/Exit");
    JMenuItem bronzeItem = new JMenuItem("Bronze");
    JMenuItem silverItem = new JMenuItem("Silver");
    JMenuItem goldItem = new JMenuItem("Gold");
    JMenuItem basicItem = new JMenuItem("Basic");
    JMenuItem betterItem = new JMenuItem("Better");
    JMenuItem bestItem = new JMenuItem("Best");
    JMenuItem totalItem = new JMenuItem("Total");
    JMenuItem clearItem = new JMenuItem("Clear");
    JMenuItem exitItem = new JMenuItem("Exit");
    
    int cost = 0;
    String oil = "";
    String wash = "";
    
    public CarCare()
    {
        this.setJMenuBar(jmb);
        jmb.add(oilMenu);
        jmb.add(washMenu);
        jmb.add(totalMenu);
        oilMenu.add(bronzeItem);
        oilMenu.add(silverItem);
        oilMenu.add(goldItem);
        washMenu.add(basicItem);
        washMenu.add(betterItem);
        washMenu.add(bestItem);
        totalMenu.add(totalItem);
        totalMenu.add(clearItem);
        totalMenu.add(exitItem);
        bronzeItem.addActionListener(this);
        silverItem.addActionListener(this);
        goldItem.addActionListener(this);
        basicItem.addActionListener(this);
        betterItem.addActionListener(this);
        bestItem.addActionListener(this);
        totalItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bronzeItem){
            cost += 20;
            oil = "Bronze";}
        else if (e.getSource() == silverItem){
            cost += 25;
            oil = "Silver";}
        else if (e.getSource() == goldItem){
            cost += 30;
            oil = "Gold";}
        else if (e.getSource() == basicItem){
            cost += 5;
            oil = "Basic";}
        else if (e.getSource() == betterItem){
            cost += 10;
            oil = "Better";}
        else if (e.getSource() == bestItem){
            cost += 15;
            oil = "Best";}
        else if (e.getSource() == clearItem){
            cost = 0;
            oil = "";
            wash = "";}
    
        else if (e.getSource() == totalItem){
            DecimalFormat df = new DecimalFormat("$##.00");
            JOptionPane.showMessageDialog(null, "Oil change: " + oil + "\nCar Wash: "
                    + wash + "\nTotal Cost: " + df.format(cost));}
        
        else if (e.getSource() == exitItem){
            System.exit(0);}                  
}
    public static void main(String[] args){
        CarCare c = new CarCare();
        c.setSize(675, 275);
        c.setVisible(true);   
        }
}

    

