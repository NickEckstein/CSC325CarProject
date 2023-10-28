package bcs.csc.car.api.sql.sql_demo;

import bcs.csc.car.api.sql.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.sql.model.engine.EngineModelPattern;
import bcs.csc.car.api.sql.sql.model.identification.Element;
import bcs.csc.car.api.sql.sql.model.make_model.Make;
import bcs.csc.car.api.sql.sql.model.make_model.Make_Model;
import bcs.csc.car.api.sql.sql.model.make_model.Model;
import bcs.csc.car.api.sql.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.sql.model.vehicle.VehicleType;
import java.util.LinkedList;

public class SQLiteDemo {

    public static void main(String[] args) {
        LinkedList<BatteryType> batteryTypeList = SQLiteUtils.readBatteryTypeData();
        for (int i = 0; i < batteryTypeList.size(); i++) {
            System.out.println(batteryTypeList.get(i));
        }

        LinkedList<BodyStyle> bodyStyleList = SQLiteUtils.readBodyStyleData();
        for (int i = 0; i < bodyStyleList.size(); i++) {
            System.out.println(bodyStyleList.get(i));
        }

        LinkedList<DriveType> driveTypeList = SQLiteUtils.readDriveTypeData();
        for (int i = 0; i < driveTypeList.size(); i++) {
            System.out.println(driveTypeList.get(i));
        }

        LinkedList<EngineModel> engineModelList = SQLiteUtils.readEngineModelData();
        for (int i = 0; i < engineModelList.size(); i++) {
            System.out.println(engineModelList.get(i));
        }

        LinkedList<EngineModelPattern> engineModelPatternList = SQLiteUtils.readEngineModelPatternData();
        for (int i = 0; i < engineModelPatternList.size(); i++) {
            System.out.println(engineModelPatternList.get(i));
        }

        LinkedList<Element> elementList = SQLiteUtils.readElementData();
        for (int i = 0; i < elementList.size(); i++) {
            System.out.println(elementList.get(i));
        }

        LinkedList<Make_Model> make_modelList = SQLiteUtils.readMake_ModelData();
        for (int i = 0; i < make_modelList.size(); i++) {
            System.out.println(make_modelList.get(i));
        }

        LinkedList<Make> makeList = SQLiteUtils.readMakeData();
        for (int i = 0; i < makeList.size(); i++) {
            System.out.println(makeList.get(i));
        }

        LinkedList<Model> modelList = SQLiteUtils.readModelData();
        for (int i = 0; i < modelList.size(); i++) {
            System.out.println(modelList.get(i));
        }

        LinkedList<Transmission> transmissionList = SQLiteUtils.readTransmissionData();
        for (int i = 0; i < transmissionList.size(); i++) {
            System.out.println(transmissionList.get(i));
        }

        LinkedList<VehicleType> vehicleTypeList = SQLiteUtils.readVehicleTypeData();
        for (int i = 0; i < vehicleTypeList.size(); i++) {
            System.out.println(vehicleTypeList.get(i));
        }

    }

}
