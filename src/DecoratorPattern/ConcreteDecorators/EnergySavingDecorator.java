package DecoratorPattern.ConcreteDecorators;

import DecoratorPattern.DeviceDecorator;
import DeviceAbstraction.Device;

public class EnergySavingDecorator extends DeviceDecorator {

    public EnergySavingDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void operate(String operation) {
        decoratedDevice.operate(operation);
        if ("on".equalsIgnoreCase(operation)) {
            addEnergySaving();
        } else if ("off".equalsIgnoreCase(operation)) {
            removeEnergySaving();
        }
    }

    private void addEnergySaving() {
        System.out.println("Energy saving mode activated to reduce power consumption.");
    }
    private void removeEnergySaving() {}
}