import static com.codeborne.selenide.Selenide.*;

public class nameGetterForHota {
    public static String nameGetterForHota(int iTabs, int gSI){

        String input;   // ������� ������ � ���������� �������
        String namesList[];     // ������ ��������
        String delimeter = " /";   // �����������



        input = $x("//div[@class='mw-parser-output']/table[" + iTabs + "]//tr[1]//b").getText();
        input = input.replace("\n", "");

        System.out.println("������������ �����: ");

        namesList = input.split(delimeter);

        System.out.println("��������� ��������: " + namesList[gSI]);
        return namesList[gSI];
    }
}

