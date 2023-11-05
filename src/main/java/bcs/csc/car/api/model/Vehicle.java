package bcs.csc.car.api.model;

import bcs.csc.car.api.sql.model.fueltype.FuelType;
import bcs.csc.car.api.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.model.make_model.Make;
import bcs.csc.car.api.sql.model.make_model.Model;
import bcs.csc.car.api.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.model.vehicle.VehicleType;
import bcs.csc.car.api.utils.VehicleIDCounter;
import java.io.Serializable;
import java.util.LinkedList;
import javafx.scene.image.Image;

public class Vehicle implements Serializable {

    private final long vehicleID;
    private BatteryType batteryType;
    private BodyStyle bodyStyle;
    private DriveType driveType;
    private EngineModel engineModel;
    private FuelType fuelType;
    private Make make;
    private Model model;
    private Transmission transmission;
    private VehicleType vehicleType;
    private long year;
    private long miles;
    private String color;
    private String conditionDescription;
    private long numberOfAccidents;
    private LinkedList<Image> imageList;

    public Vehicle(BatteryType batteryType, BodyStyle bodyStyle, DriveType driveType, EngineModel engineModel, FuelType fuelType, Make make, Model model, Transmission transmission, VehicleType vehicleType, long year, long miles, String color, String conditionDescription, long numberOfAccidents) {
        this.vehicleID = VehicleIDCounter.addNewVehicleID();
        this.batteryType = batteryType;
        this.bodyStyle = bodyStyle;
        this.driveType = driveType;
        this.engineModel = engineModel;
        this.fuelType = fuelType;
        this.make = make;
        this.model = model;
        this.transmission = transmission;
        this.vehicleType = vehicleType;
        this.year = year;
        this.miles = miles;
        this.color = color;
        this.conditionDescription = conditionDescription;
        this.numberOfAccidents = numberOfAccidents;
        this.imageList = new LinkedList<>();
    }

    public long getVehicleID() {
        return vehicleID;
    }

    public BatteryType getBatteryType() {
        return batteryType;
    }

    public BodyStyle getBodyStyle() {
        return bodyStyle;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public EngineModel getEngineModel() {
        return engineModel;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Make getMake() {
        return make;
    }

    public Model getModel() {
        return model;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public long getYear() {
        return year;
    }

    public long getMiles() {
        return miles;
    }

    public String getColor() {
        return color;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public long getNumberOfAccidents() {
        return numberOfAccidents;
    }

    public LinkedList<Image> getImageList() {
        return imageList;
    }

    public void setBatteryType(BatteryType batteryType) {
        this.batteryType = batteryType;
    }

    public void setBodyStyle(BodyStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    public void setEngineModel(EngineModel engineModel) {
        this.engineModel = engineModel;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setMiles(long miles) {
        this.miles = miles;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public void setNumberOfAccidents(long numberOfAccidents) {
        this.numberOfAccidents = numberOfAccidents;
    }

    public void setImages(LinkedList<Image> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "Vehicle [" + "batteryType=" + batteryType + ", bodyStyle=" + bodyStyle + ", driveType=" + driveType + ", engineModel=" + engineModel + ", fuelType=" + fuelType + ", make=" + make + ", model=" + model + ", transmission=" + transmission + ", vehicleType=" + vehicleType + ", year=" + year + ", miles=" + miles + ", color=" + color + ", conditionDescription=\n" + conditionDescription + "\n" + ", numberOfAccidents= " + numberOfAccidents + "]";
    }

}
