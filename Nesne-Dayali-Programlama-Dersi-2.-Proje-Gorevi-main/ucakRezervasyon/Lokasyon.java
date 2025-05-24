// Lokasyon sınıfı - Havaalanı lokasyonlarını tutan sınıfımız
public class Lokasyon {
    // Sınıf değişkenleri
    private String ulke; // Havaalanının bulunduğu ülke
    private String sehir; // Havaalanının bulunduğu şehir
    private String havaalani; // Havaalanı kodu (örn: IST)
    private boolean aktif; // Havaalanının aktif olup olmadığı

    // Yapıcı metod - Lokasyon nesnesi oluştururken gerekli bilgileri alırız
    public Lokasyon(String ulke, String sehir, String havaalani, boolean aktif) {
        this.ulke = ulke;
        this.sehir = sehir;
        this.havaalani = havaalani;
        this.aktif = aktif;
    }

    // Getter ve Setter metodları
    public String getUlke() { return ulke; } // Ülke bilgisini döndürürüz
    public void setUlke(String ulke) { this.ulke = ulke; } // Ülke bilgisini güncelleriz
    public String getSehir() { return sehir; } // Şehir bilgisini döndürürüz
    public void setSehir(String sehir) { this.sehir = sehir; } // Şehir bilgisini güncelleriz
    public String getHavaalani() { return havaalani; } // Havaalanı kodunu döndürürüz
    public void setHavaalani(String havaalani) { this.havaalani = havaalani; } // Havaalanı kodunu güncelleriz
    public boolean isAktif() { return aktif; } // Havaalanının aktiflik durumunu döndürürüz
    public void setAktif(boolean aktif) { this.aktif = aktif; } // Havaalanının aktiflik durumunu güncelleriz

    // toString metodu - Lokasyon bilgilerini string formatında döndürürüz
    @Override
    public String toString() {
        return "Lokasyon{" +
                "ulke='" + ulke + '\'' +
                ", sehir='" + sehir + '\'' +
                ", havaalani='" + havaalani + '\'' +
                ", aktif=" + aktif +
                '}';
    }
} 