import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

//Тест для конструктора с валидныдным полем sex и корректным полем expectedHasMane :
@RunWith(Parameterized.class)
public class LionTestParameterized {

    private final String sex;
    private final Boolean expectedHasMane;
    private Feline mockFeline = new Feline();

//объект mockFeline не передаем в конструктор, т.к. он для всех тестов одинаков
    public LionTestParameterized(String sex, Boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, грива: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }
    @Test
    public void lionConstructor_ValidSex_CorrectMane_Test() throws Exception{
        Lion lion = new Lion(sex, mockFeline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
//тест на выброс исключения для констурктора находится в LionTest











