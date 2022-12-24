package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface LaptopDao {
    void dodajLaptopUListu(Laptop laptop);
    void dodajLaptopUFile(Laptop laptop) throws IOException;
    Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException;
    void napuniListu(ArrayList<Laptop> laptopi);
    List<Laptop> vratiPodatkeIzDatoteke() throws IOException;
}
