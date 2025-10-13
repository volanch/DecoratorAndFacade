package DecoratorPattern.ConcreteDecorators;

import DecoratorPattern.DeviceDecorator;
import DeviceAbstraction.Device;

public class RemoteAccessDecorator extends DeviceDecorator {

    public RemoteAccessDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void on() {
        super.on();
        addRemoteAccess();
    }

    @Override
    public void off() {
        super.off();
        removeRemoteAccess();
    }

    private void addRemoteAccess(){
        System.out.println("You can control this device over the internet.");
    }
    private void removeRemoteAccess() {}
}
