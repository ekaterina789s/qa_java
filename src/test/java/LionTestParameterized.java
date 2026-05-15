import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;

//Тесты для конструктора:
@RunWith(Parameterized.class)
public class LionTestParameterized {

    private final String sex;
    private final Boolean expectedHasMane;
    private final boolean expectedException;
    private Feline mockFeline;

    public LionTestParameterized(String sex, Boolean expectedHasMane, boolean expectedException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedException = expectedException;
        this.mockFeline = mockFeline;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, false},
                {"Самка", false, false},
                {"Неизвестный", null, true},
                {null, null, true}
        });
    }
    @Test
    public void lionConstructorTest() throws Exception{
        if(expectedException) {
            try {
                new Lion(sex, mockFeline);
            } catch (Exception e) {
                assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного"));
            }
        } else {
            Lion lion = new Lion(sex, mockFeline);
            Assert.assertEquals(expectedHasMane, lion.doesHaveMane());

            }

        }


    }








