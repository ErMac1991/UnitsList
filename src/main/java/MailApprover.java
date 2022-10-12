import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class MailApprover {
    public static void MailApprover() {
        String mailForApprove = "testovtesterdop@gmail.com";
        String pass = "TestTest";
        String code;

        // открываем новую вкладку

        OpenNewWindow.OpenNewWindow();

        // переключаемся на новую вкадку и переходим в дополнительную почту

        Selenide.switchTo().window(1);
        open("https://www.google.com/intl/ru/gmail/about/");
        Clicker.Clicker("//a[text()='Войти']");

        Selenide.sleep(2000);
        Selenide.$x("//input[@type='email']").setValue(mailForApprove);
        Selenide.sleep(2000);
        Clicker.Clicker("//button/span[text()='Далее']");
        Selenide.sleep(5000);
        Selenide.$x("//input[@type='password']").setValue(pass);
        Selenide.sleep(2000);
        Clicker.Clicker("//button/span[text()='Далее']");
        Selenide.sleep(5000);

        // заходим в письмо

        Clicker.Clicker("//div[@class='Cp']/div/table/tbody/tr[1]");

        // Подтягиваем код

        code =  $x("//div[@style='text-align:center;font-size:36px;margin-top:20px;line-height:44px']").getText();


    }
}
