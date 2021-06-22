package Clase6;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEjemplo1 {

    @DataProvider(name="datos")
    public Object[][] personas(){
        return new Object[][] {
                {"Juan", 39},
                {"Maria", 22},
                {"Andres", 28}
        };
    }

    @Test (dataProvider = "datos")
    public void mostrarInfoTest(String nombre, Integer edad){
        System.out.println("Nombre: " + nombre + " y edad "+ edad);
    }

}
