package Examen;
import Examen.prueba_netflix;

import org.testng.annotations.Factory;


public class TestFactoryExamen {

    @Factory
    public Object[] prueba_netflix(){
        return new Object[]{
                new prueba_netflix(),
                new prueba_netflix()
                //new prueba_netflix("prueba1@gmail.com"),
                //new prueba_netflix("prueba2@gmail.com")
        };
    }
}
