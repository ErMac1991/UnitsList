import java.awt.*;
import java.awt.event.KeyEvent;

public class OpenNewWindow {
    public static void OpenNewWindow(){

        Robot newWindowOpener; // Открываем вторую вкладку браузера
        try {
            newWindowOpener = new Robot();
            newWindowOpener.keyPress(KeyEvent.VK_CONTROL);
            newWindowOpener.keyPress(KeyEvent.VK_T);
            newWindowOpener.keyRelease(KeyEvent.VK_CONTROL);
            newWindowOpener.keyRelease(KeyEvent.VK_T);
        }catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
