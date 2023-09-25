package Repository;


import Model.VehicleDetails;

import java.util.ArrayList;
import java.util.List;


public class VehicleDetailsRepository {
   private List<VehicleDetails> vehicleDetails;

   private static VehicleDetailsRepository vehicleDetailsRepository = null;
   private VehicleDetailsRepository(){
       this.vehicleDetails = new ArrayList<>();
   }

   public static VehicleDetailsRepository getInstance(){
       if(vehicleDetailsRepository == null) vehicleDetailsRepository =  new VehicleDetailsRepository();
       return vehicleDetailsRepository;
   }

   public void addNewVehicleDetails(VehicleDetails user){
       this.vehicleDetails.add(user);
   }
}
