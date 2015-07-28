package com;
import java.io.IOException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class TestRun extends UiAutomatorTestCase {
	public UiDevice myDevice;
	
	public void testRecorded() {
		myDevice = getUiDevice();
       		try {
			Runtime.getRuntime().exec("am start -n com.snapchat.android/com.snapchat.android.LandingPageActivity");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	sleep(10000);
        	myDevice.pressBack();
	}
}
