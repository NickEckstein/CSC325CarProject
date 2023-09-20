package model.make_model;

public class Model {

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
