package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() throws IOException {
        this.file = new File("serializable.dat");
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(laptopi);
        oos.close();
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
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            laptopi = (ArrayList<Laptop>) ois.readObject();
            ois.close();
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return this.laptopi;
    }
}
