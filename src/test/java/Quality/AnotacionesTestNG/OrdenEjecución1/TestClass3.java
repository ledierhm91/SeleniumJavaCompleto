package Quality.AnotacionesTestNG.OrdenEjecución1;

import org.testng.annotations.*;

public class TestClass3 {
    @BeforeTest
    public void doBeforeTest() {
        System.out.println("testClass3: before test");
    }
    @BeforeClass
    public void doBeforeClass() {
        System.out.println("testClass3: before class");
    }
    @Test
    public void test1() {
        System.out.println("testClass3: test1");
    }
    @Test
    public void test2() {
        System.out.println("testClass3: test2");
    }
    @AfterClass
    public void doAfterClass() {
        System.out.println("testClass3: after class");
    }
    @AfterSuite
    public void doAfterSuite() {
        System.out.println("testClass3: after suite");
    }
}