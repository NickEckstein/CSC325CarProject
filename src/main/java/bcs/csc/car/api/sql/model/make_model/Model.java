package bcs.csc.car.api.sql.model.make_model;

import java.io.Serializable;

/**
 * 
 * @author Brian Niski
 */
public class Model implements Serializable {

	private long modelID;
	private String modelName;

	public Model(long modelID, String modelName) {
		this.modelID = modelID;
		this.modelName = modelName;
	}

	public long getModelID() {
		return modelID;
	}

	public String getModelName() {
		return modelName;
	}

	@Override
	public String toString() {
		return "Model [modelID=" + modelID + ", modelName=" + modelName + "]";
	}

}
