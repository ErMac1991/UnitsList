import com.codeborne.selenide.Selenide;

public class InfoTransport { // Заносим подтянутую инфу в гуглтаб

    static int baseLine = -6; // Строка, от которой ведется расчет ячейки
    static String tabFraction = "null"; // Переменная для проверки фракции
    static String tabLevel = "0";
    static char baseColumn; // Столбец, от которого ведется расчет ячейки

    public static void InfoTransport(){

        baseColumn = 'A';


        Selenide.switchTo().window(0);

        if (Homm3TabCellsGrabler.gSIndicator > 0){
            baseColumn = (char) (baseColumn + (6 * Homm3TabCellsGrabler.gSIndicator));
            if (Main.isNeutral == false) {
                Homm3TabCellsGrabler.crLevel = "ГС";
            }

        }
        if (Homm3TabCellsGrabler.gSIndicator == 0) {
            baseLine = baseLine + 6;
        }



        if((Homm3TabCellsGrabler.gSIndicator == 0) && (!(tabFraction.equals(Homm3CrInfoGrabber.crFraction)))){
            baseLine++;
            cellsUnite.cellsUnite(baseColumn, baseLine, (char) (baseColumn + 11), baseLine);
            LineDrawer.LineDrawer(baseColumn, baseLine, (char) (baseColumn + 11), baseLine);
            gTabCellDataPaste.gTabCellDataPaste(baseColumn, baseLine, Homm3CrInfoGrabber.crFraction);
            baseLine++;
            tabFraction = Homm3CrInfoGrabber.crFraction;
        }

        if (Main.isNeutral == true && Homm3TabCellsGrabler.gSIndicator > 1) {

            Homm3TabCellsGrabler.gSIndicator = 0;
            baseLine = baseLine + 6;
            baseColumn = 'A';
        }

        cellsUnite.cellsUnite(baseColumn, baseLine, baseColumn, (baseLine + 5)); // Объединяем ячейку под уровень
        cellsUnite.cellsUnite((char) (baseColumn + 1), baseLine, (char) (baseColumn + 3), baseLine); // Объединяем ячейку под название
        cellsUnite.cellsUnite((char) (baseColumn + 1), (baseLine + 1), (char) (baseColumn + 1), (baseLine + 4)); // Объединяем ячейку под фотку
        cellsUnite.cellsUnite((char) (baseColumn + 1), (baseLine + 5), (char) (baseColumn + 5), (baseLine + 5)); // Объединяем ячейку под особенности

        LineDrawer.LineDrawer(baseColumn, baseLine, (char) (baseColumn + 5), (baseLine + 5));


        gTabCellDataPaste.gTabCellDataPaste(baseColumn, baseLine, Homm3TabCellsGrabler.crLevel); // Вносим уровень
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+1), baseLine, Homm3CrInfoGrabber.crName); // Вносим название
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine, "Значение AI");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine, Homm3CrInfoGrabber.crAIValue); // Вносим значение AI
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+1, "Атака");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+1, Homm3CrInfoGrabber.crAttack); // Вносим атаку
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+1, "Защита");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+1, Homm3CrInfoGrabber.crDefence); // Вносим защиту
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+2, "Урон");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+2, Homm3CrInfoGrabber.crDamage); // Вносим урон
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+2, "Выстрелы");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+2, Homm3CrInfoGrabber.crShots); // Вносим количество выстрелов
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+3, "Здоровье");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+3, Homm3CrInfoGrabber.crHealth); // Вносим здоровье
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+3, "Скорость");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+3, Homm3CrInfoGrabber.crSpeed); // Вносим скорость
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+4, "Цена");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+4, Homm3CrInfoGrabber.crPrice); // Вносим цену
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+4, "Прирост");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+4, Homm3CrInfoGrabber.crGrowthPerWeek); // Вносим прирост
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+1), baseLine+5, Homm3CrInfoGrabber.crFeatures); // Вносим особенности

        Selenide.switchTo().window(1);
    }
}
