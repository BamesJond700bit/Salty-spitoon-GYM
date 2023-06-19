import java.util.Scanner;
public class Main {

    static Scanner scan = new Scanner(System.in);

    static Gym gym = new Gym(); //    membuat inisiasi object gym dari kelas Gym

    public static void main(String[] args) {
        initGymData(); //memberikan data awal

        String isContinue = "y";

        while (isContinue.equals("y")) { //perulangan akan terus jalan jika iscontinue bernilai y
            showMenu();  //memanggil fungsi show menu
            int selectedMenu = chooseMenu(); //memanggil fungsi chooseMenu yang mengembalikan pilihan menu

            try {
                switch (selectedMenu) { //memeriksa pilihan menu
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
            } catch (Exception e) {  //jika terjadi kesalahan akan ditangkap dan menampilkan pesan eror
                System.out.println("Error: " + e.getMessage());
            }


            System.out.print("continue ? (y/n)");
            isContinue = scan.next();
            //jika Y maka perulangan akan berlanjut dan N untuk menghentikan perulangan
        }

    }

    public static void showMenu() { //    method untuk menampilan menu
        System.out.println("====================================");
        System.out.println("||         SALTY SPITOON          ||");
        System.out.println("====================================");
        System.out.println("|1|          Show Member          ||");
        System.out.println("|2|          Add Member           ||");
        System.out.println("|3|         Update Member         ||");
        System.out.println("|4|         Delete Member         ||");
        System.out.println("|5|         Add Suplemen          ||");
        System.out.println("|6|         Show Suplemen         ||");
        System.out.println("|7|         Sell Suplemen         ||");
        System.out.println("|8|         Gym Trainer           ||");
        System.out.println("|9|          Jadwal Gym           ||");
        System.out.println("=====================================");
    }

    public static void initGymData() {  //method untuk mengisialisasi data awal
        Member member1 = new Member();
        member1.setId(1);
        member1.setName("Vale");

        Member member2 = new Member();
        member2.setId(2);
        member2.setName("Evan");

        Member member3 = new Member();    //membuat object member
        member3.setId(3);
        member3.setName("Dika");

        Suplemen suplemen1 = new Suplemen();
        suplemen1.id = 1;
        suplemen1.name = "Whey Protein";
        suplemen1.harga = "Rp. 79.000";

        Suplemen suplemen2 = new Suplemen();
        suplemen2.id = 2;                     //membuat object suplemen
        suplemen2.name = "Creatine";
        suplemen2.harga = "Rp. 100.000";

        Suplemen suplemen3 = new Suplemen();
        suplemen3.id = 3;
        suplemen3.name = "Fat Burner";
        suplemen3.harga = "Rp. 125.000";


        gym.members.add(member1);
        gym.members.add(member2);       //menambahkankan member kedalam arraylist
        gym.members.add(member3);

        gym.suplemens.add(suplemen1);
        gym.suplemens.add(suplemen2);    //menambah suplemen ke dalam arraylist
        gym.suplemens.add(suplemen3);

    }


    public static int chooseMenu() {  //untuk menampilkan,membaca dan mengembalikan pilihan
        System.out.print("choose menu : ");
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static void showMembers() {  //untuk menampilkan member
        int i=0;  //inisialisasi nomor urut
        for (Member member : gym.members) {  //mengiterasi objek member di dalam arraylist members
            System.out.println(++i + " " + member.getName());
        } //mencetak nomor urut nama anggota
    }

    public static void addMember() { //untuk menambahkan member
        Member member = new Member(); //membuat objek member

        System.out.print("id : ");
        int id = scan.nextInt();  //menginput id
        member.setId(id); //menset id

        System.out.print("nama : ");
        String name = scan.next(); //meninput nama
        member.setName(name); //menset name
        gym.addMember(member); //memanggil method dari objek gym
                               //untuk menambahkan objek member
                              // baru ke dalam Arraylist members
    }

    public static void updateMember() {
        System.out.println("Masukkan id member yang ingin di update :");
        int id = scan.nextInt();
        System.out.println("Masukkan id baru :");
        int idNew = scan.nextInt();
        boolean idExists = false;

        for (Member member : gym.members) {
            if (member.getId() == idNew) {
                idExists = true;
                break;
            }
        }

        if (idExists) {
            System.out.println("Id sudah ada!");
        } else {
            System.out.println("Masukkan Nama Baru :");
            scan.nextLine();
            String nameNew = scan.nextLine();
            Member memberedit = gym.members.get(id - 1);
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
        for (Member member : gym.members) {
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
        for (Suplemen suplemen : gym.suplemens) {
            System.out.println(++i+" "+ suplemen.name);
            System.out.println(suplemen.harga);
        }
    }

    public static void sellSuplemen() {
        showSuplemens();
        System.out.println("Masukkan id suplemen yang ingin dijual:");
        int id = scan.nextInt();

        int index = -1;
        for (int i = gym.suplemens.size() - 1; i >= 0; i--) {
            Suplemen suplemen = gym.suplemens.get(i);
            if (suplemen.id == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            gym.suplemens.remove(index);
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

//   memanggil method override
   public static void jadwalGym(){
        Member jadwal1 = new Member();
       jadwal1.Jadwal();

       Gym jadwal2 = new Gym();
       jadwal2.Jadwal();
   }
}

