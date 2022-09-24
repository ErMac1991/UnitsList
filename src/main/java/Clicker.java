import com.codeborne.selenide.Selenide;

public class Clicker {
    public static void Clicker(String xpathForClick){
        Selenide.$x(xpathForClick).click();

    }
}
