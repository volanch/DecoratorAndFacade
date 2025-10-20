package AbstractFactoryPattern.AbstractFactory;

import DeviceAbstraction.Device;

public interface DeviceFactory {
    Device createLight();
    Device createMusicSystem();
    Device createThermostat();
    Device createSecurityCamera();
}