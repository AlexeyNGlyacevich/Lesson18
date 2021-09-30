public class PassengerCar extends Car {

    private String _seat_materials;

    public String get_seat_materials() {
        return _seat_materials;
    }

    public void set_seat_materials(String seat_materials) {
        this._seat_materials = seat_materials;
    }

    public PassengerCar(String seat_materials, String color, String name, fuelType type ) {
        this._seat_materials = seat_materials;
        this._color = color;
        this._name = name;
        this._type = fuelType.valueOf(type.toString());
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "_color='" + _color + '\'' +
                ", _name='" + _name + '\'' +
                ", _type=" + _type +
                ", _seat_materials='" + _seat_materials + '\'' +
                '}';
    }
}
