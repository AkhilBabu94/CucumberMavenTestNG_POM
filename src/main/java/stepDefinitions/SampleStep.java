package stepDefinitions;

import cucumber.api.java.en.Given;
import impl.Sample;

import java.awt.*;

public class SampleStep {

    Sample sample = new Sample();

    @Given("Sample case is working")
    public void sampleCase() throws InterruptedException, AWTException {
        sample.composeAndSendMail();
    }


}
