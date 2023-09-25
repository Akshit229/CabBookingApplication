package Repository;

import Model.CabDriver;
import Model.User;
import Model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class CabDriverRepository {
    private List<CabDriver> cabDriverList;
    private static CabDriverRepository cabDriverRepository;
    private CabDriverRepository(){
        cabDriverList = new ArrayList<>();
    }

    public static CabDriverRepository getInstance(){
        if(cabDriverRepository == null) cabDriverRepository = new CabDriverRepository();
        return cabDriverRepository;
    }

    public void save(CabDriver cabDriver){
        cabDriverList.add(cabDriver);
    }

    public List<CabDriver> getAll(){
        return this.cabDriverList;
    }

    public void updateRideDetails(User passenger, User driver){
        cabDriverList.stream().filter(cabDriver -> cabDriver.getUser().getName().equals(driver.getName())).findFirst().ifPresent(cabDriver -> {
            cabDriver.setCurrentPassenger(passenger);
            cabDriver.setDriveStatus(Status.NOT_AVAILABLE);
        });
    }

}
