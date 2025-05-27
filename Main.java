import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Answer {
    public static long factorial(int n) {
        if (n < 0) {
            return -1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void printEvenNums(int pL) {
        for (int i = 1; i <= pL; i++) {
            if (i % 2 == 0) {
                System.out.println((i));
            }
        }
    }

    public static int sumDigits(int pN) {
        int result = 0;
        int temp = pN;
        while (temp != 0) {
            result = result + temp % 10;
            temp = temp / 10;
        }
        return result;
    }

    public static int findMaxOfThree(int a, int b, int c) {
        int mx = a;
        if (b > mx) {
            mx = b;
        }
        if (c > mx) {
            mx = c;
        }
        return mx;
    }
}

class URLBuilder {
    public static String buildUrl(String baseUrl, String params) {
        if (params == null || params.isEmpty()) {
            return baseUrl;
        }

        String[] pairs = params.split("&");
        List<String> validParams = new ArrayList<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2 && !"null".equals(keyValue[1])) {
                validParams.add(pair);
            }
        }

        if (validParams.isEmpty()) {
            return baseUrl;
        }

        return baseUrl + "?" + String.join("&", validParams);
    }
}

class CsvBuilder {
    public static String buildCsv(String[] headers, String[][] data) {
        StringBuilder csv = new StringBuilder();

        // Заголовки
        csv.append(escapeCsv(headers)).append("\n");

        // Данные
        for (String[] row : data) {
            csv.append(escapeCsv(row)).append("\n");
        }

        return csv.toString();
    }

    private static String escapeCsv(String[] values) {
        return String.join(",",
                Arrays.stream(values)
                        .map(v -> v.contains(",") ? "\"" + v + "\"" : v)
                        .toArray(String[]::new));
    }
}


class EmptyLineRemover {
    public static String removeEmptyLines(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        // Разделяем текст на строки
        String[] lines = text.split("\n");

        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                result.append(line).append("\n");
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}


class ArrayMinMaxLogger {
    private static final String LOG_FILE = "log.txt";
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void findMinMaxAndLog(int[] array) throws IOException {
        if (array == null || array.length == 0) {
            System.out.println("Массив пуст или равен null");
            return;
        }

        int min = array[0];
        int max = array[0];

        // Поиск min и max
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Формируем запись для лога
        String timestamp = LocalDateTime.now().format(DATE_FORMAT);
        String logEntry = String.format("%s min=%d, max=%d\n", timestamp, min, max);

        // Записываем в лог-файл
        try {
            Files.write(Paths.get(LOG_FILE),
                    logEntry.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            System.out.println("Результаты записаны в лог-файл");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в лог-файл: " + e.getMessage());
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(("Старт!"));
        System.out.println(LocalDateTime.now());

        int n = -5;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        Answer ans = new Answer();
        long itresume_res = ans.factorial(n);
        if (itresume_res < 0) {
            System.out.println("Факториал отрицательного числа " + n + " не определен");
        }
        System.out.println((itresume_res));
        ans.printEvenNums(10);
        n = 123;
        System.out.println(ans.sumDigits(n));
        System.out.println(ans.findMaxOfThree(3, 5, 4));

        String baseUrl = "https://example.com/search";
        String params = "query=java&sort=desc&filter=null";

        String result = URLBuilder.buildUrl(baseUrl, params);
        System.out.println(result);  // https://example.com/search?query=java&sort=desc


        String[] headers = {"Name", "Age", "Address"};
        String[][] data = {
                {"John", "30", "123 Main St, Apt 4"},
                {"Alice", "25", "456 Oak Ave"}
        };

        CsvBuilder csvb = new CsvBuilder();
        System.out.println(csvb.buildCsv(headers, data));

        String text = "line1\n\nline2\n \nline3";
        System.out.println(EmptyLineRemover.removeEmptyLines(text));

        int[] numbers = {12, 5, 27, 8, 19, 3, 15};

        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        ArrayMinMaxLogger.findMinMaxAndLog(numbers);

    }
}
