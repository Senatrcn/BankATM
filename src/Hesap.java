public class Hesap {

    String kullaniciAdi;
    String sifre;
    double bakiye=0;

    Hesap(){
        hesapOlustur();
        System.out.println("Hesap başarı ile olusturuldu");

    }

    public void setKullaniciAdi(){
        System.out.println("Kullanıcı adınızı belirleyin");
        String kullaniciAdi = Methods.scanner.next();

        if (!kullaniciAdi.startsWith(" ")&&kullaniciAdi.length()>3){
            this.kullaniciAdi = kullaniciAdi;
        }else setKullaniciAdi();
    }

    public String getSifre(){
        return sifre;
    }
    public void setSifre(){
        System.out.println("Sifrenizi belirleyin");
        String sifre = Methods.scanner.next();
        if (sifre.length()>=6){
            this.sifre=sifre;
        }else {
            System.out.println("Sifreniz en az 6 karakter olmalıdır");
            setSifre();
        }
    }
    public void hesapOlustur(){
        setKullaniciAdi();
        setSifre();
        Methods.scanner.nextLine();
    }


    @Override
    public String toString() {
        return "Hesap{" +
                "kullaniciAdi='" + kullaniciAdi + '\'' +
                "sifre='"+sifre+"\'"+
                '}';
    }
}
