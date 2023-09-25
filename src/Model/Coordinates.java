package Model;

public class Coordinates {
    private Integer xCoordinate;
    private Integer yCoordinate;

    public Coordinates() {
    }

    public Coordinates(Integer xCoordinate, Integer yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double distanceTo(Coordinates other) {
        double dx = this.xCoordinate - other.xCoordinate;
        double dy = this.yCoordinate - other.yCoordinate;
        return Math.ceil(Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
