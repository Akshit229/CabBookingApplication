package Driver;

import Model.CabDriver;
import Model.Coordinates;
import Model.User;
import Model.VehicleDetails;
import Repository.UserRepository;
import Service.CabDriverService;
import Service.RideService;
import Service.UserService;

import java.io.IOException;
import java.util.List;


public class Driver {


    public static void main(String[] args) throws IOException {


        UserService us = new UserService();
        //##################### REQUIREMENT - 1(A)
        us.addNewUser(new User("Abhishek", "M", 23));
        us.addNewUser(new User("Rahul", "M", 29));
        us.addNewUser(new User("Nandini", "F", 22));

        CabDriverService cs = new CabDriverService();
        //##################### REQUIREMENT - 2(A)
        cs.addNewCabDriver(new User("Driver1", "M", 22), new VehicleDetails("Swift","KA-01-12345"), new Coordinates(10, 1));
        cs.addNewCabDriver(new User("Driver2", "M", 23), new VehicleDetails("Maruti","KA-01-11345"), new Coordinates(11, 10));
        cs.addNewCabDriver(new User("Driver3", "M", 29), new VehicleDetails("Honda","KA-01-12305"), new Coordinates(5, 3));


        RideService rideService = new RideService();
        try {
            //##################### REQUIREMENT - 3(A)
            List<CabDriver> cabDriverList = rideService.findRide("Abhishek", new Coordinates(0,0), new Coordinates(20, 1));
            printAvailableDrivers(cabDriverList);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //##################### REQUIREMENT - 3(A)
            List<CabDriver> cabDriverList1 = rideService.findRide("Rahul", new Coordinates(10,0), new Coordinates(15, 3));
            printAvailableDrivers(cabDriverList1);
            cabDriverList1.stream().findFirst().ifPresent(cabDriver -> {
                try {
                    //##################### 3(B)
                    rideService.chooseDriver("Rahul", cabDriver.getUser().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //##################### REQUIREMENT - 3(A)
            List<CabDriver> cabDriverList2 = rideService.findRide("Nandini", new Coordinates(15,6), new Coordinates(20, 4));
            printAvailableDrivers(cabDriverList2);
            //changing nandini's source to driver1's location
            cabDriverList2 = rideService.findRide("Nandini", new Coordinates(10,1), new Coordinates(20, 4));
            printAvailableDrivers(cabDriverList2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void printAvailableDrivers(List<CabDriver> cabDriverList){
        if(cabDriverList.size() == 0){
            System.out.println("No drivers available");
            return;
        }
        for(CabDriver c : cabDriverList){
            System.out.println(c.toString());
        }
    }

}
