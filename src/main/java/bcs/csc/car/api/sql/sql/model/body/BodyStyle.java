package bcs.csc.car.api.sql.sql.model.body;

public class BodyStyle {

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
