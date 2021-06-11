package co.com.sofka.app.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @DisplayName("Testing several divide")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "6,    2,   3",
            "8,    2,   4",
            "10,  2, 5",
            "1000,  2, 500"
    })
    public  void divide(Long first, Long second, Long expectedResult){
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divide by zero")
    @ParameterizedTest(name = "{0} / {1} ")
    @CsvSource({
            "6,    0",
            "8,    0",
            "10,  0",
            "1000,  0"
    })
    public  void divideFail(Long first, Long second){
        var response = Assertions.assertThrows(RuntimeException.class,()->{
            long result = basicCalculator.divide(first,second);
        });
        Assertions.assertEquals("cannot be divided by zero",response.getMessage());
    }

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sub")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "1,    2,   -1",
            "40,  20,   20",
            "100,  30,  70",
            "5,    4,   1"
    })
    public void sub(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sub(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiply")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "100,    0,   0",
            "-1,    -2,   2",
            "10,  5, 50",
            "0,  8, 0",
            "3, -3, -9"
    })
    public void multiply(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

}
