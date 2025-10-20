package DecoratorPattern;

import DeviceAbstraction.Device;

public abstract class DeviceDecorator implements Device {

    protected Device decoratedDevice;
    public DeviceDecorator(Device decoratedDevice) {
        this.decoratedDevice = decoratedDevice;
    }
    @Override
    public void operate(String operation){
        decoratedDevice.operate(operation);
    }
}
