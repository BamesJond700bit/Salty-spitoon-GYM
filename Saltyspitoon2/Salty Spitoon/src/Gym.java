import java.util.ArrayList;
import java.util.Iterator;

class Gym extends Member {


    public ArrayList<Member> members = new ArrayList<>();
    public ArrayList<Suplemen> suplemens = new ArrayList<>();


    public void addMember(Member member) {
        if (!isMemberIdExist(member.getId())) {
            this.members.add(member);
        } else {
            System.out.println("Member Sudah ada !");
        }
    }

    public boolean isMemberIdExist(int id) {
        Iterator var2 = this.members.iterator();

        Member member;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            member = (Member) var2.next();
        } while(member.getId() != id);

        return true;
    }
    //Melakukan perulangan untuk setiap member dalam daftar members.
    //Pada setiap iterasi, memeriksa apakah id member saat ini
    // sama dengan id yang sedang diperiksa.
    //Jika id member ditemukan dalam daftar members, mengembalikan
    // true yang menunjukkan bahwa id member tersebut sudah ada.
    //Jika tidak ada id member yang cocok dengan
    // parameter yang diberikan, mengembalikan false yang menunjukkan bahwa
    // id member tersebut belum ada dalam daftar members.


    public void addSuplemen(Suplemen suplemen) {
        if (!isSuplemenIdExist(suplemen.id)) {
            this.suplemens.add(suplemen);
        } else {
            System.out.println("Suplemen Id Sudah ada !");
        }
    }

    public boolean isSuplemenIdExist(int id) {
        Iterator var2 = this.suplemens.iterator();

        Suplemen suplemen;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            suplemen = (Suplemen) var2.next();
        } while(suplemen.id != id);

        return true;
    }

    @Override
    public void Jadwal() {
        System.out.println("============================");
        System.out.println("  JADWAL PELATIHAN YOGA     ");
        System.out.println("============================");
        System.out.println("|Senin  |   16.00–18.00    |");
        System.out.println("|Rabu   |   16.00–18.00    |");
        System.out.println("|Jumat  |   10.00–12.00    |");
        System.out.println("============================");
    }
}
