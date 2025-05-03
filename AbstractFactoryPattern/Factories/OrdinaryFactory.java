package AbstractFactoryPattern.Factories;

import AbstractFactoryPattern.model.Vehical;
import AbstractFactoryPattern.model.luxuryCars.Audi;
import AbstractFactoryPattern.model.luxuryCars.BMW;
import AbstractFactoryPattern.model.luxuryCars.MercedesBenz;
import AbstractFactoryPattern.model.ordinaryCars.Hyundai;
import AbstractFactoryPattern.model.ordinaryCars.Nissan;

public class OrdinaryFactory implements VehicalFactory {
    @Override
    public Vehical getVehicle(String input) {

        switch (input){
            case "Hyundai":
                return new Hyundai();
            case "Nissan":
                return new Nissan();
            default:
                return null;
        }
    }
}
