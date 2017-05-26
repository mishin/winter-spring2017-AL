package base.security;

/**
 * Created by Marth on 5/26/2017.
 */

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;

public class WebDevice implements Device {

    @Override
    public DevicePlatform getDevicePlatform() {
        return null;
    }

    @Override
    public boolean isMobile() {
        return false;
    }

    @Override
    public boolean isNormal() {
        return true;
    }

    @Override
    public boolean isTablet() {
        return false;
    }

}