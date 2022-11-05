import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class  HotaCrInfoGrabber { // Перебор ячеек таблицы Hota
    static int iTabsHota;
    static int iLinesHota;
    static int iCellsHota;
    static int allTabsOnPageHota;
    static int countLinesInTabHota;
    static int countCellsInLineHota;


    public static void HotaCrInfoGrabber() { // разобраться в xpath элементов таблицы

        String nLevel = null;
        String paramValue = null;


        Homm3CrInfoGrabber.crFeatures = "";
        Homm3CrInfoGrabber.crShots = "-";
        if (Main.isNeutral == false) {
            Homm3CrInfoGrabber.crFraction = "Причал";
        }
        else {
            Homm3CrInfoGrabber.crFraction = "Нейтралы";
        }

        String chosenXPath;

        Selenide.switchTo().window(1);

        System.out.println("Определили фракцию: " + Homm3CrInfoGrabber.crFraction);

        ElementsCollection tabs = $$x("//h3/span[contains(text(),'-й уровень')]/../following::table[1]"); // Список таблиц
        ElementsCollection lines; // Список строк в таблице
        ElementsCollection cells; // Список ячеек в строке

        System.out.println("Подтянули таблицы, их " + tabs.size());


        allTabsOnPageHota = tabs.size(); // В этом классе берем только фракционных юнитов HOTA


        for (iTabsHota = 1; iTabsHota <= allTabsOnPageHota; iTabsHota++) {

            if (Main.isNeutral == true){
                iTabsHota = allTabsOnPageHota + 1;
                lines = $$x("//h2/span[text()='Нейтральные юниты']/../following::table[1]/tbody/tr");
                countLinesInTabHota = lines.size();
                System.out.println("Количество строк в таблице " + countLinesInTabHota);

            }

            else {

                chosenXPath = HotaTabFinder.HotaTabFinder(iTabsHota);
                lines = $$x("//h3/span[text()='" + iTabsHota + "-й уровень']/../following::table[1]/tbody/tr");
                countLinesInTabHota = lines.size();
                System.out.println("Количество строк в таблице " + countLinesInTabHota);

            }

            for (iLinesHota = 2; iLinesHota <= countLinesInTabHota; iLinesHota++) {

                chosenXPath = HotaTabFinder.HotaTabFinder(iTabsHota, iLinesHota);

                if (Main.isNeutral == true){

                    cells = $$x("//h2/span[text()='Нейтральные юниты']/../following::table[1]/tbody/tr[" + iLinesHota + "]/td");
                    countCellsInLineHota = cells.size();
                    System.out.println("Количество ячеек в строке " + countCellsInLineHota);

                    System.out.println("Начали цеплять статы");


                    nLevel = $x("//h2/span[text()='Нейтральные юниты']/../following::table[1]/tbody/tr[" + iLinesHota + "]/th/p/small").getText();
                    nLevel = nLevel.replace("-й уровень", "");

                }

                else {

                    cells = $$x("//h3/span[text()='" + iTabsHota + "-й уровень']/../following::table[1]/tbody/tr[" + iLinesHota + "]/td");
                    countCellsInLineHota = cells.size();
                    System.out.println("Количество ячеек в строке " + countCellsInLineHota);

                    System.out.println("Начали цеплять статы");

                    Homm3TabCellsGrabler.crLevel = String.valueOf(iTabsHota);
                    Homm3TabCellsGrabler.gSIndicator = iLinesHota - 2;

                    System.out.println("Определили уровень: " + Homm3TabCellsGrabler.crLevel);
                    System.out.println("Определили степень улучшения: " + Homm3TabCellsGrabler.gSIndicator);


                    System.out.println("Getting cells collection. Its length is " + cells.size());
                    System.out.println("\nWorking with cells");

                }

                for (iCellsHota = 0; iCellsHota < countCellsInLineHota; iCellsHota++) { // Захват данных из таблицы существ
                    System.out.println("Cell indicator is " + iCellsHota);
                    chosenXPath = HotaTabFinder.HotaTabFinder(iTabsHota, iLinesHota, iCellsHota);

                    if (Main.isNeutral == true){
                        paramValue = "//h2/span[text()='Нейтральные юниты']/../following::table[1]/tbody/tr[" + iLinesHota +"]/td[" + (iCellsHota + 1) + "]";
                    }

                    else {
                        paramValue = "//h3/span[text()='" + iTabsHota + "-й уровень']/../following::table[1]/tbody/tr[" + iLinesHota +"]/td[" + (iCellsHota + 1) + "]";
                    }



                    switch (iCellsHota + 1) {

                        case 1:
                            Homm3CrInfoGrabber.crAttack = $x(paramValue).getText();

                        case 2:
                            Homm3CrInfoGrabber.crDefence = $x(paramValue).getText();

                        case 3:
                            Homm3CrInfoGrabber.crHealth = $x(paramValue).getText();

                        case 4:
                            Homm3CrInfoGrabber.crDamage = $x(paramValue).getText();

                        case 5:
                            Homm3CrInfoGrabber.crSpeed = $x(paramValue).getText();

                        case 6:
                            Homm3CrInfoGrabber.crGrowthPerWeek = $x(paramValue).getText();

                        case 7:
                            Homm3CrInfoGrabber.crPrice = PriceNormalizerHota.PriceNormalizerHota(paramValue);

                        case 8:
                            Homm3CrInfoGrabber.crAIValue = $x(paramValue).getText();

                        case 9:
                            if (countCellsInLineHota == 10) {
                                Homm3CrInfoGrabber.crShots = $x(paramValue).getText();
                            }
                            if (countCellsInLineHota == 9) {
                                Homm3CrInfoGrabber.crFeatures = $x(paramValue).getText();

                                if ($x(paramValue + "/p//sup").exists()) {
                                    Homm3CrInfoGrabber.crFeatures = FeaturesInfoWider.FeaturesInfoWider((paramValue + "/p//sup"), Homm3CrInfoGrabber.crFeatures);
                                }

                                Homm3CrInfoGrabber.crShots = "-";
                            }

                        case 10:
                            if (countCellsInLineHota == 10) {
                                Homm3CrInfoGrabber.crFeatures = $x(paramValue).getText();

                                if ($x(paramValue + "/p//sup").exists()) {
                                    Homm3CrInfoGrabber.crFeatures = FeaturesInfoWider.FeaturesInfoWider((paramValue + "/p//sup"), Homm3CrInfoGrabber.crFeatures);
                                }
                            }

                        default:
                            // System.out.println("Wrong way!");
                    }

                }

                Homm3CrInfoGrabber.crFeatures = Homm3CrInfoGrabber.crFeatures.replace("\n", " ");

                if (Main.isNeutral == false) {
                    Homm3CrInfoGrabber.crName = nameGetterForHota.nameGetterForHota(iTabsHota, Homm3TabCellsGrabler.gSIndicator);
                   // System.out.println(Homm3CrInfoGrabber.crName + ", фракция: " + Homm3CrInfoGrabber.crFraction + ", стоимость: " + Homm3CrInfoGrabber.crPrice + ", прирост: " + Homm3CrInfoGrabber.crGrowthPerWeek
                   //         + ", атака: " + Homm3CrInfoGrabber.crAttack + ", защита: " + Homm3CrInfoGrabber.crDefence + ", выстрелы: " + Homm3CrInfoGrabber.crShots + ", урон: " + Homm3CrInfoGrabber.crDamage
                   //         + ", здоровье: " + Homm3CrInfoGrabber.crHealth + ", скорость: " + Homm3CrInfoGrabber.crSpeed + ", особенности: " + Homm3CrInfoGrabber.crFeatures);

                    InfoTransport.InfoTransport();
                    PicGrabblerHota.PicGrabblerHota("//h3/span[text()='" + iTabsHota + "-й уровень']/../following::table[1]/tbody/tr[" + iLinesHota + "]");

                }

                if (Main.isNeutral == true && nLevel.equals(Homm3TabCellsGrabler.crLevel)) {
                    Homm3TabCellsGrabler.gSIndicator++;
                    Homm3CrInfoGrabber.crName = $x("//h2/span[text()='Нейтральные юниты']/../following::table[1]/tbody/tr[" + iLinesHota + "]/th/p").getText();
                    InfoTransport.InfoTransport();
                    PicGrabblerHota.PicGrabblerHota("//h2/span[text()='Нейтральные юниты']/../following::table[1]/tbody/tr[" + iLinesHota + "]");
                }

                else {
                    System.out.println("В нейтралах Hota нет существ уровня " + Homm3TabCellsGrabler.crLevel);
                }
            }
        }
    }
}
