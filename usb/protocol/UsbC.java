package usb.protocol;

public interface UsbC {
    /**
     * If this device takes power (PowerOrientation.RECEIVE_POWER):
     * It should get Power.ON;
     * When it gets Power.OFF it stops working
     *
     * When the device provides power (PowerOrientation.GIVE_POWER):
     * It should not take any, so power must be Power.NON
     */
    Power power(Power power);

    Object highSpeedData();

    /**
     * A device should pick a side, should it take power or deliver power.
     */
    PowerOrientation cableOrientation();

    /**
     * HDMI
     * DisplayPort
     * etc..
     */
    VideoData alternateMode();

    /**
     * Supports backwards-compatibility for older USB devises.
     */
    Object basicData();
}
