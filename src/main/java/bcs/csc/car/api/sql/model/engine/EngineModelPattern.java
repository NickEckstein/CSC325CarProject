package bcs.csc.car.api.sql.model.engine;

import java.io.Serializable;

public class EngineModelPattern implements Serializable {

	private long engineModelPatternID;
	private long engineModelID;
	private long elementID;
	private String attributeID;

	public EngineModelPattern(long engineModelPatternID, long engineModelID, long elementID, String attributeID) {
		this.engineModelPatternID = engineModelPatternID;
		this.engineModelID = engineModelID;
		this.elementID = elementID;
		this.attributeID = attributeID;
	}

	public long getEngineModelPatternID() {
		return engineModelPatternID;
	}

	public long getEngineModelID() {
		return engineModelID;
	}

	public long getElementID() {
		return elementID;
	}

	public String getAttributeID() {
		return attributeID;
	}

	@Override
	public String toString() {
		return "EngineModelPattern [engineModelPatternID=" + engineModelPatternID + ", engineModelID=" + engineModelID
				+ ", elementID=" + elementID + ", attributeID=" + attributeID + "]";
	}
	
}
