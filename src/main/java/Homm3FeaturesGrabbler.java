import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class Homm3FeaturesGrabbler {
    public static String Homm3FeaturesGrabbler() {

        // ����������� ����������� ������� Homm3

        String feature = "";
        int iFeat;

        ElementsCollection features = $$x("//span[@id='�����������']/following::ul[1]/li");

        for (iFeat = 1; iFeat <= features.size(); iFeat++) {
            feature += $x("//span[@id='�����������']/following::ul[1]/li[" + iFeat + "]").getText() + " ";
        }

        return feature;
    }
}
