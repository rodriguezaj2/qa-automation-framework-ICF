package steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class HybridHooks extends CommonMethods {

    @Before("@Hybrid")
    public void startHybrid(){
        openBrowserAndLaunchApplication();
    }

    @After("@Hybrid")
    public void endHybrid(){
        closeBrowser();
    }
}
