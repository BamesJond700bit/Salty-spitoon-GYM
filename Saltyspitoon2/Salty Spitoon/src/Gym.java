import java.util.ArrayList;
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
        for (Member member : this.members) {
            if (member.getId()==(id)) {
                return true;
            }
        }
        return false;
    }

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
        System.out.println("  JADWAL PELATIHAN YOGA     ");
        System.out.println("============================");
        System.out.println("|Senin  |   16.00–18.00    |");
        System.out.println("|Rabu   |   16.00–18.00    |");
        System.out.println("|Jumat  |   10.00–12.00    |");
        System.out.println("============================");
    }
}