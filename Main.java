import java.io.IOException;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//4


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

class RemoveNegatives {
    public static int[] removeNegativeNumbers(int[] input) {

        int count = 0;
        for (int num : input) {
            if (num >= 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : input) {
            if (num >= 0) {
                result[index++] = num;
            }
        }
        return result;
    }
}

class UniqEl{
    public static int[] getUniqueNumbers(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int[] temp = new int[input.length];
        int size = 0;

        for (int num : input) {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (temp[i] == num) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[size++] = num;
            }
        }
        return Arrays.copyOf(temp, size);
    }
}

class StringFilter {

    public static String[] filterStrings(String[] input) {
        if (input == null) {
            return new String[0];
        }

        List<String> resultList = new ArrayList<>();

        for (String str : input) {
            if (str != null && str.length() > 3) {
                resultList.add(str);
            }
        }

        return resultList.toArray(new String[0]);
    }
}

class ArrayAverage {
    public static int calculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым или null");
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        // Округляем среднее значение до ближайшего целого
        return (int) Math.round((double) sum / numbers.length);
    }
}

//4
class LLTasks {
    public static LinkedList<String> removeOddLengthStrings(LinkedList<String> list) {
        if (list == null) return new LinkedList<>();

        LinkedList<String> result = new LinkedList<>();
        for (String str : list) {
            if (str != null && str.length() % 2 == 0) {
                result.add(str);
            }
        }
        return result;
    }
}

class MyStack {
    private LinkedList<String> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    // Добавить
    public void push(String element) {
        stack.addFirst(element);  // или stack.push(element);
    }

    // Возвращает и удаляет
    public String pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return stack.removeFirst();  // или stack.pop();
    }

    // Возвращает без удаления
    public String peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return stack.getFirst();  // или stack.peek();
    }

    // Все элементы стека
    public LinkedList<String> getElements() {
        return new LinkedList<>(stack);  // возвращаем копию
    }
}

class ListUtils {
    public static int countOccurrences(LinkedList<String> list, String value) {
        int res = 0;
        int c=res;
        for ( String el : list ) {
            if (el.equals(value) ){
                c++;
            }
        }
        res=c;
    return res;
    }
}

class DequeTasks {
    public static void rotateDeque(Deque<Integer> deque, int n) {
        if (deque == null || deque.isEmpty() || n == 0) {
            return;
        }

        int size = deque.size();
        n = n % size;  // Убираем полные обороты

        // Если n отрицательное - преобразуем в эквивалентный положительный сдвиг
        if (n < 0) {
            n += size;
        }
        // Поворачиваем вправо на n позиций
        for (int i = 0; i < n; i++) {
            deque.addFirst(deque.removeLast());
        }
    }
}

//5

class StudentRegistry {
    private final Map<String, List<Integer>> studentGrades = new HashMap<>();

    // Добавляет или обновляет запись о студенте
    public void addStudentGrade(String name, Integer grade) {
        studentGrades.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);
    }

    // Находит оценки студента по имени
    public List<Integer> findStudentGrades(String name) {
        return studentGrades.getOrDefault(name, Collections.emptyList());
    }

    // Возвращает весь справочник
    public Map<String, List<Integer>> getAllStudents() {
        return new HashMap<>(studentGrades); // копия
    }

    // Удаляет студента из справочника
    public void removeStudent(String name) {
        studentGrades.remove(name);
    }
}

class BrowserHistory {
    private final Deque<String> history = new LinkedList<>();
    private static final int MAX_HISTORY_SIZE = 10;

    // Добавляет сайт в историю посещений
    public void visitSite(String site) {
        if (site == null || site.isBlank()) {
            throw new IllegalArgumentException("Сайт не может быть пустым");
        }
        if (history.size() >= MAX_HISTORY_SIZE) {
            history.removeLast(); // Удаляем самый старый
        }
        history.addFirst(site); // Добавляем в начало очереди
    }

    // Возвращает сайт, который был посещен steps назад
    public String back(int steps) {
        if (steps <= 0 || steps > history.size()) {
            return null;
        }

        // Используем stream для безопасного доступа к элементу
        Optional<String> result = history.stream()
                .skip(steps - 1L)
                .findFirst();

        return result.orElse(null);
    }

    // Возвращает всю историю посещений (последний посещенный сайт первым)
    public Deque<String> getHistory() {
        return new LinkedList<>(history); // Возвращаем копию для защиты данных
    }

    public void clearHistory() {
        history.clear();
    }

    public boolean containsSite(String site) {
        return history.contains(site);
    }

}

class ShoppingBasket {
    private final Map<String, Integer> basket = new HashMap<>();

    // Добавляет продукт в корзину или увеличивает количество
    public void addProduct(String product, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть > 0");
        }
        if (product == null || quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Некорректные параметры");
        }
        basket.put(product, basket.getOrDefault(product, 0) + quantity);
    }

    // Удаляет продукт из корзины
    public void removeProduct(String product) {
        basket.remove(product);
    }

    // Обновляет количество продукта
    public void updateQuantity(String product, Integer quantity) {
        if (basket.containsKey(product) && quantity != null && quantity > 0) {
            basket.put(product, quantity);
        }
    }

    // Проверяет наличие продукта и возвращает его количество
    public int checkProduct(String product) {
        return basket.getOrDefault(product, 0);
    }

    // Выводит все продукты в корзине
    public void showBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        System.out.println("Содержимое корзины:");
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            System.out.printf("- %s: %d шт.%n", entry.getKey(), entry.getValue());
        }
    }
}


