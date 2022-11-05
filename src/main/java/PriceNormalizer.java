import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PriceNormalizer {
    public static String PriceNormalizer(String xPathOfPrice) {
        String price = "";
        String countRes = "";
        String countGold = "";


        if ($x(xPathOfPrice + "/br").exists()) {
            price = $x(xPathOfPrice).getText();
            countGold = price.split("\n")[1].replace(" ", "");
            countRes = price.split("\n")[0].replace(" ", "");
            countRes = countRes.replace("[1]", "");

            price = countGold;
            price += "(" + $x(xPathOfPrice + "/a[2]").getAttribute("title") + ") + ";
            price += countRes;
            price += "(" + $x(xPathOfPrice + "/a[1]").getAttribute("title") + ")";

            //price = price.replace("\n", "");
            price = price.replace("(Золото)", "");

            System.out.println("Стоимость: " + price);
        }
        else {
            price = $x(xPathOfPrice).getText();
        }

        return price;

        }

}
