import com.codeborne.selenide.Selenide;

public class HotaTabFinder { // Находим таблицу, вне зависимости от того, сжата она или нет

    public static int wideControl; // Переменная для контроля широких таблиц
    public static int thinControl; // Переменная для контроля узких таблиц
    public static String xPathOfTabElement;

    public static String HotaTabFinder(int iTab) {

        if (Selenide.$x("//h3/span[contains(text(),'" + iTab +"-й уровень')]/../following::div[@class='table-wide'][1]").exists()) {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-й уровень')]/../following::div[@class='table-wide'][1]/div[@class='table-wide-inner']/table[1]/tbody/tr";
        }
        else {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-й уровень')]/../following::table[1]/tbody/tr";
        }

       return xPathOfTabElement;
    }

    public static String HotaTabFinder(int iTab, int iLine) {

        if (Selenide.$x("//h3/span[contains(text(),'" + iTab +"-й уровень')]/../following::div[@class='table-wide'][1]").exists()) {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-й уровень')]/../following::div[@class='table-wide'][1]/div[@class='table-wide-inner']/table[1]/tbody/tr[" + iLine + "]/td";
        }
        else {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-й уровень')]/../following::table[1]/tbody/tr[" + iLine + "]/td";
        }

        return xPathOfTabElement;
    }

    public static String HotaTabFinder(int iTab, int iLine, int  iCell) {

        if (Selenide.$x("//h3/span[contains(text(),'" + iTab +"-й уровень')]/../following::div[@class='table-wide'][1]").exists()) {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-й уровень')]/../following::div[@class='table-wide'][1]/div[@class='table-wide-inner']/table[1]/tbody/tr[" + iLine + "]/td[" + iCell + "]";
        }
        else {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-й уровень')]/../following::table[1]/tbody/tr[" + iLine + "]/td[" + iCell + "]";
        }

        return xPathOfTabElement;
    }


}
