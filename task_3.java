import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckIsAdultTest {

    private final int age;
    private final boolean expected;

    public CheckIsAdultTest(int age, boolean expected) {
        this.age = age;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {19, true},  // Старше 18 лет
                {17, false}, // Младше 18 лет
                {18, true},  // Ровно 18 лет
                {21, true},  // Страны, где совершеннолетие в 21 год
                // Добавьте дополнительные тестовые случаи, если необходимо
        });
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(age);
        assertEquals("Неправильный результат для возраста " + age, expected, isAdult);
    }
}