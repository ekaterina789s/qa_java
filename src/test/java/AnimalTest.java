import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AnimalTest {
    Animal animal = new Animal();

    //Проверка метода public List<String> getFood(String animalKind) throws Exception по блокам
    @Test
    public void getFoodHerbivoreTest() throws Exception{
        Assert.assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodPredator() throws Exception{
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test
    public void getFoodException() {
        String animalKind = "Всеядное";
        try{
            animal.getFood("Всеядное");
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }

    }

    //Проверка метода public String getFamily()
    @Test
    public void getFamilyAnimalTest(){
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }



}
