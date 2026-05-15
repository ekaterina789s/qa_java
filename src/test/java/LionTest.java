
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

//Проверка метода getKittens()
    @Test
    public void getKittensLionTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        // Передаем любой корректный пол, так как метод не зависит от него
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());

    }

//Проверка метода getFood()
    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
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











