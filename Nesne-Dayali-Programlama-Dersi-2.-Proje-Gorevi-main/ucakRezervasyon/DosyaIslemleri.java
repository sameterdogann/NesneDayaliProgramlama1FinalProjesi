import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import java.io.File;
import java.lang.StringBuilder;

public class DosyaIslemleri {
    // Rezervasyon bilgilerini JSON formatında dosyaya kaydetme metodumuz
    public static void rezervasyonKaydet(Rezervasyon rezervasyon) {
        try {
            // Mevcut JSON dosyasını oku
            JSONArray rezervasyonlar = new JSONArray();
            try {
                JSONParser parser = new JSONParser();
                FileReader reader = new FileReader("rezervasyonlar.json");
                Object obj = parser.parse(reader);
                if (obj instanceof JSONArray) {
                    rezervasyonlar = (JSONArray) obj;
                }
                reader.close();
            } catch (Exception e) {
                // Dosya yoksa veya boşsa yeni bir JSONArray oluşturuyoruz
            }

            // Yeni rezervasyon bilgilerini JSON objesi olarak oluşturuyoruz
            JSONObject yeniRezervasyon = new JSONObject();
            yeniRezervasyon.put("ad", new String(rezervasyon.getAd().getBytes("UTF-8"), "UTF-8"));
            yeniRezervasyon.put("soyad", new String(rezervasyon.getSoyad().getBytes("UTF-8"), "UTF-8"));
            yeniRezervasyon.put("yas", rezervasyon.getYas());
            
            // Uçuş bilgilerini düzenli formatta kaydet
            Ucus ucus = rezervasyon.getUcus();
            String ucusBilgisi = String.format("%s - %s - %s - %s",
                ucus.getKalkis().getSehir() + " (" + ucus.getKalkis().getHavaalani() + ")",
                ucus.getVaris().getSehir() + " (" + ucus.getVaris().getHavaalani() + ")",
                ucus.getUcak().getModel() + " (" + ucus.getUcak().getSeriNo() + ")",
                ucus.getSaat().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            
            yeniRezervasyon.put("ucus", new String(ucusBilgisi.getBytes("UTF-8"), "UTF-8"));
            yeniRezervasyon.put("koltukNo", new String(rezervasyon.getKoltukNo().getBytes("UTF-8"), "UTF-8"));

            // Yeni rezervasyonu diziye ekle
            rezervasyonlar.add(yeniRezervasyon);

            // JSON dosyasına UTF-8 ile yaz
            try (FileWriter file = new FileWriter("rezervasyonlar.json", false)) {
                file.write(rezervasyonlar.toJSONString());
                file.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Kaydedilmiş rezervasyonları dosyadan okuma metodumuz
    public static Set<String> rezervasyonlariOku() {
        Set<String> rezervasyonlar = new HashSet<>();

        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("rezervasyonlar.json");
            Object obj = parser.parse(reader);
            
            if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;
                for (Object rezervasyonObj : jsonArray) {
                    if (rezervasyonObj instanceof JSONObject) {
                        JSONObject rezervasyon = (JSONObject) rezervasyonObj;
                        try {
                            String ad = new String(((String)rezervasyon.get("ad")).getBytes("UTF-8"), "UTF-8");
                            String soyad = new String(((String)rezervasyon.get("soyad")).getBytes("UTF-8"), "UTF-8");
                            Long yas = (Long)rezervasyon.get("yas");
                            String ucus = new String(((String)rezervasyon.get("ucus")).getBytes("UTF-8"), "UTF-8");
                            String koltukNo = new String(((String)rezervasyon.get("koltukNo")).getBytes("UTF-8"), "UTF-8");
                            
                            String rezervasyonStr = String.format("%s|%s|%d|%s|%s",
                                ad, soyad, yas.intValue(), ucus, koltukNo);
                            rezervasyonlar.add(rezervasyonStr);
                        } catch (Exception e) {
                            System.out.println("Rezervasyon verisi okunurken hata: " + e.getMessage());
                            continue;
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Rezervasyon dosyası okunurken hata: " + e.getMessage());
            return new HashSet<>();
        }
        return rezervasyonlar;
    }

    // Rezervasyon bilgilerini görüntüleme metodumuz
    public static String rezervasyonGoruntule(String ad, String soyad) {
        try {
            // Dosya var mı kontrol etme işlemimiz
            File rezervasyonDosyasi = new File("rezervasyonlar.json");
            if (!rezervasyonDosyasi.exists()) {
                return "Henüz hiç rezervasyon yapılmamış!";
            }

            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("rezervasyonlar.json");
            Object obj = parser.parse(reader);
            
            if (!(obj instanceof JSONArray)) {
                reader.close();
                return "Rezervasyon verisi geçersiz format!";
            }

            JSONArray rezervasyonlar = (JSONArray) obj;
            if (rezervasyonlar.isEmpty()) {
                reader.close();
                return "Henüz hiç rezervasyon yapılmamış!";
            }

            for (Object rezervasyonObj : rezervasyonlar) {
                if (!(rezervasyonObj instanceof JSONObject)) {
                    continue;
                }

                JSONObject rezervasyon = (JSONObject) rezervasyonObj;
                
                // Gerekli alanların varlığını kontrol etme işlemimiz
                if (!rezervasyon.containsKey("ad") || !rezervasyon.containsKey("soyad") || 
                    !rezervasyon.containsKey("yas") || !rezervasyon.containsKey("ucus") || 
                    !rezervasyon.containsKey("koltukNo")) {
                    continue;
                }

                try {
                    String kayitliAd = new String(((String)rezervasyon.get("ad")).getBytes("UTF-8"), "UTF-8");
                    String kayitliSoyad = new String(((String)rezervasyon.get("soyad")).getBytes("UTF-8"), "UTF-8");
                    String girilenAd = new String(ad.trim().getBytes("UTF-8"), "UTF-8");
                    String girilenSoyad = new String(soyad.trim().getBytes("UTF-8"), "UTF-8");
                    
                    if (kayitliAd.equals(girilenAd) && kayitliSoyad.equals(girilenSoyad)) {
                        String ucusBilgisi = new String(((String)rezervasyon.get("ucus")).getBytes("UTF-8"), "UTF-8");
                        String[] ucusBilgileri = ucusBilgisi.split(" - ");
                        
                        if (ucusBilgileri.length != 4) {
                            continue;
                        }

                        StringBuilder sonuc = new StringBuilder();
                        sonuc.append("Rezervasyon Bilgileri:\n");
                        sonuc.append("Ad: ").append(kayitliAd).append("\n");
                        sonuc.append("Soyad: ").append(kayitliSoyad).append("\n");
                        sonuc.append("Yaş: ").append(rezervasyon.get("yas")).append("\n");
                        sonuc.append("Kalkış: ").append(ucusBilgileri[0]).append("\n");
                        sonuc.append("Varış: ").append(ucusBilgileri[1]).append("\n");
                        sonuc.append("Uçak: ").append(ucusBilgileri[2]).append("\n");
                        sonuc.append("Uçuş Saati: ").append(ucusBilgileri[3]).append("\n");
                        sonuc.append("Koltuk No: ").append(rezervasyon.get("koltukNo"));

                        reader.close();
                        return sonuc.toString();
                    }
                } catch (Exception e) {
                    System.out.println("Rezervasyon verisi işlenirken hata oluştu: " + e.getMessage());
                    continue;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Rezervasyon bilgileri okunurken bir hata oluştu!";
        }
        
        return "İsminize ait rezervasyon bulunmamaktadır!";
    }

    // Koltuk durumlarını JSON formatında kaydetme işlemimiz
    public static void koltukDurumuKaydet(Map<String, Map<String, Boolean>> ucakKoltuklari) {
        try {
            JSONObject koltukDurumlari = new JSONObject();
            
            for (Map.Entry<String, Map<String, Boolean>> entry : ucakKoltuklari.entrySet()) {
                JSONObject ucakKoltuklariObj = new JSONObject();
                for (Map.Entry<String, Boolean> koltukEntry : entry.getValue().entrySet()) {
                    ucakKoltuklariObj.put(koltukEntry.getKey(), koltukEntry.getValue());
                }
                koltukDurumlari.put(entry.getKey(), ucakKoltuklariObj);
            }

            try (FileWriter file = new FileWriter("koltuk_durumlari.json", false)) {
                file.write(koltukDurumlari.toJSONString());
                file.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Koltuk durumlarını JSON dosyasından yükleme işlemimiz
    public static Map<String, Map<String, Boolean>> koltukDurumuYukle() {
        Map<String, Map<String, Boolean>> ucakKoltuklari = new HashMap<>();
        
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("koltuk_durumlari.json");
            Object obj = parser.parse(reader);
            
            if (obj instanceof JSONObject) {
                JSONObject koltukDurumlari = (JSONObject) obj;
                for (Object ucakKey : koltukDurumlari.keySet()) {
                    String ucakId = (String) ucakKey;
                    JSONObject ucakKoltuklariObj = (JSONObject) koltukDurumlari.get(ucakId);
                    Map<String, Boolean> koltuklar = new HashMap<>();
                    
                    for (Object koltukKey : ucakKoltuklariObj.keySet()) {
                        String koltukNo = (String) koltukKey;
                        Boolean durum = (Boolean) ucakKoltuklariObj.get(koltukNo);
                        koltuklar.put(koltukNo, durum);
                    }
                    
                    ucakKoltuklari.put(ucakId, koltuklar);
                }
            }
            reader.close();
        } catch (Exception e) {
            // Dosya yoksa veya hata oluşursa boş map döndürüyoruz
            return new HashMap<>();
        }
        
        return ucakKoltuklari;
    }
} 