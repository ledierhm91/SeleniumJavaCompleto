package Quality.AnotacionesTestNG.FactorySuite;

import org.testng.annotations.Factory;

public class FactoryClass {
    @Factory
    public Object[] createTestClass() {
        return new Object[]{
                new TestClass("1"),
                new TestClass("2")};
    }
}