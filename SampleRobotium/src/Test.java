import junit.framework.Assert;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;


public class Test extends ActivityInstrumentationTestCase2<Activity> {
	
      private static final String LAUNCHER_ACTIVITY_CLASSNAME = "com.snapchat.android.LandingPageActivity";

      private static Class<?> launchActivityClass;
      static {
              try {
                      launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
              } catch (ClassNotFoundException e) {
                      throw new RuntimeException(e);
              }
      }
      

	  private Solo solo;

	  public Test() {
		  super((Class<Activity>) launchActivityClass);
	  }

	  public void setUp() throws Exception {
	        solo = new Solo(getInstrumentation(), getActivity());
	  }
	  
	  
	  public void testPreferenceIsSaved() throws Exception {
	  
	                solo.sendKey(Solo.MENU);
	                solo.clickOnText("More");
	                solo.clickOnText("Preferences");
	                solo.clickOnText("Edit File Extensions");
	                Assert.assertTrue(solo.searchText("rtf"));
	            
	                
	                solo.clickOnText("txt");
	                solo.clearEditText(2);
	                solo.enterText(2, "robotium");
	                solo.clickOnButton("Save");
	                solo.goBack();
	                solo.clickOnText("Edit File Extensions");
	                Assert.assertTrue(solo.searchText("application/robotium"));
	                
	  }

	   @Override
	   public void tearDown() throws Exception {
	        solo.finishOpenedActivities();
	  }
	
	

}
