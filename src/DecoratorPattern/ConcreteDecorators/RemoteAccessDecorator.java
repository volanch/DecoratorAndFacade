package DecoratorPattern.ConcreteDecorators;

import DecoratorPattern.DeviceDecorator;
import DeviceAbstraction.Device;

public class RemoteAccessDecorator extends DeviceDecorator {

    public RemoteAccessDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void operate(String operation) {
        decoratedDevice.operate(operation);
        if ("on".equalsIgnoreCase(operation)) {
            addRemoteAccess();
        } else if ("off".equalsIgnoreCase(operation)) {
            removeRemoteAccess();
        }
    }

    private void addRemoteAccess(){
        System.out.println("You can control this device over the internet.");
    }
    private void removeRemoteAccess() {}
}
