package CLI;

import AbstractFactoryPattern.AbstractFactory.DeviceFactory;
import AbstractFactoryPattern.ConcreteFactories.BasicDeviceFactory;
import AbstractFactoryPattern.ConcreteFactories.EcoDeviceFactory;
import AbstractFactoryPattern.ConcreteFactories.SmartDeviceFactory;
import CSV.LoggerCSV;
import DecoratorPattern.ConcreteDecorators.*;
import DeviceAbstraction.CustomDeviceCLI.CustomDevice;
import DeviceAbstraction.Device;
import FacadePattern.HomeAutomationFacade;

import java.util.Scanner;

public class HomeAutomationCLI {
    private HomeAutomationFacade homeFacade;
    private Scanner scanner;

    public HomeAutomationCLI() {
        this.scanner = new Scanner(System.in);
        this.homeFacade = new HomeAutomationFacade();
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Smart Home Automation CLI ---");
            System.out.println("1. Activate Night Mode");
            System.out.println("2. Activate Party Mode");
            System.out.println("3. Activate Secure Mode");
            System.out.println("4. Manual Device Control");
            System.out.println("5. Change Factory");
            System.out.println("6. Add Custom Device");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> homeFacade.activateNightMode();
                case "2" -> homeFacade.startPartyMode();
                case "3" -> homeFacade.leaveHome();
                case "4" -> manualDeviceControl();
                case "5" -> changeFactory();
                case "6" -> addCustomDevice();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Please use integer ._.");
            }
        }
    }
    private void addCustomDevice() {
        System.out.print("Enter device name: ");
        String deviceName = scanner.nextLine().trim();

        Device device = new CustomDevice(deviceName);

        System.out.print("Add Voice Control? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            device = new VoiceControlDecorator(device);
        }

        System.out.print("Add Remote Access? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            device = new RemoteAccessDecorator(device);
        }

        System.out.print("Add Energy Saving? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            device = new EnergySavingDecorator(device);
        }

        System.out.print("Turn device ON or OFF?: ");
        String action = scanner.nextLine().trim().toLowerCase();

        if (action.equals("on")) {
            device.operate("on");
            LoggerCSV.log("UserAction", "CLI", deviceName, "on");
        } else if (action.equals("off")) {
            device.operate("off");
            LoggerCSV.log("UserAction", "CLI", deviceName, "off");
        } else {
            System.out.println("Invalid action.");
        }

        System.out.println("Device logged to CSV.");
        System.out.println();
    }

    private void manualDeviceControl() {
        while (true) {
            System.out.println("\n--- Manual Device Control ---");
            System.out.println("1. Turn ON Light");
            System.out.println("2. Turn OFF Light");
            System.out.println("3. Adjust Light Brightness");
            System.out.println("4. Turn ON Music");
            System.out.println("5. Turn OFF Music");
            System.out.println("6. Turn ON Thermostat");
            System.out.println("7. Turn OFF Thermostat");
            System.out.println("8. Set Thermostat Temperature");
            System.out.println("9. Turn ON Security Camera");
            System.out.println("10. Turn OFF Security Camera");
            System.out.println("0. Back to Main Menu");

            System.out.print("Choice: ");
            String option = scanner.nextLine();

            if (option.equals("0")) break;

            String factoryName = homeFacade.getFactoryName();

            switch (option) {
                case "1" -> {
                    homeFacade.getLight().operate("on");
                    LoggerCSV.log("Manual Control", factoryName, "Light", "on");
                }
                case "2" -> {
                    homeFacade.getLight().operate("off");
                    LoggerCSV.log("Manual Control", factoryName, "Light", "off");
                }
                case "3" -> {
                    System.out.print("Enter brightness (0-100): ");
                    String brightness = scanner.nextLine();
                    homeFacade.getLight().operate("brightness:" + brightness);
                    LoggerCSV.log("Manual Control", factoryName, "Light", "brightness " + brightness + "%");
                }
                case "4" -> {
                    homeFacade.getMusicSystem().operate("on");
                    LoggerCSV.log("Manual Control", factoryName, "MusicSystem", "on");
                }
                case "5" -> {
                    homeFacade.getMusicSystem().operate("off");
                    LoggerCSV.log("Manual Control", factoryName, "MusicSystem", "off");
                }
                case "6" -> {
                    homeFacade.getThermostat().operate("on");
                    LoggerCSV.log("Manual Control", factoryName, "Thermostat", "on");
                }
                case "7" -> {
                    homeFacade.getThermostat().operate("off");
                    LoggerCSV.log("Manual Control", factoryName, "Thermostat", "off");
                }
                case "8" -> {
                    System.out.print("Enter temperature (°C): ");
                    String temp = scanner.nextLine();
                    homeFacade.getThermostat().operate("temperature:" + temp);
                    LoggerCSV.log("Manual Control", factoryName, "Thermostat", "temperature " + temp + "°C");
                }
                case "9" -> {
                    homeFacade.getSecurityCamera().operate("on");
                    LoggerCSV.log("Manual Control", factoryName, "SecurityCamera", "on");
                }
                case "10" -> {
                    homeFacade.getSecurityCamera().operate("off");
                    LoggerCSV.log("Manual Control", factoryName, "SecurityCamera", "off");
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void changeFactory() {
        System.out.println("\n--- Change Device Factory ---");
        System.out.println("1. Smart Device Factory");
        System.out.println("2. Eco Device Factory");
        System.out.println("3. Basic Device Factory");
        System.out.print("Choice: ");
        String option = scanner.nextLine();

        DeviceFactory newFactory;

        switch (option) {
            case "1" -> newFactory = new SmartDeviceFactory();
            case "2" -> newFactory = new EcoDeviceFactory();
            case "3" -> newFactory = new BasicDeviceFactory();
            default -> {
                System.out.println("Invalid option!");
                return;
            }
        }

        homeFacade.setFactory(newFactory);
        System.out.println("Factory changed successfully!");
    }
}
