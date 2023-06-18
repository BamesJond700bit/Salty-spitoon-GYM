import java.util.Scanner;
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
        for (Member member : gym.members) {
            System.out.println(member.getId() + " " + member.getName());
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
        System.out.println("Masukkan id baru :");
        int idNew = scan.nextInt();
        for (Member member : gym.members) {
            if (member.getId() == id) {
                System.out.println("Id sudah ada!");
                break;
            }
            System.out.println("Masukkan Nama Baru :");
            scan.nextLine();
            String nameNew = scan.nextLine();
            Member barangedit = gym.members.get(id - 1);
            barangedit.setId(idNew);
            barangedit.setName(nameNew);
            gym.members.set(id - 1, barangedit);

        }

    }
    public static void deleteMember() {
        System.out.println("Masukkan id member yang ingin dihapus :");
        int id = scan.nextInt();
        gym.members.remove(id - 1);
    }

    public static void addSuplemen(){
        Suplemen suplemen = new Suplemen();
        System.out.print("id : ");
        suplemen.id = scan.nextInt();
        System.out.print("nama : ");
        suplemen.name = scan.next();
        System.out.println("Harga : ");
        suplemen.setHarga(scan.next());
        gym.addSuplemen(suplemen);
    }

    public static void showSuplemens() {
        for (Suplemen suplemen : gym.suplemens) {
            System.out.println(suplemen.id + " " + suplemen.name);
            System.out.println(suplemen.getHarga());
        }
    }

    public static void sellSuplemen() {
        System.out.println("Masukkan id suplemen yang ingin dihapus :");
        int id = scan.nextInt();
        gym.members.remove(id - 1);
    }

}

