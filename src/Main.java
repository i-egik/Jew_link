

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.function.Function;

public class Main {
    private static String shortURL;

    public static void main(String[] args) throws URISyntaxException, IOException {
        {

            //генерация пользователя
            UUID uuid = UUID.randomUUID(); //генерация случайного UUID
            System.out.println("Ваш UUID на текущую сессию " + uuid);


            //обрезание ссылки (можно будет заменить на генерацию из случайных символов)

            Scanner command = new Scanner(System.in);
            while (!"exit".equals(command)) {
                System.out.println("Введите длинную сылку для генерации сокращённой");
                String originalURL = command.nextLine();
                System.out.println("Ваша длинная ссылка: " + originalURL);


                String ShortUUID = UUID.randomUUID().toString().substring(0, 6);
                System.out.println("short UUID " + ShortUUID.toString());
                final String shortURL = originalURL.substring(0, 6) + ShortUUID;
                System.out.println("Ваша короткая ссылка: " + shortURL);

                //задаю время жизни ссылки
                LocalDateTime timer;
                timer = LocalDateTime.now().plusMinutes(3);
                TimerTask task = new TimerTask() {
                    public void run() {
                        ShortURL.UrlInformation.shortURL = null;
                    }
                };
                //тест ссылки

                System.out.println("Теперь можете ввести или скопировать короткую ссылку в консоль чтобы перейти по адресу");
                Scanner newLink = new Scanner(System.in);
                if (newLink.nextLine().equals(shortURL)) {
                    String replace = shortURL.replace(originalURL, shortURL);
                    Desktop.getDesktop().browse(new URI(originalURL));
                    //количество переходов

                } else {
                    System.out.println("Ссылка неверная или более недействительна. Перезапустите программу");
                }

            }
        }
    }
}