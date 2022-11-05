import com.codeborne.selenide.Selenide;

public class gTabCellDataPaste {

    // ¬писываем данные в €чейку гуглтаба

    public static void gTabCellDataPaste(char baseColumn, int baseLine, String data){
        Selenide.$x("//input[@id]")
                .click();
        Selenide.$x("//input[@id]")
                .setValue("" + baseColumn + baseLine)
                .pressEnter();
        Selenide.$x("//div[@id='t-formula-bar-input']/div")
                .click();
        Selenide.$x("//div[@id='t-formula-bar-input']/div")
                .setValue(data)
                .pressEnter();

    }
}
