package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class MusicSystem implements Device {
    private boolean MusicIsPlaying = false;

    @Override
    public void on(){
        System.out.println("Music is playing.");
        MusicIsPlaying = true;
    }

    @Override
    public void off(){
        System.out.println("Music is stopping.");
        MusicIsPlaying = false;
    }
}
