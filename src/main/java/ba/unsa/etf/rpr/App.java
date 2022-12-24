package ba.unsa.etf.rpr;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Laptop l = new Laptop("HP", "neki", 500, 16, 500, 200, "i7", "NVidia GeForce", 15);
        //LaptopDao laptopDao = new LaptopDaoSerializableFile();
        //LaptopDao laptopDao = new LaptopDaoJSONFile();
        LaptopDao laptopDao = new LaptopDaoXMLFile();
        laptopDao.dodajLaptopUFile(l);
        System.out.println(laptopDao.vratiPodatkeIzDatoteke());
    }
}
