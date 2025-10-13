package DecoratorPattern.ConcreteDecorators;

import DecoratorPattern.DeviceDecorator;
import DeviceAbstraction.Device;

public class VoiceControlDecorator extends DeviceDecorator {

    public VoiceControlDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void on() {
        super.on();
        addVoiceControl();
    }

    @Override
    public void off() {
        super.off();
        removeVoiceControl();
    }

    private void addVoiceControl() {
        System.out.println("You can now control this device using your voice.");
    }
    private void removeVoiceControl() {}
}
