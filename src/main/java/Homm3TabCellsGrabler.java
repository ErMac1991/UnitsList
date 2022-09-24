import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Homm3TabCellsGrabler {
    public static String crLevel = null; // ���� ��������
    public static boolean gS = false;

    public static void Homm3TabCellsGrabler() {


        String urlOfCard = null;        // ������ �� �������� ��������

        int iTabs; // ������� ��� ����� ������
        int allTabsOnPage;
        int iLines; // ������� ��� ����� ����� � �������
        int countLinesInTab; // ���������� ����� � �������
        int iCells; // ������� ��� ����� ����� � ������
        int countCellsInLine; // ���������� �������� � �������

        ElementsCollection tabs = $$("table"); // ������ ������
        ElementsCollection lines; // ������ ����� � �������
        ElementsCollection cells;

        Selenide.switchTo().window(1);

        allTabsOnPage = tabs.size()-1; // � ���� ������ ����� ������ ����������� ������ HOMM3

        for (iTabs = 1; iTabs <= allTabsOnPage; iTabs++) {

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

                            gS = false;
                            urlOfCard = cells.get(iCells).find("a").getAttribute("href");
                        System.out.println(urlOfCard);
                            Homm3CrInfoGrabber.Homm3CrInfoGrabber(urlOfCard);
                            break;

                        case 3: // ����������� ������ ��������
                          System.out.println("We'll work with icons later");
                            break;

                        case 4: // ������������� � �������� �� �������� � ����������� �����
                            urlOfCard = cells.get(iCells).find("a").getAttribute("href");
                            gS = true;
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

            }
        }
    }
}

