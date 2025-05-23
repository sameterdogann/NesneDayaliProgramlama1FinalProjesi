package kodlar;

import java.io.*;
import java.util.*;

public class dosyaIslemleri {
    public static List<String> dosyaOku(String dosyaYolu) {
        List<String> satirlar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                satirlar.add(satir.trim());
            }
        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + dosyaYolu);
        }
        return satirlar;
    }

    public static void dosyayaYaz(String dosyaYolu, List<String> veriSatirlari) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu))) {
            for (String satir : veriSatirlari) {
                writer.write(satir);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatası: " + dosyaYolu);
        }
    }

    public static void dosyayaEkle(String dosyaYolu, String yeniSatir) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu, true))) {
            writer.write(yeniSatir);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Dosyaya ekleme hatası: " + dosyaYolu);
        }
    }
}
