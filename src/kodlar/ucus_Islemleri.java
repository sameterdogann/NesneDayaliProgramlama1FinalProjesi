package kodlar;

import java.util.*;

// Soyut (abstract) sınıf - temel uçuş özelliklerini içerir
abstract class ucus_Islemleri_Base {
    public String ucusKodu;
    public String ucakKodu;
    public String kalkisLokasyonu;
    public String varisLokasyonu;
    public String tarih;
    public int kalanKoltuk;

    public ucus_Islemleri_Base(String ucusKodu, String ucakKodu, String kalkisLokasyonu,
                               String varisLokasyonu, String tarih, int kalanKoltuk) {
        this.ucusKodu = ucusKodu;
        this.ucakKodu = ucakKodu;
        this.kalkisLokasyonu = kalkisLokasyonu;
        this.varisLokasyonu = varisLokasyonu;
        this.tarih = tarih;
        this.kalanKoltuk = kalanKoltuk;
    }

    // Kalan koltuk sayısını 1 azaltır
    public void kalanKoltukAzalt() {
        if (kalanKoltuk > 0) {
            kalanKoltuk--;
        }
    }

    // Soyut metod: her uçuş bilgisi gösteriminde farklılık olabilir
    public abstract void bilgileriGoster();
}

// Uçuş işlemleri sınıfı, soyut sınıftan türetilir ve arayüzü uygular
public class ucus_Islemleri extends ucus_Islemleri_Base implements arayuz {

    public ucus_Islemleri(String ucusKodu, String ucakKodu, String kalkisLokasyonu,
                          String varisLokasyonu, String tarih, int kalanKoltuk) {
        super(ucusKodu, ucakKodu, kalkisLokasyonu, varisLokasyonu, tarih, kalanKoltuk);
    }

    // Dosyadan uçuşları yükler ve uçuş listesi olarak döner
    public static List<ucus_Islemleri> ucuslariYukle(String dosyaYolu) {
        List<ucus_Islemleri> ucuslar = new ArrayList<>();
        List<String> satirlar = dosyaIslemleri.dosyaOku(dosyaYolu);

        for (String satir : satirlar) {
            if (satir.trim().isEmpty() || satir.startsWith("ucusKodu")) continue;

            try {
                String[] parca = satir.split(",");
                if (parca.length != 6) continue;

                String ucusKodu = parca[0].trim();
                String ucakKodu = parca[1].trim();
                String kalkis = parca[2].trim();
                String varis = parca[3].trim();
                String tarih = parca[4].trim();
                int koltuk = Integer.parseInt(parca[5].trim());

                ucuslar.add(new ucus_Islemleri(ucusKodu, ucakKodu, kalkis, varis, tarih, koltuk));
            } catch (Exception e) {
                System.out.println("Satır okunamadı: " + satir);
            }
        }

        return ucuslar;
    }

    // Uçuş bilgilerini ekrana yazdırır
    @Override
    public void bilgileriGoster() {
        System.out.println("Uçuş Kodu: " + ucusKodu);
        System.out.println("Uçak Kodu: " + ucakKodu);
        System.out.println("Kalkış Lokasyonu: " + kalkisLokasyonu);
        System.out.println("Varış Lokasyonu: " + varisLokasyonu);
        System.out.println("Tarih: " + tarih);
        System.out.println("Kalan Koltuk: " + kalanKoltuk);
        System.out.println("-------------------------");
    }
}
