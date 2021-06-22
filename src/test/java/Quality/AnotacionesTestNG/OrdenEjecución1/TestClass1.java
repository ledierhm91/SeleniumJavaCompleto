package Quality.AnotacionesTestNG.OrdenEjecución1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass1 {
    @BeforeSuite
    public void doBeforeSuite() {
        System.out.println("testClass1: before suite");
    }

    @BeforeTest
    public void doBeforeTest() {
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
    public void doBeforeMethod() {
        System.out.println("testClass1: before method");
    }

    @AfterMethod
    public void doAfterMethod() {
        System.out.println("testClass1: after method");
    }

    @BeforeClass
    public void doBeforeClass() {
        System.out.println("testClass1: before class");
    }

    @AfterClass
    public void doAfterClass() {
        System.out.println("testClass1: after class");
    }
}