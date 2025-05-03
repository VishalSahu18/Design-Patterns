package StrategyPattern.WithStrategyPattern;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle  = new SportsVehicle();
        vehicle.drive();

        Vehicle goodsVehicle = new GoodsVehicle();
        goodsVehicle.drive();

    }
}