//package pkg4;

import org.junit.jupiter.api.Test;
import pkg4.BookRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * BookService Tester.
 *
 * @author Tsvetkov
 * @version 1.0
 * @since <pre>2023</pre>
 */
class BookServiceTest {
    /**
     *   Тест BookService, с моск-заглушкой для BookRepository
     */
    @Test
    public void BookServiceMockTest() {
        // Создаем мок
        BookRepository mockedRepo = mock(BookRepository.class);

        // Используем мок
        mockedRepo.findAll();
        mockedRepo.findById("001");
        mockedRepo.findById("002");

        // Проверяем, что методы были вызваны
        verify(mockedRepo).findAll();
        verify(mockedRepo).findById("001");
        verify(mockedRepo).findById("002");

    }
}