package AssignmentVehicle_Rental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class View_Feedback_Page {
    public JFrame getJFrame(){
        feedbackmodel.setRowCount(0);
        importToUserTable();
        return feedbackDetails;
    } 
    
    DefaultTableModel feedbackmodel;
    private JFrame feedbackDetails;
    private JButton BackButton;
    private JLabel Search;
    private JTextField SField;
    
    public View_Feedback_Page(){
        // Design
        feedbackDetails = new JFrame(" Customer Details ");
        feedbackDetails.setBounds(900,700,866,630);     
        feedbackDetails.setLayout(null);
        feedbackDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        feedbackDetails.setResizable(false);
        feedbackDetails.setBackground(new Color(240,255,255));
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        feedbackDetails.setContentPane(panel);
        panel.setLayout(null);
        
        String [] feedbacktable_header = {"Reviews","Username"};
        JTable table = new JTable();
        feedbackmodel = new DefaultTableModel(feedbacktable_header,0){ // specify number of columns

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }; 

        feedbackmodel.setColumnIdentifiers(feedbacktable_header);
        table.setModel(feedbackmodel);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(80, 60, 700, 500);
        feedbackDetails.add(jScrollPane);
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

        table.getColumnModel().getColumn(0).setMinWidth(500);
        table.getColumnModel().getColumn(1).setMinWidth(200);     

        
        table.getTableHeader().setReorderingAllowed(false);
    
        Search = new JLabel("Search:");
        Search.setBounds(270,12,80,25);
        Search.setFont(new Font("Serif", Font.BOLD, 14));
        SField = new JTextField("",20);
        SField.setBounds(330,12,165,25);
        
        SField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                feedbackmodel = (DefaultTableModel) table.getModel();
                String search = SField.getText();
                TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(feedbackmodel);
                table.setRowSorter(sort);
                sort.setRowFilter(RowFilter.regexFilter(search));
            }
        });
        
        BackButton = new JButton("Back");
        BackButton.setBounds(750,10,80,30);
        BackButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        BackButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page3.getJFrame().setVisible(true);
            feedbackDetails.setVisible(false);
        }); 
        
        feedbackDetails.add(Search);
        feedbackDetails.add(SField);
        feedbackDetails.add(BackButton);
        
        feedbackDetails.setLocationRelativeTo(null);
    }
    

    public void importToUserTable(){
        File user_file = new File("Feedback.txt");
        try {
            BufferedReader user_reader = new BufferedReader(new FileReader(user_file));
            Object [] line = user_reader.lines().toArray();
            
            for(int i=0; i<line.length; i++){
                String data = line[i].toString().trim();
                String [] row = data.split("-"); 
                feedbackmodel.addRow(row);
            }               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View_customer_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
