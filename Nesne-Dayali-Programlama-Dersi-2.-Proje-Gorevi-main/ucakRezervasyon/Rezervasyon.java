// Rezervasyon sınıfı - Rezervasyon bilgilerini tutan sınıf
public class Rezervasyon {
    // Sınıf değişkenlerimiz
    private Ucus ucus; // Rezervasyon yapılan uçuş
    private String ad; // Yolcunun adı
    private String soyad; // Yolcunun soyadı
    private int yas; // Yolcunun yaşı
    private String koltukNo;

    // Yapıcı metod - Rezervasyon nesnesi oluştururken gerekli bilgileri alır
    public Rezervasyon(Ucus ucus, String ad, String soyad, int yas, String koltukNo) {
        this.ucus = ucus;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.koltukNo = koltukNo;
    }

    // Getter ve Setter metodlarımız
    public Ucus getUcus() { return ucus; } // Uçuş bilgisini döndürürüz
    public void setUcus(Ucus ucus) { this.ucus = ucus; } // Uçuş bilgisini güncelleriz
    public String getAd() { return ad; } // Yolcunun adını döndürürüz
    public void setAd(String ad) { this.ad = ad; } // Yolcunun adını güncelleriz
    public String getSoyad() { return soyad; } // Yolcunun soyadını döndürürüz
    public void setSoyad(String soyad) { this.soyad = soyad; } // Yolcunun soyadını güncelleriz
    public int getYas() { return yas; } // Yolcunun yaşını döndürürüz
    public void setYas(int yas) { this.yas = yas; } // Yolcunun yaşını güncelleriz
    public String getKoltukNo() { return koltukNo; }

    // toString metodu - Rezervasyon bilgilerini string formatında döndürürüz
    @Override
    public String toString() {
        return ucus.toString() + " - Koltuk: " + koltukNo;
    }
} 