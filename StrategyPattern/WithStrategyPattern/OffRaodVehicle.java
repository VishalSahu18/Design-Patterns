package StrategyPattern.WithStrategyPattern;

import StrategyPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRaodVehicle extends Vehicle{

    OffRaodVehicle(){
        super(new SportsDriveStrategy());
    }
}
