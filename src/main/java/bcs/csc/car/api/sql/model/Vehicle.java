package bcs.csc.car.api.sql.model;

import bcs.csc.car.api.sql.model.fueltype.FuelType;
import bcs.csc.car.api.sql.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.sql.model.make_model.Make;
import bcs.csc.car.api.sql.sql.model.make_model.Model;
import bcs.csc.car.api.sql.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.sql.model.vehicle.VehicleType;

public class Vehicle {

    private BatteryType batteryType;
    private BodyStyle bodyStyle;
    private DriveType driveType;
    private EngineModel engineModel;
    private FuelType fuelType;
    private Make make;
    private Model model;
    private Transmission transmission;
    private VehicleType vehicleType;

    public Vehicle(BatteryType batteryType, BodyStyle bodyStyle, DriveType driveType, EngineModel engineModel, FuelType fuelType, Make make, Model model, Transmission transmission, VehicleType vehicleType) {
        this.batteryType = batteryType;
        this.bodyStyle = bodyStyle;
        this.driveType = driveType;
        this.engineModel = engineModel;
        this.fuelType = fuelType;
        this.make = make;
        this.model = model;
        this.transmission = transmission;
        this.vehicleType = vehicleType;
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

    @Override
    public String toString() {
        return "Vehicle [" + "batteryType=" + batteryType + ", bodyStyle=" + bodyStyle + ", driveType=" + driveType + ", engineModel=" + engineModel + ", fuelType=" + fuelType + ", make=" + make + ", model=" + model + ", transmission=" + transmission + ", vehicleType=" + vehicleType + "]";
    }

}
