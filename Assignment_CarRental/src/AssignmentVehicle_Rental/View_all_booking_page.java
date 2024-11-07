package AssignmentVehicle_Rental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class View_all_booking_page {
    
    public JFrame getJFrame(){
        bookingModel.setRowCount(0);
        importToBookingTable();
        return viewBooking;
    } 
    
    DefaultTableModel bookingModel;
    private JFrame viewBooking;
    private JButton RemButton,BackButton;
    private JLabel Search;
    private JTextField SField;

    public View_all_booking_page(){

        // Design
        viewBooking = new JFrame(" Booking Details");
        viewBooking.setBounds(900,700,866,630);     
        viewBooking.setLayout(null);
        viewBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewBooking.setResizable(false);
        viewBooking.setBackground(new Color(240,255,255));
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        viewBooking.setContentPane(panel);
        panel.setLayout(null);
        String [] bookingtable_header = {"Booking ID", "Booked Car Number", "Payment", "Booking Date", "Booking Time", "Payment Status", "User Email", "Username"};
        JTable table = new JTable();
        bookingModel = new DefaultTableModel(bookingtable_header,0){ // specify number of columns

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }; 

        bookingModel.setColumnIdentifiers(bookingtable_header);
        table.setModel(bookingModel);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(32, 55, 800, 500);
        viewBooking.add(jScrollPane);
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
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

        table.getColumnModel().getColumn(0).setMinWidth(90);
        table.getColumnModel().getColumn(1).setMinWidth(120);
        table.getColumnModel().getColumn(2).setMinWidth(60);
        table.getColumnModel().getColumn(3).setMinWidth(80);   
        table.getColumnModel().getColumn(4).setMinWidth(85);   
        table.getColumnModel().getColumn(5).setMinWidth(95);   
        table.getColumnModel().getColumn(6).setMinWidth(145); 
        table.getColumnModel().getColumn(7).setMinWidth(115); 

        table.getTableHeader().setReorderingAllowed(false);

        RemButton = new JButton("Cancel Booking");
        RemButton.setBounds(70,10,200,30);
        RemButton.setFont(new Font("Serif", Font.BOLD, 14));
        RemButton.addActionListener((ActionEvent e) -> {
            int confirmation = JOptionPane.showConfirmDialog(viewBooking, "Are you sure you want to cancel this booking?", "Cancel Booking", JOptionPane.YES_NO_OPTION);
            if(confirmation == JOptionPane.YES_OPTION){
                bookingModel.removeRow(table.getSelectedRow());
                String Fpath = ("BookingDetails.txt");
                File file = new File(Fpath);
            
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0; i<table.getRowCount(); i++){
                    for(int y = 0; y<table.getColumnCount(); y++ ){
                        if(y <= 7){
                            bw.write(table.getValueAt(i, y).toString() + " ");
                        } else {
                            bw.write(table.getValueAt(i, y).toString());
                        }
                }
                bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(View_customer_details.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else{
                if(confirmation == JOptionPane.NO_OPTION){
                    Car_RentalMain.page3.getJFrame().setVisible(true);
                    viewBooking.dispose();
                }
            }
        });
        
        Search = new JLabel("Search:");
        Search.setBounds(270,12,80,25);
        Search.setFont(new Font("Serif", Font.BOLD, 14));
        SField = new JTextField("",20);
        SField.setBounds(330,12,165,25);
        
        SField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                bookingModel = (DefaultTableModel) table.getModel();
                String search = SField.getText();
                TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(bookingModel);
                table.setRowSorter(sort);
                sort.setRowFilter(RowFilter.regexFilter(search));
            }
        });
        
        BackButton = new JButton("Back");
        BackButton.setBounds(750,10,80,30);
        BackButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        BackButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page3.getJFrame().setVisible(true);
            viewBooking.setVisible(false);
        });        
        
        viewBooking.add(RemButton);
        viewBooking.add(Search);
        viewBooking.add(SField);
        viewBooking.add(BackButton);
        
        
        viewBooking.setLocationRelativeTo(null);
    }
    
    public void importToBookingTable(){
        File file = new File("BookingDetails.txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                Object[]lines = reader.lines().toArray();
                
                for(int i=0; i<lines.length; i++){
                String line = lines[i].toString().trim();
                String [] dataRow = line.split(" ");
                bookingModel.addRow(dataRow);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Car_details_page.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
}
