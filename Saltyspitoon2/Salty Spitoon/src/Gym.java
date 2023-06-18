import java.util.ArrayList;
class Gym  {


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


}