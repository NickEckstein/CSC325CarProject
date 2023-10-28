package bcs.csc.car.api.sql.model.fueltype;

public class FuelType {

    private long id;
    private String name;

    public FuelType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FuelType [" + "id=" + id + ", name=" + name + "]";
    }

}
