package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class Thermostat implements Device {
    private boolean thermostatIsOn = false;
    private int temperature = 20;
    @Override
    public void on(){
        System.out.println("Thermostat is set to " + temperature + " celsius.");
        thermostatIsOn = true;
    }
    @Override
    public void off(){
        System.out.println("Thermostat is off.");
        thermostatIsOn = false;
    }
}
