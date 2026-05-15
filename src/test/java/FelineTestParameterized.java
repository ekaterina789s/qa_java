import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


    @RunWith(Parameterized.class)
    public class FelineTestParameterized {

        private final int inputKittensCount;
        private final int expectedKittensCount;

        // Конструктор для получения параметров
        public FelineTestParameterized(int inputKittensCount, int expectedKittensCount) {
            this.inputKittensCount = inputKittensCount;
            this.expectedKittensCount = expectedKittensCount;
        }

        // Метод, предоставляющий данные для тестов
        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { 0, 0 },
                    { 1, 1 },
                    { 3, 3 },
                    { 5, 5 },
                    { 10, 10 },
            });
        }

        @Test
        public void testGetKittensWithParameter() {
            // Given: создаём экземпляр тестируемого класса
            Feline feline = new Feline();

            // When: вызываем тестируемый метод с параметром из набора данных
            int result = feline.getKittens(inputKittensCount);

            // Then: проверяем, что результат соответствует ожидаемому
            Assert.assertEquals(expectedKittensCount, result);
        }

    }

