import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Homm3TabCellsGrabler {
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
           System.out.println(countLinesInTab);

            for (iLines = 2; iLines <= countLinesInTab; iLines++) {
                cells = $$x("//table[" + iTabs + "]//tr[" + iLines + "]//td");
                countCellsInLine = cells.size();
              System.out.println("Getting cells collection. Its length is " + cells.size());
               System.out.println("\nWorking with cells");

                for (iCells = 0; iCells < countCellsInLine; iCells++) { // ������ ������ �� ������� �������
                 System.out.println("Cell indicator is " + iCells);
                    switch (iCells+1) {

                        case 1: // ����������� ������� ��������
                            crLevel = cells.get(iCells).getText();

                         System.out.println("Level of creature is received,its " + crLevel);
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
                        System.out.println(urlOfCard);
                            Homm3CrInfoGrabber.Homm3CrInfoGrabber(urlOfCard);
                            break;

                        case 3: // ����������� ������ ��������
                          System.out.println("We'll work with icons later");
                            break;

                        case 4: // ������������� � �������� �� �������� � ����������� �����
                            urlOfCard = cells.get(iCells).find("a").getAttribute("href");
                            //gS = true;

                            if (!crLevel.equals(prevLevel)){
                                gSIndicator = 0;
                                prevLevel = crLevel;
                            }
                            else {
                                gSIndicator++;
                            }

                          System.out.println("Name of GS  is received its " + Homm3CrInfoGrabber.crName);
                            Homm3CrInfoGrabber.Homm3CrInfoGrabber(urlOfCard);
                            break;

                        case 5: // ����������� ������ �� ��������
                         System.out.println("We'll work with these icons later too");
                            break;

                        default:
                            System.out.println("Wrong way");

                    }
                }

                if (Main.isNeutral == true) { // ����������� ��������� � Hota

                    FollowHotaCr.FollowHotaCr();
                    HotaCrInfoGrabber.HotaCrInfoGrabber();
                    open(Main.urlCrTabs);
                    System.out.println("��������� �� �������� � ��������� ������� Homm3");

                }

            }
        }
    }
}

