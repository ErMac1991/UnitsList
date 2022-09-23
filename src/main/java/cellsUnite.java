import com.codeborne.selenide.Selenide;

public class cellsUnite {

    // Объединяем ячейки
    public static void cellsUnite(char ch1, int num1, char ch2, int num2){
        Selenide.$x("//input[@id]")
                .click();
        Selenide.$x("//input[@id]")
                .setValue("" + ch1 + num1 + ":" + ch2 + num2)
                .pressEnter();
        Selenide.$x("//div[@aria-label='Объединить ячейки']")
                .click();

    }
}
