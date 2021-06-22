package Examen;

import org.testng.annotations.DataProvider;

public class DataGeneratorExamen {

    @DataProvider(name="mails")
    public Object[][] emailsvalidos(){
        return new Object[][] {
                {"carlos@test.com"},
                {"lester@test.com"},
                {"test@test.com"}
        };
    }

}
