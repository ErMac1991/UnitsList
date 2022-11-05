
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class Homm3CrInfoGrabber {
    static String crName;        // �������� ��������
    static String crAIValue;        // �������� �� ��
    static String crFraction;    // �������
    static String crPrice;          // ����
    static String crGrowthPerWeek;  // ������� �� ������
    static String crAttack;         // �����
    static String crDefence;        // ������
    static String crShots;       // ���������� ���������
    static String crDamage;      // ����
    static String crHealth;         // ��������
    static String crSpeed;          // ��������
    static String crFeatures;   // �����������

    public static void Homm3CrInfoGrabber(String urlOfCard){
        Selenide.switchTo().window(1);
        crFeatures = "���";
        open(urlOfCard);
        crName = $x("//h2[@class='pi-item pi-item-spacing pi-title pi-secondary-background']").getText();
        crFraction = $x("//h3[b[text()='�������']]/../div[@class='pi-data-value pi-font']").getText();
        crPrice = PriceNormalizer.PriceNormalizer("//h3[b[text()='���������']]/../div[@class='pi-data-value pi-font']");
        crGrowthPerWeek = $x("//h3[b[text()='������� �������']]/../div[@class='pi-data-value pi-font']").getText();
        crAIValue = $x("//h3[p[span[text()='�������� AI']]]/../div[@class='pi-data-value pi-font']").getText();
        crAttack = $x("//h3[b[text()='�����']]/../div[@class='pi-data-value pi-font']").getText();
        crDefence = $x("//h3[b[text()='������']]/../div[@class='pi-data-value pi-font']").getText();
        crShots = $x("//h3[b[text()='��������']]/../div[@class='pi-data-value pi-font']").getText();
        crDamage = $x("//h3[b[text()='����']]/../div[@class='pi-data-value pi-font']").getText();
        crHealth = $x("//h3[b[text()='��������']]/../div[@class='pi-data-value pi-font']").getText();
        crSpeed = $x("//h3[b[text()='��������']]/../div[@class='pi-data-value pi-font']").getText();
        if ((crFraction.equals("�����������")) || (crFraction.equals("����������� �����"))){
            crFraction ="��������";

        }
        if ($x("//span[@id='�����������']").exists()) {
            crFeatures = Homm3FeaturesGrabbler.Homm3FeaturesGrabbler();
            crFeatures = TextCleaner.TextCleaner(crFeatures);
        }

       // String stats[] = {crFraction, Homm3TabCellsGrabler.crLevel, crName, crAttack, crDefence, crShots, crDamage, crHealth,
       //         crSpeed, crPrice, crGrowthPerWeek, crAIValue, crFeatures};

        InfoTransport.InfoTransport();
        PicGrabblerHota.PicGrabblerHomm3("//a[@class='image image-thumbnail']/img");
        open(Main.urlCrTabs);


      /*   System.out.println(crName + ", �������: " + crFraction + ", ���������: " + crPrice + ", �������: " + crGrowthPerWeek
                + ", �����: " + crAttack + ", ������: " + crDefence + ", ��������: " + crShots + ", ����: " + crDamage
                + ", ��������: " + crHealth + ", ��������: " + crSpeed + ", �����������: " + crFeatures); */


    }
}
