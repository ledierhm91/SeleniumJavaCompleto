package Clase5.factories;

import org.testng.annotations.Test;

public class CalculadoraTest {
    int num1 = 0;
    int num2 = 0;

    public CalculadoraTest(int numero1, int numero2){
        num1 = numero1;
        num2 = numero2;
    }

    @Test
    public void sumar(){
        int suma = num1+ num2;
        System.out.println("La suma es " +suma);
    }
    @Test
    public void restar(){
        int resta = num1 - num2;
        System.out.println("La resta es " + resta);

    }
}
