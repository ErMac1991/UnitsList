import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.open;

public class FollowHomm3Creatures {
    public static void FollowHomm3Creatures() {
        Selenide.switchTo().window(1);
        open(Main.urlSiteHommWiki);

        Clicker.Clicker("//b[text()='Heroes III']");

        Clicker.Clicker("//a[text()='Список существ Heroes of Might and Magic III']");
        Main.urlCrTabs = WebDriverRunner.getWebDriver().getCurrentUrl();

    }
}