package AssignmentVehicle_Rental;

public class Booking_Info {

    private String BookingID;
    private String BookCarNum;
    private String Price; 
    private String date;
    private String paymentStatus;
    private String email;
    private String User; 

    public Booking_Info(String BookingID, String BookCarNum, String Price, String date, String paymentStatus, String email, String User) {
        this.BookingID = BookingID;
        this.BookCarNum = BookCarNum;
        this.Price = Price;
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.email = email;
        this.User = User;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }

    public String getBookCarNum() {
        return BookCarNum;
    }

    public void setBookCarNum(String BookCarNum) {
        this.BookCarNum = BookCarNum;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    

    
    
}