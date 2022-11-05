public class TextCleaner {
    public static String TextCleaner(String text) { // ѕереводим многострочный текст в однострочный

        text.replace("\n", " ");

        return text;

    }
}
