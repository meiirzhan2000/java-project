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

public class User_Menu {
    
    public JFrame getJFrame(){
        return UserMenu;
    }

    private static JFrame UserMenu;
    private JButton BookCar, BookingHistory, Feedback, Exit;
    private JLabel imagelabel;
            
    public User_Menu() {
    
    UserMenu = new JFrame("IW Car Rental"); 
    UserMenu.setBounds(900,700,866,630);
    UserMenu.setLayout(null);
    UserMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    UserMenu.setResizable(false);
    UserMenu.setBackground(new Color(240,255,255));
    JPanel panel = new JPanel();
    panel.setLayout(null);
    UserMenu.add(panel);
    
    BookCar = new JButton("Booking Car");
    BookCar.setBounds(90, 100, 200, 50);
    BookCar.setFont(new Font("Serif", Font.BOLD, 15));
    
    BookCar.addActionListener((ActionEvent e) -> { 
        Car_RentalMain.page8.getJFrame().setVisible(true); //to Carbooking page
        UserMenu.setVisible(false);
    });
    
    BookingHistory = new JButton("Booking History");
    BookingHistory.setBounds(90, 200, 200, 50);
    BookingHistory.setFont(new Font("Serif", Font.BOLD, 15));
    BookingHistory.addActionListener((ActionEvent e) -> {           
        String Input_Password = JOptionPane.showInputDialog(UserMenu, "Please enter the password to view your Booking History: ");

    }); 
    
    Feedback = new JButton("Feedback");
    Feedback.setBounds(90, 300, 200, 50);
    Feedback.setFont(new Font("Serif", Font.BOLD, 15));
    
    Feedback.addActionListener((ActionEvent e) -> { 
        Car_RentalMain.page9.getJFrame().setVisible(true); //to editproofile page
        UserMenu.setVisible(false);
    });
    
    Exit = new JButton("Exit");
    Exit.setBounds(90, 400, 200, 50);
    Exit.setFont(new Font("Serif", Font.BOLD, 15));

    Exit.addActionListener((ActionEvent e) -> {           
        int showLogoutMsg = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", 
                "Exit Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                if (showLogoutMsg == 0) {
                    System.exit(0);
                }
    }); 
    
    imagelabel = new JLabel();
    imagelabel.setBounds(300,195,600,200);
    imagelabel.setIcon((new ImageIcon("CarRentalLogo.png")));
    
    UserMenu.add(BookCar);
    UserMenu.add(BookingHistory);
    UserMenu.add(Feedback);
    UserMenu.add(imagelabel);
    UserMenu.add(Exit);
    
    UserMenu.setLocationRelativeTo(null);    
    
    }
}