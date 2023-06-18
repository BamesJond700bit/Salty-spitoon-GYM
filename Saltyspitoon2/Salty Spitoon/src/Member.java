import java.util.ArrayList;

class Member{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Jadwal(){
        System.out.println("============================");
        System.out.println("  JADWAL PELATIHAN FITNES   ");
        System.out.println("============================");
        System.out.println("|Selasa  |   13.00–17.00    |");
        System.out.println("|Kamis   |   13.00–17.00    |");
        System.out.println("|Sabtu   |   08.00–12.00    |");
        System.out.println("============================");
    }

}