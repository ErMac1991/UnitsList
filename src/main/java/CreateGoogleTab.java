import com.codeborne.selenide.*;

public class CreateGoogleTab {
    public static String email = "testovtester2022@gmail.com";
    public static String password = "TestTest";

    // �������� ������� �������

    public static void CreateGoogleTab() {

            Selenide.$x("//input[@type='email']").setValue(email);
            Clicker.Clicker("//button/span[text()='�����']");
        Selenide.$x("//input[@type='password']").setValue(password);
        Clicker.Clicker("//button/span[text()='�����']");



        Selenide.sleep(5000);

        if (Selenide.$x("//h1/span[text()='����������� ���� ��������']").exists()) {
            MailApprover.MailApprover();
        }

            Clicker.Clicker("//div[@aria-label='������� ����']");
            Clicker.Clicker("//div[text()='�������']");
            Clicker.Clicker("//div[text()='������ ����']/../../../div[@class='docs-homescreen-templates-templateview-preview " +
                    "docs-homescreen-templates-templateview-preview-showcase']");

    }

}
