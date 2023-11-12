//package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pkg3.NumLib;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * NumLib Tester junit5
 *
 * @author Tsvetkov
 * @version 1.0
 * @since <pre>2023</pre>
 */
class NumLibTest5 {

    NumLib nl = new NumLib();

    @BeforeEach
    void setUp() {
        NumLib nl = new NumLib();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Method: evenOddNumber()
     * Тестируем все возможные варианты
     * Обозначения: zn= Входные значения, ex = Должно быть на выходе, rz = Фактический результат
     */
    @Test
    void evenOddNumber() {

        final int zn0=0;          //Граничное значение
        final boolean ex0=true;   //должны получить true

        final int zn1=3; //3;     //Нечетное
        final boolean ex1=false;  //должны получить false

        final int zn2=4; //4;     //Четное
        final boolean ex2=true;

        final int zn3=-3;         //Отризательное нечетное
        final boolean ex3=false;

        final int zn4=-4; //-4;   //Отрицательное четное
        final boolean ex4=true;

        String s1="Не верный результат, ";
        String s2=" четное, должно быть true";
        String s3=" нечетное, должно быть false";

        boolean rz0 = nl.evenOddNumber(zn0);
        assertThat(rz0, instanceOf(Boolean.class));
        assertTrue(s1 + zn0+ s2, rz0);
        assertEquals(ex0, rz0);

        boolean rz1 = nl.evenOddNumber(zn1);
        assertThat(rz1, instanceOf(Boolean.class));
        assertFalse(s1 + zn1+ s3, rz1);
        assertEquals(ex1, rz1);

        boolean rz2 = nl.evenOddNumber(zn2);
        assertThat(rz2, instanceOf(Boolean.class));
        assertTrue(s1 + zn2+ s2, rz2);
        assertEquals(ex2, rz2);

        boolean rz3 = nl.evenOddNumber(zn3);
        assertThat(rz3, instanceOf(Boolean.class));
        assertFalse(s1 + zn3+ s3, rz3);
        assertEquals(ex3, rz3);

        boolean rz4 = nl.evenOddNumber(zn4);
        assertThat(rz4, instanceOf(Boolean.class));
        assertTrue(s1 + zn2+ s2, rz4);
        assertEquals(ex4, rz4);

    }

    /**
     * Method: numberInInterval()
     * Тестируем все возможные варианты
     * Обозначения: zn[]= Входные значения, ex[] = Должно быть на выходе, rz = Фактический результат
     */
    @Test
    void numberInInterval() {

        int mCountTests=4;
        int[]     zn = new int[mCountTests];
        boolean[] ex = new boolean[mCountTests];
        String[]  ms = new String[mCountTests];

        zn[0]=4;      //меньше интервала
        ex[0]=false;  //меньше интервала ожидаем false
        ms[0]="Меньше левой границы, должно быть "+ex[0];

        zn[1]=25;     //равно левой границе
        ex[1]=true;   // ожидаем true
        ms[1]="Равно левой границе, должно быть "+ex[1];

        zn[2]=100;    //равно правой границе
        ex[2]=true;  // ожидаем true
        ms[2]="Равно правой границе, должно быть "+ex[2];

        zn[3]=110;    //больше правой
        ex[3]=false;  //ожидаем false
        ms[3]="Больше правой границы, должно быть "+ex[3];;

        String s1="Не верный результат для значения: ";

        for (int i = 0; i < mCountTests; i++) {
            boolean rz = nl.numberInInterval(zn[i]);
            assertThat(rz, instanceOf(Boolean.class));
            if(ex[i]==true) {
                assertTrue(s1 + zn[i]+" "+ms[i], rz);
            }
            else{
                assertFalse(s1 + zn[i]+" "+ms[i], rz);
            }
            assertEquals(ex[i], rz);
        }
    }
}