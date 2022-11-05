import com.codeborne.selenide.Selenide;
import java.awt.*;
import java.awt.event.KeyEvent;

public class   LineDrawer { // Чертим разметку в гуглтаб
    public static void LineDrawer(char ch1, int num1, char ch2, int num2){
        Robot lineDrawerRobot; // Рисуем границы

        Selenide.$x("//input[@id]")
                .click();
        Selenide.$x("//input[@id]")
                .setValue("" + ch1 + num1 + ":" + ch2 + num2)
                .pressEnter();

        // Сетка
        Selenide.$x("//div[@aria-label='Границы']")
                .click();

        Selenide.$x("//div[@aria-label='Стиль границ']")
                .click();

        try {
            lineDrawerRobot = new Robot();
            lineDrawerRobot.keyPress(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyRelease(KeyEvent.VK_DOWN);
            lineDrawerRobot.keyPress(KeyEvent.VK_ENTER);
            lineDrawerRobot.keyRelease(KeyEvent.VK_ENTER);
        }catch (AWTException e) {
            e.printStackTrace();
        }

        Selenide.$x("//div[@aria-label='Границы']")
                .click();

        Selenide.$x("//div[@aria-label='Все границы']")
                .click();


        // Обводка

        Selenide.$x("//div[@aria-label='Внешние границы']")
                .click();

        Selenide.$x("//div[@aria-label='Стиль границ']")
                .click();

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

    }
}
