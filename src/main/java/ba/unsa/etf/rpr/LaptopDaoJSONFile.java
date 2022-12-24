package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile() throws IOException {
        this.file = new File("serializable.json");
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(laptopi);
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(json.getBytes());
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
        ObjectMapper om = new ObjectMapper();
        laptopi = om.readValue(file, new TypeReference<ArrayList<Laptop>>(){});
        return laptopi;
    }
}
