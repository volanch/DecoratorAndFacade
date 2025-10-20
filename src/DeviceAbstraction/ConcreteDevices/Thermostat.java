package DeviceAbstraction.ConcreteDevices;

import DeviceAbstraction.Device;

public class Thermostat implements Device {
    private boolean thermostatIsOn = false;
    private int temperature = 20;

    public void on(){
        System.out.println("Thermostat is set to " + temperature + " celsius.");
        thermostatIsOn = true;
    }

    public void off(){
        System.out.println("Thermostat is off.");
        thermostatIsOn = false;
    }

    public void setTemperature(int temperature) {
        if (temperature < 10 || temperature > 35) {
            System.out.println("temperature must be between 10°C and 35°C");
            return;
        }
        this.temperature = temperature;
        if (thermostatIsOn)
            System.out.println("Temperature adjusted to " + temperature + "°C");
        else
            System.out.println("thermostat is currently off.");
    }

    @Override
    public void operate(String operation) {
        if ("on".equalsIgnoreCase(operation)) on();
        else if ("off".equalsIgnoreCase(operation)) off();
        else if (operation.startsWith("temperature:")) {
            try {
                int temp = Integer.parseInt(operation.split(":")[1]);
                setTemperature(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid operation for Thermostat: " + operation);
        }
    }
}
