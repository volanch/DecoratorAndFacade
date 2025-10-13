package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class Light implements Device {
    private boolean LightIsOn = false;

    @Override
    public void on(){
        System.out.println("Light is on.");
        LightIsOn = true;
    }
    @Override
    public void off(){
        System.out.println("Light is off.");
        LightIsOn = false;
    }
}
