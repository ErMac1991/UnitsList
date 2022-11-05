import com.codeborne.selenide.Selenide;

public class Clicker { // Нажатие ЛКМ на элемент
    public static void Clicker(String xpathForClick){
        Selenide.$x(xpathForClick).click();

    }
}
