import DecoratorPattern.ConcreteDecorators.*;
import DeviceAbstraction.*;
import DeviceAbstraction.ConcreteDevices.*;
import FacadePattern.HomeAutomationFacade;

public class Main {
    public static void main(String[] args) {
        Device smartLight = new VoiceControlDecorator(new Light());

        /*
        System.out.println("Operating Smart Light:");
        smartLight.on();
        System.out.println();
        System.out.println("Again:");
        smartLight = new RemoteAccessDecorator(smartLight);
        smartLight.on();
        System.out.println();
        */

        Device musicSystem = new RemoteAccessDecorator(new EnergySavingDecorator(new MusicSystem()));

        /*
        System.out.println("Operating Smart Music System:");
        musicSystem.on();
        musicSystem.off();
        */

        Device smartThermostat = new EnergySavingDecorator(new Thermostat());
        Device smartCamera = new RemoteAccessDecorator(new SecurityCamera());

        HomeAutomationFacade home = new HomeAutomationFacade(
                smartLight, musicSystem, smartThermostat, smartCamera
        );

        home.startPartyMode();
        home.activateNightMode();
        home.leaveHome();
    }
}
