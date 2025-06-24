package AdapterDesignPattern.Adapter;

import AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{

    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }
    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPound();

        //convert it to KGs
        double weightInKg = weightInPound* .45;

        return weightInKg;
    }
}
