package model.make_model;

public class Make {

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
