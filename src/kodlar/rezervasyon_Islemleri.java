package kodlar;

import java.util.*;

public class rezervasyon_Islemleri {

    // Uçuş listesi gönderilerek rezervasyon yapılır
    public static void rezervasyonYap(String dosyaYolu, List<ucus_Islemleri> ucuslar, String tcKimlik, String ad, String soyad, String ucusKodu) {
        for (ucus_Islemleri u : ucuslar) {
            if (u.ucusKodu.equalsIgnoreCase(ucusKodu)) {
                if (u.kalanKoltuk > 0) {
                    // Koltuk varsa rezervasyon yapılır
                    u.kalanKoltukAzalt();
                    String veri = tcKimlik + "," + ad + "," + soyad + "," + ucusKodu;
                    dosyaIslemleri.dosyayaEkle(dosyaYolu, veri);
                    System.out.println("Rezervasyon başarıyla yapıldı. Kalan koltuk: " + u.kalanKoltuk);
                    return;
                } else {
                    System.out.println("Bu uçuşta boş koltuk kalmamıştır.");
                    return;
                }
            }
        }
        System.out.println("Uçuş kodu bulunamadı.");
    }

    // Tüm rezervasyonları listeler
    public static void rezervasyonlariListele(String dosyaYolu) {
        List<String> satirlar = dosyaIslemleri.dosyaOku(dosyaYolu);
        System.out.println("Mevcut Rezervasyonlar:");
        for (String s : satirlar) {
            if (s.trim().isEmpty() || s.startsWith("tcKimlik")) continue;
            String[] parca = s.split(",");
            if (parca.length >= 4) {
                System.out.println("TC: " + parca[0] + " | Ad: " + parca[1] + " | Soyad: " + parca[2] + " | Uçuş: " + parca[3]);
            }
        }
    }
}
