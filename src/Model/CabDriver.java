package Model;

import Model.enums.Status;

public class CabDriver {
    private User user;
    private VehicleDetails carDetails;
    private Coordinates coordinates;
    private Status driveStatus;
    private User currentPassenger;

    public CabDriver() {
    }

    public CabDriver(User user, VehicleDetails carDetails, Coordinates coordinates) {
        this.user = user;
        this.carDetails = carDetails;
        this.coordinates = coordinates;
        this.driveStatus = Status.AVAILABLE;
        this.currentPassenger = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VehicleDetails getVehicleDetails() {
        return carDetails;
    }

    public void setVehicleDetails(VehicleDetails carDetails) {
        this.carDetails = carDetails;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Status getDriveStatus() {
        return driveStatus;
    }

    public void setDriveStatus(Status driveStatus) {
        this.driveStatus = driveStatus;
    }

    public User getCurrentPassenger() {
        return currentPassenger;
    }

    public void setCurrentPassenger(User currentPassenger) {
        this.currentPassenger = currentPassenger;
    }

    @Override
    public String toString() {
        return "CabDriver{" +
                "user=" + user +
                ", carDetails=" + carDetails +
                ", coordinates=" + coordinates +
                ", driveStatus=" + driveStatus +
                ", currentPassenger=" + currentPassenger +
                '}';
    }
}
