import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class Homm3TabCellsGrabler { // ������� ����� ������� Homm3

    public static String crLevel = null; // ���� ��������
    public static String prevLevel = null; // �������� ����� ����������� ��������
    public static boolean gS = false;
    public static int gSIndicator = 0;
    public static int iTabs; // ������� ��� ����� ������
    public static int allTabsOnPage;
    public static int iLines; // ������� ��� ����� ����� � �������
    public static int countLinesInTab; // ���������� ����� � �������
    public static int iCells; // ������� ��� ����� ����� � ������
    public static int countCellsInLine; // ���������� �������� � �������

    public static void Homm3TabCellsGrabler() {

        String urlOfCard = null;        // ������ �� �������� ��������

        ElementsCollection tabs = $$x("//table"); // ������ ������
        ElementsCollection lines; // ������ ����� � �������
        ElementsCollection cells;

        System.out.println("����������� ������� �� Homm3");

        Selenide.switchTo().window(1);

        allTabsOnPage = tabs.size()-1; // � ���� ������ ����� ������ ����������� ������ HOMM3

        for (iTabs = 1; iTabs <= allTabsOnPage; iTabs++) {

            if (Main.isNeutral == true) {
                iTabs = allTabsOnPage +1;
            }

            lines = $$x("//table[" + iTabs + "]//tr");
            countLinesInTab = lines.size();


            for (iLines = 2; iLines <= countLinesInTab; iLines++) {
                cells = $$x("//table[" + iTabs + "]//tr[" + iLines + "]//td");
                countCellsInLine = cells.size();


                for (iCells = 0; iCells < countCellsInLine; iCells++) { // ������ ������ �� ������� �������

                    switch (iCells+1) {

                        case 1: // ����������� ������� ��������
                            crLevel = cells.get(iCells).getText();

                            break;

                        case 2: // �������������� � �������� �������� � ����������� �����

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


                        case 4: // ������������� � �������� �� �������� � ����������� �����
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

                if (Main.isNeutral == true) { // ����������� ��������� � Hota

                    FollowHotaCr.FollowHotaCr();
                    HotaCrInfoGrabber.HotaCrInfoGrabber();
                    open(Main.urlCrTabs);


                }

            }
        }
    }
}

