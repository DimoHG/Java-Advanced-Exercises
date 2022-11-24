package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private final static Integer[] NUMBERS = {7, 3, 2, 1};

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }
    //1. Базата се създава успешно
    @Test
    public void testConstructorCreatesValidDB() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertArrayEquals(NUMBERS, dbElements);
    }

    //2. Ексепшън при > 16 елемента
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16elements() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);
    }

    //3. Ексепшън при < 1 елемента
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNoElements() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    //4. Ексепшън при null
    @Test(expected = OperationNotSupportedException.class)
    public void addNullShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    //5. Добавяме успешно на края на дб
    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(42);
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(42));
        Assert.assertEquals(NUMBERS.length + 1, dbElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyDB() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove(); //-> EXCEPTION
    }

    @Test
    public void testRemoveShouldRemove() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();
        Assert.assertEquals(elementsBeforeRemove.length - 1, elementsAfterRemove.length);

        int previousSecondToLastElement = elementsBeforeRemove[elementsBeforeRemove.length - 2];
        int currentLastElement = elementsAfterRemove[elementsAfterRemove.length -1];
        Assert.assertEquals(previousSecondToLastElement, currentLastElement);
    }
}