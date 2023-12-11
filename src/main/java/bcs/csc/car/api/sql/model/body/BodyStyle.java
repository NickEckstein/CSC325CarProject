package bcs.csc.car.api.sql.model.body;

import java.io.Serializable;

/**
 * SQL Model Class
 * @author Brian Niski
 */
public class BodyStyle implements Serializable {

	private long bodyStyleID;
	private String bodyStyleName;

	public BodyStyle(long bodyStyleID, String bodyStyleName) {
		this.bodyStyleID = bodyStyleID;
		this.bodyStyleName = bodyStyleName;
	}

	public long getBodyStyleID() {
		return bodyStyleID;
	}

	public String getBodyStyleName() {
		return bodyStyleName;
	}

	@Override
	public String toString() {
		return "BodyStyle [bodyStyleID=" + bodyStyleID + ", bodyStyleName=" + bodyStyleName + "]";
	}

}
