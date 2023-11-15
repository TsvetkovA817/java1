//package pkg4;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class MockTest {

    /**
     * 4.0. Проверка работы Mockito
     */
     @Test
    public void listMockTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("1");
        mockedList.add("2");
        mockedList.add("3");
        mockedList.add("4");
        mockedList.add("A");
        mockedList.add("B");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("1");
        verify(mockedList).add("2");
        verify(mockedList).add("3");
        verify(mockedList).add("4");
        verify(mockedList).add("A");
        verify(mockedList).add("B");
        verify(mockedList).clear();
    }

}