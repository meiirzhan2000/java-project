package AssignmentVehicle_Rental;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import static java.lang.Integer.parseInt;

public class User_Login_Page extends JFrame{

    public JFrame getJFrame(){
        return loginMenu;
    }        

    private JFrame loginMenu;
    private JLabel Username, password, Title, signUpQues;
    private JTextField inputField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private JToggleButton showPS;
    
    // 窗口设定
    public User_Login_Page(){
        
        // Interface Design
        loginMenu = new JFrame(" IW Car Rental ");
        loginMenu.setBounds(500,300,380,300);     
        loginMenu.setLayout(null);
        loginMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginMenu.setResizable(false);
        Title = new JLabel("Login Page");
        Title.setBounds(160,20,200,25);
        Title.setFont(new Font("Serif", Font.BOLD, 14));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        loginMenu.add(panel);
        
        Username = new JLabel("Username:");
        Username.setBounds(70,50,80,25);
        Username.setFont(new Font("Serif", Font.BOLD, 14));
        inputField = new JTextField("",20);
        inputField.setBounds(150,50,165,25);

        password = new JLabel("Password:");
        password.setBounds(70,90,80,25);
        password.setFont(new Font("Serif", Font.BOLD, 14));
        passwordField = new JPasswordField("",20);
        passwordField.setBounds(150,90,165,25);
        
        ImageIcon icon = new ImageIcon("showPassword.png");        
        showPS = new JToggleButton("");
        showPS.setBounds(310,89,28,28);
        showPS.setIcon(icon);

        showPS.addMouseListener(new MouseAdapter() {     //logic for show password 
            @Override
            public void mouseClicked(MouseEvent e) {
                if(showPS.isSelected()) {
                    passwordField.setEchoChar((char)0);
                }else {
                    passwordField.setEchoChar('●');
                }
            }
        });
        
        signUpQues = new JLabel("Do not have an account?");
        signUpQues.setBounds(120,115,200,25);
        signUpQues.setFont(new Font("Serif", Font.BOLD, 14));

        registerButton = new JButton("Sign Up");
        registerButton.setBounds(110,140,80,25);
        registerButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car_RentalMain.page2.getJFrame().setVisible(true);
                loginMenu.setVisible(false);
            }
        });
        
        loginButton = new JButton("Login");
        loginButton.setBounds(190,140,80,25);
        loginButton.setFont(new Font("Serif", Font.BOLD, 14));
        loginButton.addActionListener(new LoginActionListener());
                
        loginMenu.add(Title);
        loginMenu.add(Username);
        loginMenu.add(inputField);
        loginMenu.add(password);
        loginMenu.add(passwordField);
        loginMenu.add(signUpQues);
        loginMenu.add(loginButton);
        loginMenu.add(registerButton);
        loginMenu.add(showPS);
        
 
        loginMenu.setLocationRelativeTo(null);
        loginMenu.setVisible(true);
    }
    

    private class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File inputfile= new File("User_Details.txt");
            String username = inputField.getText();
            String password = passwordField.getText();
            if(username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Invalid UserName/Password", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
            if (username.trim().equalsIgnoreCase("123") //crmanagement_IW
                && password.equals("123")) { //hi4859
                inputField.setText("");
                passwordField.setText("");
                Car_RentalMain.page3.getJFrame().setVisible(true);
                loginMenu.setVisible(false);         
                    } else {
                    try{
                        Scanner ud = new Scanner(new File("User_Details.txt"));
                        while(ud.hasNextLine()){
                            String s =ud.nextLine();
                            String[] sArray = s.split("  ");
                            
                            if(!username.equals(sArray[0]) || !password.equals(sArray[1])){
                                inputField.setText("");
                                passwordField.setText("");
                                } else {
                                    if(username.equals(sArray[0]) && password.equals(sArray[1])){
                                        Car_RentalMain.userLogin = new User_Info(sArray[0], sArray[1], sArray[2], sArray[3], parseInt(sArray[4]), sArray[5], sArray[6], sArray[7]);
                                    Car_RentalMain.page7.getJFrame().setVisible(true);
                                    loginMenu.setVisible(false);
                                }
                            }
                        }
                }catch(FileNotFoundException p){
                }
            }
            }
        }
    }
}



