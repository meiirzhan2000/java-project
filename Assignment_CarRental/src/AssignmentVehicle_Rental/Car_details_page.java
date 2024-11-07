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
import javax.swing.JComboBox;
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



public class Car_details_page extends JFrame{
    public JFrame getJFrame(){
        tableModel.setRowCount(0);
        importToTable();
        return carDetails;
    } 
    
    public void clearFields(){
        NumberField.setText(null);
        PriceField.setText(null);
        StatusField.setText(null);
    }
    
    DefaultTableModel tableModel;
    private JFrame carDetails;
    private JButton BackButton, AddButton, UpdateButton, RemoveButton, ClearButton, RefreshButton;
    private JLabel CNumber, CType, CBrand, CPrice, CStatus, Search;
    private JTextField NumberField, PriceField, StatusField, SearchField;
    private JComboBox CarTypeChoice, CarBrandChoice;
    private JTable table;
    
    
    public Car_details_page(){

        // Design
        carDetails = new JFrame(" Car Details ");
        carDetails.setBounds(900,700,866,630);     
        carDetails.setLayout(null);
        carDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carDetails.setResizable(false);
        carDetails.setBackground(new Color(240,255,255));
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        carDetails.setContentPane(panel);
        panel.setLayout(null);
        
        String [] table_header = {"Car Number", "Car Type", "Car Brand", "Car Price", "Car Status"};
        table = new JTable();
        tableModel = new DefaultTableModel(table_header,0){ // specify number of columns

            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        }; 
        tableModel.setColumnIdentifiers(table_header);
        table.setModel(tableModel);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(70, 200, 740, 350);
        carDetails.add(jScrollPane);
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

        table.getColumnModel().getColumn(0).setMinWidth(148);
        table.getColumnModel().getColumn(1).setMinWidth(148);
        table.getColumnModel().getColumn(2).setMinWidth(148);
        table.getColumnModel().getColumn(3).setMinWidth(148);
        table.getColumnModel().getColumn(4).setMinWidth(148);
        
        table.getTableHeader().setReorderingAllowed(false);
      
        CNumber = new JLabel("Car Number:");
        CNumber.setBounds(70,50,90,25);
        CNumber.setFont(new Font("Serif", Font.BOLD, 14));
        NumberField = new JTextField("",20);
        NumberField.setBounds(150,50,165,25);

        //Combo Box - 5, 7 seated
        CType = new JLabel("Type:");
        CType.setBounds(70,80,80,25);
        CType.setFont(new Font("Serif", Font.BOLD, 14));
        String Car_Type[] = {"5-seaters", "7-seaters"};
        CarTypeChoice = new JComboBox<>(Car_Type);
        CarTypeChoice.setBounds(150, 80, 150, 25);
        
        //Combo Box - Toyota, Honda, Perodua, Mazda
        CBrand = new JLabel("Brand:");
        CBrand.setBounds(70,110,80,25);
        CBrand.setFont(new Font("Serif", Font.BOLD, 14));
        String Car_Brand[] = {"Toyota", "Honda","Perodua","Mazda"};
        CarBrandChoice = new JComboBox<>(Car_Brand);
        CarBrandChoice.setBounds(150, 110, 150, 25);

        CPrice = new JLabel("Price:");
        CPrice.setBounds(70,140,80,25);
        CPrice.setFont(new Font("Serif", Font.BOLD, 14));
        PriceField = new JTextField("",20);
        PriceField.setBounds(150,140,165,25);
        
        CStatus = new JLabel("Status:");
        CStatus.setBounds(70,170,80,25);
        CStatus.setFont(new Font("Serif", Font.BOLD, 14));
        StatusField = new JTextField("",20);
        StatusField.setBounds(150,170,165,25);
        
        Search = new JLabel("Search:");
        Search.setBounds(600,50,80,25);
        Search.setFont(new Font("Serif", Font.BOLD, 14));
        SearchField = new JTextField("",20);
        SearchField.setBounds(650,50,165,25);
        
        SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tableModel = (DefaultTableModel) table.getModel();
                String search = SearchField.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(tableModel);
                table.setRowSorter(sort);
                sort.setRowFilter(RowFilter.regexFilter(search));
            }
        });

        AddButton = new JButton("Add");
        AddButton.setBounds(200,10,100,30);
        AddButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        AddButton.addActionListener((ActionEvent e) -> {
            String CarNumber;
            String CarType;
            String CarBrand;
            String CarPrice;
            String CarStatus;
            Car_Info CarStore;
            tableModel.insertRow(table.getRowCount(), new Object[]{
            CarNumber = NumberField.getText().trim(),
            CarType = CarTypeChoice.getSelectedItem().toString(),
            CarBrand = CarBrandChoice.getSelectedItem().toString(),
            CarPrice = PriceField.getText().trim(),
            CarStatus = StatusField.getText().trim(),
            });
            
            if (CarNumber.isEmpty() && CarPrice.isEmpty() && CarStatus.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Car Number, Car Price and Car Status !");
            } else {
                if (CarNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Car Number !");
                } else {
                    if (CarPrice.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Car Price !");
                    } else {
                        if (CarStatus.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Enter Car Status !");
                        }else{
                            if (!CarNumber.isEmpty() && !CarPrice.isEmpty() && !CarStatus.isEmpty()) {
                            CarStore = new Car_Info(CarNumber,CarType,CarBrand,CarPrice,CarStatus);
                            File_Data.car_details.add(new Car_Info(CarNumber,CarType,CarBrand,CarPrice,CarStatus));
                            File_Data.writeInFile();
                            clearFields();
                            JOptionPane.showMessageDialog(null, "Data Added.");
                            }
                        }
                    }
                }
            }
            
        });
        
        UpdateButton = new JButton("Update");
        UpdateButton.setBounds(300,10,100,30);
        UpdateButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        UpdateButton.addActionListener((ActionEvent e) -> {
            tableModel = (DefaultTableModel) table.getModel();
            if(table.getSelectedRowCount() == 1){
                String Fpath = ("CarDetails.txt");
                File file = new File(Fpath);
                
                
                String CarNumber = NumberField.getText();
                String CarType = CarTypeChoice.getSelectedItem().toString();
                String CarBrand = CarBrandChoice.getSelectedItem().toString();
                String CarPrice = PriceField.getText();
                String CarStatus = StatusField.getText();
                
                tableModel.setValueAt(CarNumber, table.getSelectedRow(), 0);
                tableModel.setValueAt(CarType, table.getSelectedRow(), 1);
                tableModel.setValueAt(CarBrand, table.getSelectedRow(), 2);
                tableModel.setValueAt(CarPrice, table.getSelectedRow(), 3);
                tableModel.setValueAt(CarStatus, table.getSelectedRow(), 4);
  
                try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0; i<table.getRowCount(); i++){
                    for(int y = 0; y<table.getColumnCount(); y++ ){
                        if(y <= 4){
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
                Logger.getLogger(Car_details_page.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        RemoveButton = new JButton("Remove");
        RemoveButton.setBounds(400,10,100,30);
        RemoveButton.setFont(new Font("Serif", Font.BOLD, 14));
        RemoveButton.addActionListener((ActionEvent e) -> {
            tableModel.removeRow(table.getSelectedRow());
            
            String Fpath = ("CarDetails.txt");
                File file = new File(Fpath);
            
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0; i<table.getRowCount(); i++){
                    for(int y = 0; y<table.getColumnCount(); y++ ){
                        if(y <= 4){
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
                Logger.getLogger(Car_details_page.class.getName()).log(Level.SEVERE, null, ex);
            }  
        });
        
        ClearButton = new JButton("Clear All");
        ClearButton.setBounds(500,10,100,30);
        ClearButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        ClearButton.addActionListener((ActionEvent e) -> {
                clearFields();
            });

        RefreshButton = new JButton("Refresh");
        RefreshButton.setBounds(600,10,100,30);
        RefreshButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        RefreshButton.addActionListener((ActionEvent e) -> {
            tableModel.setRowCount(0);
            importToTable();
            });
        
        
        BackButton = new JButton("Back");
        BackButton.setBounds(750,10,80,30);
        BackButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        BackButton.addActionListener((ActionEvent e) -> {
            Car_RentalMain.page3.getJFrame().setVisible(true);
            carDetails.setVisible(false);
        });        
        
        carDetails.add(CNumber);
        carDetails.add(NumberField);
        carDetails.add(CType);
        carDetails.add(CarTypeChoice);
        carDetails.add(CBrand);
        carDetails.add(CarBrandChoice);
        carDetails.add(CPrice);
        carDetails.add(PriceField);
        carDetails.add(CStatus);
        carDetails.add(StatusField);
        carDetails.add(AddButton);
        carDetails.add(UpdateButton);
        carDetails.add(RemoveButton);
        carDetails.add(BackButton);
        carDetails.add(ClearButton);
        carDetails.add(RefreshButton);
        carDetails.add(Search);
        carDetails.add(SearchField);

                
        carDetails.setLocationRelativeTo(null);
    }
    
    public void importToTable(){
        File file = new File("CarDetails.txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                Object[]lines = reader.lines().toArray();
                
                for(int i=0; i<lines.length; i++){
                String line = lines[i].toString().trim();
                String [] dataRow = line.split(" ");
                tableModel.addRow(dataRow);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Car_details_page.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    

}


