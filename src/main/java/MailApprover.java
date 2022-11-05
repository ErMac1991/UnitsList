import com.codeborne.selenide.Selenide;

public class MailApprover {
    public static void MailApprover() { // На случай, если гуглтаб при входе попросит подтвердить почту
        String mailForApprove = "testovtesterdop@gmail.com";

        Clicker.Clicker("//div[text()='Подтвердите резервный адрес электронной почты']");

        Selenide.$x("//input[@aria-label='Введите резервный адрес электронной почты']").setValue(mailForApprove);
        Clicker.Clicker("//button/span[text()='Далее']");

    }
}
