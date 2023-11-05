package bcs.csc.car.api.utils;

public class VehicleIDCounter {

    private static long id = 0;

    public static long addNewVehicleID() {
        return id++;
    }

}
