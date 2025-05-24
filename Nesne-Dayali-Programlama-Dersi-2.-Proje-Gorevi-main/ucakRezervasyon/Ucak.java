// Uçak sınıfı - Uçak bilgilerini tutan sınıf
import java.util.*;

public class Ucak {
    // Sınıf değişkenleri
    private String model; // Uçağın modeli (örn: Boeing 737)
    private String marka; // Uçağın markası (örn: Boeing)
    private String seriNo; // Uçağın seri numarası
    private int koltukKapasitesi; // Uçağın toplam koltuk kapasitesi
    private Map<String, Boolean> koltuklar; // Koltuk numarası ve doluluk durumu

    // Yapıcı metod - Uçak nesnesi oluştururken gerekli bilgileri alırız
    public Ucak(String model, String marka, String seriNo, int koltukKapasitesi) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.koltukKapasitesi = koltukKapasitesi;
        this.koltuklar = new HashMap<>();
        koltuklariOlustur();
    }

    private void koltuklariOlustur() {
        // A1'den başlayarak koltukları oluştur
        for (int i = 1; i <= koltukKapasitesi; i++) {
            String koltukNo = "A" + i;
            koltuklar.put(koltukNo, false); // false = boş koltuk
        }
    }

    public boolean koltukDoluMu(String koltukNo) {
        return koltuklar.getOrDefault(koltukNo.toUpperCase(), true);
    }

    public boolean koltukRezervasyonYap(String koltukNo) {
        koltukNo = koltukNo.toUpperCase();
        if (!koltuklar.containsKey(koltukNo)) {
            return false;
        }
        if (koltuklar.get(koltukNo)) {
            return false;
        }
        koltuklar.put(koltukNo, true);
        return true;
    }

    public String getKoltukDurumu() {
        StringBuilder durum = new StringBuilder();
        int sayac = 0;
        
        for (Map.Entry<String, Boolean> koltuk : koltuklar.entrySet()) {
            durum.append(koltuk.getKey())
                 .append(": ")
                 .append(koltuk.getValue() ? "DOLU" : "BOŞ");
            
            sayac++;
            if (sayac % 3 == 0) {
                durum.append("\n");
            } else {
                durum.append(" | ");
            }
        }
        return durum.toString();
    }

    public String getBosKoltuklar() {
        StringBuilder bosKoltuklar = new StringBuilder();
        int sayac = 0;
        
        for (Map.Entry<String, Boolean> koltuk : koltuklar.entrySet()) {
            if (!koltuk.getValue()) {
                bosKoltuklar.append(koltuk.getKey());
                sayac++;
                if (sayac % 3 == 0) {
                    bosKoltuklar.append("\n");
                } else {
                    bosKoltuklar.append(" | ");
                }
            }
        }
        return bosKoltuklar.toString();
    }

    // Getter ve Setter metodları
    public String getModel() { return model; } // Model bilgisini döndürür
    public void setModel(String model) { this.model = model; } // Model bilgisini günceller
    public String getMarka() { return marka; } // Marka bilgisini döndürür
    public void setMarka(String marka) { this.marka = marka; } // Marka bilgisini günceller
    public String getSeriNo() { return seriNo; } // Seri numarasını döndürür
    public void setSeriNo(String seriNo) { this.seriNo = seriNo; } // Seri numarasını günceller
    public int getKoltukKapasitesi() { return koltukKapasitesi; } // Koltuk kapasitesini döndürür
    public void setKoltukKapasitesi(int koltukKapasitesi) { this.koltukKapasitesi = koltukKapasitesi; } // Koltuk kapasitesini günceller
    public Map<String, Boolean> getKoltuklar() {
        return koltuklar;
    }

    public void setKoltuklar(Map<String, Boolean> yeniKoltuklar) {
        this.koltuklar = yeniKoltuklar;
    }

    // toString metodu - Uçak bilgilerini string formatında döndürürüz
    @Override
    public String toString() {
        return "Ucak{" +
                "model='" + model + '\'' +
                ", marka='" + marka + '\'' +
                ", seriNo='" + seriNo + '\'' +
                ", koltukKapasitesi=" + koltukKapasitesi +
                '}';
    }
} 