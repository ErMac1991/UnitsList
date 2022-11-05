import com.codeborne.selenide.Selenide;

import java.awt.*;
import java.awt.event.KeyEvent;

public class closingGoogleTab { // Выравниваем таблицу, экспортируем и закрываем Гуглтаб
    public static void closingGoogleTab(){
        String tabName = "Таблица юнитов HOMM3 + HOTA";

        Selenide.switchTo().window(0);
       // Clicker.Clicker("//input[@class='docs-title-input']");
         Selenide.$x("//input[@class='docs-title-input']").setValue(tabName);
         Clicker.Clicker("//div[@class='grid-table-container']");


        Robot ctrlA;

        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_CONTROL);
            ctrlA.keyPress(KeyEvent.VK_A);
            ctrlA.keyRelease(KeyEvent.VK_A);
            ctrlA.keyPress(KeyEvent.VK_A);
            ctrlA.keyRelease(KeyEvent.VK_A);
            ctrlA.keyRelease(KeyEvent.VK_CONTROL);

        }
        catch (Exception e) {
            e.printStackTrace();
       }

        Clicker.Clicker("//div[@aria-label='Выравнивание по горизонтали']");
        Clicker.Clicker("//div[@id='t-align-middle']");
        Selenide.sleep(1000);
        Clicker.Clicker("//div[@aria-label='Выравнивание по вертикали']");
        Clicker.Clicker("//div[@id='t-align-center']");
        Selenide.sleep(1000);
        Clicker.Clicker("//div[@aria-label='Перенос текста']");
        Clicker.Clicker("//div[@aria-label='Переносить по словам']");
        Selenide.sleep(1000);



        Clicker.Clicker("//div[@id='docs-file-menu']");

        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_RIGHT);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Clicker.Clicker("//div[@aria-label='Главная страница Google Таблиц']");
        Clicker.Clicker("//div[@title='" + tabName + "']/../div[@aria-label='Ещё (раскрывающееся меню)']");

        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Clicker.Clicker("//button[@name='moveToTrash']");


    }
}
