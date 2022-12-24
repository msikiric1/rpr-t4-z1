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
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(laptop);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop laptop : laptopi) {
            if(laptop.getProcesor().equals(procesor))
                return laptop;
        }
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            while(true) {
                try {
                    laptopi.add((Laptop) ois.readObject());
                } catch(IOException e) {
                    break;
                }
            }
            ois.close();
        } catch(ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return this.laptopi;
    }
}
