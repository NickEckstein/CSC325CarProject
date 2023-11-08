package bcs.csc.car.api.model;

import java.io.Serializable;

/**
 * 
 * @author Brian Niski
 */
public class LegalMake_Model implements Serializable {

    private String makeName;
    private String modelName;

    public LegalMake_Model(String makeName, String modelName) {
        this.makeName = makeName;
        this.modelName = modelName;
    }

    public String getMakeName() {
        return makeName;
    }

    public String getModelName() {
        return modelName;
    }

    @Override
    public String toString() {
        return "Legal Make Model: [" + "make=" + makeName + ", model=" + modelName + "]";
    }

}
