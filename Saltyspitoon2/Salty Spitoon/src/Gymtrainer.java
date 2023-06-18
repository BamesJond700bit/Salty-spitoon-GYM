public abstract class Gymtrainer {
    String name;

    int Tahunpengalaman;

    public Gymtrainer(String name,int Tahunpengalaman){
        this.name = name;
        this.Tahunpengalaman = Tahunpengalaman;
    }

    public abstract void sesiPelatihan();

}
