import static com.codeborne.selenide.Selenide.*;

public class nameGetterForHota {
    public static String nameGetterForHota(int iTabs, int gSI){ // �������� ������ �������� �������� Hota

        String input;   // ������� ������ � ���������� �������
        String namesList[];     // ������ ��������
        String delimeter = " /";   // �����������

        input = $x("//h3/span[text()='" + iTabs + "-� �������']/../following::table[1]/tbody/tr[1]/th[1]/p//b[1]").getText();
        input = input.replace("\n", "");

        namesList = input.split(delimeter);

        return namesList[gSI];
    }
}

