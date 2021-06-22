package Clase6;

import org.testng.annotations.DataProvider;

public class DataGenerator {

    @DataProvider(name="paises")
    public Object[][] paisesConCapitales(){
        return new Object[][] {
                {"Buenos Aires", "Argetina"},
                {"Montevideo", "Uruguay"},
                {"Santiago", "Chile"}
        };
    }


    @DataProvider(name="loginData")
    public Object[][] loginInfo(){
        return new Object[][] {
                {"John", "Smith", "New York", 1231234},
                {"Alan", "Rowen", "Dallas", 33333},
                {"Brianne", "Cowen", "Miami", 22222}
        };
    }

    @DataProvider(name="emails")
    public Object[][] emailInfo(){
        return new Object[][] {
                {"testing@test.com", "valid"},
                {"", "invalid"},
                {"asdfasdfasdf","invalid"}
        };
    }

}
