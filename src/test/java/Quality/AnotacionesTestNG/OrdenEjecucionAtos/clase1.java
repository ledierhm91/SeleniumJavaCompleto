package Quality.AnotacionesTestNG.OrdenEjecucionAtos;

import org.testng.annotations.Test;

public class clase1 {


    @Test(groups = "simple")
    public void unitLevel1() {
        System.out.println("testClass1: Unit level1 testing");
    }

    @Test(groups = "simple")
    public void unitLevel2() {
        System.out.println("testClass1: Unit level2 testing");
    }
}
