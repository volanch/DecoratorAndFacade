package AbstractFactoryPattern.ConcreteFactories;

import AbstractFactoryPattern.AbstractFactory.DeviceFactory;
import Builder.DeviceBuilder;
import DeviceAbstraction.Device;
import DeviceAbstraction.ConcreteDevices.*;
import DecoratorPattern.ConcreteDecorators.*;

public class EcoDeviceFactory implements DeviceFactory {
    @Override
    public Device createLight() {
        return new DeviceBuilder(new Light())
                .addEnergySaving()
                .build();
    }

    @Override
    public Device createMusicSystem() {
        return new DeviceBuilder(new MusicSystem())
                .addEnergySaving()
                .build();
    }

    @Override
    public Device createThermostat() {
        return new DeviceBuilder(new Thermostat())
                .addEnergySaving()
                .build();
    }

    @Override
    public Device createSecurityCamera() {
        return new DeviceBuilder(new SecurityCamera())
                .addEnergySaving()
                .build();
    }
}