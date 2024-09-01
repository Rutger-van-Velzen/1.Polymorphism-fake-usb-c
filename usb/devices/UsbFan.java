package usb.devices;

import usb.protocol.Power;
import usb.protocol.PowerOrientation;
import usb.protocol.UsbC;
import usb.protocol.VideoData;

public class UsbFan implements UsbC {
    private boolean fanSpinning= false;

    public boolean isFanSpinning() {
        return fanSpinning;
    }

    @Override
    public Power power(Power power) {
        fanSpinning = (power == Power.ON);

        System.out.println("[usb.devices.UsbFan] fanSpinning : " + fanSpinning);


        return null;
    }

    @Override
    public Object highSpeedData() {
        return null;
    }

    @Override
    public PowerOrientation cableOrientation() {

        System.out.println("[usb.devices.UsbFan] RECEIVE_POWER");

        return PowerOrientation.RECEIVE_POWER;
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
