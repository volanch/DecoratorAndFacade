package DeviceAbstraction.CustomDeviceCLI;

import DeviceAbstraction.Device;

public class CustomDevice implements Device {
    private final String name;

    public CustomDevice(String name) {
        this.name = name;
    }

    @Override
    public void operate(String operation){
        System.out.println(name + " is " + operation);
    }

    @Override
    public String toString(){
        return name;
    }
}
