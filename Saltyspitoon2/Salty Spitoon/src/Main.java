import java.util.Scanner;
import java.util.Iterator;
public class Main {

    static Scanner scan = new Scanner(System.in);
    static Gym gym = new Gym();

    public static void main(String[] args) {
        initGymData();

        String isContinue = "y";

        while (isContinue.equals("y")) {
            showMenu();
            int selectedMenu = chooseMenu();

            try {
                switch (selectedMenu) {
                    case 1:
                        showMembers();
                        break;
                    case 2:
                        addMember();
                        break;
                    case 3:
                        updateMember();
                        break;
                    case 4:
                        deleteMember();
                        break;
                    case 5:
                        addSuplemen();
                        break;
                    case 6:
                        showSuplemens();
                        break;
                    case 7:
                        sellSuplemen();
                        break;
                    case 8:
                        gymTrainer();
                        break;
                    case 9:
                        jadwalGym();
                        break;
                    default:
                        throw new IllegalArgumentException("input yang bener bang");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


            System.out.print("continue ? (y/n)");
            isContinue = scan.next();
        }

    }

    //    method untuk menampilan menu
    public static void showMenu() {
        System.out.println("==========SALTY SPITOON=============");
        System.out.println("1.Show Member");
        System.out.println("2.Add Member");
        System.out.println("3.Update Member");
        System.out.println("4.Delete Member");
        System.out.println("5.Add Suplemen");
        System.out.println("6.Show Suplemen");
        System.out.println("7.Sell Suplemen");
        System.out.println("8.Gym Trainer");
        System.out.println("9.Jadwal Gym");
        System.out.println("=====================================");
    }

    public static void initGymData() {
        Member member1 = new Member();
        member1.setId(1);
        member1.setName("Vale");

        Member member2 = new Member();
        member2.setId(2);
        member2.setName("Evan");

        Member member3 = new Member();
        member3.setId(3);
        member3.setName("Dika");

        Suplemen suplemen1 = new Suplemen();
        suplemen1.id = 1;
        suplemen1.name = "Whey Protein";
        suplemen1.harga = "Rp. 79.000";

        Suplemen suplemen2 = new Suplemen();
        suplemen2.id = 2;
        suplemen2.name = "Creatine";
        suplemen2.harga = "Rp. 100.000";

        Suplemen suplemen3 = new Suplemen();
        suplemen3.id = 3;
        suplemen3.name = "Fat Burner";
        suplemen3.harga = "Rp. 125.000";


        gym.members.add(member1);
        gym.members.add(member2);
        gym.members.add(member3);

        gym.suplemens.add(suplemen1);
        gym.suplemens.add(suplemen2);
        gym.suplemens.add(suplemen3);

    }


    public static int chooseMenu() {
        System.out.print("choose menu : ");
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static void showMembers() {
        int i = 0;
        Iterator var1 = gym.members.iterator();

        while(var1.hasNext()) {
            Member member = (Member) var1.next();
            ++i;
            System.out.println("" + i + " " + member.getName());
        }

    }

    public static void addMember() {
        Member member = new Member();
        System.out.print("id : ");
        int id = scan.nextInt();
        member.setId(id);
        System.out.print("name : ");
        String name = scan.next();
        member.setName(name);
        gym.addMember(member);
    }

    public static void updateMember() {
        System.out.println("Masukkan id member yang ingin di update :");
        int id = scan.nextInt();
        System.out.println("Konfirmasi ID yang ingin di update:");
        int idNew = scan.nextInt();
        boolean idExists = true;
        Iterator var3 = gym.members.iterator();

        Member memberedit;
        while(var3.hasNext()) {
            memberedit = (Member) var3.next();
            if (memberedit.getId() == idNew) {
                idExists = false;
                break;
            }
        }

        if (idExists) {
            System.out.println("ID tidak sesuai!");
        } else {
            System.out.println("Masukkan Nama Baru :");
            scan.nextLine();
            String nameNew = scan.nextLine();
            memberedit = (Member) gym.members.get(id - 1);
            memberedit.setId(idNew);
            memberedit.setName(nameNew);
            gym.members.set(id - 1, memberedit);
        }

    }
    public static void deleteMember() {
        showMembers();
        System.out.println("Masukkan id member yang ingin dihapus:");
        int id = scan.nextInt();
        Member memberToDelete = null;
        Iterator var2 = gym.members.iterator();

        while(var2.hasNext()) {
            Member member = (Member) var2.next();
            if (member.getId() == id) {
                memberToDelete = member;
                break;
            }
        }

        if (memberToDelete != null) {
            gym.members.remove(memberToDelete);
            System.out.println("Member berhasil dihapus.");
        } else {
            System.out.println("Member dengan ID tersebut tidak ditemukan.");
        }

    }

    public static void addSuplemen(){
        Suplemen suplemen = new Suplemen();
        System.out.print("id : ");
        suplemen.id = scan.nextInt();
        System.out.print("nama : ");
        suplemen.name = scan.next();
        System.out.println("Harga : ");
        suplemen.harga = (scan.next());
        gym.addSuplemen(suplemen);
    }

    public static void showSuplemens() {
        int i = 0;
        Iterator var1 = gym.suplemens.iterator();

        while(var1.hasNext()) {
            Suplemen suplemen = (Suplemen) var1.next();
            ++i;
            System.out.println("" + i + ". " + suplemen.name);
            System.out.println(suplemen.harga);
        }

    }

    public static void sellSuplemen() {
        showSuplemens();
        System.out.println("Masukkan id Suplemen yang ingin dijual:");
        int id = scan.nextInt();
        Suplemen SuplemenToDelete = null;
        Iterator var2 = gym.suplemens.iterator();

        while(var2.hasNext()) {
            Suplemen suplemen = (Suplemen) var2.next();
            if (suplemen.id == id) {
                SuplemenToDelete = suplemen;
                break;
            }
        }

        if (SuplemenToDelete != null) {
            gym.suplemens.remove(SuplemenToDelete);
            System.out.println("Suplemen berhasil dijual.");
        } else {
            System.out.println("Suplemen dengan ID tersebut tidak ditemukan.");
        }

    }
    public static void gymTrainer(){

        Gymtrainer trainer1 = new FitnessTrainer("Larry",5);
        Gymtrainer trainer2 = new Yogatrainer("Sandy" ,10);

        System.out.println("Pelatih 1 :");
        System.out.println("Nama :" + trainer1.name);
        System.out.println("Pengalaman : "+trainer1.Tahunpengalaman+"tahun");
        trainer1.sesiPelatihan();

        System.out.println("------------------------------------------");

        System.out.println("Pelatih 2 :");
        System.out.println("Nama :"+trainer2.name);
        System.out.println("Pengalaman :"+trainer2.Tahunpengalaman+"tahun");
        trainer2.sesiPelatihan();
    }

    public static void jadwalGym(){
        Member jadwal1 = new Member();
        jadwal1.Jadwal();

        Gym jadwal2 = new Gym();
        jadwal2.Jadwal();
    }
}

