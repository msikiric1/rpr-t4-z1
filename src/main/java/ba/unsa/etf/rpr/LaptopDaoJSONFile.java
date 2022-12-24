package ba.unsa.etf.rpr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    @Override
    public void dodajLaptopUListu(Laptop laptop) {

    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {

    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {

    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() {
        return null;
    }
}
