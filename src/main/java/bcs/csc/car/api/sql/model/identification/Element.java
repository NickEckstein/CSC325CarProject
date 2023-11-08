package bcs.csc.car.api.sql.model.identification;

import java.io.Serializable;

/**
 * 
 * @author Brian Niski
 */
public class Element implements Serializable {

    private long id;
    private String name;
    private String code;
    private String lookupTable;
    private String description;
    private boolean isPrivate;
    private String groupName;
    private String dataType;
    private String decode;

    public Element(long id, String name, String code, String lookupTable, String description, boolean isPrivate, String groupName, String dataType, String decode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.lookupTable = lookupTable;
        this.description = description;
        this.isPrivate = isPrivate;
        this.groupName = groupName;
        this.dataType = dataType;
        this.decode = decode;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLookupTable() {
        return lookupTable;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDecode() {
        return decode;
    }

    @Override
    public String toString() {
        return "Element [" + "id=" + id + ", name=" + name + ", code=" + code + ", lookupTable=" + lookupTable + ", description=" + description + ", isPrivate=" + isPrivate + ", groupName=" + groupName + ", dataType=" + dataType + ", decode=" + decode + "]";
    }

}
