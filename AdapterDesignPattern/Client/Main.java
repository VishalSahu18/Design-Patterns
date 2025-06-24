package AdapterDesignPattern.Client;

import AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import AdapterDesignPattern.Adapter.WeightMachineAdapter;
import AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
