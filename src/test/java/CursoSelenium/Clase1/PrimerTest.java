package CursoSelenium.Clase1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrimerTest {

    //método que devuelve un objeto de tipo WebDriver para e instanciar el ChromeDriver y setiar las properti donde esta el driver y acceder a facebook//
    private WebDriver inicializarfacebook(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.facebook.com");
        return driver;
    }

    //método que que recibe una url por parámetros, setea el setproperty, crea el WebDriver, navega hacia la url que se paso y devuelve un objeto de tipo WebDriver//
    private WebDriver inicializarSitioGetDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    //este test es para imprimir una frase//
    @Test
    public void testing(){
        System.out.println("Esto es un test!!");
    }

    //Acceder a facebook desde otro método y saber el título y la url de la página y MAXIMIZAR la Página//
    @Test
    public void testInWindows1(){
        //WebDriver driver= inicializarfacebook();
        WebDriver driver= inicializarSitioGetDriver("http://www.facebook.com");
        driver.manage().window().maximize();
        System.out.println("El título de la página es " + driver.getTitle());
        System.out.println("La url de la página es " + driver.getCurrentUrl());
        driver.close();
    }

    //este test es para encontrar la cantidad de h1 y h2 y todos los textos de h1 y h2//
    @Test
    public void spotifytest(){
        WebDriver driver= inicializarSitioGetDriver("http://www.spotify.com");
        System.out.println("El título de la página es " + driver.getTitle());
        System.out.println("La url de la página es " + driver.getCurrentUrl());

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        System.out.println("Se encontraron " + listaDeH1s.size() + " elementos");
        for (WebElement elemento : listaDeH1s){
            System.out.println("H1 -> " + elemento.getText());
        }
        List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
        System.out.println("Se encontraron " + listaDeH2s.size() + " elementos");
        for (WebElement elemento : listaDeH2s){
            System.out.println("H2 -> " + elemento.getText());
        }
        driver.close();
    }

    //Ej4:Este test es para encontrar la cantidad de párrafos que hay, mostrar sus textos y que no esten vacios//
    @Test
    public void spotifytest2(){
        WebDriver driver= inicializarSitioGetDriver("http://www.spotify.com");

        System.out.println("El título de la página es " + driver.getTitle());
        System.out.println("La url de la página es " + driver.getCurrentUrl());

        List<WebElement> listalinks= driver.findElements(By.tagName("a"));
        System.out.println("****Links del sitio****");
        for (WebElement elementos : listalinks){
            if(elementos.getText().isEmpty() == false){
                System.out.println("Links -> " + elementos.getText());
            }
        }
        List<WebElement> listaParrafos= driver.findElements(By.tagName("p"));
        System.out.println("Hay una cantidad de " + listaParrafos.size() + " párrafos");
        for (int i=0; i<listaParrafos.size(); i++ ){
            if(listaParrafos.get(i).getText().isEmpty() == false){
                System.out.println("Parrafos: " + listaParrafos.get(i).getText());
            }
        }
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.close();
    }

//este test es para encontrar todos los links que hay en la página y que no esten vacios//
    @Test
    public void mostrarfyLinks(){
        WebDriver driver= inicializarSitioGetDriver("http://www.spotify.com");

        System.out.println("El título de la página es " + driver.getTitle());
        System.out.println("La url de la página es " + driver.getCurrentUrl());

        List<WebElement> listalinks= driver.findElements(By.tagName("a"));
        System.out.println("Existen " + listalinks.size() + " Links");
        for (WebElement elementos : listalinks){
            if(elementos.getText().isEmpty() == false){
            System.out.println("Links -> " + elementos.getText());
        }
        }
        driver.close();

}

//este test es para encontrar solo 3 links de la página y que no esten vacios//
    @Test
    public void mostrarfyLinksSolo3(){
        WebDriver driver= inicializarSitioGetDriver("http://www.spotify.com");

        System.out.println("El título de la página es " + driver.getTitle());
        System.out.println("La url de la página es " + driver.getCurrentUrl());

        List<WebElement> listalinks= driver.findElements(By.tagName("a"));
        System.out.println("Existen " + listalinks.size() + " Links");
        System.out.println("Se imprime solo 3 links");
        for (int i=0; i<3; i++){
            if(listalinks.get(i).getText().isEmpty() == false){
                System.out.println(listalinks.get(i).getText());
        }
        }
        driver.close();
}
//Ejercicio 6
    @Test
    public void getTitleGoogleTest(){
        WebDriver driver= inicializarSitioGetDriver("http://www.google.com");
        String namegoogle= driver.getTitle();

            if(namegoogle.equals("Google")){
                System.out.println("Test pasado");
            }
            else{
                System.out.println("Test fallado");
    }
    }

    //ejercicio 6
    @Test
    public void getTitleSpotify(){
        WebDriver driver= inicializarSitioGetDriver("http://www.spotify.com");
        String nombrspotify= driver.getTitle();

        if(nombrspotify.equals("Escuchar es todo - Spotify")){
            System.out.println("Test pasado");
        }
        else{
            System.out.println("Test fallado");
        }
    }

    //Buscar en google algo y mostrar el nombre del botón y hacer clic en el botón
    @Test
    public void BuscarGoogle(){
        WebDriver driver= inicializarSitioGetDriver("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Que es selenium?");
        WebElement boton= driver.findElement(By.name("btnK"));
        System.out.println("El boton se llama: " + boton.getAttribute("value"));
        //variante 2 eliminando línea anterior.
        //String valor=boton.getAttribute("value");
        //System.out.println("El boton se llama: " + valor);
        driver.manage().window().maximize();
        boton.click();
        driver.navigate().refresh();
        driver.close();

    }
    //Ejercicio 10 Enviar datos al textbox y dar ENTER
    @Test
    public void BuscarGoogle2(){
        WebDriver driver= inicializarSitioGetDriver("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Que es selenium?" + Keys.ENTER);
        driver.manage().window().maximize();
    }

    //Enviar datos al combobox y refrescar la página
    @Test
    public void RefrescarURL(){
        WebDriver driver= inicializarSitioGetDriver("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Que es selenium?");
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }
    //Ejercicio 11
    @Test
    public void BuscarGoogleVolverAtras(){
        WebDriver driver= inicializarSitioGetDriver("http://www.google.com");
        System.out.println("El sitio se llama " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Que es selenium?" + Keys.ENTER);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().back();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().forward();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

        //driver.navigate().back();
        //driver.navigate().refresh();
        //driver.navigate().forward();
    }
    //Ejercicio 12
    @Test
    public void FacebookPaginaTest(){
        WebDriver driver= inicializarSitioGetDriver("http://www.facebook.com");
        List<WebElement> listadiv= driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de div es " +listadiv.size() + " divisiones");

        List<WebElement> listahiper= driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de liks es : " + listahiper.size());
        for(WebElement lis: listahiper){
            if(lis.getText().isEmpty() == false){
                System.out.println("El textos del links es : " + lis.getText());
        }}
        List<WebElement> listabotones= driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de botones es: " + listabotones.size());
        for(WebElement lista: listabotones){
            System.out.println("El texto del botón es: " + lista.getText() );
        }
    }
    //Ejercicio 13
    @Test
    public void EnviarFacebook(){
        WebDriver driver= inicializarSitioGetDriver("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("fgfgfgfgf");
        //driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
        //driver.findElement(By.name("login")).click();
        WebElement boton = driver.findElement(By.name("login"));
        boton.click();
    }
    //Ejercicio 14
    @Test
    public void Netflixtest(){
        WebDriver driver= inicializarSitioGetDriver("http://www.netflix.com/uy");
        List<WebElement> lista= driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de H1 es " + lista.size());
        List<WebElement> lista2= driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de H2 es " + lista2.size());
        if(lista.size() > lista2.size()){
            for(WebElement lis1: lista){
                System.out.println("H1 - " + lis1.getText());
            }
        }
            else{
            for(WebElement lis2: lista2){
                System.out.println("H1 - " + lis2.getText());
            }
        }
         driver.navigate().refresh();
        List<WebElement> botones= driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de botones es " + botones.size());
        for(WebElement lis: botones){
            System.out.println("El texto es: " + lis.getText());
        }
        driver.manage().window().maximize();

        List<WebElement> listadiv= driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de div es " + listadiv.size());

        String nombre= driver.getTitle();
        System.out.println("El título de la página es " + nombre);

        List<WebElement> listainput= driver.findElements(By.tagName("input"));
        System.out.println("La cantidad de input es " + listainput.size());

        List<WebElement> listalink= driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de link es " + listalink.size());
    }
    //Ejercicio 15
    @Test
    public void Netflix(){
        WebDriver driver= inicializarSitioGetDriver("http://www.netflix.com/uy");

        driver.findElement(By.linkText("Iniciar sesión")).click();

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        System.out.println("Se encontraron " + listaDeH1s.size() + " elementos H1");
        for (WebElement elemento : listaDeH1s){
            System.out.println("H1 -> " + elemento.getText());
        }
        List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
        System.out.println("Se encontraron " + listaDeH2s.size() + " elementos H2");
        for (WebElement elemento : listaDeH2s){
            System.out.println("H2 -> " + elemento.getText());
        }
        driver.navigate().back();
        driver.navigate().refresh();

        List<WebElement> listadiv= driver.findElements(By.tagName("div"));
        for(WebElement li: listadiv){
            if(li.getText().isEmpty() == false){
                System.out.println("DIV -> " + li.getText());
            }
        }
        System.out.println("El título de la página es: " + driver.getTitle());
    }
    //Ejercicio 7
    @Test
    public void Dimensiones(){
        WebDriver driver= inicializarSitioGetDriver("http://www.google.com");

        int alto= driver.manage().window().getSize().getHeight();
        int ancho= driver.manage().window().getSize().getWidth();

        System.out.println("El alto es: " + alto);
        System.out.println("El ancho es: " + ancho);

        Dimension dimension= new Dimension(1024, 768);
        driver.manage().window().setSize(dimension);
        System.out.println("Actualizando las dimensiones de la página (Largo y Ancho)");

        alto= driver.manage().window().getSize().getHeight();
        ancho= driver.manage().window().getSize().getWidth();

        System.out.println("El nuevo largo es: " + alto);
        System.out.println("El nuevo ancho es: " + ancho);
    }
}