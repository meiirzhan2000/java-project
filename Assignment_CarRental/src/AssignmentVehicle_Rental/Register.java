package AssignmentVehicle_Rental;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Register extends JFrame{
    
    public JFrame getJFrame(){
        return registerMenu;
    }
    
    public void clearFields(){
        inputField.setText("");
        firstField.setText(null);
        lastField.setText(null);
        passwordField.setText(null);
        ageField.setText(null);
        phoneField.setText(null);
        addressField.setText(null);
    }
    
    private JFrame registerMenu;
    private JLabel Username, password, Title, firstName, lastName, age, phone, address, genderOption;
    private JTextField inputField, firstField, lastField, ageField, phoneField, addressField;
    private JPasswordField passwordField;
    private JButton regButton, backButton;
    private JToggleButton showPassword;
    private JRadioButton male, female;
    private ButtonGroup Gender;
    
    // 窗口设定
    public Register(){
        
        // Interface Design
        registerMenu = new JFrame(" IW Car Rental ");
        registerMenu.setBounds(360,505,360,505);     
        registerMenu.setLayout(null);
        registerMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerMenu.setResizable(false);
        Title = new JLabel("Register Page");
        Title.setBounds(140,20,200,25);
        Title.setFont(new Font("Serif", Font.BOLD, 14));
        
        Username = new JLabel("Username:");
        Username.setBounds(70,50,80,25);
        Username.setFont(new Font("Serif", Font.BOLD, 14));
        inputField = new JTextField("",20);
        inputField.setBounds(150,50,165,25);

        firstName = new JLabel("First Name:");
        firstName.setBounds(70,80,80,25);
        firstName.setFont(new Font("Serif", Font.BOLD, 14));
        firstField = new JTextField("",20);
        firstField.setBounds(150,80,165,25);
        
        lastName = new JLabel("Last Name:");
        lastName.setBounds(70,110,80,25);
        lastName.setFont(new Font("Serif", Font.BOLD, 14));
        lastField = new JTextField("",20);
        lastField.setBounds(150,110,165,25);
              
        age = new JLabel("Age:");
        age.setBounds(70,140,80,25);
        age.setFont(new Font("Serif", Font.BOLD, 14));
        ageField = new JTextField("",20);
        ageField.setBounds(150,140,165,25);
        
        password = new JLabel("Password:");
        password.setBounds(70,170,80,25);
        password.setFont(new Font("Serif", Font.BOLD, 14));
        passwordField = new JPasswordField("",20);
        passwordField.setBounds(150,170,165,25);
        
        ImageIcon icon = new ImageIcon("showPassword.png");        
        showPassword = new JToggleButton("");
        showPassword.setBounds(310,169,28,28);
        showPassword.setIcon(icon);
        
        showPassword.addMouseListener(new MouseAdapter() {     // for show password 
            @Override
            public void mouseClicked(MouseEvent e) {
                if(showPassword.isSelected()) {
                    passwordField.setEchoChar((char)0);
                }else {
                    passwordField.setEchoChar('●');
                }
            }
        });

        genderOption = new JLabel("Select Your Gender:");
        genderOption.setBounds(70,200,150,25);
        genderOption.setFont(new Font("Serif", Font.BOLD, 14));
        
        male = new JRadioButton("MALE");
        male.setBounds(90,220,80,25);
        male.setFont(new Font("Serif", Font.BOLD, 12));
        
        female = new JRadioButton("FEMALE");
        female.setBounds(150,220,100,25);
        female.setFont(new Font("Serif", Font.BOLD, 12));
        
        Gender = new ButtonGroup();
        Gender.add(male);
        Gender.add(female);
        
        phone = new JLabel("Phone:");
        phone.setBounds(70,250,80,25);
        phone.setFont(new Font("Serif", Font.BOLD, 14));
        phoneField = new JTextField("",20);
        phoneField.setBounds(150,250,165,25);
         
        address = new JLabel("Address:");
        address.setBounds(70,280,80,25);
        address.setFont(new Font("Serif", Font.BOLD, 14));
        addressField = new JTextField("",20);
        addressField.setBounds(150,280,165,25);
        
        regButton = new JButton("Register");
        regButton.setBounds(110,305,80,25);
        regButton.setFont(new Font("Serif", Font.BOLD, 14));
        regButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                String Username;
                String password;
                String firstName;
                String lastName;
                int Age;
                String Gender; 
                String Phone;
                String Address;

                User_Info UserStore;
                Username = inputField.getText();
                password = passwordField.getText();
                firstName = firstField.getText();
                lastName = lastField.getText();
                Age = Integer.parseInt(ageField.getText());
                Gender = selectGender();
                Phone = phoneField.getText();            
                Address = addressField.getText();
               
                if (Username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Your Username !");
                } else {
                    if (firstName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter Your First Name !");
                    } else {
                        if (lastName.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please Enter Your Last Name !");
                        } else{
                            if(Age < 17){
                            JOptionPane.showMessageDialog(null, "Please Re-Enter Your Age !");
                            } else{
                                if (password.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Please Enter Your Password !");
                                } else{
                                    if (!male.isSelected() && !female.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Please Select The Gender !");
                                        }
                                    } if (Phone.isEmpty()){
                                        JOptionPane.showMessageDialog(null, "Please Enter Your Phone Number !");
                                    } else{
                                        if(Address.isEmpty()){
                                        JOptionPane.showMessageDialog(null, "Please Enter Your Address !");
                                        } else{ 
                                            if(Username.isEmpty()||password.isEmpty()||firstName.isEmpty()||lastName.isEmpty() || !male.isSelected() && !female.isSelected() || Age < 17 || Phone.isEmpty()|| Address.isEmpty()){ 
                                                JOptionPane.showMessageDialog(null, "Please Enter The Details !");
                                        } else{
                                                if(!Username.isEmpty()&&!password.isEmpty()&&!firstName.isEmpty()&&!lastName.isEmpty()&& male.isSelected() || female.isSelected()&& Age >= 17&& !Phone.isEmpty()&&!Address.isEmpty()){
                                                UserStore = new User_Info(Username,password,firstName,lastName,Age,Phone,Gender,Address);
                                                File_Data.user_details.add(new User_Info(Username,password,firstName,lastName,Age,Phone,Gender,Address));
                                                File_Data.writeInFile();
                                                clearFields();
                                                Car_RentalMain.page1.getJFrame().setVisible(true);
                                                registerMenu.dispose();
                                                regButton.setEnabled(false);
                                            }
                                        }
                                    }
                                }
                                }
                            }
                        }
                    }
            }
        });

        backButton = new JButton("Return");
        backButton.setBounds(190,305,80,25);
        backButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        backButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                Car_RentalMain.page1.getJFrame().setVisible(true);
                registerMenu.dispose();
            }
        });
        
        registerMenu.add(Title);
        registerMenu.add(Username);
        registerMenu.add(inputField);
        registerMenu.add(firstName);
        registerMenu.add(firstField);
        registerMenu.add(lastName);
        registerMenu.add(lastField);
        registerMenu.add(age);
        registerMenu.add(ageField);
        registerMenu.add(password);
        registerMenu.add(passwordField);
        registerMenu.add(showPassword);
        registerMenu.add(regButton);
        registerMenu.add(genderOption);
        registerMenu.add(male);
        registerMenu.add(female);
        registerMenu.add(phone); 
        registerMenu.add(phoneField);
        registerMenu.add(address); 
        registerMenu.add(addressField);
        registerMenu.add(backButton);
 
        registerMenu.setLocationRelativeTo(null);
        
    }
    
    public String selectGender() {
        if (male.isSelected()) {
            return "MALE";
        } else {
            return "FEMALE";
        }
    }

}
