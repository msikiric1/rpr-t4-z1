package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public interface LaptopDao {
    void dodajLaptopUListu(Laptop laptop);
    void dodajLaptopUFile(Laptop laptop);
    Laptop getLaptop(String procesor);
    void napuniListu(ArrayList<Laptop> laptopi);
    List<Laptop> vratiPodatkeIzDatoteke();
}
