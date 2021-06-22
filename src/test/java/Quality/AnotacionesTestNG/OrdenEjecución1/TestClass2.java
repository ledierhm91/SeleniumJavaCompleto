package Quality.AnotacionesTestNG.OrdenEjecución1;

import org.testng.annotations.*;

public class TestClass2 {

    @BeforeTest
    public void doBeforeTest() {
        System.out.println("testClass2: before test");
    }
    @BeforeClass
    public void doBeforeClass() {
        System.out.println("testClass2: before class");
    }
    @BeforeMethod
    public void doBeforeMethod() {
        System.out.println("testClass2: before method");
    }
    @Test
    public void scenario1() {
        System.out.println("testClass2: scenario1");
    }
    @Test
    public void scenario2() {
        System.out.println("testClass2: scenario2");
    }
    @AfterMethod
    public void doAfterMethod() {
        System.out.println("testClass2: After method");
    }
    @AfterClass
    public void doAfterClass() {
        System.out.println("testClass2: after class");
    }
}