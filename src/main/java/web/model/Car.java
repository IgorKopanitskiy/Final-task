package web.model;

public class Car {
    private String modelName;
    private int horsePower;
    private String colour;

    public Car(String modelName, int horsePower, String colour) {
        this.modelName = modelName;
        this.horsePower = horsePower;
        this.colour = colour;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", horsePower=" + horsePower +
                ", colour='" + colour + '\'' +
                '}';
    }
}
