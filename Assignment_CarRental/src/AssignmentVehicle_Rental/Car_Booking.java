package AssignmentVehicle_Rental;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Car_Booking extends JFrame {
    
    DefaultTableModel tModel;
    private static JFrame CarBooking;
    private JButton Confirm, Cancel;
    private JLabel Booking, Price,Email,Username_valid, Username_valid2;      
    private JTextField BookingField, PriceField, EmailField, Username_validField;
    private Label paymentLabel;

    public JFrame getJFrame(){
        tModel.setRowCount(0);
        importToTable();
        return CarBooking;
    
    }
    
    public Car_Booking() {
    CarBooking = new JFrame(" Car Booking ");
    CarBooking.setBounds(900,700,866,630);     
    CarBooking.setLayout(null);
    CarBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CarBooking.setResizable(false);
    CarBooking.setBackground(new Color(240,255,255));
    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(5,5,5,5));
    CarBooking.setContentPane(panel);
    panel.setLayout(null);
    paymentLabel = new Label("The Amount You Need To Pay is: ",Label.CENTER);
    paymentLabel.setFont(new Font("Serif", Font.BOLD, 14));
    
    String [] table_header = {"Car Number", "Car Type", "Car Brand", "Car Price", "Car Status"};
        JTable table = new JTable();
        tModel = new DefaultTableModel(table_header,0){ // specify number of columns

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }; 
        tModel.setColumnIdentifiers(table_header);
        table.setModel(tModel);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(45, 125, 775, 350);
        CarBooking.add(jScrollPane);
        table.setGridColor(Color.BLACK);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLACK);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
      
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        table.getColumnModel().getColumn(0).setMinWidth(155);
        table.getColumnModel().getColumn(1).setMinWidth(155);
        table.getColumnModel().getColumn(2).setMinWidth(155);
        table.getColumnModel().getColumn(3).setMinWidth(155);
        table.getColumnModel().getColumn(4).setMinWidth(155);
        
        table.getTableHeader().setReorderingAllowed(false);

    Booking = new JLabel("Enter The Car Number For Booking:");
    Booking.setBounds(30,50,250,25);
    Booking.setFont(new Font("Serif", Font.BOLD, 14));
    BookingField = new JTextField("",20);
    BookingField.setBounds(270,50,165,25);
    BookingField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String BookCarNumber = BookingField.getText();
                Scanner price;
                try {
                    price = new Scanner(new File("CarDetails.txt"));
                    while(price.hasNextLine()){
                    String s = price.nextLine();
                    String[] sArray = s.split(" ");
                        
                            if(BookCarNumber.equals(sArray[0])){
                                String Price = sArray[3];
                                PriceField.setText(Price);
                            }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Car_Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });    

    Price = new JLabel("The total price is:");
    Price.setBounds(30,80,200,25);
    Price.setFont(new Font("Serif", Font.BOLD, 14));
    PriceField = new JTextField("",20);
    PriceField.setBounds(270,80,165,25);
    
    Email = new JLabel("Enter Your Email:");
    Email.setBounds(480,50,250,25);
    Email.setFont(new Font("Serif", Font.BOLD, 14));
    EmailField = new JTextField("",20);
    EmailField.setBounds(620,50,180,25);
    
    Username_valid = new JLabel("Enter Your Username:");
    Username_valid.setBounds(480,80,320,25);
    Username_valid.setFont(new Font("Serif", Font.BOLD, 14));
    Username_validField = new JTextField("",20);
    Username_validField.setBounds(620,80,180,25);
    
    Username_valid2 = new JLabel("(For Validation Use)");
    Username_valid2.setBounds(480,95,250,15);
    Username_valid2.setFont(new Font("Serif", Font.ITALIC, 8));

    Confirm  = new JButton("Confirm") ;
    Confirm.setBounds(380, 500, 200, 50);
    Confirm.setForeground(Color.BLACK);
    
    Confirm.addActionListener((ActionEvent e) -> {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date rent_time = new Date();
        String rent_Time = formatter.format(rent_time);
        String BookCarNumber = BookingField.getText();
        if(BookCarNumber.isEmpty()){
            JOptionPane.showMessageDialog(CarBooking,"Please Enter The Car Number You Want to Booked !");
        }else{
            String Username = Username_validField.getText();
            if(Username.isEmpty()){
                JOptionPane.showMessageDialog(CarBooking,"Please Enter Your Username! ");
                } else{
            String Email_Input = EmailField.getText();
            String Car_Price = PriceField.getText();
            Random random = new Random();  
            int BookingID = random.nextInt(10000, 100000);
            String value = Integer.toString(BookingID * 19);
            int bookingresult = JOptionPane.showConfirmDialog(null, "Your Booking ID is: IW"+ value + "\n"+ "Your Booking Time & Date is: "+rent_Time + 
                "\n"+"The car you have booked is: " + BookCarNumber +"\n"+ "The Price is: " + Car_Price + "\n"+ "Your Email is: " + Email_Input + "\n"+ "Your Username is: " + Username + "\n"+"Proceed To Payment?","Booking Confirmation" ,JOptionPane.YES_NO_OPTION);
            switch (bookingresult) {
                case JOptionPane.YES_OPTION:
                    String inputPrice = JOptionPane.showInputDialog(CarBooking, "The total amount is "+ Car_Price);
                    int x = Integer.parseInt(inputPrice);
                    int y = Integer.parseInt(Car_Price);
                    if (x>=y) {
                        JOptionPane.showMessageDialog(CarBooking, "Thank you for the payment and the change is RM"+(x-y)+".");
                        String PaymentStatus = "Done";
                        Booking_Info BookingStore;
                        BookingStore = new Booking_Info(value,BookCarNumber,Car_Price,rent_Time,PaymentStatus,Email_Input,Username);
                        File_Data.booking_details.add(new Booking_Info(value,BookCarNumber,Car_Price,rent_Time,PaymentStatus,Email_Input,Username));
                        File_Data.writeInFile();
                        clearFields();
                        Car_RentalMain.page7.getJFrame().setVisible(true); //to usermenu page
                        CarBooking.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(CarBooking,"You need to make the full payment!");
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    clearFields();
                    break;
                }
            }
        }
    });
    
    Cancel  = new JButton("Cancel") ;
    Cancel.setBounds(600, 500, 200, 50);
    Cancel.setForeground(Color.RED);    

    CarBooking.add(Booking);
    CarBooking.add(BookingField);
    CarBooking.add(Email);
    CarBooking.add(EmailField);
    CarBooking.add(Username_valid);
    CarBooking.add(Username_valid2);
    CarBooking.add(Username_validField);
    CarBooking.add(Price);
    CarBooking.add(PriceField);
    CarBooking.add(Confirm);
    CarBooking.add(Cancel);

    
    // Confirm - add files then generate  

    Cancel.addActionListener((ActionEvent e) -> {
        Car_RentalMain.page7.getJFrame().setVisible(true); //to usermenu page
        CarBooking.setVisible(false);
        clearFields();
    });
    
    CarBooking.setLocationRelativeTo(null);

    }
    
    public void importToTable(){
        File file = new File("CarDetails.txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                Object[]lines = reader.lines().toArray();
                
                for(int i=0; i<lines.length; i++){
                String line = lines[i].toString().trim();
                String [] dataRow = line.split(" ");
                tModel.addRow(dataRow);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Car_details_page.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    
    public void clearFields(){
        BookingField.setText(null);
        PriceField.setText(null);
        EmailField.setText(null);
        Username_validField.setText(null);
    }

}
