package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class Light implements Device {
    private boolean LightIsOn = false;
    private int brightness = 100;

    public void on() {
        LightIsOn = true;
        System.out.println("Light is ON. Brightness: " + brightness + "%");
    }

    public void off(){
        System.out.println("Light is off.");
        LightIsOn = false;
    }

    @Override
    public void operate(String operation) {
        if ("on".equalsIgnoreCase(operation)) on();
        else if ("off".equalsIgnoreCase(operation)) off();
        else if (operation.startsWith("brightness:")) {
            try {
                int level = Integer.parseInt(operation.split(":")[1]);
                setBrightness(level);
            } catch (Exception e) {
                System.out.println("Invalid brightness value.");
            }
        } else {
            System.out.println("Invalid operation for Light: " + operation);
        }
    }

        public void setBrightness (int level){
            if (level < 0 || level > 100) {
                System.out.println("enter between 0 and 100");
                return;
            }
            brightness = level;
            if (LightIsOn)
                System.out.println("Brightness adjusted to " + brightness + "%");
            else
                System.out.println("light is currently off.");
        }
    }
