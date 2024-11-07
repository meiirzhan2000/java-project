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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class View_customer_details {
    
    public JFrame getJFrame(){
        model.setRowCount(0);
        importToUserTable();
        return customerDetails;
    } 
    
    DefaultTableModel model;
    private JFrame customerDetails;
    private JButton UpdButton, RemButton, BackButton;
    private JLabel Search;
    private JTextField SField;
    
    public View_customer_details(){
        // Design
        customerDetails = new JFrame(" Customer Details ");
        customerDetails.setBounds(900,700,866,630);     
        customerDetails.setLayout(null);
        customerDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerDetails.setResizable(false);
        customerDetails.setBackground(new Color(240,255,255));
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        customerDetails.setContentPane(panel);
        panel.setLayout(null);
        
        String [] usertable_header = {"Username", "Password", "First Name", "Last Name", "Age", "PhoneNo.","Gender", "Address"};
        JTable table = new JTable();
        model = new DefaultTableModel(usertable_header,0){ // specify number of columns

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }; 

        model.setColumnIdentifiers(usertable_header);
        table.setModel(model);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(70, 60, 740, 500);
        customerDetails.add(jScrollPane);
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

        table.getColumnModel().getColumn(0).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(4).setMaxWidth(40);
        table.getColumnModel().getColumn(5).setMinWidth(100);
        table.getColumnModel().getColumn(6).setMinWidth(30);
        table.getColumnModel().getColumn(7).setMinWidth(200);     

        
        table.getTableHeader().setReorderingAllowed(false);
        
        UpdButton = new JButton("Update");
        UpdButton.setBounds(70,10,100,30);
        UpdButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        RemButton = new JButton("Remove");
        RemButton.setBounds(170,10,100,30);
        RemButton.setFont(new Font("Serif", Font.BOLD, 14));
        RemButton.addActionListener((ActionEvent e) -> {
            model.removeRow(table.getSelectedRow());
            
            String Fpath = ("User_Details.txt");
                File file = new File(Fpath);
            
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0; i<table.getRowCount(); i++){
                    for(int y = 0; y<table.getColumnCount(); y++ ){
                        if(y <= 7){
                            bw.write(table.getValueAt(i, y).toString() + "  ");
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
        });
        
        Search = new JLabel("Search:");
        Search.setBounds(270,12,80,25);
        Search.setFont(new Font("Serif", Font.BOLD, 14));
        SField = new JTextField("",20);
        SField.setBounds(330,12,165,25);
        
        SField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                model = (DefaultTableModel) table.getModel();
                String search = SField.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(model);
                table.setRowSorter(sort);
                sort.setRowFilter(RowFilter.regexFilter(search));
            }
        });
        
        BackButton = new JButton("Back");
        BackButton.setBounds(750,10,80,30);
        BackButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        BackButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page3.getJFrame().setVisible(true);
            customerDetails.setVisible(false);
        }); 
        
        customerDetails.add(Search);
        customerDetails.add(SField);
        customerDetails.add(UpdButton);
        customerDetails.add(RemButton);
        customerDetails.add(BackButton);
        
        customerDetails.setLocationRelativeTo(null);
    }
    

    public void importToUserTable(){
        File user_file = new File("User_Details.txt");
        try {
            BufferedReader user_reader = new BufferedReader(new FileReader(user_file));
            Object [] line = user_reader.lines().toArray();
            
            for(int i=0; i<line.length; i++){
                String data = line[i].toString().trim();
                String [] row = data.split("  "); //2 space
                model.addRow(row);
            }               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View_customer_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
