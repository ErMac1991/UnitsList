import com.codeborne.selenide.Selenide;

import java.awt.*;
import java.awt.event.KeyEvent;


import static com.codeborne.selenide.Selenide.*;

public class PicGrabblerHota {
    public static void PicGrabblerHota(String xPathOfLine) { // ������� � ��������� ����������� �������

        String xPathOfPic = xPathOfLine + "/th/div/div[@class='floatnone']";
        $x(xPathOfPic).contextClick(); // ���� ������ �������

        PicCopypaster.PicCopypaster();

        Selenide.switchTo().window(1); // ������������� �� ��������
        Selenide.sleep(1000);
    }

    public static void PicGrabblerHomm3 (String xPathOfPic) {

        $x(xPathOfPic).contextClick(); // ���� ������ �������

        PicCopypaster.PicCopypaster();

        Selenide.switchTo().window(1); // ������������� �� ��������
        Selenide.sleep(1000);
    }
}
