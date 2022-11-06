import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class Homm3FeaturesGrabbler {
    public static String Homm3FeaturesGrabbler() {

        // Подтягиваем особенности существ Homm3

        String feature = "";
        int iFeat;

        ElementsCollection features = $$x("//span[@id='Особенности']/following::ul[1]/li");

        for (iFeat = 1; iFeat <= features.size(); iFeat++) {
            feature += $x("//span[@id='Особенности']/following::ul[1]/li[" + iFeat + "]").getText() + " ";
        }

        return feature;
    }
}
