import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Clicker {
    public static void Clicker(String xpathForClick){
        Selenide.$x(xpathForClick).click();

    }
}
