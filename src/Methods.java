import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    static Scanner scanner = new Scanner(System.in);
    static List<Hesap> hesapListesi = new ArrayList<>();
    public static void atmGiris(){
        System.out.println("Yeni hesap olusturmak icin 1\nHesabınıza giris yapmak icin 2\nÇıkış için 3'ü tuşlayın");
        int islem= Methods.scanner.nextInt();
        scanner.nextLine();
        if (islem ==1){
            hesapOlustur();
        }else if (islem ==2){
            hesabaGiris();
        }else if(islem == 3){
            System.exit(0);
        }else atmGiris();

    }
    public static void hesapOlustur(){

        hesapListesi.add(new Hesap());
        System.out.println(hesapListesi);
        hesabaGiris();

    }
    public static void hesabaGiris() {

        boolean login= false;
        System.out.println("Kullanıcı adınızı giriniz");
        String girilenKullaniciAdi= scanner.nextLine();

        System.out.println("Şifrenizi giriniz");
        String girilenSifre = scanner.nextLine();

        for (Hesap hesap : hesapListesi) {
            System.out.println(hesap);
            if (hesap.kullaniciAdi.equals(girilenKullaniciAdi) && hesap.sifre.equals(girilenSifre)) {
                login = true;
                System.out.println("Giriş başarılı");
                islemSec(hesap);
            }
        }
        if (!login){
            System.out.println("Kullanıcı adı veya sifre yanlış");
            atmGiris();
        }
    }

    public static void islemSec(Hesap hesap) {

        int islem = 0;

        while(islem!=6){
            System.out.println("Yapmak istediginiz islemi seçiniz");
            System.out.println("Bakiye sorgulama : 1\nPara yatirma : 2\nPara çekme : 3\nPara gönderme : 4\nSifre değiştirme : 5\nÇıkıs : 6");
            islem = scanner.nextInt();
            switch(islem){
                case 1:
                    bakiyeSorgula(hesap);
                    break;
                case 2:
                    paraYatir(hesap);
                    break;
                case 3:
                    paraCek(hesap);
                    break;
                case 4:
                    paraGonder(hesap);
                    break;
                case 5:
                    sifreDegistir(hesap);
                    break;
                case 6:
                    cikis();
                    break;
                default:
                    System.out.println("Hatalı tuşlama");
                    break;
            }
            scanner.nextLine();
        }

    }

    public static void bakiyeSorgula(Hesap hesap) {
        System.out.println("Mevcut bakiyeniz : "+ hesap.bakiye);
    }

    public static void paraYatir(Hesap hesap) {
        System.out.println("Yatırmak istediginiz miktarı giriniz");
        double yatirilacakPara = scanner.nextDouble();
        hesap.bakiye += yatirilacakPara;
        System.out.println("Para yatırma işlemi başarıyla gerçekleşti");
        scanner.nextLine();
    }

    public static void paraCek(Hesap hesap) {
        System.out.println("Cekmek istediginiz miktarı giriniz");
        double cekilecekPara = scanner.nextDouble();
        if (cekilecekPara>hesap.bakiye){
            System.out.println("Girdiginiz miktar bakiyenizi asmaktadır. Lütfen tekrar deneyin");
        }else{
            hesap.bakiye -= cekilecekPara;
            System.out.println("Para çekme işlemi başarıyla gerçekleşti");
        }
        scanner.nextLine();

    }

    public static void paraGonder(Hesap hesap) {
        scanner.nextLine();
        System.out.println("IBAN girin");
        String iban = scanner.nextLine();
        if (iban.startsWith("TR")&& iban.length()==26){
            System.out.println("Göndermek istediginiz miktarı girin");
            double gonderilecekPara = scanner.nextDouble();

            if (gonderilecekPara>hesap.bakiye){
                System.out.println("Girdiginiz miktar bakiyenizi asmaktadır. Lütfen tekrar deneyin");
            }else{
                hesap.bakiye-=gonderilecekPara;
                System.out.println("Para gönderme işlemi başarıyla gerçekleşti");
            }

        }else{
            System.out.println("Hatalı giriş yaptınız. Tekrar deneyin");
        }

    }

    public static void sifreDegistir(Hesap hesap) {
        System.out.println("Lütfen sifrenizi giriniz");
        String girilenSifre = scanner.next();

        if (girilenSifre.equals(hesap.sifre)){
            String eskiSifre = hesap.getSifre();
            hesap.setSifre();
            if (eskiSifre.equals(hesap.sifre)){
                System.out.println("Farklı bir şifre girin");
                hesap.setSifre();
            }else{
                System.out.println("Şifreniz degistirildi");
            }

        }else{
            System.out.println("Sifrenizi yanlıs girdiniz. Tekrar deneyin");
        }

    }

    public static void cikis() {
        System.out.println("Yine bekleriz");
        atmGiris();
    }
}
