package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class MusicSystem implements Device {
    private boolean MusicIsPlaying = false;

    public void on(){
        System.out.println("Music is playing.");
        MusicIsPlaying = true;
    }

    public void off(){
        System.out.println("Music is stopping.");
        MusicIsPlaying = false;
    }

    @Override
    public void operate(String operation) {
        if ("on".equalsIgnoreCase(operation)) on();
        else if ("off".equalsIgnoreCase(operation)) off();
        else System.out.println("Invalid operation for MusicSystem: " + operation);
    }
}
