package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class SecurityCamera implements Device {
    private boolean CameraIsRecording = false;

    public void on(){
        System.out.println("Camera is recording.");
        CameraIsRecording = true;
    }

    public void off(){
        System.out.println("Camera is off.");
        CameraIsRecording = false;
    }

    @Override
    public void operate(String operation) {
        if ("on".equalsIgnoreCase(operation)) on();
        else if ("off".equalsIgnoreCase(operation)) off();
        else System.out.println("Invalid operation for SecurityCamera: " + operation);
    }
}
