import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class Homm3TabCellsGrabler { // Перебор ячеек таблицы Homm3

    public static String crLevel = null; // Ранг существа
    public static String prevLevel = null; // Значение ранга предыдущего существа
    public static boolean gS = false;
    public static int gSIndicator = 0;
    public static int iTabs; // счетчик для цикла таблиц
    public static int allTabsOnPage;
    public static int iLines; // счетчик для цикла строк в таблице
    public static int countLinesInTab; // количество строк в таблице
    public static int iCells; // счетчик для цикла ячеек в строке
    public static int countCellsInLine; // количество столбцов в таблице

    public static void Homm3TabCellsGrabler() {

        String urlOfCard = null;        // Ссылка на карточку существа

        ElementsCollection tabs = $$x("//table"); // Список таблиц
        ElementsCollection lines; // Список строк в таблице
        ElementsCollection cells;

        System.out.println("Запустилась машинка по Homm3");

        Selenide.switchTo().window(1);

        allTabsOnPage = tabs.size()-1; // В этом классе берем только фракционных юнитов HOMM3

        for (iTabs = 1; iTabs <= allTabsOnPage; iTabs++) {

            if (Main.isNeutral == true) {
                iTabs = allTabsOnPage +1;
            }

            lines = $$x("//table[" + iTabs + "]//tr");
            countLinesInTab = lines.size();


            for (iLines = 2; iLines <= countLinesInTab; iLines++) {
                cells = $$x("//table[" + iTabs + "]//tr[" + iLines + "]//td");
                countCellsInLine = cells.size();


                for (iCells = 0; iCells < countCellsInLine; iCells++) { // Захват данных из таблицы существ

                    switch (iCells+1) {

                        case 1: // Подтягиваем уровень существа
                            crLevel = cells.get(iCells).getText();

                            break;

                        case 2: // Пороваливаемся в карточку существа и подтягивает статы

                            //gS = false;

                            if (!crLevel.equals(prevLevel)){
                                gSIndicator = 0;
                                prevLevel = crLevel;
                            }
                            else {
                                gSIndicator++;
                            }

                            urlOfCard = cells.get(iCells).find("a").getAttribute("href");
                            Homm3CrInfoGrabber.Homm3CrInfoGrabber(urlOfCard);
                            break;


                        case 4: // Проваливаемся в карточку ГС существа и подтягивает статы
                            urlOfCard = cells.get(iCells).find("a").getAttribute("href");

                            if (!crLevel.equals(prevLevel)){
                                gSIndicator = 0;
                                prevLevel = crLevel;
                            }
                            else {
                                gSIndicator++;
                            }


                            Homm3CrInfoGrabber.Homm3CrInfoGrabber(urlOfCard);
                            break;

                        default:


                    }
                }

                if (Main.isNeutral == true) { // Подтягиваем нейтралов с Hota

                    FollowHotaCr.FollowHotaCr();
                    HotaCrInfoGrabber.HotaCrInfoGrabber();
                    open(Main.urlCrTabs);


                }

            }
        }
    }
}

