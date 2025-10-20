package AbstractFactoryPattern.ConcreteFactories;

import AbstractFactoryPattern.AbstractFactory.DeviceFactory;
import DeviceAbstraction.Device;
import DeviceAbstraction.ConcreteDevices.*;

public class BasicDeviceFactory implements DeviceFactory {
    @Override
    public Device createLight() {
        return new Light();
    }

    @Override
    public Device createMusicSystem() {
        return new MusicSystem();
    }

    @Override
    public Device createThermostat() {
        return new Thermostat();
    }

    @Override
    public Device createSecurityCamera() {
        return new SecurityCamera();
    }
}