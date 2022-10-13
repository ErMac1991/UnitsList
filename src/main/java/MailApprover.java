import com.codeborne.selenide.Selenide;

public class MailApprover {
    public static void MailApprover() {
        String mailForApprove = "testovtesterdop@gmail.com";
        // String pass = "TestTest";

        Clicker.Clicker("//div[text()='Подтвердите резервный адрес электронной почты']");
        Selenide.$x("//div[text()='Введите резервный адрес электронной почты']").setValue(mailForApprove);
        Clicker.Clicker("//button/span[text()='Далее']");

    }
}
