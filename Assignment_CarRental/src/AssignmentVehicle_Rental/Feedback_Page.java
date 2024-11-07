package AssignmentVehicle_Rental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Feedback_Page {
    
    public JFrame getJFrame(){
        return User_Feedback;
    }
    
    private static JFrame User_Feedback;
    private JLabel FeedbackTitle, UserName,FeedbackLabel;
    private JTextArea UserNameInput,FeedbackInput;
    private JButton SubmitButton,BackButton;
    
    
    public Feedback_Page(){
    User_Feedback = new JFrame("IW Car Rental - Feedback"); 
    User_Feedback.setBounds(900,700,866,630);
    User_Feedback.setLayout(null);
    User_Feedback.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    User_Feedback.setResizable(false);
    User_Feedback.setBackground(new Color(240,255,255));
    JPanel panel = new JPanel();
    panel.setLayout(null);
    User_Feedback.add(panel);
     
    FeedbackTitle = new JLabel("Customer Feedback");
    FeedbackTitle.setBounds(90,50,800,40);
    FeedbackTitle.setFont(new Font("Serif", Font.BOLD, 45));
    
    UserName = new JLabel("Username: ");
    UserName.setBounds(100,100,80,25);
    UserName.setFont(new Font("Serif", Font.BOLD, 16));
    UserNameInput = new JTextArea();
    UserNameInput.setBounds(200, 100, 85, 25);
    UserNameInput.setFont(new Font("Serif", Font.ITALIC, 14));
    
    FeedbackLabel = new JLabel("Customer Feedback");
    FeedbackLabel.setBounds(100,150,150,25);
    FeedbackLabel.setFont(new Font("Serif", Font.BOLD, 16));
    FeedbackInput = new JTextArea();
    FeedbackInput.setBounds(100, 180, 700, 300);
    FeedbackInput.setFont(new Font("Serif", Font.ITALIC, 16));
    
    SubmitButton = new JButton("Submit");
    SubmitButton.setBounds(500, 500, 200, 50);
    SubmitButton.setForeground(Color.BLACK);
    SubmitButton.addActionListener((ActionEvent e) -> {
        String username = UserNameInput.getText();
        String feedback = FeedbackInput.getText().trim();
        Feedback_Info FeedbackStore = new Feedback_Info(Car_RentalMain.userLogin.getUsername(),feedback); //wenti
        File_Data.feedback_data.add(new Feedback_Info(Car_RentalMain.userLogin.getUsername(),feedback)); //wenti
        File_Data.writeInFile();
        clearFields();
        Car_RentalMain.page7.getJFrame().setVisible(true);
        User_Feedback.dispose();
        }); 
    
  
    BackButton = new JButton("Back");
    BackButton.setBounds(750,10,80,30);
    BackButton.setFont(new Font("Serif", Font.BOLD, 14));
        
    BackButton.addActionListener((ActionEvent e) -> {
        Car_RentalMain.page7.getJFrame().setVisible(true);
        User_Feedback.setVisible(false);
        }); 
    
    User_Feedback.add(FeedbackTitle);
    User_Feedback.add(BackButton);
    User_Feedback.add(SubmitButton);
    User_Feedback.add(FeedbackInput);
    User_Feedback.add(FeedbackLabel);
    User_Feedback.add(UserName);
    User_Feedback.add(UserNameInput);
    
    
    User_Feedback.setLocationRelativeTo(null); 
    
    }
    public void clearFields(){
        UserNameInput.setText("");
        FeedbackInput.setText("");
    }
}
