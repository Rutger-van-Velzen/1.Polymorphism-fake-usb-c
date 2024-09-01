package usb.devices;

import usb.protocol.Power;
import usb.protocol.PowerOrientation;
import usb.protocol.UsbC;
import usb.protocol.VideoData;

public class UsbStick implements UsbC {
    private boolean isTurnedOn = false;
    private Object data = new Object();

    @Override
    public Power power(Power power) {
        isTurnedOn = (power == Power.ON);

        System.out.println("[usb.devices.UsbStick] isTurnedOn : " + isTurnedOn);

        return null;
    }

    @Override
    public Object highSpeedData() {
        System.out.println("[usb.devices.UsbStick] highSpeedData");

        return (isTurnedOn)
                ? data
                : null;
    }

    @Override
    public PowerOrientation cableOrientation() {
        System.out.println("[usb.devices.UsbStick] RECEIVE_POWER");
        return PowerOrientation.RECEIVE_POWER;
    }

    @Override
    public VideoData alternateMode() {
        return null;
    }

    @Override
    public Object basicData() {
        System.out.println("[usb.devices.UsbStick] basicData");
        return null;
    }
}
