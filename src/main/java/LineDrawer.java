import com.codeborne.selenide.Selenide;

import java.awt.*;
import java.awt.event.KeyEvent;

public class   LineDrawer {
    public static void LineDrawer(char ch1, int num1, char ch2, int num2){
        Robot lineDrawerRobot; // ������ �������

        Selenide.$x("//input[@id]")
                .click();
        Selenide.$x("//input[@id]")
                .setValue("" + ch1 + num1 + ":" + ch2 + num2)
                .pressEnter();

        // �����
        Selenide.$x("//div[@aria-label='�������']")
                .click();
       // System.out.println("1");
        Selenide.$x("//div[@aria-label='����� ������']")
                .click();
      //  System.out.println("2");
        try {
            lineDrawerRobot = new Robot();
            lineDrawerRobot.keyPress(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyRelease(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyPress(KeyEvent.VK_ENTER);
            lineDrawerRobot.keyRelease(KeyEvent.VK_ENTER);
        }catch (AWTException e) {
            e.printStackTrace();
        }
     //   System.out.println("3");
        Selenide.$x("//div[@aria-label='�������']")
                .click();
      //  System.out.println("4");
        Selenide.$x("//div[@aria-label='��� �������']")
                .click();
       // System.out.println("5");

        // �������
        //Selenide.$x("//div[@aria-label='�������']")                .click();



       // Selenide.$x("//div[@aria-label='�������']")                .click();
      //  System.out.println("6");
        Selenide.$x("//div[@aria-label='������� �������']")
                .click();
      //  System.out.println("7");
        Selenide.$x("//div[@aria-label='����� ������']")
                .click();
      //  System.out.println("8");
        try {
            lineDrawerRobot = new Robot();
            lineDrawerRobot.keyPress(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyRelease(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyPress(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyRelease(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyPress(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyRelease(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyPress(KeyEvent.VK_ENTER);
            lineDrawerRobot.keyRelease(KeyEvent.VK_ENTER);
        }catch (AWTException e) {
            e.printStackTrace();
        }
       // System.out.println("9");
    }
}
