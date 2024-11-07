package AssignmentVehicle_Rental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Admin_Menu{
    
    public JFrame getJFrame(){
        return adminMenu;
    } 
    //report
    private JFrame adminMenu;
    private JButton viewButton, CarDetailsButton, CustomerButton,FeedbackButton, ReportButton, LogoutButton;
    private JLabel imageLabel;

    public Admin_Menu(){

        adminMenu = new JFrame(" Admin Page ");
        adminMenu.setBounds(900,700,866,630);     
        adminMenu.setLayout(null);
        adminMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminMenu.setResizable(false);
        adminMenu.setBackground(new Color(240,255,255));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        adminMenu.add(panel);

        viewButton = new JButton("Customer Booking");
        viewButton.setBounds(90,100,200,100);
        viewButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        viewButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page4.getJFrame().setVisible(true);
            adminMenu.setVisible(false);
        });
        

        CarDetailsButton = new JButton("Car Details");
        CarDetailsButton.setBounds(90,250,200,100);
        CarDetailsButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        CarDetailsButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page5.getJFrame().setVisible(true);
            adminMenu.setVisible(false);
        });
        
        CustomerButton = new JButton("Customer Details");
        CustomerButton.setBounds(90,400,200,100);
        CustomerButton.setFont(new Font("Serif", Font.BOLD, 14));   
        
        CustomerButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page6.getJFrame().setVisible(true);
            adminMenu.setVisible(false);
        });
        
        imageLabel = new JLabel();
        imageLabel.setBounds(300,195,600,200);
        imageLabel.setIcon((new ImageIcon("CarRentalLogo.png")));
        
        ReportButton = new JButton("Generate Report");
        ReportButton.setBounds(600,10,150,30);
        ReportButton.setFont(new Font("Serif", Font.BOLD, 14)); // add action
        
        FeedbackButton = new JButton("View Feedback");
        FeedbackButton.setBounds(450,10,150,30);
        FeedbackButton.setFont(new Font("Serif", Font.BOLD, 14)); 
        
        FeedbackButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page10.getJFrame().setVisible(true);
            adminMenu.setVisible(false);
        });
        
        LogoutButton = new JButton("Logout");
        LogoutButton.setBounds(750,10,80,30);
        LogoutButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        LogoutButton.addActionListener((ActionEvent e) -> {           
            int showLogoutMsg = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", 
                    "Logout Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                    if (showLogoutMsg == 0) {
                        System.exit(0);
                    }
        });        
        
        adminMenu.add(viewButton);
        adminMenu.add(CarDetailsButton);
        adminMenu.add(CustomerButton);    
        adminMenu.add(FeedbackButton);
        adminMenu.add(imageLabel);
        adminMenu.add(LogoutButton);
        adminMenu.add(ReportButton);

        
 
        adminMenu.setLocationRelativeTo(null);
    }
}