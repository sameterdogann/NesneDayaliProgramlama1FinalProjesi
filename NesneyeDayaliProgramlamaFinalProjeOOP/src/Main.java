package kodlar;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Uçuş dosyasının yolu
        String ucusDosyasi = "src/csvDosyalari/ucuslar.csv";
        String rezervasyonDosyasi = "src/csvDosyalari/rezervasyonlar.csv";

        // Uçuşları başta yükle
        List<ucus_Islemleri> ucuslar = ucus_Islemleri.ucuslariYukle(ucusDosyasi);

        while (true) {
            System.out.println("\n1 - Uçuşları Listele");
            System.out.println("2 - Rezervasyon Yap");
            System.out.println("3 - Rezervasyonları Listele");
            System.out.println("4 - Çıkış");
            System.out.print("Seçim: ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            if (secim == 1) {

                for (ucus_Islemleri u : ucuslar) {
                    System.out.println("Uçuş Kodu: " + u.ucusKodu + ", Tarih ve Saat: " + u.tarih +
                            ", Kalkış: " + u.kalkisLokasyonu + ", Varış: " + u.varisLokasyonu +
                            ", Kalan Koltuk: " + u.kalanKoltuk);
                }

            } else if (secim == 2) {
                System.out.print("TC Kimlik Numaranız: ");
                String tc = scanner.nextLine();

                System.out.print("Adınız: ");
                String ad = scanner.nextLine();

                System.out.print("Soyadınız: ");
                String soyad = scanner.nextLine();

                System.out.print("Uçuş Kodu (Örnek: TK2320): ");
                String kod = scanner.nextLine();

                // Rezervasyon yapma metoduna 6 parametreyle çağrı
                rezervasyon_Islemleri.rezervasyonYap(rezervasyonDosyasi, ucuslar, tc, ad, soyad, kod);
            } else if (secim == 3) {
                rezervasyon_Islemleri.rezervasyonlariListele(rezervasyonDosyasi);
            } else if (secim == 4) {
                System.out.println("Programdan çıkılıyor...");
                break;
            } else {
                System.out.println("Geçersiz seçim.");
            }
        }
    }
}
