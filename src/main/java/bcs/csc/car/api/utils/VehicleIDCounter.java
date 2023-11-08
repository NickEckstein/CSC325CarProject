package bcs.csc.car.api.utils;

/**
 * 
 * @author Brian Niski
 */
public class VehicleIDCounter {

    private static long id = 1;

    public static long addNewVehicleID() {
        return id++;
    }

}
