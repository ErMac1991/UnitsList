import com.codeborne.selenide.*;




public class CreateGoogleTab {
    public static String email = "testovtester2022@gmail.com";
    public static String password = "TestTest";

    // �������� ������� �������

    public static void CreateGoogleTab() {
        Selenide.sleep(2000);
            Selenide.$x("//input[@type='email']").setValue(email);
        Selenide.sleep(2000);
            Clicker.Clicker("//button/span[text()='�����']");
        Selenide.sleep(5000);
        Selenide.$x("//input[@type='password']").setValue(password);
        Selenide.sleep(2000);
        Clicker.Clicker("//button/span[text()='�����']");
        Selenide.sleep(5000);
            Clicker.Clicker("//div[@aria-label='������� ����']");
            Clicker.Clicker("//div[text()='�������']");
            Clicker.Clicker("//div[text()='������ ����']/../../../div[@class='docs-homescreen-templates-templateview-preview " +
                    "docs-homescreen-templates-templateview-preview-showcase']");
          //  Selenide.$x("//input[@class='docs-title-input']").setValue("������� ������ HOMM3 + HOTA");
    }

}
