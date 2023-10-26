package bcs.csc.car.api.sql.sql_demo;

import java.util.LinkedList;

import bcs.csc.car.api.sql.sql.model.battery.BatteryType;
import bcs.csc.car.api.sql.sql.model.body.BodyStyle;
import bcs.csc.car.api.sql.sql.model.drive.DriveType;
import bcs.csc.car.api.sql.sql.model.engine.EngineModel;
import bcs.csc.car.api.sql.sql.model.engine.EngineModelPattern;
import bcs.csc.car.api.sql.sql.model.make_model.Make;
import bcs.csc.car.api.sql.sql.model.make_model.Make_Model;
import bcs.csc.car.api.sql.sql.model.make_model.Model;
import bcs.csc.car.api.sql.sql.model.transmission.Transmission;
import bcs.csc.car.api.sql.sql.model.vehicle.VehicleType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteUtils {

    public static LinkedList<BatteryType> readBatteryTypeData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<BatteryType> batteryTypeList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM BatteryType";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("BATTERY TYPE CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                batteryTypeList.add(new BatteryType(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return batteryTypeList;
    }

    public static LinkedList<BodyStyle> readBodyStyleData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<BodyStyle> bodyStyleList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM BodyStyle";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("BODY STYLE CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                bodyStyleList.add(new BodyStyle(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return bodyStyleList;
    }

    public static LinkedList<DriveType> readDriveTypeData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<DriveType> driveTypeList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM DriveType";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("DRIVE TYPE CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                driveTypeList.add(new DriveType(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return driveTypeList;
    }

    public static LinkedList<EngineModel> readEngineModelData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<EngineModel> engineModelList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM EngineModel";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("ENGINE MODEL CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                String description = resultSet.getString("Description");
                engineModelList.add(new EngineModel(id, name, description));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return engineModelList;
    }

    public static LinkedList<EngineModelPattern> readEngineModelPatternData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<EngineModelPattern> engineModelPatternList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM EngineModelPattern";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("ENGINE MODEL PATTERN CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                long engineModelID = Long.parseLong(resultSet.getString("EngineModelId"));
                long elementID = Long.parseLong(resultSet.getString("ElementId"));
                String attributeID = resultSet.getString("AttributeId");
                engineModelPatternList.add(new EngineModelPattern(id, engineModelID, elementID, attributeID));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return engineModelPatternList;
    }

    public static LinkedList<Make_Model> readMake_ModelData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<Make_Model> make_modelList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Make_Model";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("MAKE_MODEL CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                long makeID = Long.parseLong(resultSet.getString("MakeId"));
                long modelID = Long.parseLong(resultSet.getString("ModelId"));
                make_modelList.add(new Make_Model(id, makeID, modelID));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return make_modelList;
    }

    public static LinkedList<Make> readMakeData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<Make> makeList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Make";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("MAKE CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                makeList.add(new Make(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return makeList;
    }

    public static LinkedList<Model> readModelData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<Model> modelList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Model";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("MODEL CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                modelList.add(new Model(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return modelList;
    }

    public static LinkedList<Transmission> readTransmissionData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<Transmission> transmissionList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Transmission";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("TRANSMISSION CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                transmissionList.add(new Transmission(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return transmissionList;
    }

    public static LinkedList<VehicleType> readVehicleTypeData() {
        Connection connection = SQLiteConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<VehicleType> vehicleTypeList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM VehicleType";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("VEHICLE TYPE CONNECTION");
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("Id"));
                String name = resultSet.getString("Name");
                vehicleTypeList.add(new VehicleType(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return vehicleTypeList;
    }

}
