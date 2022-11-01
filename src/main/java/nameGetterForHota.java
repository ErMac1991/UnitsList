import static com.codeborne.selenide.Selenide.*;

public class nameGetterForHota {
    public static String nameGetterForHota(int iTabs, int gSI){

        String input;   // Входная строка с названиями существ
        String namesList[];     // массив названий
        String delimeter = " /";   // разделитель



        input = $x("//h3/span[text()='" + iTabs + "-й уровень']/../following::table[1]/tbody/tr[1]/th[1]/p//b[1]").getText();
        input = input.replace("\n", "");

        System.out.println("Обработанный инпут: ");

        namesList = input.split(delimeter);

        System.out.println("Выходящее название: " + namesList[gSI]);
        return namesList[gSI];
    }
}

