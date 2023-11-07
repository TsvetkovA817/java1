package test.pkg2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import pkg2.Motorcycle;
import pkg2.Vehicle;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Motorcycle Tester.
 *
 * @author Tsvetkov
 * @version 1.0
 * @since <pre>2023</pre>
 */
public class MotorcycleTest {

    Motorcycle moto = new Motorcycle("", "", 0);

    @Before
    public void before() throws Exception {
        moto = new Motorcycle("company1", "model1", 2023);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: testSpeedValue()
     * Тест значения скорости: Должно быть целое, положительное значение, равно указанному
     */
    @Test
    public void testSpeedValue() throws Exception {
        moto.testDrive();
        int zn = moto.getSpeed();
        int ex = 75;
        assertThat(zn, instanceOf(Integer.class));
        assertTrue("Нет скорости", zn > 0);
        assertEquals(ex, zn);
    }

    /**
     * Method: testInstanceOf()
     * Тест объекта: Должно быть не null, наследник указанного объекта
     */
    @Test
    public void testInstanceOf() throws Exception {
        assertNotNull("Нет значения", moto);
        assertThat(moto, instanceOf(Vehicle.class));
    }

    /**
     * Method: testCountWheel()
     * Тест значения колес: Должно быть целое, положительное значение, равно указанному
     */
    @Test
    public void testCountWheel() throws Exception {
        int zn = moto.getNumWheels();
        int ex = 2;
        assertThat(zn, instanceOf(Integer.class));
        assertTrue("Нет колес", zn > 0);
        assertEquals(ex, zn);
    }

    /**
     * Method: park()
     * Тест парковки: Должно быть целое, равно нулю
     */
    @Test
    public void testPark() throws Exception {
        moto.testDrive();
        int zn = moto.getSpeed();
        int st = 1;
        if (zn > 0) {
            moto.park();
            st = moto.getSpeed();
            assertThat(zn, instanceOf(Integer.class));
            assertEquals(0, st);
        } else {
            Assert.fail("Moto не едет");
        }
    }

    /**
     * Method: testGetCompany()
     * Тест значения компании: Должна быть строка, не нулевая, входить в список необходимых, равна указанной
     */
    @Test
    public void testGetCompany() throws Exception {
        String zn = moto.getCompany();

        String ex = "company1";
        String[] arrModels = {"company1", "company2", "company3"};

        assertNotNull("Нет значения", zn);
        assertThat(zn, instanceOf(String.class));

        boolean inList = Arrays.asList(arrModels).contains(zn);
        assertTrue("Производитель не в списке", inList);

        assertEquals(ex, zn);

    }

    /**
     * Method: testGetModel()
     * Тест значения модели: Должна быть строка, не нулевая, входить в список необходимых, равна указанной
     */
    @Test
    public void testGetModel() throws Exception {
        String zn = moto.getModel();

        String[] arrModels = {"model1", "model2", "model3"};
        String ex = "model1";

        assertNotNull("Нет значения", zn);
        assertThat(zn, instanceOf(String.class));

        boolean inList = Arrays.asList(arrModels).contains(zn);
        assertTrue("Модель не в списке", inList);

        assertEquals(ex, zn);
    }

    /**
     * Method: testGetYearRelease()
     * Тест значения года: Должно быть целое, положительное значение, в диапазоне,
     * в необходимом списке, равно указанному
     */
    @Test
    public void testGetYearRelease() throws Exception {
        int zn = moto.getYearRelease();
        int ex = 2023;

        int[] arrYears = new int[4];
        arrYears[0] = 2020;
        arrYears[1] = 2021;
        arrYears[2] = 2022;
        arrYears[3] = 2023;

        int minYear = 1900;
        int maxYear = 2200;

        assertThat(zn, instanceOf(Integer.class));
        assertFalse("Получен отрицательный год", zn < 0);
        assertFalse("Не верный год", zn < minYear || zn > maxYear);

        Set<Integer> yearsSet = Arrays.stream(arrYears).boxed().collect(Collectors.toSet());
        boolean inList = yearsSet.contains(zn);
        assertTrue("Год не в списке", inList);

        assertEquals(ex, zn);
    }


    /**
     * Method: testToString()
     * Тест представления объекта:
     * Должна быть строка, не нулевая, равна указанной
     */
    @Test
    public void testToString() throws Exception {
        String zn = moto.toString();
        String ex = "This motorcycle is a 2023 company1 model1;";
        System.out.println(zn);
        assertThat(zn, instanceOf(String.class));
        assertNotNull(ex);
        assertEquals(ex, zn);
    }

}
