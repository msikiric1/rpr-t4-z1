package ba.unsa.etf.rpr;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Laptop l = new Laptop("IBM", "neki treci", 700, 6, 300, 100, "i5", "neka", 16);
        LaptopDao laptopDao = new LaptopDaoSerializableFile();
        //LaptopDao laptopDao = new LaptopDaoJSONFile();
        //LaptopDao laptopDao = new LaptopDaoXMLFile();
        laptopDao.dodajLaptopUFile(l);
        System.out.println(laptopDao.vratiPodatkeIzDatoteke());
    }
}
