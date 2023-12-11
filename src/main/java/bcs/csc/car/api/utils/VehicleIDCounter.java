package bcs.csc.car.api.utils;

/**
 * Utility Class
 * Used to track how many Vehicle objects are created
 * @author Brian Niski
 */
public class VehicleIDCounter {

    private static long id = 1;

    public static long addNewVehicleID() {
        return id++;
    }

}
