package Service;


import Model.VehicleDetails;

import Repository.VehicleDetailsRepository;



public class VehicleDetailsService {
    private final static VehicleDetailsRepository vr = VehicleDetailsRepository.getInstance();

    public void addNewVehicleDetails(VehicleDetails vehicleDetails){
        vr.addNewVehicleDetails(vehicleDetails);
    }
}
