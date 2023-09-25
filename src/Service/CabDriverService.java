package Service;

import Model.CabDriver;
import Model.Coordinates;
import Model.User;
import Model.VehicleDetails;
import Repository.CabDriverRepository;

import java.util.List;
import java.util.Optional;

public class CabDriverService {
    private static final CabDriverRepository cabDriverRepository = CabDriverRepository.getInstance();
    private static final UserService userService = new UserService();
    private static final VehicleDetailsService vehicleService = new VehicleDetailsService();

    public void addNewCabDriver(CabDriver cabDriver){
        userService.addNewUser(cabDriver.getUser());
        vehicleService.addNewVehicleDetails(cabDriver.getVehicleDetails());
        cabDriverRepository.save(cabDriver);
    }

    public void addNewCabDriver(User user, VehicleDetails vehicleDetails, Coordinates coordinates){
        userService.addNewUser(user);
        vehicleService.addNewVehicleDetails(vehicleDetails);
        cabDriverRepository.save(new CabDriver(user, vehicleDetails, coordinates));
    }

    public List<CabDriver> getAllCabDrivers(){
        return cabDriverRepository.getAll();
    }

    public void setRideForDriver(String userName, String driverName) throws Exception {
        Optional<User> customer = userService.findByName(userName);
        if(customer.isEmpty()) throw new Exception("Invalid user name, User does not exist");

        Optional<User> driver = userService.findByName(driverName);
        if(driver.isEmpty()) throw new Exception("Invalid cabDriver name, CabDriver does not exist");
        cabDriverRepository.updateRideDetails(customer.get(), driver.get());
    }
}
