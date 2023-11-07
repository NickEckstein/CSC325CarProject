package bcs.csc.car.api.model;

import bcs.csc.car.api.sql.model.fueltype.FuelType;
import bcs.csc.car.api.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.model.vehicle.VehicleType;
import bcs.csc.car.api.utils.VehicleIDCounter;
import java.io.Serializable;
import java.util.LinkedList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class Vehicle implements Serializable {

    private final SimpleLongProperty vehicleID;
    private SimpleStringProperty batteryType;
    private SimpleStringProperty bodyStyle;
    private SimpleStringProperty driveType;
    private SimpleStringProperty engineModel;
    private SimpleStringProperty fuelType;
    private SimpleStringProperty make;
    private SimpleStringProperty model;
    private SimpleStringProperty transmission;
    private SimpleStringProperty vehicleType;
    private SimpleLongProperty year;
    private SimpleLongProperty miles;
    private SimpleStringProperty color;
    private SimpleStringProperty conditionDescription;
    private SimpleLongProperty numberOfAccidents;
    private LinkedList<Image> imageList;
    private SimpleDoubleProperty price;

    public Vehicle(String batteryType, String bodyStyle, String driveType, String engineModel, String fuelType, String make, String model, String transmission, String vehicleType, long year, long miles, String color, String conditionDescription, long numberOfAccidents, double price) {
        this.vehicleID = new SimpleLongProperty(VehicleIDCounter.addNewVehicleID());
        this.batteryType = new SimpleStringProperty(batteryType);
        this.bodyStyle = new SimpleStringProperty(bodyStyle);
        this.driveType = new SimpleStringProperty(driveType);
        this.engineModel = new SimpleStringProperty(engineModel);
        this.fuelType = new SimpleStringProperty(fuelType);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.transmission = new SimpleStringProperty(transmission);
        this.vehicleType = new SimpleStringProperty(vehicleType);
        this.year = new SimpleLongProperty(year);
        this.miles = new SimpleLongProperty(miles);
        this.color = new SimpleStringProperty(color);
        this.conditionDescription = new SimpleStringProperty(conditionDescription);
        this.numberOfAccidents = new SimpleLongProperty(numberOfAccidents);
        this.imageList = new LinkedList<>();
        this.price = new SimpleDoubleProperty(price);
    }

    public long getVehicleID() {
        return vehicleID.getValue();
    }

    public String getBatteryType() {
        return batteryType.getValue();
    }

    public String getBodyStyle() {
        return bodyStyle.getValue();
    }

    public String getDriveType() {
        return driveType.getValue();
    }

    public String getEngineModel() {
        return engineModel.getValue();
    }

    public String getFuelType() {
        return fuelType.getValue();
    }

    public String getMake() {
        return make.getValue();
    }

    public String getModel() {
        return model.getValue();
    }

    public String getTransmission() {
        return transmission.getValue();
    }

    public String getVehicleType() {
        return vehicleType.getValue();
    }

    public long getYear() {
        return year.getValue();
    }

    public long getMiles() {
        return miles.getValue();
    }

    public String getColor() {
        return color.getValue();
    }

    public String getConditionDescription() {
        return conditionDescription.getValue();
    }

    public long getNumberOfAccidents() {
        return numberOfAccidents.getValue();
    }

    public LinkedList<Image> getImageList() {
        return imageList;
    }

    public double getPrice() {
        return price.getValue();
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = new SimpleStringProperty(batteryType);
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = new SimpleStringProperty(bodyStyle);
    }

    public void setDriveType(String driveType) {
        this.driveType = new SimpleStringProperty(driveType);
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = new SimpleStringProperty(engineModel);
    }

    public void setFuelType(String fuelType) {
        this.fuelType = new SimpleStringProperty(fuelType);
    }

    public void setMake(String make) {
        this.make = new SimpleStringProperty(make);
    }

    public void setModel(String model) {
        this.model = new SimpleStringProperty(model);
    }

    public void setTransmission(String transmission) {
        this.transmission = new SimpleStringProperty(transmission);
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = new SimpleStringProperty(vehicleType);
    }

    public void setYear(long year) {
        this.year = new SimpleLongProperty(year);
    }

    public void setMiles(long miles) {
        this.miles = new SimpleLongProperty(miles);
    }

    public void setColor(String color) {
        this.color = new SimpleStringProperty(color);
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = new SimpleStringProperty(conditionDescription);
    }

    public void setNumberOfAccidents(long numberOfAccidents) {
        this.numberOfAccidents = new SimpleLongProperty(numberOfAccidents);
    }

    public void setImages(LinkedList<Image> imageList) {
        this.imageList = imageList;
    }

    public void setPrice(double price) {
        this.price = new SimpleDoubleProperty(price);
    }

    @Override
    public String toString() {
        return "Vehicle [Vehicle ID: " + vehicleID.getValue() + " ["
                + "batteryType=" + batteryType
                + ", bodyStyle=" + bodyStyle
                + ", driveType=" + driveType
                + ", engineModel=" + engineModel
                + ", fuelType=" + fuelType
                + ", make=" + make
                + ", model=" + model
                + ", transmission=" + transmission
                + ", vehicleType=" + vehicleType
                + ", year=" + year
                + ", miles=" + miles
                + ", color=" + color
                + ", conditionDescription=\n" + conditionDescription + "\n"
                + ", numberOfAccidents= " + numberOfAccidents
                + ", price=" + price
                + "]]";
    }

}
