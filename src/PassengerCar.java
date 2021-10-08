public class PassengerCar extends Car {

    private String seat_materials;

    public String get_seat_materials() {
        return seat_materials;
    }

    public void set_seat_materials(String seat_materials) {
        this.seat_materials = seat_materials;
    }

    public PassengerCar(String color, String name, FuelType type, String seat_materials) {
        super(color, name, type);
        this.seat_materials = seat_materials;
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "seat_materials=" + seat_materials +
                ", color=" + super.getColor() +
                ", name=" + super.getName() +
                ", Fuel type" + super.getType() +
                '}';
    }
}