class MergeSort {

    // Основной метод
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    // Рекурсивный метод сортировки
    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(array, helper, low, middle);      // Сортировка левой половины
            mergeSort(array, helper, middle + 1, high); // Сортировка правой половины
            merge(array, helper, low, middle, high);   // Слияние двух отсортированных половин
        }
    }

    // Метод для слияния двух отсортированных подмассивов
    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        //вспомогательный массив
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        // Итерация по вспомогательному массиву. Сравнение элементов из левой и правой половин,
        // и запись меньшего элемента в исходный массив
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        // Копируем оставшиеся элементы левой половины (если такие есть)
        while (helperLeft <= middle) {
            array[current] = helper[helperLeft];
            current++;
            helperLeft++;
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

        System.out.println("Исходный " + Arrays.toString(numbers));
        ArrayMinMaxLogger.findMinMaxAndLog(numbers);

        int[] input = {5, -3, 8, -1, 0, 2, -7, 4};
        int[] resultArr = RemoveNegatives.removeNegativeNumbers(input);

        System.out.println("Исходный: " + Arrays.toString(input));
        System.out.println("Результат: " + Arrays.toString(resultArr));

        int[] input3 = {1, 2, 3, 2, 4, 1, 5};
        int[] unique = UniqEl.getUniqueNumbers(input3);

        System.out.println("Исходный: " + Arrays.toString(input3));
        System.out.println("Уникальный: " + Arrays.toString(unique));

        String[] input4 = {"cat", "elephant", "dog", "giraffe"};
        String[] result4 = StringFilter.filterStrings(input4);

        System.out.println("Исходный: " + Arrays.toString(input4));
        System.out.println("Результат: " + Arrays.toString(result4));

        int[] numbers2 = {4, 2, 7, 5, 1};
        int average = ArrayAverage.calculateAverage(numbers2);
        System.out.println("Среднее: " + average);

        //4
        LinkedList<String> ll = new LinkedList<>();
        ll.add("apple");
        ll.add("banana");
        ll.add("pear");
        ll.add("grape");
        ll.add("apple");

        System.out.println("5 Исходный список: " + ll);
        LinkedList<String> result5 = LLTasks.removeOddLengthStrings(ll);
        System.out.println("5 Результат: " + result5);

        MyStack stack = new MyStack();

        stack.push("apple");
        stack.push("banana");
        stack.push("pear");
        stack.push("grape");

        System.out.println("Все элементы: " + stack.getElements());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Оставшиеся элементы: " + stack.getElements());

        String v = "apple";
        System.out.println("Количество " + String.valueOf(ListUtils.countOccurrences(ll,v)));

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);

        System.out.println("Исходная очередь: " + deque);

        DequeTasks.rotateDeque(deque, 2);
        System.out.println("Поворот вправо на 2: " + deque);

        DequeTasks.rotateDeque(deque, -1);
        System.out.println("Поворот влево на 1: " + deque);

        //5

        StudentRegistry registry = new StudentRegistry();

        // Добавляем студентов
        registry.addStudentGrade("Иван Иванов", 5);
        registry.addStudentGrade("Иван Иванов", 4); // + вторая оценка
        registry.addStudentGrade("Мария Петрова", 3);

        // Поиск студента
        System.out.println("Оценки Ивана: " + registry.findStudentGrades("Иван Иванов"));
        System.out.println("если нет имени : " + registry.findStudentGrades("нет имени"));

        // Получаем всех студентов
        System.out.println("Все студенты: " + registry.getAllStudents());

        // Удаляем студента
        registry.removeStudent("Мария Петрова");
        System.out.println("После удаления: " + registry.getAllStudents());


        BrowserHistory browser = new BrowserHistory();

        // Добавляем сайты в историю
        browser.visitSite("google.com");
        browser.visitSite("youtube.com");
        browser.visitSite("github.com");
        browser.visitSite("stackoverflow.com");

        // Тест
        System.out.println("Вся история: " + browser.getHistory());
        System.out.println("1 шаг назад: " + browser.back(1));
        System.out.println("3 шага назад: " + browser.back(3));
        System.out.println("5 шагов назад: " + browser.back(5));

        ShoppingBasket basket = new ShoppingBasket();
        // Добавляем продукты
        basket.addProduct("Яблоки", 5);
        basket.addProduct("Бананы", 3);
        basket.addProduct("Яблоки", 2); // Увеличим количество

        // Проверяем продукты
        System.out.println("Яблок в корзине: " + basket.checkProduct("Яблоки"));
        System.out.println("Апельсинов в корзине: " + basket.checkProduct("Апельсины"));

        // Обновляем количество
        basket.updateQuantity("Бананы", 10);
        basket.updateQuantity("Апельсины", 5); // Не добавится

        // Удаляем
        basket.removeProduct("Яблоки");

        // Показываем корзину
        basket.showBasket();

        int[] initArray;
        initArray = new int[]{38, 27, 43, 3, 9, 82, 10};

        System.out.println("Начальный массив:");
        System.out.println(Arrays.toString(initArray));
        MergeSort.mergeSort(initArray);
        System.out.println("Сортированный:");
        System.out.println(Arrays.toString(initArray));

    }
}
