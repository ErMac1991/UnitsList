import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;



public  class Main {
    static String urlSiteHommWiki = "https://mightandmagic.fandom.com/ru/";
    static String urlGoogleDocs = "https://docs.google.com/";

    static String urlCrTabs = null;


     @Before
             public void Starter() {

         // ��������� � ��������� Web ��������

          WebDriverManager.chromedriver().setup();
          browser = "chrome";
          driverManagerEnabled = true;
          browserSize = "1900x1080";

     }
    @Test

    public void Engine(){

        //�������� ������� ������ ������� ��������

        open();
        OpenNewWindow.OpenNewWindow();
        Selenide.sleep(5000);

        // ������������� �� ������ ������� � ������� ������� � �������

        Selenide.switchTo().window(0);
        open(urlGoogleDocs);
        CreateGoogleTab.CreateGoogleTab();


        // ������������� �� ������ ������� � ��������� � ������ ������� HOMM3

        Selenide.switchTo().window(1);
        FollowHomm3Creatures.FollowHomm3Creatures();

        // ��������� ������ �� ������������ ������

        Homm3TabCellsGrabler.Homm3TabCellsGrabler();

// ������������� �� ������ ������� � ��������� � ������ ������� HOTA

        Selenide.switchTo().window(1);
        FollowHotaCr.FollowHotaCr();

        // ��������� ������ �� ������������ ������

        HotaCrInfoGrabber.HotaCrInfoGrabber();

        // ����������� �������, ������������, ������ �����

        closingGoogleTab.closingGoogleTab();


    }

     @After
     public  void Dropper(){

         WebDriverManager.chromedriver().quit();
     }

}
