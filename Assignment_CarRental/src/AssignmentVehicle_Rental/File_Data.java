package AssignmentVehicle_Rental;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class File_Data {
    public static ArrayList<Car_Info> car_details = new ArrayList<Car_Info>();
    public static ArrayList<User_Info> user_details = new ArrayList<User_Info>();
    public static ArrayList<Booking_Info> booking_details = new ArrayList<Booking_Info>();
    public static ArrayList<Feedback_Info> feedback_data = new ArrayList<Feedback_Info>();
    
    public static void writeInFile(){
        try{
            FileWriter w = new FileWriter("CarDetails.txt", true);
            BufferedWriter bw = new BufferedWriter(w);
            for(Car_Info c: car_details){
                w.write(c.getCarNumber()+ " " + c.getCarType() + " " + c.getCarBrand() + " " + c.getCarPrice() + " " + c.getCarStatus()+"\n");
            }
            w.close();
            FileWriter i = new FileWriter("User_Details.txt",true);
            for(User_Info u: user_details){
                i.write(u.getUsername()+ "  " + u.getPassword() + "  " + u.getFirstName() +
                        "  " + u.getLastName() + "  " + u.getAge() + "  " + u.getPhone() +
                        "  " + u.getGender() + "  " + u.getAddress()+"\n");
            }
            i.close();        
            FileWriter d = new FileWriter("BookingDetails.txt", true);
            for(Booking_Info b: booking_details){
                d.write("IW"+b.getBookingID()+ " " + b.getBookCarNum() + " "+ b.getPrice()+" "+b.getDate()+" "+b.getPaymentStatus() +" "+ b.getEmail()+" "+b.getUser()+"\n");
            }
            d.close();
            FileWriter fb = new FileWriter("Feedback.txt", true);
            for(Feedback_Info f: feedback_data){
                fb.write(f.getReview()+"-"+f.getUsername()+"\n");
            }
            fb.close();
        }
        catch(IOException e){
        JOptionPane.showMessageDialog(null, "Error in writing file.");
        }
    }
    
    
    
    
    
   
    public static void read(){ //read booking details
        
        try{
            Scanner scan = new Scanner(new File("BookingDetails.txt"));
            int n = 0;
            String BookingID = null;
            String BookCarNum = null;
            String Price = null;
            String date = null;
            String paymentStatus = null;
            String email = null;
            String User = null;
            Booking_Info BookingStore;

            while(scan.hasNext()){
                String store = scan.nextLine();
                StringTokenizer st = new StringTokenizer (store," ");
                
                while(st.hasMoreTokens()){
                    n++;
                    if(n == 1){
                        BookingID = st.nextToken();
                    }
                    else if(n == 2){
                        BookCarNum = st.nextToken();
                    }
                    else if(n == 3){
                        Price = st.nextToken();
                    }
                    else if(n == 4){
                        date = st.nextToken();
                    }
                    else if(n == 5){
                        paymentStatus = st.nextToken();
                    }
                    else if(n == 6){
                        email = st.nextToken();
                    }
                    else if(n == 7){
                        paymentStatus = st.nextToken();
                    }
                    if(n == 8){
                        break;
                    }
                }
                BookingStore = new Booking_Info(BookingID,BookCarNum,Price,date,paymentStatus,email,User);
                booking_details.add(BookingStore);
                n = 0;
            }  
        }
        catch(Exception e){
                System.out.println("Error");
            }
    }
    
}
