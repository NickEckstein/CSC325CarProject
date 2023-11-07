package bcs.csc.car.api.sql.model.make_model;

import java.io.Serializable;

public class Make implements Serializable {

	private long makeID;
	private String makeName;

	public Make(long makeID, String makeName) {
		this.makeID = makeID;
		this.makeName = makeName;
	}

	public long getMakeID() {
		return makeID;
	}

	public String getMakeName() {
		return makeName;
	}

	@Override
	public String toString() {
		return "Make [makeID=" + makeID + ", makeName=" + makeName + "]";
	}

}
