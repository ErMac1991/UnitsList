import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.open;

public class FollowHotaCr {
    public static void FollowHotaCr(){

        // ������� �� �������� �� ������� ������� Hota

        Selenide.switchTo().window(1);
        open(Main.urlSiteHommWiki);

        Clicker.Clicker("//b[text()='Heroes III']");

        Clicker.Clicker("//a[text()='������ ������� Horn of the Abyss']");

        System.out.println("������� �� �������� ������� Hota");
    }
}
