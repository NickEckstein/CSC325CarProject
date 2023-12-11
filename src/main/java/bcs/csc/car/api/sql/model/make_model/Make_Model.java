package bcs.csc.car.api.sql.model.make_model;

import java.io.Serializable;

/**
 * SQL Model Class
 * @author Brian Niski
 */
public class Make_Model implements Serializable {

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
