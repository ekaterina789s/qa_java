import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;
import java.util.List;




public class FelineTest {
     private Feline feline = new Feline();

    //Проверка метода eatMeat класса Feline
    @Test
    public void eatMeatFelineTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }

    //Проверка метода getFamily() класса Feline
    @Test
    public void getFamilyFelineTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    //Проверка метода getKittens() класса Feline
    @Test
    public void getKittensFelineTest() {
        Assert.assertEquals(1, feline.getKittens());

    }

    //Проверка метода getKittens(int kittensCount) проверяется в классе FelineTestParameterized

}










