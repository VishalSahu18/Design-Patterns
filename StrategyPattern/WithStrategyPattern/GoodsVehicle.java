package StrategyPattern.WithStrategyPattern;

import StrategyPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
