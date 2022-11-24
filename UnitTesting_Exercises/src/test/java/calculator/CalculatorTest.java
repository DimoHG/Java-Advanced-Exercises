package calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void prepare(){
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        int sum = calculator.sum(5, 4);
        Assert.assertEquals(9, sum);
    }

    @Test
    public void testMultiplication(){
        int multiplication = calculator.multiply(5, 4);
        Assert.assertEquals(20, multiplication);
    }

}