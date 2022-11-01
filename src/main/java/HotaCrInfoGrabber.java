import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class  HotaCrInfoGrabber {
    static int iTabsHota;
    static int iLinesHota;
    static int iCellsHota;
    static int allTabsOnPageHota;
    static int countLinesInTabHota;
    static int countCellsInLineHota;


    public static void HotaCrInfoGrabber() { // ����������� � xpath ��������� �������

        String nLevel = null;
        String paramValue = null;


        Homm3CrInfoGrabber.crFeatures = "";
        Homm3CrInfoGrabber.crShots = "-";
        if (Main.isNeutral == false) {
            Homm3CrInfoGrabber.crFraction = "������";
        }
        else {
            Homm3CrInfoGrabber.crFraction = "��������";
        }

        String chosenXPath;

        Selenide.switchTo().window(1);

        System.out.println("���������� �������: " + Homm3CrInfoGrabber.crFraction);

        ElementsCollection tabs = $$x("//h3/span[contains(text(),'-� �������')]/../following::table[1]"); // ������ ������
        ElementsCollection lines; // ������ ����� � �������
        ElementsCollection cells; // ������ ����� � ������

        System.out.println("��������� �������, �� " + tabs.size());


        allTabsOnPageHota = tabs.size(); // � ���� ������ ����� ������ ����������� ������ HOTA


        for (iTabsHota = 1; iTabsHota <= allTabsOnPageHota; iTabsHota++) {

            if (Main.isNeutral == true){
                iTabsHota = allTabsOnPageHota + 1;
                lines = $$x("//h2/span[text()='����������� �����']/../following::table[1]/tbody/tr");
                countLinesInTabHota = lines.size();
                System.out.println("���������� ����� � ������� " + countLinesInTabHota);

            }

            else {

                chosenXPath = HotaTabFinder.HotaTabFinder(iTabsHota);
                lines = $$x("//h3/span[text()='" + iTabsHota + "-� �������']/../following::table[1]/tbody/tr");
                countLinesInTabHota = lines.size();
                System.out.println("���������� ����� � ������� " + countLinesInTabHota);

            }

            for (iLinesHota = 2; iLinesHota <= countLinesInTabHota; iLinesHota++) {

                chosenXPath = HotaTabFinder.HotaTabFinder(iTabsHota, iLinesHota);

                if (Main.isNeutral == true){

                    cells = $$x("//h2/span[text()='����������� �����']/../following::table[1]/tbody/tr[" + iLinesHota + "]/td");
                    countCellsInLineHota = cells.size();
                    System.out.println("���������� ����� � ������ " + countCellsInLineHota);

                    System.out.println("������ ������� �����");


                    nLevel = $x("//h2/span[text()='����������� �����']/../following::table[1]/tbody/tr[" + iLinesHota + "]/th/p/small").getText();
                    nLevel = nLevel.replace("-� �������", "");

                }

                else {

                    cells = $$x("//h3/span[text()='" + iTabsHota + "-� �������']/../following::table[1]/tbody/tr[" + iLinesHota + "]/td");
                    countCellsInLineHota = cells.size();
                    System.out.println("���������� ����� � ������ " + countCellsInLineHota);

                    System.out.println("������ ������� �����");

                    Homm3TabCellsGrabler.crLevel = String.valueOf(iTabsHota);
                    Homm3TabCellsGrabler.gSIndicator = iLinesHota - 2;

                    System.out.println("���������� �������: " + Homm3TabCellsGrabler.crLevel);
                    System.out.println("���������� ������� ���������: " + Homm3TabCellsGrabler.gSIndicator);


                    System.out.println("Getting cells collection. Its length is " + cells.size());
                    System.out.println("\nWorking with cells");

                }

                for (iCellsHota = 0; iCellsHota < countCellsInLineHota; iCellsHota++) { // ������ ������ �� ������� �������
                    System.out.println("Cell indicator is " + iCellsHota);
                    chosenXPath = HotaTabFinder.HotaTabFinder(iTabsHota, iLinesHota, iCellsHota);

                    if (Main.isNeutral == true){
                        paramValue = $x("//h2/span[text()='����������� �����']/../following::table[1]/tbody/tr[" + iLinesHota +"]/td[" + (iCellsHota + 1) + "]").getText();
                    }

                    else {
                        paramValue = $x("//h3/span[text()='" + iTabsHota + "-� �������']/../following::table[1]/tbody/tr[" + iLinesHota +"]/td[" + (iCellsHota + 1) + "]").getText();
                    }



                    switch (iCellsHota + 1) {

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
                            if (countCellsInLineHota == 10) {
                                Homm3CrInfoGrabber.crShots = paramValue;
                            }
                            if (countCellsInLineHota == 9) {
                                Homm3CrInfoGrabber.crFeatures = paramValue;
                                Homm3CrInfoGrabber.crShots = "-";
                            }

                        case 10:
                            if (countCellsInLineHota == 10) {
                                Homm3CrInfoGrabber.crFeatures = paramValue;
                            }

                        default:
                            // System.out.println("Wrong way!");
                    }

                }

                Homm3CrInfoGrabber.crFeatures = Homm3CrInfoGrabber.crFeatures.replace("\n", " ");

                if (Main.isNeutral == false) {
                    Homm3CrInfoGrabber.crName = nameGetterForHota.nameGetterForHota(iTabsHota, Homm3TabCellsGrabler.gSIndicator);
                    System.out.println(Homm3CrInfoGrabber.crName + ", �������: " + Homm3CrInfoGrabber.crFraction + ", ���������: " + Homm3CrInfoGrabber.crPrice + ", �������: " + Homm3CrInfoGrabber.crGrowthPerWeek
                            + ", �����: " + Homm3CrInfoGrabber.crAttack + ", ������: " + Homm3CrInfoGrabber.crDefence + ", ��������: " + Homm3CrInfoGrabber.crShots + ", ����: " + Homm3CrInfoGrabber.crDamage
                            + ", ��������: " + Homm3CrInfoGrabber.crHealth + ", ��������: " + Homm3CrInfoGrabber.crSpeed + ", �����������: " + Homm3CrInfoGrabber.crFeatures);

                    InfoTransport.InfoTransport();

                }

                if (Main.isNeutral == true && nLevel.equals(Homm3TabCellsGrabler.crLevel)) {
                    Homm3TabCellsGrabler.gSIndicator++;
                    Homm3CrInfoGrabber.crName = $x("//h2/span[text()='����������� �����']/../following::table[1]/tbody/tr[" + iLinesHota + "]/th/p").getText();
                    InfoTransport.InfoTransport();
                }

                else {
                    System.out.println("� ��������� Hota ��� ������� ������ " + Homm3TabCellsGrabler.crLevel);
                }
            }
        }
    }
}
