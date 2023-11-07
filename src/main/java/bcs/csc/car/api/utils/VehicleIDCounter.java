package bcs.csc.car.api.utils;

public class VehicleIDCounter {

    private static long id = 1;

    public static long addNewVehicleID() {
        return id++;
    }

}
