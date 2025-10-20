package FacadePattern;

import CSV.LoggerCSV;
import AbstractFactoryPattern.AbstractFactory.DeviceFactory;
import AbstractFactoryPattern.ConcreteFactories.*;
import DeviceAbstraction.Device;

public class HomeAutomationFacade {
    private DeviceFactory factory;

    private Device light;
    private Device musicSystem;
    private Device thermostat;
    private Device securityCamera;

    public HomeAutomationFacade() {
        this.factory = new SmartDeviceFactory();
        createDevices();
    }

    public HomeAutomationFacade(DeviceFactory factory) {
        this.factory = factory;
        createDevices();
    }

    public void setFactory(DeviceFactory factory) {
        this.factory = factory;
        System.out.println("Device factory changed to: " + factory.getClass().getSimpleName());
        createDevices();
    }

    private void createDevices() {
        this.light = factory.createLight();
        this.musicSystem = factory.createMusicSystem();
        this.thermostat = factory.createThermostat();
        this.securityCamera = factory.createSecurityCamera();
    }

    public void activateNightMode() {
        System.out.println("Activating Night Mode!");
        showImage("night");
        light.operate("off");
        LoggerCSV.log("Activate Night Mode", factory.getClass().getSimpleName(), "Light", "off");
        thermostat.operate("on");
        LoggerCSV.log("Activate Night Mode", factory.getClass().getSimpleName(), "Thermostat", "on");
        securityCamera.operate("on");
        LoggerCSV.log("Activate Night Mode", factory.getClass().getSimpleName(), "SecurityCamera", "on");
        System.out.println("Night mode activated.");
        System.out.println();
    }

    public void startPartyMode() {
        System.out.println("Starting Party Mode!");
        showImage("party");
        light.operate("on");
        LoggerCSV.log("Activate Party Mode", factory.getClass().getSimpleName(), "Light", "on");
        musicSystem.operate("on");
        LoggerCSV.log("Activate Party Mode", factory.getClass().getSimpleName(), "MusicSystem", "on");
        System.out.println("Party mode activated.");
        System.out.println();
    }

    public void leaveHome() {
        System.out.println("Leaving Home!");
        showImage("secure");
        musicSystem.operate("off");
        LoggerCSV.log("Leaving Home", factory.getClass().getSimpleName(), "MusicSystem", "off");
        light.operate("off");
        LoggerCSV.log("Leaving Home", factory.getClass().getSimpleName(), "Light", "off");
        thermostat.operate("off");
        LoggerCSV.log("Leaving Home", factory.getClass().getSimpleName(), "Thermostat", "off");
        securityCamera.operate("on");
        LoggerCSV.log("Leaving Home", factory.getClass().getSimpleName(), "SecurityCamera", "on");
        System.out.println("You may leave safely.");
        System.out.println();
    }

    private void showImage(String imageName) {
        String imagePath = "C:/Users/vladk/IdeaProjects/DecoratorAndFacade/Assets/" + imageName + ".jpg";

        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imagePath);

            java.awt.Image scaledImage = icon.getImage().getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
            icon = new javax.swing.ImageIcon(scaledImage);

            javax.swing.JFrame frame = new javax.swing.JFrame("Mode: " + imageName);
            frame.setUndecorated(true);
            frame.setAlwaysOnTop(true);
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

            javax.swing.JLabel label = new javax.swing.JLabel(icon);
            frame.getContentPane().add(label);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            new javax.swing.Timer(2000, e -> frame.dispose()).start();
        });
    }



    public Device getLight() { return light; }
    public Device getMusicSystem() { return musicSystem; }
    public Device getThermostat() { return thermostat; }
    public Device getSecurityCamera() { return securityCamera; }
    public String getFactoryName() {
        return factory.getClass().getSimpleName();
    }
}
