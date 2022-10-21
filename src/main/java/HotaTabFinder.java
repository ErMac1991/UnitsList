import com.codeborne.selenide.Selenide;

public class HotaTabFinder {
    public static int wideControl; // ���������� ��� �������� ������� ������
    public static int thinControl; // ���������� ��� �������� ����� ������
    public static String xPathOfTabElement;

    public static String HotaTabFinder(int iTab) {

        if (Selenide.$x("//h3/span[contains(text(),'" + iTab +"-� �������')]/../following::div[@class='table-wide'][1]").exists()) {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::div[@class='table-wide'][1]/div[@class='table-wide-inner']/table[1]/tbody/tr";
        }
        else {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::table[1]/tbody/tr";
        }

       return xPathOfTabElement;
    }

    public static String HotaTabFinder(int iTab, int iLine) {

        if (Selenide.$x("//h3/span[contains(text(),'" + iTab +"-� �������')]/../following::div[@class='table-wide'][1]").exists()) {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::div[@class='table-wide'][1]/div[@class='table-wide-inner']/table[1]/tbody/tr[" + iLine + "]/td";
        }
        else {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::table[1]/tbody/tr[" + iLine + "]/td";
        }

        return xPathOfTabElement;
    }

    public static String HotaTabFinder(int iTab, int iLine, int  iCell) {

        if (Selenide.$x("//h3/span[contains(text(),'" + iTab +"-� �������')]/../following::div[@class='table-wide'][1]").exists()) {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::div[@class='table-wide'][1]/div[@class='table-wide-inner']/table[1]/tbody/tr[" + iLine + "]/td[" + iCell + "]";
        }
        else {
            xPathOfTabElement = "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::table[1]/tbody/tr[" + iLine + "]/td[" + iCell + "]";
        }

        return xPathOfTabElement;
    }


    // "//div[@class='mw-parser-output']/table[1]/tbody/tr[2]/td[1]" ��� ����������
    // "//div[@class='mw-parser-output']/div[@class='table-wide'][1]//table//tr[2]/td[1]" � �����������

    // "//h3/span[contains(text(),'" + iTab + "-� �������')]/../following::table[1]/tbody/tr[2]/td[3]"

}
