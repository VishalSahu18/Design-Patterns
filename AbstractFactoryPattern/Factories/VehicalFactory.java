package AbstractFactoryPattern.Factories;

import AbstractFactoryPattern.model.Vehical;

public interface VehicalFactory{

    Vehical getVehicle(String input);
}
