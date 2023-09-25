package Model;

public class VehicleDetails {
    private String modelName;
    private String vehicleNumber;

    public VehicleDetails() {
    }

    public VehicleDetails(String modelName, String vehicleNumber) {
        this.modelName = modelName;
        this.vehicleNumber = vehicleNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "modelName='" + modelName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
