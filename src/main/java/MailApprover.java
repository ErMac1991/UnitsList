import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class MailApprover {
    public static void MailApprover() {
        String mailForApprove = "testovtesterdop@gmail.com";
        String pass = "TestTest";
        String code;

        // ��������� ����� �������

        OpenNewWindow.OpenNewWindow();

        // ������������� �� ����� ������ � ��������� � �������������� �����

        Selenide.switchTo().window(1);
        open("https://www.google.com/intl/ru/gmail/about/");
        Clicker.Clicker("//a[text()='�����']");

        Selenide.sleep(2000);
        Selenide.$x("//input[@type='email']").setValue(mailForApprove);
        Selenide.sleep(2000);
        Clicker.Clicker("//button/span[text()='�����']");
        Selenide.sleep(5000);
        Selenide.$x("//input[@type='password']").setValue(pass);
        Selenide.sleep(2000);
        Clicker.Clicker("//button/span[text()='�����']");
        Selenide.sleep(5000);

        // ������� � ������

        Clicker.Clicker("//div[@class='Cp']/div/table/tbody/tr[1]");

        // ����������� ���

        code =  $x("//div[@style='text-align:center;font-size:36px;margin-top:20px;line-height:44px']").getText();


    }
}
