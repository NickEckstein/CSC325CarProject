package bcs.csc.car.api.sql.utils;

import bcs.csc.car.api.model.LegalMake_Model;
import bcs.csc.car.api.sql.model.make_model.Make;
import bcs.csc.car.api.sql.model.make_model.Make_Model;
import bcs.csc.car.api.sql.model.make_model.Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * SQL Utility Class
 * Data parsing from SQL database
 * @author Brian Niski
 */
public class DataParser {

    public static LinkedList<LegalMake_Model> readThroughMake_ModelList(LinkedList<Make_Model> make_modelList, LinkedList<Make> makeList, LinkedList<Model> modelList) {
        LinkedList<LegalMake_Model> legalMake_ModelList = new LinkedList<>();
        ListIterator make_modelIterator = make_modelList.listIterator();
        while (make_modelIterator.hasNext()) {
            Make_Model make_model = (Make_Model) make_modelIterator.next();
            Make make = new Make(-1, "");
            ListIterator makeListIterator = makeList.listIterator();
            while (makeListIterator.hasNext()) {
                make = (Make) makeListIterator.next();
                if (make_model.getMakeID() == make.getMakeID()) {
                    break;
                } else {
                    make = new Make(-1, "");
                }
            }
            Model model = new Model(-1, "");
            ListIterator modelListIterator = modelList.listIterator();
            while (modelListIterator.hasNext()) {
                model = (Model) modelListIterator.next();
                if (make_model.getModelID() == model.getModelID()) {
                    break;
                } else {
                    model = new Model(-1, "");
                }
            }
            if ((make.getMakeID() != -1) && (model.getModelID() != -1)) {
                legalMake_ModelList.add(new LegalMake_Model(make.getMakeName(), model.getModelName()));
            }
        }
        return legalMake_ModelList;
    }

    public static <T> void saveFile(T object, String objectType) {
        try {
            FileOutputStream fileOut = new FileOutputStream(objectType + ".dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Saved " + objectType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> LinkedList<T> readFile(String directory) {
        LinkedList<T> linkedList = new LinkedList<>();
        try {
            FileInputStream fileIn = new FileInputStream(directory);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            linkedList = (LinkedList<T>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return linkedList;
    }

}
