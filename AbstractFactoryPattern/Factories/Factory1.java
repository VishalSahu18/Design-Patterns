package AbstractFactoryPattern.Factories;

import AbstractFactoryPattern.model.luxuryCars.Audi;
import AbstractFactoryPattern.model.luxuryCars.BMW;
import AbstractFactoryPattern.model.luxuryCars.MercedesBenz;

public class Factory1 {

    public VehicalFactory getFactory(String input){
        switch (input){
            case "Luxury":
                return new LuxuryFactory();
            case "Ordinary":
                return new OrdinaryFactory();
            default:
                return null;
        }
    }
}
