import usb.devices.PowerBankOutput;
import usb.devices.UsbFan;
import usb.devices.UsbStick;
import usb.protocol.Power;
import usb.protocol.PowerOrientation;
import usb.protocol.UsbC;

import java.util.Objects;

public class MyApplication {
    public void run(){
        var usbStick = new UsbStick();
        var usbFan = new UsbFan();
        var powerBank = new PowerBankOutput();

        usbCharger(usbStick);
        usbCharger(usbFan);
        usbCharger(powerBank);

        getDataFromUsb(usbStick);
        getDataFromUsb(usbFan);
        getDataFromUsb(powerBank);

    }

    private void usbCharger(UsbC usbDevice){
        System.out.println("\nusbCharger");
        if(usbDevice.cableOrientation() == PowerOrientation.RECEIVE_POWER)
            usbDevice.power(Power.ON);
    }

    private Object getDataFromUsb(UsbC usbDevice){
        System.out.println("\ngetDataFromUsb");
        if(usbDevice.cableOrientation() == PowerOrientation.GIVE_POWER)
            return null;


        usbDevice.power(Power.ON);

        var data = usbDevice.highSpeedData();
        if (Objects.isNull(data))
            data = usbDevice.basicData();

        return data;

    }
}
