package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile() {
        this.file = new File("serializable.xml");
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        XmlMapper xm = new XmlMapper();
        String xml = xm.writeValueAsString(laptopi);
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(xml.getBytes());
        fo.close();
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for(Laptop laptop : laptopi) {
            if(laptop.getProcesor().equals(procesor))
                return laptop;
        }
        throw new NeodgovarajuciProcesorException("Laptop se ne nalazi u listi");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        XmlMapper xm = new XmlMapper();
        laptopi = xm.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        return laptopi;
    }
}
