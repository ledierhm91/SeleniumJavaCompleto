package Quality.AnotacionesTestNG.OrdenEjecución;

import org.testng.annotations.*;

public class TestClass1 {
    @BeforeSuite
    public void suiteSetup1() {
        System.out.println("testClass1.suiteSetup1: before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("testClass1: before test");
    }

    @Test
    public void unitLevel1() {
        System.out.println("testClass1: Unit level1 testing");
    }

    @Test
    public void unitLevel2() {
        System.out.println("testClass1: Unit level2 testing");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("testClass1: before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("testClass1: after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("testClass1: before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("testClass1: after class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("testClass1: after test");
    }

    @AfterSuite
    public void cleanupSuite() {
        System.out.println("testClass1.cleanupSuite: after suite");
    }
}
