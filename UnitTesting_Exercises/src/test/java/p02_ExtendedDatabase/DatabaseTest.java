package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private Person pesho = new Person(1, "Pesho");
    private Person toshko = new Person(2, "Toshko");
    private Person goshko = new Person(3, "Goshko");
    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(pesho, toshko, goshko);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowIfMissing() throws OperationNotSupportedException {
        database.findByUsername("Sashko");
    }

    @Test
    public void testFindByUsernameShouldReturnUser() throws OperationNotSupportedException {
        Person person = database.findByUsername(pesho.getUsername());
        Assert.assertEquals(person.getId(), pesho.getId());
        Assert.assertEquals(person.getUsername(), pesho.getUsername());
    }


}