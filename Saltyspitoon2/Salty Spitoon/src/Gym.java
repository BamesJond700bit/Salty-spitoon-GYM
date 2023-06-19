import java.util.ArrayList;
class Gym extends Member {


    public ArrayList<Member> members = new ArrayList<>();
    public ArrayList<Suplemen> suplemens = new ArrayList<>();

//untuk memastikan tidak ada duplikasi id pada member
    public void addMember(Member member) { //menerima objek member sebagai parameter
        if (!isMemberIdExist(member.getId())) { //untuk mengecek apakah id sudah ada didalam members
            this.members.add(member); //jika id false maka akan ditambahkan
                                      // dan jika true maka akan mencetak pesan
        } else {
            System.out.println("Member Sudah ada !");
        }
    }

    public boolean isMemberIdExist(int id) { //menerima parameter id
        for (Member member : this.members) {
            if (member.getId()==(id)) {
                return true;
            }
        }
        return false;
    }
    //Melakukan perulangan untuk setiap member dalam daftar members.
    //Pada setiap iterasi, memeriksa apakah id member saat ini
    // sama dengan id yang sedang diperiksa.
    //Jika id member ditemukan dalam daftar members, mengembalikan
    // true yang menunjukkan bahwa id member tersebut sudah ada.
    //Jika tidak ada id member yang cocok dengan
    // parameter yang diberikan, mengembalikan false yang menunjukkan bahwa
    // id member tersebut belum ada dalam daftar members.



//untuk memastikan tidak ada duplikasi id pada suplemen
    public void addSuplemen(Suplemen suplemen) {
        if (!isSuplemenIdExist(suplemen.id)) {
            this.suplemens.add(suplemen);
        } else {
            System.out.println("Suplemen Id Sudah ada !");
        }
    }

    public boolean isSuplemenIdExist(int id) {
        for (Suplemen suplemen : this.suplemens) {
            if (suplemen.id==id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void Jadwal() {
        System.out.println("============================");
        System.out.println("   JADWAL PELATIHAN YOGA    ");
        System.out.println("============================");
        System.out.println("|Senin  |   16.00–18.00    |");
        System.out.println("|Rabu   |   16.00–18.00    |");
        System.out.println("|Jumat  |   10.00–12.00    |");
        System.out.println("============================");
    }

}