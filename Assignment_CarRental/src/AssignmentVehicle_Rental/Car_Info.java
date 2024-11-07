package AssignmentVehicle_Rental;

public class Car_Info {
    
    private String CarNumber;
    private String CarType;
    private String CarBrand;
    private String CarPrice;
    private String CarStatus;

    public Car_Info(String CarNumber, String CarType, String CarBrand, String CarPrice, String CarStatus) {
        this.CarNumber = CarNumber;
        this.CarType = CarType;
        this.CarBrand = CarBrand;
        this.CarPrice = CarPrice;
        this.CarStatus = CarStatus;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String CarNumber) {
        this.CarNumber = CarNumber;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String CarBrand) {
        this.CarBrand = CarBrand;
    }

    public String getCarPrice() {
        return CarPrice;
    }

    public void setCarPrice(String CarPrice) {
        this.CarPrice = CarPrice;
    }

    public String getCarStatus() {
        return CarStatus;
    }

    public void setCarStatus(String CarStatus) {
        this.CarStatus = CarStatus;
    }
}
