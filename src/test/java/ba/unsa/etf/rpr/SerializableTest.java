package ba.unsa.etf.rpr;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class SerializableTest {
    private static ArrayList<Laptop> laptopi;

    @BeforeAll
    public static void setup() {
        laptopi = new ArrayList<>();
        laptopi.add(new Laptop("HP", "neki", 500, 16, 500, 200, "i7", "NVidia GeForce", 15));
        laptopi.add(new Laptop("Apple", "neki drugi", 2000, 32, 600, 400, "m", "neka tamo", 18));
    }

    @Test
    public void dodajLaptopUListuTest() throws NeodgovarajuciProcesorException {
        LaptopDao ldsf = Mockito.mock(LaptopDaoSerializableFile.class);
        ldsf.dodajLaptopUListu(new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16));
        Mockito.when(ldsf.getLaptop("neki treci")).thenReturn(new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16));
    }

    @Test
    public void dodajLaptopUFileTest() throws IOException {
        LaptopDaoSerializableFile laptopDao = new LaptopDaoSerializableFile();
        laptopDao.dodajLaptopUFile(new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16));
        assertEquals("i5", laptopDao.vratiPodatkeIzDatoteke().get(0).getProcesor());
    }

    @Test
    public void getLaptopTest() throws IOException, NeodgovarajuciProcesorException {
        LaptopDaoSerializableFile laptopDao = new LaptopDaoSerializableFile();
        laptopDao.dodajLaptopUFile(new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16));
        assertEquals(new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16), laptopDao.getLaptop("i5"));
    }

    @Test
    public void napuniListuTest() throws IOException, NeodgovarajuciProcesorException {
        LaptopDaoSerializableFile laptopDao = new LaptopDaoSerializableFile();
        Laptop l1 = new Laptop("HP", "neki", 500, 16, 500, 200, "i7", "NVidia GeForce", 15);
        Laptop l2 = new Laptop("Apple", "neki drugi", 2000, 32, 600, 400, "m", "neka tamo", 18);
        Laptop l3 = new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16);
        ArrayList<Laptop> laptopi1 = new ArrayList<>();
        laptopi1.add(l1); laptopi1.add(l2); laptopi1.add(l3);
        laptopDao.napuniListu(laptopi1);
        assertEquals(laptopi1.get(0), laptopDao.getLaptop("i7"));
    }

    @Test
    public void vratiPodatkeIzDatotekeTest() throws IOException, NeodgovarajuciProcesorException {
        LaptopDaoSerializableFile laptopDao = new LaptopDaoSerializableFile();
        Laptop l1 = new Laptop("HP", "neki", 500, 16, 500, 200, "i7", "NVidia GeForce", 15);
        Laptop l2 = new Laptop("Apple", "neki drugi", 2000, 32, 600, 400, "m", "neka tamo", 18);
        Laptop l3 = new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16);
        ArrayList<Laptop> laptopi1 = new ArrayList<>();
        laptopi1.add(l1); laptopi1.add(l2); laptopi1.add(l3);
        laptopDao.dodajLaptopUFile(l1);
        laptopDao.dodajLaptopUFile(l2);
        laptopDao.dodajLaptopUFile(l3);
        assertEquals(laptopi1, laptopDao.vratiPodatkeIzDatoteke());
    }


}
