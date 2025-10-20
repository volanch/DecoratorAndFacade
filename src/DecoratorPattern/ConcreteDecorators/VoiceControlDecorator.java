package DecoratorPattern.ConcreteDecorators;

import DecoratorPattern.DeviceDecorator;
import DeviceAbstraction.Device;

public class VoiceControlDecorator extends DeviceDecorator {

    public VoiceControlDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void operate(String operation) {
        decoratedDevice.operate(operation);
        if ("on".equalsIgnoreCase(operation)) {
            addVoiceControl();
        } else if ("off".equalsIgnoreCase(operation)) {
            removeVoiceControl();
        }
    }

    private void addVoiceControl() {
        System.out.println("You can now control this device using your voice.");
    }
    private void removeVoiceControl() {}
}
