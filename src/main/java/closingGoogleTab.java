import com.codeborne.selenide.Selenide;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$x;

public class closingGoogleTab { // ����������� �������, ������������ � ��������� �������
    public static void closingGoogleTab(){
        String tabName = "������� ������ HOMM3 + HOTA";

        Selenide.switchTo().window(0);
       // Clicker.Clicker("//input[@class='docs-title-input']");
         $x("//input[@class='docs-title-input']").setValue(tabName);
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

        Clicker.Clicker("//div[@aria-label='������������ �� �����������']");
        Selenide.sleep(1000);
        //Clicker.Clicker("//div[@aria-activedescendant='goog-palette-cell-401']");
        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_RIGHT);
            ctrlA.keyRelease(KeyEvent.VK_RIGHT);
            ctrlA.keyPress(KeyEvent.VK_ENTER);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Selenide.sleep(1000);
        Clicker.Clicker("//div[@aria-label='������������ �� ���������']");
        Selenide.sleep(1000);
        //Clicker.Clicker("//div[@aria-label='�� ������']");
        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_RIGHT);
            ctrlA.keyRelease(KeyEvent.VK_RIGHT);
            ctrlA.keyPress(KeyEvent.VK_ENTER);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Selenide.sleep(1000);
        Clicker.Clicker("//div[@aria-label='������� ������']");
        Selenide.sleep(1000);
        //Clicker.Clicker("//div[@aria-label='���������� �� ������']");
        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_RIGHT);
            ctrlA.keyRelease(KeyEvent.VK_RIGHT);
            ctrlA.keyPress(KeyEvent.VK_ENTER);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Selenide.sleep(1000);



        Clicker.Clicker("//div[@id='docs-file-menu']");

        Selenide.sleep(1000);
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
            ctrlA.keyPress(KeyEvent.VK_RIGHT);
            ctrlA.keyRelease(KeyEvent.VK_RIGHT);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_ENTER);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Selenide.sleep(1000);
        Clicker.Clicker("//span[text()='�������']");

        Clicker.Clicker("//div[@id='docs-branding-logo']");
        Clicker.Clicker("//div[@title='" + tabName + "']/../div[@aria-label='��� (�������������� ����)']");
        Selenide.sleep(1000);
        try {

            ctrlA = new Robot();
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_DOWN);
            ctrlA.keyRelease(KeyEvent.VK_DOWN);
            ctrlA.keyPress(KeyEvent.VK_ENTER);
            ctrlA.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        $x("//button[@name='moveToTrash']").exists();
        Clicker.Clicker("//button[@name='moveToTrash']");


    }
}
