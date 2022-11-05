import com.codeborne.selenide.Selenide;

public class InfoTransport { // ������� ���������� ���� � �������

    static int baseLine = -6; // ������, �� ������� ������� ������ ������
    static String tabFraction = "null"; // ���������� ��� �������� �������
    static String tabLevel = "0";
    static char baseColumn; // �������, �� �������� ������� ������ ������

    public static void InfoTransport(){

        baseColumn = 'A';


        Selenide.switchTo().window(0);

        if (Homm3TabCellsGrabler.gSIndicator > 0){
            baseColumn = (char) (baseColumn + (6 * Homm3TabCellsGrabler.gSIndicator));
            if (Main.isNeutral == false) {
                Homm3TabCellsGrabler.crLevel = "��";
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

        cellsUnite.cellsUnite(baseColumn, baseLine, baseColumn, (baseLine + 5)); // ���������� ������ ��� �������
        cellsUnite.cellsUnite((char) (baseColumn + 1), baseLine, (char) (baseColumn + 3), baseLine); // ���������� ������ ��� ��������
        cellsUnite.cellsUnite((char) (baseColumn + 1), (baseLine + 1), (char) (baseColumn + 1), (baseLine + 4)); // ���������� ������ ��� �����
        cellsUnite.cellsUnite((char) (baseColumn + 1), (baseLine + 5), (char) (baseColumn + 5), (baseLine + 5)); // ���������� ������ ��� �����������

        LineDrawer.LineDrawer(baseColumn, baseLine, (char) (baseColumn + 5), (baseLine + 5));


        gTabCellDataPaste.gTabCellDataPaste(baseColumn, baseLine, Homm3TabCellsGrabler.crLevel); // ������ �������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+1), baseLine, Homm3CrInfoGrabber.crName); // ������ ��������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine, "�������� AI");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine, Homm3CrInfoGrabber.crAIValue); // ������ �������� AI
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+1, "�����");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+1, Homm3CrInfoGrabber.crAttack); // ������ �����
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+1, "������");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+1, Homm3CrInfoGrabber.crDefence); // ������ ������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+2, "����");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+2, Homm3CrInfoGrabber.crDamage); // ������ ����
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+2, "��������");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+2, Homm3CrInfoGrabber.crShots); // ������ ���������� ���������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+3, "��������");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+3, Homm3CrInfoGrabber.crHealth); // ������ ��������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+3, "��������");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+3, Homm3CrInfoGrabber.crSpeed); // ������ ��������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+2), baseLine+4, "����");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+3), baseLine+4, Homm3CrInfoGrabber.crPrice); // ������ ����
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+4), baseLine+4, "�������");
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+5), baseLine+4, Homm3CrInfoGrabber.crGrowthPerWeek); // ������ �������
        gTabCellDataPaste.gTabCellDataPaste((char)(baseColumn+1), baseLine+5, Homm3CrInfoGrabber.crFeatures); // ������ �����������

        Selenide.switchTo().window(1);
    }
}
