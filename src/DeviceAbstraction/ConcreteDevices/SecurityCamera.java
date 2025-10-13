package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class SecurityCamera implements Device {
    private boolean CameraIsRecording = false;
    @Override
    public void on(){
        System.out.println("Camera is recording.");
        CameraIsRecording = true;
    }

    @Override
    public void off(){
        System.out.println("Camera is recording.");
        CameraIsRecording = false;
    }
}
