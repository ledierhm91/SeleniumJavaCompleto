package Quality.AnotacionesTestNG.SuitesPadreHijo;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestClassHijo1 {
    @BeforeSuite
    @Parameters("param")
    public void beforeSuite(String p) {
        System.out.println("TestClassHijo1: before suite " + p);
    }
}