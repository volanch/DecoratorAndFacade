package Builder;

import DeviceAbstraction.Device;
import DecoratorPattern.ConcreteDecorators.*;

public class DeviceBuilder {
    private Device device;

    public DeviceBuilder(Device baseDevice) {
        this.device = baseDevice;
    }

    public DeviceBuilder addVoiceControl() {
        device = new VoiceControlDecorator(device);
        return this;
    }

    public DeviceBuilder addEnergySaving() {
        device = new EnergySavingDecorator(device);
        return this;
    }

    public DeviceBuilder addRemoteAccess() {
        device = new RemoteAccessDecorator(device);
        return this;
    }

    public Device build() {
        return device;
    }
}
