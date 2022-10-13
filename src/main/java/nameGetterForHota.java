import static com.codeborne.selenide.Selenide.*;

public class nameGetterForHota {
    public static String nameGetterForHota(int iTabs, int gSI){

        String input;   // Входная строка с названиями существ
        String namesList[];     // массив названий
        String delimeter = " /";   // разделитель



        input = $x("//div[@class='mw-parser-output']/table[" + iTabs + "]//tr[1]//b").getText();
        input = input.replace("\n", "");

        System.out.println("Обработанный инпут: ");

        namesList = input.split(delimeter);

        System.out.println("Выходящее название: " + namesList[gSI]);
        return namesList[gSI];
    }
}

