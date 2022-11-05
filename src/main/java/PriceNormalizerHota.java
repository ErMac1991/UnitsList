import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PriceNormalizerHota {
    public static String PriceNormalizerHota (String xPathOfPrice) { // Получаем стоимость существа Hota (в т.ч. составную)
        String price = "";
        String res = "";
        String countRes = "";
        String countGold = "";

        if ($x(xPathOfPrice + "/p/br").exists()) {
            price = $x(xPathOfPrice + "/p").getText();
            countGold = price.split("\n")[0];
            countRes = price.split("\n")[1].replace(" ", "");

            price = countGold + " " + countRes;

            res = $x(xPathOfPrice + "/p/a/img").getAttribute("alt");
            res = res.split(" ")[0];
            System.out.println("Ресурс: " + res);

            price += "(" + res + ")";
            price = price.replace("\n", "");

            System.out.println("Стоимость: " + price);
        }
        else {
            price = $x(xPathOfPrice).getText();
        }

        return price;

    }
}
