package Quality.AnotacionesTestNG.SuitesPadreHijo;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestClassHijo2 {
    @BeforeSuite
    @Parameters("param")
    public void beforeSuite(String p) {
        System.out.println("TestClassHijo2: before suite " + p);
    }
}