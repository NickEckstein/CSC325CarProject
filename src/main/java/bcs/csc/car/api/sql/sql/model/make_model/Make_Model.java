package bcs.csc.car.api.sql.sql.model.make_model;

public class Make_Model {

	private long id;
	private long makeID;
	private long modelID;

	public Make_Model(long id, long makeID, long modelID) {
		this.id = id;
		this.makeID = makeID;
		this.modelID = modelID;
	}

	public long getId() {
		return id;
	}

	public long getMakeID() {
		return makeID;
	}

	public long getModelID() {
		return modelID;
	}

	@Override
	public String toString() {
		return "Make_Model [id=" + id + ", makeID=" + makeID + ", modelID=" + modelID + "]";
	}

}
