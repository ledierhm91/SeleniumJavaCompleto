package Quality.AnotacionesTestNG.DependenciaTestSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeSuiteDependency {

    @BeforeSuite(dependsOnMethods={"firstBeforeSuite","beforeSuite"})
    public void secondBeforeSuite() {
        System.out.println("Second Before suite");
    }

    @BeforeSuite
    public void firstBeforeSuite() {
        System.out.println("First before suite");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @Test
    public void unitTest() {
        System.out.println("Unit test");
    }
}