package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] NAMES = {"Pesho", "Gosho", "Tosho"};

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreate() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(NAMES);
        Assert.assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[1], listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[2], listIterator.print());
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext()); //true
        listIterator.move(); //Gosho
        Assert.assertTrue(listIterator.hasNext()); //true
        listIterator.move(); //Toshko
        Assert.assertFalse(listIterator.hasNext()); //false
    }

    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.move()); //Goshko
        Assert.assertTrue(listIterator.move()); //Toshko
        Assert.assertFalse(listIterator.move()); //Toshko
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowWithEmptyIterator() throws OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }

    @Test
    public void testPrintShouldReturn(){
        Assert.assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[1], listIterator.print());
    }
}