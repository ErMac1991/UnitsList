import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class HotaCrInfoGrabber {



    public static void HotaCrInfoGrabber() {

        Homm3CrInfoGrabber.crFeatures = "";
        Homm3CrInfoGrabber.crShots = "-";
        Homm3CrInfoGrabber.crFraction = "Причал";

        Selenide.switchTo().window(1);

        System.out.println("Определили фракцию: " + Homm3CrInfoGrabber.crFraction);

        ElementsCollection tabs = $$x("//div[@class='mw-parser-output']/table"); // Список таблиц
        ElementsCollection lines; // Список строк в таблице
        ElementsCollection cells; // Список ячеек в строке

        System.out.println("Подтянули таблицы");


        Homm3TabCellsGrabler.allTabsOnPage = tabs.size() - 1; // В этом классе берем только фракционных юнитов HOTA

        for (Homm3TabCellsGrabler.iTabs = 1; Homm3TabCellsGrabler.iTabs <= Homm3TabCellsGrabler.allTabsOnPage; Homm3TabCellsGrabler.iTabs++) {

            lines = $$x("//div[@class='mw-parser-output']/table[" + Homm3TabCellsGrabler.iTabs + "]//tr");
            Homm3TabCellsGrabler.countLinesInTab = lines.size();
            System.out.println(Homm3TabCellsGrabler.countLinesInTab);

            for (Homm3TabCellsGrabler.iLines = 2; Homm3TabCellsGrabler.iLines <= Homm3TabCellsGrabler.countLinesInTab; Homm3TabCellsGrabler.iLines++) {
                cells = $$x("//div[@class='mw-parser-output']/table[" + Homm3TabCellsGrabler.iTabs + "]//tr[" + Homm3TabCellsGrabler.iLines + "]//td");
                Homm3TabCellsGrabler.countCellsInLine = cells.size();


                System.out.println("Начали цеплять статы");

                Homm3TabCellsGrabler.crLevel = String.valueOf(Homm3TabCellsGrabler.iTabs);
                Homm3TabCellsGrabler.gSIndicator = Homm3TabCellsGrabler.iLines - 2;

                System.out.println("Определили уровень: " + Homm3TabCellsGrabler.crLevel);
                System.out.println("Определили степень улучшения: " + Homm3TabCellsGrabler.gSIndicator);


                System.out.println("Getting cells collection. Its length is " + cells.size());
                System.out.println("\nWorking with cells");

                for (Homm3TabCellsGrabler.iCells = 0; Homm3TabCellsGrabler.iCells < Homm3TabCellsGrabler.countCellsInLine; Homm3TabCellsGrabler.iCells++) { // Захват данных из таблицы существ
                    System.out.println("Cell indicator is " + Homm3TabCellsGrabler.iCells);

                    String paramValue = $x("//div[@class='mw-parser-output']/table[" + Homm3TabCellsGrabler.iTabs + "]//tr[" + Homm3TabCellsGrabler.iLines + "]//td[" + (Homm3TabCellsGrabler.iCells + 1) + "]").getText();

                    switch (Homm3TabCellsGrabler.iCells + 1) {

                        case 1:
                            Homm3CrInfoGrabber.crAttack = paramValue;

                        case 2:
                            Homm3CrInfoGrabber.crDefence = paramValue;

                        case 3:
                            Homm3CrInfoGrabber.crHealth = paramValue;

                        case 4:
                            Homm3CrInfoGrabber.crDamage = paramValue;

                        case 5:
                            Homm3CrInfoGrabber.crSpeed = paramValue;

                        case 6:
                            Homm3CrInfoGrabber.crGrowthPerWeek = paramValue;

                        case 7:
                            Homm3CrInfoGrabber.crPrice = paramValue;

                        case 8:
                            Homm3CrInfoGrabber.crAIValue = paramValue;

                        case 9:
                            if (Homm3TabCellsGrabler.countCellsInLine == 10) {
                                Homm3CrInfoGrabber.crShots = paramValue;
                            }
                            if (Homm3TabCellsGrabler.countCellsInLine == 9) {
                                Homm3CrInfoGrabber.crFeatures = paramValue;
                            }

                        case 10:
                            if (Homm3TabCellsGrabler.countCellsInLine == 10) {
                                Homm3CrInfoGrabber.crFeatures = paramValue;
                            }

                        default:
                            System.out.println("Wrong way!");
                    }

                }

                Homm3CrInfoGrabber.crName = nameGetterForHota.nameGetterForHota(Homm3TabCellsGrabler.iTabs, Homm3TabCellsGrabler.gSIndicator);
                Homm3CrInfoGrabber.crFeatures = Homm3CrInfoGrabber.crFeatures.replace("\n", " ");

                System.out.println(Homm3CrInfoGrabber.crName + ", фракция: " + Homm3CrInfoGrabber.crFraction + ", стоимость: " + Homm3CrInfoGrabber.crPrice + ", прирост: " + Homm3CrInfoGrabber.crGrowthPerWeek
                        + ", атака: " + Homm3CrInfoGrabber.crAttack + ", защита: " + Homm3CrInfoGrabber.crDefence + ", выстрелы: " + Homm3CrInfoGrabber.crShots + ", урон: " + Homm3CrInfoGrabber.crDamage
                        + ", здоровье: " + Homm3CrInfoGrabber.crHealth + ", скорость: " + Homm3CrInfoGrabber.crSpeed + ", особенности: " + Homm3CrInfoGrabber.crFeatures);

                InfoTransport.InfoTransport();

            }
        }
    }
}
