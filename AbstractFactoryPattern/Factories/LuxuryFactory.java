package AbstractFactoryPattern.Factories;

import AbstractFactoryPattern.model.Vehical;
import AbstractFactoryPattern.model.luxuryCars.Audi;
import AbstractFactoryPattern.model.luxuryCars.BMW;
import AbstractFactoryPattern.model.luxuryCars.MercedesBenz;

public class LuxuryFactory implements VehicalFactory {

    @Override
    public Vehical getVehicle(String input) {
        switch (input){
            case "MercedesBenz":
                return new MercedesBenz();
            case "BMW":
                return new BMW();
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }


}
