package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] numbers = {3, 1, 5, 2, -5, -10, 12};
        int[] sortedArray = {-10, -5, 1, 2, 3, 5 ,12};
        Bubble.sort(numbers);
        Assert.assertArrayEquals(sortedArray, numbers);
    }
}