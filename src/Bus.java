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


    public Bus(int dor, int place, String color, String name, fuelType type ) {
        this.dor = dor;
        this.place = place;
        this._color = color;
        this._name = name;
        this._type = fuelType.valueOf(type.toString());
    }

    @Override
    public String toString() {
        return "Bus{" +
                "dor=" + dor +
                ", place=" + place +
                ", _color='" + _color + '\'' +
                ", _name='" + _name + '\'' +
                ", _type=" + _type +
                '}';
    }
}
