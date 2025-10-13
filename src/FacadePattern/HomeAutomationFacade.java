package FacadePattern;

import DeviceAbstraction.Device;

public class HomeAutomationFacade {
    private Device light;
    private Device musicSystem;
    private Device thermostat;
    private Device securityCamera;

    public HomeAutomationFacade(Device light, Device musicSystem, Device thermostat, Device securityCamera) {
        this.light = light;
        this.musicSystem = musicSystem;
        this.thermostat = thermostat;
        this.securityCamera = securityCamera;
    }

    public void activateNightMode() {
        System.out.println("Activating Night Mode!");
        light.off();
        thermostat.on();
        securityCamera.on();
        System.out.println("Night mode activated.");
        System.out.println();
    }

    public void startPartyMode() {
        System.out.println("Starting Party Mode!");
        light.on();
        musicSystem.on();
        System.out.println("Party mode activated.");
        System.out.println();
    }

    public void leaveHome() {
        System.out.println("Leaving Home!");
        musicSystem.off();
        light.off();
        thermostat.off();
        securityCamera.on();
        System.out.println("You may leave safely.");
        System.out.println();
    }
}