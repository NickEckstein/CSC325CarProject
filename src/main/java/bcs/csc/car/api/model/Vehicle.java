package bcs.csc.car.api.model;

import java.util.LinkedList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author Brian
 */
public class Vehicle {

    private SimpleStringProperty email;
    private SimpleStringProperty make;
    private SimpleStringProperty model;
    private SimpleIntegerProperty year;
    private SimpleStringProperty color;
    private SimpleStringProperty fuelType;
    private SimpleIntegerProperty miles;
    private SimpleIntegerProperty accidents;
    private SimpleDoubleProperty price;
    private String additionalInformation;
    private LinkedList<Image> imageList;

    public Vehicle(String email, String make, String model, int year, String color, String fuelType, int miles, int accidents, double price, String additionalInformation) {
        this.email = new SimpleStringProperty(email);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleIntegerProperty(year);
        this.color = new SimpleStringProperty(color);
        this.fuelType = new SimpleStringProperty(fuelType);
        this.miles = new SimpleIntegerProperty(miles);
        this.accidents = new SimpleIntegerProperty(accidents);
        this.price = new SimpleDoubleProperty(price);
        this.additionalInformation = additionalInformation;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getMake() {
        return make.getValue();
    }

    public String getModel() {
        return model.getValue();
    }

    public int getYear() {
        return year.getValue();
    }

    public String getColor() {
        return color.getValue();
    }

    public String getFuelType() {
        return fuelType.getValue();
    }

    public int getMiles() {
        return miles.getValue();
    }

    public int getAccidents() {
        return accidents.getValue();
    }

    public double getPrice() {
        return price.getValue();
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public LinkedList<Image> getImageList() {
        return imageList;
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setMake(String make) {
        this.make = new SimpleStringProperty(make);
    }

    public void setModel(String model) {
        this.model = new SimpleStringProperty(model);
    }

    public void setYear(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    public void setColor(String color) {
        this.color = new SimpleStringProperty(color);
    }

    public void setFuelType(String fuelType) {
        this.fuelType = new SimpleStringProperty(fuelType);
    }

    public void setMiles(int miles) {
        this.miles = new SimpleIntegerProperty(miles);
    }

    public void setAccidents(int accidents) {
        this.accidents = new SimpleIntegerProperty(accidents);
    }

    public void setPrice(double price) {
        this.price = new SimpleDoubleProperty(price);
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setImageList(LinkedList<Image> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "Vehicle{"
                + " make=" + make.getValue()
                + ", model=" + model.getValue()
                + ", year=" + year.getValue()
                + ", color=" + color.getValue()
                + ", fuelType=" + fuelType.getValue()
                + ", miles=" + miles.getValue()
                + ", accidents=" + accidents.getValue()
                + ", price=" + price.getValue()
                + ", additionalInformation=" + additionalInformation
                + '}';
    }

}
