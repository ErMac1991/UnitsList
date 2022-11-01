import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;



public  class Main {
    static String urlSiteHommWiki = "https://mightandmagic.fandom.com/ru/";
    static String urlGoogleDocs = "https://docs.google.com/";
    static String urlCrTabs = null;
    static boolean isNeutral;


     @Before
             public void Starter() {

         // Установка и настройка Web дравйера

          WebDriverManager.chromedriver().setup();
          browser = "chrome";
          driverManagerEnabled = true;
          browserSize = "1900x1080";

     }
    @Test

    public void Engine(){



        //Пытаемся открыть вторую вкладку браузера

        open();
        OpenNewWindow.OpenNewWindow();
        Selenide.sleep(5000);

        // Переключаемся на первую вкладку и создаем таблицу в гуглдок

        Selenide.switchTo().window(0);
        open(urlGoogleDocs);
        CreateGoogleTab.CreateGoogleTab();

        // Подтягиваем инфу про нейтралов

        Selenide.switchTo().window(1);
        isNeutral = true;
        FollowHomm3Creatures.FollowHomm3Creatures();
        Homm3TabCellsGrabler.Homm3TabCellsGrabler();


        // Переключаемся на вторую вкладку и переходим в раздел существ HOTA

        Selenide.switchTo().window(1);
        FollowHotaCr.FollowHotaCr();

        // Запускаем машину по подтягиванию статов

        isNeutral = false;
        HotaCrInfoGrabber.HotaCrInfoGrabber();

        // Переключаемся на вторую вкладку и переходим в раздел существ HOMM3

        Selenide.switchTo().window(1);
        FollowHomm3Creatures.FollowHomm3Creatures();

        // Запускаем машину по подтягиванию статов

        isNeutral = false;
        Homm3TabCellsGrabler.Homm3TabCellsGrabler();



        // Причесываем таблицу, экспортируем, чистим мусор

        closingGoogleTab.closingGoogleTab();


    }

     @After
     public  void Dropper(){

         WebDriverManager.chromedriver().quit();
     }

}
