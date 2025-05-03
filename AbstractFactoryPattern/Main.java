package AbstractFactoryPattern;

import AbstractFactoryPattern.Factories.Factory1;
import AbstractFactoryPattern.Factories.VehicalFactory;
import AbstractFactoryPattern.model.Vehical;

public class Main {

    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();

        VehicalFactory luxury1 = factory1.getFactory("Luxury");
        Vehical mercedes = luxury1.getVehicle("MercedesBenz");

        System.out.println(mercedes.getAverage());

    }



}
