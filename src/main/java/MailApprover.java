import com.codeborne.selenide.Selenide;

public class MailApprover {
    public static void MailApprover() { // �� ������, ���� ������� ��� ����� �������� ����������� �����
        String mailForApprove = "testovtesterdop@gmail.com";

        Clicker.Clicker("//div[text()='����������� ��������� ����� ����������� �����']");

        Selenide.$x("//input[@aria-label='������� ��������� ����� ����������� �����']").setValue(mailForApprove);
        Clicker.Clicker("//button/span[text()='�����']");

    }
}
