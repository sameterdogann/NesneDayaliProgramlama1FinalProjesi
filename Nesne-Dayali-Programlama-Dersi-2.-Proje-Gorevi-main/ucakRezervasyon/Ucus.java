import java.time.LocalDateTime;

// Uçuş sınıfı - Uçuş bilgilerini tutan sınıf
public class Ucus {
    // Sınıf değişkenleri
    private Lokasyon kalkis; // Kalkış lokasyonu
    private Lokasyon varis; // Varış lokasyonu
    private LocalDateTime saat; // Uçuş saati
    private Ucak ucak; // Uçuşu yapacak uçak
    private int kalanKoltuk; // Uçakta kalan koltuk sayısı

    // Yapıcı metod - Uçuş nesnesi oluştururken gerekli bilgileri alır
    public Ucus(Lokasyon kalkis, Lokasyon varis, LocalDateTime saat, Ucak ucak) {
        this.kalkis = kalkis;
        this.varis = varis;
        this.saat = saat;
        this.ucak = ucak;
        this.kalanKoltuk = ucak.getKoltukKapasitesi(); // Başlangıçta kalan koltuk sayısı uçağın kapasitesine eşit
    }

    // Rezervasyon yapma metodu - Koltuk varsa rezervasyon yapar ve true döndürür
    public boolean rezervasyonYap() {
        if (kalanKoltuk > 0) {
            kalanKoltuk--; // Kalan koltuk sayısını bir azalt
            return true; // Rezervasyon başarılı
        }
        return false; // Koltuk kalmadığı için rezervasyon başarısız
    }

    // Getter ve Setter metodları
    public Lokasyon getKalkis() { return kalkis; } // Kalkış lokasyonunu döndürür
    public void setKalkis(Lokasyon kalkis) { this.kalkis = kalkis; } // Kalkış lokasyonunu günceller
    public Lokasyon getVaris() { return varis; } // Varış lokasyonunu döndürür
    public void setVaris(Lokasyon varis) { this.varis = varis; } // Varış lokasyonunu günceller
    public LocalDateTime getSaat() { return saat; } // Uçuş saatini döndürür
    public void setSaat(LocalDateTime saat) { this.saat = saat; } // Uçuş saatini günceller
    public Ucak getUcak() { return ucak; } // Uçak bilgisini döndürür
    public void setUcak(Ucak ucak) { this.ucak = ucak; } // Uçak bilgisini günceller
    public int getKalanKoltuk() { return kalanKoltuk; } // Kalan koltuk sayısını döndürür
    public void setKalanKoltuk(int kalanKoltuk) { this.kalanKoltuk = kalanKoltuk; } // Kalan koltuk sayısını günceller

    // toString metodu - Uçuş bilgilerini string formatında döndürür
    @Override
    public String toString() {
        return "Ucus{" +
                "kalkis=" + kalkis +
                ", varis=" + varis +
                ", saat=" + saat +
                ", ucak=" + ucak +
                ", kalanKoltuk=" + kalanKoltuk +
                '}';
    }
} 