
class Car {
    private String modelName;
    private String engineType;
    private String color;
    private String transmission;
    private boolean sunroof;
    private boolean infotainmentSystem;

    // Constructor used by Builder
    Car(String modelName, String engineType, String color,
        String transmission, boolean sunroof, boolean infotainmentSystem) {

        this.modelName = modelName;
        this.engineType = engineType;
        this.color = color;
        this.transmission = transmission;
        this.sunroof = sunroof;
        this.infotainmentSystem = infotainmentSystem;
    }

    @Override
    public String toString() {
        return
            "Model Name: " + modelName + "\n" +
            "Engine Type: " + engineType + "\n" +
            "Color: " + color + "\n" +
            "Transmission: " + transmission + "\n" +
            "Sunroof: " + (sunroof ? "Yes" : "No") + "\n" +
            "Infotainment System: " + (infotainmentSystem ? "Yes" : "No");
    }
}

class CarBuilder {

    // Default configuration
    private String modelName = "Default Model";
    private String engineType = "Petrol";
    private String color = "White";
    private String transmission = "Manual";
    private boolean sunroof = false;
    private boolean infotainmentSystem = false;

    public CarBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public CarBuilder setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    public CarBuilder setInfotainmentSystem(boolean infotainmentSystem) {
        this.infotainmentSystem = infotainmentSystem;
        return this;
    }

    public Car build() {
        return new Car(
            modelName,
            engineType,
            color,
            transmission,
            sunroof,
            infotainmentSystem
        );
    }
}

public class BuilderPatterDemo{
    public static void main(String[] args) {

        // Default Car
        Car defaultCar = new CarBuilder().build();
        System.out.println("Default Car Configuration:\n" + defaultCar);

        // Customized Car
        Car customCar = new CarBuilder()
                .setModelName("Tesla Model 3")
                .setEngineType("Electric")
                .setColor("Midnight Silver")
                .setTransmission("Automatic")
                .setSunroof(true)
                .setInfotainmentSystem(true)
                .build();

        System.out.println("\nCustomized Car Configuration:\n" + customCar);
    }
}
