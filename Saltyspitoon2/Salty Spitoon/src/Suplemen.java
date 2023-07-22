import java.util.ArrayList;
public class Suplemen {
    public int id;
    public String name;
    public String harga;

    // Konstruktor dengan semua variabel
    public Suplemen(int id, String name, String harga) {
        this.id = id;
        this.name = name;
        this.harga = harga;
    }

    // Konstruktor dengan hanya id dan nama
    public Suplemen(int id, String name) {
        this(id, name, null);
    }

    // Konstruktor dengan hanya nama dan harga
    public Suplemen(String name, String harga) {
        this(0, name, harga);
    }

    // Konstruktor dengan hanya id
    public Suplemen(int id) {
        this(id, null, null);
    }

    // Konstruktor biasa
    public Suplemen() {
        this(0, null, null);
    }
}