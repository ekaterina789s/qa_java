import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class LionTest {

//Проверка, что метод getKittens() у Lion возвращает правильное кол-во котят()
    @Test
    public void getKittensLion_ReturnsCorrectCount_Test() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        // Передаем любой корректный пол, так как метод не зависит от него
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
       int result = lion.getKittens();
       Assert.assertEquals(1, result);
    }

    //Тест для проверки взаимодействия с Feline: проверяет, что при вызове lion.getKittens() вызывается feline.getKittens()
    @Test
    public void getKittensLion_CallsFelineGetKittens() throws Exception{
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

//Проверка, что lion.getFood() возвращает корректные значения
    @Test
    public void getFoodLionCorrectList() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List <String> result = lion.getFood();
        Assert.assertEquals(expectedFood, result);
    }
//Проверка, что вызывался feline.getFood("Хищник") в lion.getFood()
    @Test
    public void getFoodFelineCorrectList() throws Exception{
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

//Проверка, что при передаче в конструктор Lion(String sex, Feline feline) невалидного аргумента sex, выбрасывается исключение
    @Test
    public void shouldThrowExceptionForInvalidSex() throws Exception{
        String sex = "Другой";
        Feline feline = new Feline();

        try {
            new Lion(sex, feline);
            fail("Должно было быть выброшено исключение для пола: " + sex);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage()
            );
        }
    }
//Проверки метода doesHaveMane()
    @Test
    public void doesHaveManeTest_Male() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(lion.hasMane, lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeTest_Female() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(lion.hasMane, lion.doesHaveMane());
    }
}











