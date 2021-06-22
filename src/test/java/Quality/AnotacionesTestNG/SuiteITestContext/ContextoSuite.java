package Quality.AnotacionesTestNG.SuiteITestContext;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public class ContextoSuite {
    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        System.out.println("ContextBeforeSuite: before suite " + context.getSuite().getName());
    }
}