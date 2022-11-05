
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class Homm3CrInfoGrabber {
    static String crName;        // Название существа
    static String crAIValue;        // Ценность по ИИ
    static String crFraction;    // Фракция
    static String crPrice;          // Цена
    static String crGrowthPerWeek;  // Прирост за неделю
    static String crAttack;         // Атака
    static String crDefence;        // Защита
    static String crShots;       // Количество выстрелов
    static String crDamage;      // Урон
    static String crHealth;         // Здоровье
    static String crSpeed;          // Скорость
    static String crFeatures;   // Особенности

    public static void Homm3CrInfoGrabber(String urlOfCard){
        Selenide.switchTo().window(1);
        crFeatures = "Нет";
        open(urlOfCard);
        crName = $x("//h2[@class='pi-item pi-item-spacing pi-title pi-secondary-background']").getText();
        crFraction = $x("//h3[b[text()='Фракция']]/../div[@class='pi-data-value pi-font']").getText();
        crPrice = PriceNormalizer.PriceNormalizer("//h3[b[text()='Стоимость']]/../div[@class='pi-data-value pi-font']");
        crGrowthPerWeek = $x("//h3[b[text()='Базовый прирост']]/../div[@class='pi-data-value pi-font']").getText();
        crAIValue = $x("//h3[p[span[text()='Значение AI']]]/../div[@class='pi-data-value pi-font']").getText();
        crAttack = $x("//h3[b[text()='Атака']]/../div[@class='pi-data-value pi-font']").getText();
        crDefence = $x("//h3[b[text()='Защита']]/../div[@class='pi-data-value pi-font']").getText();
        crShots = $x("//h3[b[text()='Выстрелы']]/../div[@class='pi-data-value pi-font']").getText();
        crDamage = $x("//h3[b[text()='Урон']]/../div[@class='pi-data-value pi-font']").getText();
        crHealth = $x("//h3[b[text()='Здоровье']]/../div[@class='pi-data-value pi-font']").getText();
        crSpeed = $x("//h3[b[text()='Скорость']]/../div[@class='pi-data-value pi-font']").getText();
        if ((crFraction.equals("Нейтральный")) || (crFraction.equals("Нейтральные юниты"))){
            crFraction ="Нейтралы";

        }
        if ($x("//span[@id='Особенности']").exists()) {
            crFeatures = Homm3FeaturesGrabbler.Homm3FeaturesGrabbler();
            crFeatures = TextCleaner.TextCleaner(crFeatures);
        }

       // String stats[] = {crFraction, Homm3TabCellsGrabler.crLevel, crName, crAttack, crDefence, crShots, crDamage, crHealth,
       //         crSpeed, crPrice, crGrowthPerWeek, crAIValue, crFeatures};

        InfoTransport.InfoTransport();
        PicGrabblerHota.PicGrabblerHomm3("//a[@class='image image-thumbnail']/img");
        open(Main.urlCrTabs);


      /*   System.out.println(crName + ", фракция: " + crFraction + ", стоимость: " + crPrice + ", прирост: " + crGrowthPerWeek
                + ", атака: " + crAttack + ", защита: " + crDefence + ", выстрелы: " + crShots + ", урон: " + crDamage
                + ", здоровье: " + crHealth + ", скорость: " + crSpeed + ", особенности: " + crFeatures); */


    }
}
