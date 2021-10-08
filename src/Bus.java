public class Bus extends Car {

    private int dor;
    private int place;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getDor() {
        return dor;
    }

    public void setDor(int dor) {
        this.dor = dor;
    }

    public Bus(String color, String name, FuelType type, int dor, int place) {
        super(color, name, type);
        this.dor = dor;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "dor=" + dor +
                ", place=" + place +
                ", color=" + super.getColor()+
                ", name=" + super.getName()+
                ", Fuel type=" + super.getType() +
                '}';
    }
}
