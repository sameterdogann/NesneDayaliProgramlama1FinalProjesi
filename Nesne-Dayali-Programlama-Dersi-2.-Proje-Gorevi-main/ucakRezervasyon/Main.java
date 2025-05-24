import java.util.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Örnek uçak verilerimizi oluşturma
        Ucak ucak1 = new Ucak("Boeing 737", "Boeing", "SN123", 30); // Sabit koltuk sayısı
        Ucak ucak2 = new Ucak("Airbus A320", "Airbus", "SN456", 35);
        Ucak ucak3 = new Ucak("Boeing 777", "Boeing", "SN789", 40);
        Ucak ucak4 = new Ucak("Airbus A350", "Airbus", "SN101", 45);
        Ucak ucak5 = new Ucak("Boeing 787", "Boeing", "SN202", 25);
        Ucak ucak6 = new Ucak("Airbus A330", "Airbus", "SN303", 38);
        Ucak ucak7 = new Ucak("Boeing 747", "Boeing", "SN404", 42);
        Ucak ucak8 = new Ucak("Airbus A380", "Airbus", "SN505", 50);
        Ucak ucak9 = new Ucak("Boeing 737 MAX", "Boeing", "SN606", 32);
        Ucak ucak10 = new Ucak("Airbus A220", "Airbus", "SN707", 28);

        // Kaydedilmiş koltuk durumlarını yükle
        Map<String, Map<String, Boolean>> kayitliKoltuklar = DosyaIslemleri.koltukDurumuYukle();
        
        // Uçakların koltuk durumlarını güncelle
        if (kayitliKoltuklar.containsKey("SN123")) ucak1.setKoltuklar(kayitliKoltuklar.get("SN123"));
        if (kayitliKoltuklar.containsKey("SN456")) ucak2.setKoltuklar(kayitliKoltuklar.get("SN456"));
        if (kayitliKoltuklar.containsKey("SN789")) ucak3.setKoltuklar(kayitliKoltuklar.get("SN789"));
        if (kayitliKoltuklar.containsKey("SN101")) ucak4.setKoltuklar(kayitliKoltuklar.get("SN101"));
        if (kayitliKoltuklar.containsKey("SN202")) ucak5.setKoltuklar(kayitliKoltuklar.get("SN202"));
        if (kayitliKoltuklar.containsKey("SN303")) ucak6.setKoltuklar(kayitliKoltuklar.get("SN303"));
        if (kayitliKoltuklar.containsKey("SN404")) ucak7.setKoltuklar(kayitliKoltuklar.get("SN404"));
        if (kayitliKoltuklar.containsKey("SN505")) ucak8.setKoltuklar(kayitliKoltuklar.get("SN505"));
        if (kayitliKoltuklar.containsKey("SN606")) ucak9.setKoltuklar(kayitliKoltuklar.get("SN606"));
        if (kayitliKoltuklar.containsKey("SN707")) ucak10.setKoltuklar(kayitliKoltuklar.get("SN707"));

        // Örnek lokasyon verilerimizi oluşturma
        Lokasyon istanbul = new Lokasyon("Türkiye", "İstanbul", "IST", true); // İstanbul Sabiha Gökçen Havalimanı
        Lokasyon berlin = new Lokasyon("Almanya", "Berlin", "BER", true); // Berlin Brandenburg Havalimanı
        Lokasyon paris = new Lokasyon("Fransa", "Paris", "CDG", true); // Paris Charles de Gaulle Havalimanı
        Lokasyon londra = new Lokasyon("İngiltere", "Londra", "LHR", true); // Londra Heathrow Havalimanı
        Lokasyon roma = new Lokasyon("İtalya", "Roma", "FCO", true); // Roma Fiumicino Havalimanı
        Lokasyon madrid = new Lokasyon("İspanya", "Madrid", "MAD", true); // Madrid Barajas Havalimanı
        Lokasyon amsterdam = new Lokasyon("Hollanda", "Amsterdam", "AMS", true); // Amsterdam Schiphol Havalimanı
        Lokasyon viyana = new Lokasyon("Avusturya", "Viyana", "VIE", true); // Viyana Uluslararası Havalimanı
        Lokasyon atina = new Lokasyon("Yunanistan", "Atina", "ATH", true); // Atina Uluslararası Havalimanı
        Lokasyon moskova = new Lokasyon("Rusya", "Moskova", "SVO", true); // Moskova Sheremetyevo Havalimanı

        // Örnek uçuş verilerimizi oluşturma
        Ucus ucus1 = new Ucus(istanbul, berlin, LocalDateTime.of(2024, 6, 10, 10, 0), ucak1); // İstanbul-Berlin uçuşu
        Ucus ucus2 = new Ucus(paris, londra, LocalDateTime.of(2024, 6, 11, 11, 30), ucak2); // Paris-Londra uçuşu
        Ucus ucus3 = new Ucus(roma, madrid, LocalDateTime.of(2024, 6, 12, 13, 15), ucak3); // Roma-Madrid uçuşu
        Ucus ucus4 = new Ucus(amsterdam, viyana, LocalDateTime.of(2024, 6, 13, 14, 45), ucak4); // Amsterdam-Viyana uçuşu
        Ucus ucus5 = new Ucus(atina, moskova, LocalDateTime.of(2024, 6, 14, 16, 20), ucak5); // Atina-Moskova uçuşu
        Ucus ucus6 = new Ucus(berlin, paris, LocalDateTime.of(2024, 6, 15, 9, 30), ucak6); // Berlin-Paris uçuşu
        Ucus ucus7 = new Ucus(londra, roma, LocalDateTime.of(2024, 6, 16, 12, 45), ucak7); // Londra-Roma uçuşu
        Ucus ucus8 = new Ucus(madrid, amsterdam, LocalDateTime.of(2024, 6, 17, 15, 15), ucak8); // Madrid-Amsterdam uçuşu
        Ucus ucus9 = new Ucus(viyana, atina, LocalDateTime.of(2024, 6, 18, 17, 30), ucak9); // Viyana-Atina uçuşu
        Ucus ucus10 = new Ucus(moskova, istanbul, LocalDateTime.of(2024, 6, 19, 19, 45), ucak10); // Moskova-İstanbul uçuşu

        // Kullanıcı girişi için Scanner nesnesi oluşturma işlemimiz
        Scanner scanner = new Scanner(System.in);
        boolean devam = true;

        // Mevcut rezervasyonları dosyadan okuma işlemimiz
        Set<String> rezervasyonYapanlar = DosyaIslemleri.rezervasyonlariOku();

        // Ana program döngüsü - Kullanıcı çıkış yapana kadar menüyü gösteririz
        while (devam) {
            // Ana menü gösterimi
            System.out.println("\nAna Menü:");
            System.out.println("1 - Uçuşları Listele");
            System.out.println("2 - Rezervasyon Yap");
            System.out.println("3 - Uçak Bilgilerini Görüntüle");
            System.out.println("4 - Lokasyon Bilgilerini Görüntüle");
            System.out.println("5 - Uçuş Saatleri");
            System.out.println("6 - Rezervasyon Görüntüle");
            System.out.println("7 - Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = 0;
            try {
                secim = scanner.nextInt();
                scanner.nextLine(); // Buffer temizleme (Dosyayı satır satır okuyup, her satırı JSON formatına çeviriyoruz yani her satırı JSON gibi anlamaya çalışıyoruz.)
            } catch (Exception e) {
                System.out.println("Lütfen geçerli bir sayı giriniz!");
                scanner.nextLine(); // Hatalı girişi temizle
                continue;
            }

            switch (secim) { // Menü seçeneklerimize göre işlem yapma - Kullanıcının seçimine göre ilgili işlemi gerçekleştiririz
                case 1:
                    // Uçuşları listeleme
                    System.out.println("\nMevcut Uçuşlar:");
                    System.out.println("Uçuş 1:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus1.getKalkis().getUlke() + ", Şehir: " + ucus1.getKalkis().getSehir() + ", Havaalanı: " + ucus1.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus1.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus1.getVaris().getUlke() + ", Şehir: " + ucus1.getVaris().getSehir() + ", Havaalanı: " + ucus1.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus1.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus1.getUcak().getModel() + ", Marka: " + ucus1.getUcak().getMarka() + ", Seri No: " + ucus1.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus1.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 2:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus2.getKalkis().getUlke() + ", Şehir: " + ucus2.getKalkis().getSehir() + ", Havaalanı: " + ucus2.getKalkis().getHavaalani() + ", Havaalanı Adı: Charles de Gaulle, Uçuş: " + (ucus2.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus2.getVaris().getUlke() + ", Şehir: " + ucus2.getVaris().getSehir() + ", Havaalanı: " + ucus2.getVaris().getHavaalani() + ", Havaalanı Adı: Heathrow, Uçuş: " + (ucus2.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus2.getUcak().getModel() + ", Marka: " + ucus2.getUcak().getMarka() + ", Seri No: " + ucus2.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus2.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 3:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus3.getKalkis().getUlke() + ", Şehir: " + ucus3.getKalkis().getSehir() + ", Havaalanı: " + ucus3.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus3.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus3.getVaris().getUlke() + ", Şehir: " + ucus3.getVaris().getSehir() + ", Havaalanı: " + ucus3.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus3.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus3.getUcak().getModel() + ", Marka: " + ucus3.getUcak().getMarka() + ", Seri No: " + ucus3.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus3.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 4:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus4.getKalkis().getUlke() + ", Şehir: " + ucus4.getKalkis().getSehir() + ", Havaalanı: " + ucus4.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus4.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus4.getVaris().getUlke() + ", Şehir: " + ucus4.getVaris().getSehir() + ", Havaalanı: " + ucus4.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus4.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus4.getUcak().getModel() + ", Marka: " + ucus4.getUcak().getMarka() + ", Seri No: " + ucus4.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus4.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 5:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus5.getKalkis().getUlke() + ", Şehir: " + ucus5.getKalkis().getSehir() + ", Havaalanı: " + ucus5.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus5.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus5.getVaris().getUlke() + ", Şehir: " + ucus5.getVaris().getSehir() + ", Havaalanı: " + ucus5.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus5.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus5.getUcak().getModel() + ", Marka: " + ucus5.getUcak().getMarka() + ", Seri No: " + ucus5.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus5.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 6:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus6.getKalkis().getUlke() + ", Şehir: " + ucus6.getKalkis().getSehir() + ", Havaalanı: " + ucus6.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus6.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus6.getVaris().getUlke() + ", Şehir: " + ucus6.getVaris().getSehir() + ", Havaalanı: " + ucus6.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus6.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus6.getUcak().getModel() + ", Marka: " + ucus6.getUcak().getMarka() + ", Seri No: " + ucus6.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus6.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 7:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus7.getKalkis().getUlke() + ", Şehir: " + ucus7.getKalkis().getSehir() + ", Havaalanı: " + ucus7.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus7.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus7.getVaris().getUlke() + ", Şehir: " + ucus7.getVaris().getSehir() + ", Havaalanı: " + ucus7.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus7.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus7.getUcak().getModel() + ", Marka: " + ucus7.getUcak().getMarka() + ", Seri No: " + ucus7.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus7.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 8:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus8.getKalkis().getUlke() + ", Şehir: " + ucus8.getKalkis().getSehir() + ", Havaalanı: " + ucus8.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus8.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus8.getVaris().getUlke() + ", Şehir: " + ucus8.getVaris().getSehir() + ", Havaalanı: " + ucus8.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus8.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus8.getUcak().getModel() + ", Marka: " + ucus8.getUcak().getMarka() + ", Seri No: " + ucus8.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus8.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 9:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus9.getKalkis().getUlke() + ", Şehir: " + ucus9.getKalkis().getSehir() + ", Havaalanı: " + ucus9.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus9.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus9.getVaris().getUlke() + ", Şehir: " + ucus9.getVaris().getSehir() + ", Havaalanı: " + ucus9.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus9.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus9.getUcak().getModel() + ", Marka: " + ucus9.getUcak().getMarka() + ", Seri No: " + ucus9.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus9.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 10:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus10.getKalkis().getUlke() + ", Şehir: " + ucus10.getKalkis().getSehir() + ", Havaalanı: " + ucus10.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus10.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus10.getVaris().getUlke() + ", Şehir: " + ucus10.getVaris().getSehir() + ", Havaalanı: " + ucus10.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus10.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Uçak: Model: " + ucus10.getUcak().getModel() + ", Marka: " + ucus10.getUcak().getMarka() + ", Seri No: " + ucus10.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus10.getUcak().getKoltukKapasitesi());
                    try { // Thread.sleep için hata yakalama - Programın 1 saniye beklemesi sırasında oluşabilecek kesinti hatalarımızıı yakalarız
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { // Kesinti hatası yakalandığında - Eğer bekleme işlemi kesintiye uğrarsa hatayı ekrana yazdırırız
                        e.printStackTrace();
                    }
                    System.out.print("\nDevam etmek için Enter'a basın...");
                    scanner.nextLine();
                    break;
                case 2:
                    // Rezervasyon yapma işlemi için
                    boolean ucusSecimDevam = true;
                    while (ucusSecimDevam) {
                        System.out.println("\nUçuş seçiniz (1-10):");
                        System.out.println("0 - Ana Menüye Dön");
                        System.out.print("Seçiminiz: ");
                        int ucusSecim = 0;
                        try {
                            ucusSecim = scanner.nextInt();
                            scanner.nextLine(); // Buffer temizleme
                        } catch (Exception e) {
                            System.out.println("Lütfen geçerli bir sayı giriniz!");
                            scanner.nextLine(); // Hatalı girişi temizle
                            continue;
                        }

                        if (ucusSecim == 0) {
                            ucusSecimDevam = false;
                            continue;
                        }
                        
                        if (ucusSecim >= 1 && ucusSecim <= 10) {
                            // Seçilen uçuşun koltuk durumunu göster
                            Ucus secilenUcus = null;
                            switch (ucusSecim) {
                                case 1: secilenUcus = ucus1; break;
                                case 2: secilenUcus = ucus2; break;
                                case 3: secilenUcus = ucus3; break;
                                case 4: secilenUcus = ucus4; break;
                                case 5: secilenUcus = ucus5; break;
                                case 6: secilenUcus = ucus6; break;
                                case 7: secilenUcus = ucus7; break;
                                case 8: secilenUcus = ucus8; break;
                                case 9: secilenUcus = ucus9; break;
                                case 10: secilenUcus = ucus10; break;
                            }
                            
                            boolean koltukSecimDevam = true;
                            while (koltukSecimDevam) {
                                System.out.println("\nKoltuk Durumu:");
                                System.out.println(secilenUcus.getUcak().getKoltukDurumu());
                                
                                System.out.println("\nKoltuk seçiniz (örn: A1):");
                                System.out.println("0 - Uçuş Seçimine Geri Dön");
                                System.out.print("Seçiminiz: ");
                                String koltukSecim = scanner.nextLine().trim().toUpperCase();
                                
                                if (koltukSecim.equals("0")) {
                                    koltukSecimDevam = false;
                                    continue;
                                }
                                
                                if (!secilenUcus.getUcak().koltukDoluMu(koltukSecim)) {
                                    boolean bilgiGirisDevam = true;
                                    while (bilgiGirisDevam) {
                                        System.out.print("Adınız: ");
                                        String ad = scanner.nextLine();
                                        System.out.print("Soyadınız: ");
                                        String soyad = scanner.nextLine();
                                        System.out.print("Yaşınız: ");
                                        int yas = 0;
                                        try {
                                            yas = scanner.nextInt();
                                            scanner.nextLine(); // Buffer temizleme işlemimiz
                                        } catch (Exception e) {
                                            System.out.println("Lütfen geçerli bir yaş giriniz!");
                                            scanner.nextLine(); // Hatalı girişi temizleme işlemimiz
                                            continue;
                                        }
                                        
                                        // Rezervasyon kontrolü için
                                        boolean rezervasyonVar = false;
                                        String secilenUcusStr = secilenUcus.toString();
                                        
                                        // Rezervasyon kontrolü ve işlemi
                                        for (String rezervasyonYapan : rezervasyonYapanlar) {
                                            String[] bilgiler = rezervasyonYapan.split(",");
                                            if (bilgiler[0].equals(ad) && bilgiler[1].equals(soyad) && Integer.parseInt(bilgiler[2]) == yas) {
                                                if (bilgiler[3].equals(secilenUcusStr)) {
                                                    System.out.println("Bu kişi zaten bu uçuşa rezervasyon yapmış!");
                                                } else {
                                                    System.out.println("Bu kişi zaten başka bir uçuşa rezervasyon yapmış! Başka bir uçuşa rezervasyon yapamazsınız.");
                                                }
                                                rezervasyonVar = true;
                                                break;
                                            }
                                        }
                                        
                                        if (!rezervasyonVar) {
                                            if (secilenUcus.getUcak().koltukRezervasyonYap(koltukSecim)) {
                                                Rezervasyon rezervasyon = new Rezervasyon(secilenUcus, ad, soyad, yas, koltukSecim);
                                                DosyaIslemleri.rezervasyonKaydet(rezervasyon);
                                                
                                                // Koltuk durumlarını kaydet
                                                Map<String, Map<String, Boolean>> ucakKoltuklari = new HashMap<>();
                                                ucakKoltuklari.put("SN123", ucak1.getKoltuklar());
                                                ucakKoltuklari.put("SN456", ucak2.getKoltuklar());
                                                ucakKoltuklari.put("SN789", ucak3.getKoltuklar());
                                                ucakKoltuklari.put("SN101", ucak4.getKoltuklar());
                                                ucakKoltuklari.put("SN202", ucak5.getKoltuklar());
                                                ucakKoltuklari.put("SN303", ucak6.getKoltuklar());
                                                ucakKoltuklari.put("SN404", ucak7.getKoltuklar());
                                                ucakKoltuklari.put("SN505", ucak8.getKoltuklar());
                                                ucakKoltuklari.put("SN606", ucak9.getKoltuklar());
                                                ucakKoltuklari.put("SN707", ucak10.getKoltuklar());
                                                DosyaIslemleri.koltukDurumuKaydet(ucakKoltuklari);
                                                
                                                System.out.println("Rezervasyon başarılı!");
                                                bilgiGirisDevam = false;
                                                koltukSecimDevam = false;
                                                ucusSecimDevam = false;
                                                
                                                try {
                                                    Thread.sleep(1000);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                                System.out.print("\nDevam etmek için Enter'a basın...");
                                                scanner.nextLine();
                                            } else {
                                                System.out.println("Koltuk rezervasyonu yapılamadı!");
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Seçilen koltuk dolu veya geçersiz!");
                                }
                            }
                        } else {
                            System.out.println("Geçersiz uçuş seçimi!");
                        }
                    }
                    break;
                case 3:
                    // Uçak bilgilerini görüntüleme
                    System.out.println("\nUçak Bilgileri:");
                    System.out.println("Uçuş 1 Uçak: Model: " + ucus1.getUcak().getModel() + ", Marka: " + ucus1.getUcak().getMarka() + ", Seri No: " + ucus1.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus1.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 2 Uçak: Model: " + ucus2.getUcak().getModel() + ", Marka: " + ucus2.getUcak().getMarka() + ", Seri No: " + ucus2.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus2.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 3 Uçak: Model: " + ucus3.getUcak().getModel() + ", Marka: " + ucus3.getUcak().getMarka() + ", Seri No: " + ucus3.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus3.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 4 Uçak: Model: " + ucus4.getUcak().getModel() + ", Marka: " + ucus4.getUcak().getMarka() + ", Seri No: " + ucus4.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus4.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 5 Uçak: Model: " + ucus5.getUcak().getModel() + ", Marka: " + ucus5.getUcak().getMarka() + ", Seri No: " + ucus5.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus5.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 6 Uçak: Model: " + ucus6.getUcak().getModel() + ", Marka: " + ucus6.getUcak().getMarka() + ", Seri No: " + ucus6.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus6.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 7 Uçak: Model: " + ucus7.getUcak().getModel() + ", Marka: " + ucus7.getUcak().getMarka() + ", Seri No: " + ucus7.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus7.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 8 Uçak: Model: " + ucus8.getUcak().getModel() + ", Marka: " + ucus8.getUcak().getMarka() + ", Seri No: " + ucus8.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus8.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 9 Uçak: Model: " + ucus9.getUcak().getModel() + ", Marka: " + ucus9.getUcak().getMarka() + ", Seri No: " + ucus9.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus9.getUcak().getKoltukKapasitesi());
                    System.out.println("\nUçuş 10 Uçak: Model: " + ucus10.getUcak().getModel() + ", Marka: " + ucus10.getUcak().getMarka() + ", Seri No: " + ucus10.getUcak().getSeriNo() + ", Koltuk Kapasitesi: " + ucus10.getUcak().getKoltukKapasitesi());
                    try { // Thread.sleep için hata yakalama - Programın 1 saniye beklemesi sırasında oluşabilecek kesinti hatalarını yakalarız
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { // Kesinti hatası yakalandığında - Eğer bekleme işlemi kesintiye uğrarsa hatayı ekrana yazdırırız
                        e.printStackTrace();
                    }
                    System.out.print("\nDevam etmek için Enter'a basın...");
                    scanner.nextLine();
                    break;
                case 4:
                    // Lokasyon bilgilerini görüntüleme
                    System.out.println("\nLokasyon Bilgileri:");
                    System.out.println("Uçuş 1 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus1.getKalkis().getUlke() + ", Şehir: " + ucus1.getKalkis().getSehir() + ", Havaalanı: " + ucus1.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus1.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus1.getVaris().getUlke() + ", Şehir: " + ucus1.getVaris().getSehir() + ", Havaalanı: " + ucus1.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus1.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 2 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus2.getKalkis().getUlke() + ", Şehir: " + ucus2.getKalkis().getSehir() + ", Havaalanı: " + ucus2.getKalkis().getHavaalani() + ", Havaalanı Adı: Charles de Gaulle, Uçuş: " + (ucus2.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus2.getVaris().getUlke() + ", Şehir: " + ucus2.getVaris().getSehir() + ", Havaalanı: " + ucus2.getVaris().getHavaalani() + ", Havaalanı Adı: Heathrow, Uçuş: " + (ucus2.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 3 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus3.getKalkis().getUlke() + ", Şehir: " + ucus3.getKalkis().getSehir() + ", Havaalanı: " + ucus3.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus3.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus3.getVaris().getUlke() + ", Şehir: " + ucus3.getVaris().getSehir() + ", Havaalanı: " + ucus3.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus3.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 4 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus4.getKalkis().getUlke() + ", Şehir: " + ucus4.getKalkis().getSehir() + ", Havaalanı: " + ucus4.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus4.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus4.getVaris().getUlke() + ", Şehir: " + ucus4.getVaris().getSehir() + ", Havaalanı: " + ucus4.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus4.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 5 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus5.getKalkis().getUlke() + ", Şehir: " + ucus5.getKalkis().getSehir() + ", Havaalanı: " + ucus5.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus5.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus5.getVaris().getUlke() + ", Şehir: " + ucus5.getVaris().getSehir() + ", Havaalanı: " + ucus5.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus5.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 6 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus6.getKalkis().getUlke() + ", Şehir: " + ucus6.getKalkis().getSehir() + ", Havaalanı: " + ucus6.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus6.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus6.getVaris().getUlke() + ", Şehir: " + ucus6.getVaris().getSehir() + ", Havaalanı: " + ucus6.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus6.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 7 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus7.getKalkis().getUlke() + ", Şehir: " + ucus7.getKalkis().getSehir() + ", Havaalanı: " + ucus7.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus7.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus7.getVaris().getUlke() + ", Şehir: " + ucus7.getVaris().getSehir() + ", Havaalanı: " + ucus7.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus7.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 8 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus8.getKalkis().getUlke() + ", Şehir: " + ucus8.getKalkis().getSehir() + ", Havaalanı: " + ucus8.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus8.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus8.getVaris().getUlke() + ", Şehir: " + ucus8.getVaris().getSehir() + ", Havaalanı: " + ucus8.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus8.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 9 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus9.getKalkis().getUlke() + ", Şehir: " + ucus9.getKalkis().getSehir() + ", Havaalanı: " + ucus9.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus9.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus9.getVaris().getUlke() + ", Şehir: " + ucus9.getVaris().getSehir() + ", Havaalanı: " + ucus9.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus9.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("\nUçuş 10 Lokasyonları:");
                    System.out.println("Kalkış Lokasyonu: Ülke: " + ucus10.getKalkis().getUlke() + ", Şehir: " + ucus10.getKalkis().getSehir() + ", Havaalanı: " + ucus10.getKalkis().getHavaalani() + ", Havaalanı Adı: Sabiha Gökçen, Uçuş: " + (ucus10.getKalkis().isAktif() ? "Aktif" : "Pasif"));
                    System.out.println("Varış Lokasyonu: Ülke: " + ucus10.getVaris().getUlke() + ", Şehir: " + ucus10.getVaris().getSehir() + ", Havaalanı: " + ucus10.getVaris().getHavaalani() + ", Havaalanı Adı: Berlin Brandenburg, Uçuş: " + (ucus10.getVaris().isAktif() ? "Aktif" : "Pasif"));
                    try { // Thread.sleep için hata yakalama - Programın 1 saniye beklemesi sırasında oluşabilecek kesinti hatalarımzıı yakalarız
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { // Kesinti hatası yakalandığında - Eğer bekleme işlemi kesintiye uğrarsa hatayı ekrana yazdırırız
                        e.printStackTrace();
                    }
                    System.out.print("\nDevam etmek için Enter'a basın...");
                    scanner.nextLine();
                    break;
                case 5:
                    // Uçuş saatlerini görüntüleme
                    System.out.println("\nUçuş Saatleri:");
                    System.out.println("Uçuş 1 Saati: " + ucus1.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 2 Saati: " + ucus2.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 3 Saati: " + ucus3.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 4 Saati: " + ucus4.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 5 Saati: " + ucus5.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 6 Saati: " + ucus6.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 7 Saati: " + ucus7.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 8 Saati: " + ucus8.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 9 Saati: " + ucus9.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println("\nUçuş 10 Saati: " + ucus10.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    try { // Thread.sleep için hata yakalama - Programın 1 saniye beklemesi sırasında oluşabilecek kesinti hatalarımızı yakalarız.
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { // Kesinti hatası yakalandığında - Eğer bekleme işlemi kesintiye uğrarsa hatayı ekrana yazdırırız.
                        e.printStackTrace();
                    }
                    System.out.print("\nDevam etmek için Enter'a basın...");
                    scanner.nextLine();
                    break;
                case 6:
                    // Rezervasyon görüntüleme işlemi
                    boolean rezervasyonGoruntuleDevam = true;
                    while (rezervasyonGoruntuleDevam) {
                        System.out.println("\nRezervasyon Görüntüleme");
                        System.out.println("0 - Ana Menüye Dön");
                        
                        System.out.print("Adınız: ");
                        String goruntuleAd = scanner.nextLine().trim();
                        if (goruntuleAd.equals("0")) {
                            rezervasyonGoruntuleDevam = false;
                            continue;
                        }
                        
                        System.out.print("Soyadınız: ");
                        String goruntuleSoyad = scanner.nextLine().trim();
                        if (goruntuleSoyad.equals("0")) {
                            continue;
                        }
                        
                        System.out.println("\nRezervasyon bilgileriniz sorgulanıyor...");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                        String rezervasyonBilgisi = DosyaIslemleri.rezervasyonGoruntule(goruntuleAd, goruntuleSoyad);
                        System.out.println("\n" + rezervasyonBilgisi);
                        
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("\nDevam etmek için Enter'a basın...");
                        scanner.nextLine();
                        rezervasyonGoruntuleDevam = false;
                    }
                    break;
                case 7:
                    // Programdan çıkış
                    devam = false;
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default: // Geçersiz menü seçimi kontrolü - 1-7 arası olmayan bir seçim yapılmışsa uyarı veririz
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }
    }
} 