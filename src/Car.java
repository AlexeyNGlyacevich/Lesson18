public abstract class Car
{
    private String color;
    private String name;
    private FuelType type;

    public enum FuelType{
        Diesel,
        Gasoline;
    }

    public FuelType getType() {
        return type;
    }

    public void setType(FuelType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String _color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = name;
    }

    public Car(String color, String name, FuelType type) {
        this.color = color;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
