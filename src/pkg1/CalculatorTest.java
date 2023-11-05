package pkg1;


import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    public static void main(String[] args) {

        // Проверка функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Неправильный аргумент - вызываем исключение
         try {
             pkg1.Calculator.calculation(8, 4, '_');  //'_'
            } catch (IllegalStateException e) {
              if (!e.getMessage().equals("Unexpected value operator: _")) {
                 throw new AssertionError("Ошибка в методе");
             }
           }

         //Assert:
         //Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');


        //Проверка базового функционала  AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        //Проверка ожидаемого исключения AssertJ:
        assertThatThrownBy(
            () -> Calculator.calculation(8, 4, '_') )
                .isInstanceOf(IllegalStateException.class);

        // граничные случаи 0,1,-1
        assertThatThrownBy(() ->
                 pkg1.Calculator.squareRootExtraction(-1)
         ).isInstanceOf(IllegalArgumentException.class);

        // деление на ноль AssertJ
        assertThatThrownBy(() ->
                pkg1.Calculator.calculation(5, 0, '/')
         ).isInstanceOf(ArithmeticException.class);

        //

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.calculation(2_147_483_647, 0, '+')); // integer overflow
        System.out.println(Calculator.calculation(2_147_483_647, 2, '*')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));

        // Сравнение сообщений об ошибках Ассерт, AssertJ
        System.out.println("1) ---");
        if (0 != pkg1.Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }
        System.out.println("2) ---");
        assert 0 == pkg1.Calculator.calculation(2, 6, '+');
        System.out.println("3) ---");
        assertThat(pkg1.Calculator.calculation(2, 6, '+')).isEqualTo(0);

    }


    // CalculateDiscount
    // Проверка функционала, с использованием утверждений AssertJ:
    public static void calculateDiscountTest(){

        assertThat(Calculator.calculateDiscount(0, 0)).isEqualTo(0);
        assertThat(Calculator.calculateDiscount(10, 10)).isEqualTo(9);
        assertThat(Calculator.calculateDiscount(15.456, 0)).isEqualTo(15.46);
        assertThat(Calculator.calculateDiscount(0, 10)).isEqualTo(0);

        assertThatThrownBy(
                () -> Calculator.calculateDiscount(10, -10) )
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(
                () -> Calculator.calculateDiscount(-10, 10) )
                .isInstanceOf(ArithmeticException.class);
    }
}
