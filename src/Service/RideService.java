package Service;

import Model.CabDriver;
import Model.Coordinates;
import Model.User;
import Model.enums.Status;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RideService {

    private static final UserService userService = new UserService();
    private static final CabDriverService cabDriverService = new CabDriverService();
    private final Integer SEARCH_RADIUS = 5; //as per problem statement

    public List<CabDriver> findRide(String userName, Coordinates source, Coordinates destination) throws Exception {
        Optional<User> user = userService.findByName(userName);
        if(user.isEmpty()) throw new Exception("Invalid user name, User does not exist");

        List<CabDriver> cabDriverList = cabDriverService.getAllCabDrivers();
        return findNearByCabDrivers(cabDriverList, source);
    }

    public void chooseDriver(String userName, String driverName) throws Exception {
        cabDriverService.setRideForDriver(userName, driverName);
    }


    private List<CabDriver> findNearByCabDrivers(List<CabDriver> cabDriverList, Coordinates source){
        return cabDriverList.stream()
                .filter(cabDriver -> cabDriver.getDriveStatus().equals(Status.AVAILABLE) && cabDriver.getCoordinates().distanceTo(source) <= SEARCH_RADIUS).collect(Collectors.toList());
    }


    private Optional<CabDriver> findNearestCabDriver(List<CabDriver> cabDriverList, Coordinates source){
        return cabDriverList.stream()
                .filter(cabDriver -> cabDriver.getDriveStatus().equals(Status.AVAILABLE) && cabDriver.getCoordinates().distanceTo(source) <= SEARCH_RADIUS)
                .min(Comparator.comparingDouble(cabDriver -> cabDriver.getCoordinates().distanceTo(source)));
    }
}
