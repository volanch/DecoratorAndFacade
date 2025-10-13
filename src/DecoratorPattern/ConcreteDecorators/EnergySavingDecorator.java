package DecoratorPattern.ConcreteDecorators;

import DecoratorPattern.DeviceDecorator;
import DeviceAbstraction.Device;

public class EnergySavingDecorator extends DeviceDecorator {

    public EnergySavingDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void on() {
        super.on();
        addEnergySaving();
    }

    @Override
    public void off() {
        super.off();
        removeEnergySaving();
    }

    private void addEnergySaving() {
        System.out.println("Energy saving mode activated to reduce power consumption.");
    }
    private void removeEnergySaving() {}
}