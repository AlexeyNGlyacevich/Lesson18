public abstract class Car
{
    public String _color;
    public String _name;
    public fuelType _type;

    public enum fuelType{
        Diesel,
        Gasoline;
    }

    public fuelType getType() {
        return _type;
    }

    public void setType(fuelType type) {
        this._type = type;
    }

    public String getColor() {
        return _color;
    }

    public void setColor(String _color) {
        this._color = _color;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

}
