package Quality.AnotacionesTestNG.FactorySuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestClass {
    private String param;

    public TestClass(String param) {
        this.param = param;
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @Test
    public void PruebaFicticia() {
        System.out.println("prueba ficticia " + param);
    }
}