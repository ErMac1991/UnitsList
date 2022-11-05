import static com.codeborne.selenide.Selenide.*;

public class FeaturesInfoWider {
    public static String FeaturesInfoWider(String xPath, String baseFeature) {

        // Подтягиваем расширенные особенности для существ Hota

        String feature = "";
        String iD = "";
        String number;

        iD = $x(xPath).getAttribute("id").replace("ref", "note");
        number = $x(xPath).getText();
        System.out.println("LinkNumber: " + number);
        feature = baseFeature.replace(number, "") + " (" + $x("//li[@id='" + iD + "']/span[@class='reference-text']").getText() + ")";
        System.out.println("Feature (full): " + feature);

        return feature;
    }
}
