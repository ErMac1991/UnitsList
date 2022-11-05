import com.codeborne.selenide.Selenide;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$x;

public class PicCopypaster {
    public static void PicCopypaster(){
        Robot picRemover;

        Selenide.sleep(500);
        try { // Копируем картинку
            picRemover = new Robot();
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_DOWN);
            picRemover.keyRelease(KeyEvent.VK_DOWN);
            picRemover.keyPress(KeyEvent.VK_ENTER);
            picRemover.keyRelease(KeyEvent.VK_ENTER);
        }catch (AWTException e) {
            e.printStackTrace();
        }

        Selenide.switchTo().window(0); // Переключились на таблицу
        Selenide.sleep(500);

        Selenide.$x("//input[@id]")
                .click();
        Selenide.$x("//input[@id]")
                .setValue("" + (char)(InfoTransport.baseColumn + 1) + (InfoTransport.baseLine + 1))
                .pressEnter();
        Selenide.sleep(500);
        try { // Вставляем картинку
            picRemover = new Robot();
            picRemover.keyPress(KeyEvent.VK_CONTROL);
            picRemover.keyPress(KeyEvent.VK_V);
            picRemover.keyRelease(KeyEvent.VK_V);
            picRemover.keyRelease(KeyEvent.VK_CONTROL);

        }catch (AWTException e) {
            e.printStackTrace();
        }

        Selenide.sleep(500);
        $x("//div[@class='waffle-borderless-embedded-object-overlay waffle-borderless-embedded-object-overlay-focused']/div[@class='waffle-obj-control waffle-obj-menu-control-material']/div[@aria-label='Настройки']").click();

        Selenide.sleep(500);
        try { // Вставляем картинку
            picRemover = new Robot();
            picRemover.keyPress(KeyEvent.VK_UP);
            picRemover.keyRelease(KeyEvent.VK_UP);
            picRemover.keyPress(KeyEvent.VK_ENTER);
            picRemover.keyRelease(KeyEvent.VK_ENTER);

        }catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
