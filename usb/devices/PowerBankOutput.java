package usb.devices;

import usb.protocol.Power;
import usb.protocol.PowerOrientation;
import usb.protocol.UsbC;
import usb.protocol.VideoData;

public class PowerBankOutput implements UsbC {
    private int powerLevel = 100;

    @Override
    public Power power(Power power) {
        if(power != Power.NON)
            throw new IllegalArgumentException("Orientation violated!");

        powerLevel--;

        System.out.println("[usb.devices.PowerBankOutput] powerLevel : " + powerLevel);


        return (powerLevel > 0)
                ? Power.ON
                : Power.OFF;
    }

    @Override
    public Object highSpeedData() {
        return null;
    }

    @Override
    public PowerOrientation cableOrientation() {
        System.out.println("[usb.devices.PowerBankOutput] GIVE_POWER");

        return PowerOrientation.GIVE_POWER;
    }

    @Override
    public VideoData alternateMode() {
        return null;
    }

    @Override
    public Object basicData() {
        return null;
    }
}
