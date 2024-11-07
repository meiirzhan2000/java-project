package AssignmentVehicle_Rental;

public class Car_RentalMain {
    public static User_Login_Page page1;
    public static Register page2;
    public static Admin_Menu page3;
    public static View_all_booking_page page4;
    public static Car_details_page page5;
    public static View_customer_details page6;
    public static User_Menu page7;
    public static Car_Booking page8;
    public static Feedback_Page page9;
    public static View_Feedback_Page page10;
    public static User_Info userLogin = null;

    public static void main(String[] args) {
        
        page1 = new User_Login_Page();
        page2 = new Register();
        page3 = new Admin_Menu();
        page4 = new View_all_booking_page();
        page5 = new Car_details_page();
        page6 = new View_customer_details();
        page7 = new User_Menu();
        page8 = new Car_Booking();
        page9 = new Feedback_Page();
        page10 = new View_Feedback_Page();
    }
}
