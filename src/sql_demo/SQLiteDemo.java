package sql_demo;

import java.util.LinkedList;

import model.battery.BatteryType;
import model.body.BodyStyle;
import model.drive.DriveType;
import model.engine.EngineModel;
import model.engine.EngineModelPattern;
import model.make_model.Make;
import model.make_model.Make_Model;
import model.make_model.Model;
import model.transmission.Transmission;
import model.vehicle.VehicleType;

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
