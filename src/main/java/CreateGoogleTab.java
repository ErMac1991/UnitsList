import com.codeborne.selenide.*;

public class CreateGoogleTab {
    public static String email = "testovtester2022@gmail.com";
    public static String password = "TestTest";

    // Открытие таблицы гуглдок

    public static void CreateGoogleTab() {

            Selenide.$x("//input[@type='email']").setValue(email);
            Clicker.Clicker("//button/span[text()='Далее']");
        Selenide.$x("//input[@type='password']").setValue(password);
        Clicker.Clicker("//button/span[text()='Далее']");



        Selenide.sleep(5000);

        if (Selenide.$x("//h1/span[text()='Подтвердите свою личность']").exists()) {
            MailApprover.MailApprover();
        }

            Clicker.Clicker("//div[@aria-label='Главное меню']");
            Clicker.Clicker("//div[text()='Таблицы']");
            Clicker.Clicker("//div[text()='Пустой файл']/../../../div[@class='docs-homescreen-templates-templateview-preview " +
                    "docs-homescreen-templates-templateview-preview-showcase']");

    }

}
