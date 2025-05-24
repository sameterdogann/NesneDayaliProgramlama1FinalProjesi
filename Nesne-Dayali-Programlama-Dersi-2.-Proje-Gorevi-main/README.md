# Uçak Rezervasyon Sistemi

Bu proje, Java programlama dili kullanılarak geliştirilmiş bir uçak rezervasyon sistemidir. Sistem, kullanıcıların uçuş seçimi yapmasına, koltuk rezervasyonu yapmasına ve mevcut rezervasyonlarını görüntülemesine olanak sağlar.

## Özellikler

- Uçuş listesi görüntüleme
- Koltuk rezervasyonu yapma
- Uçak bilgilerini görüntüleme
- Lokasyon bilgilerini görüntüleme
- Uçuş saatlerini görüntüleme
- Rezervasyon görüntüleme
- Türkçe karakter desteği
- JSON formatında veri saklama
- Koltuk durumlarını kalıcı olarak saklama

## Sistem Gereksinimleri

- Java JDK 8 veya üzeri
- org.json.simple kütüphanesi

## Proje Yapısı

Proje aşağıdaki ana sınıflardan oluşmaktadır:

### 1. Main.java
Ana program sınıfı. Kullanıcı arayüzünü ve program akışını yönetir.

#### Önemli Özellikleri:
- 10 farklı uçak örneği
- 10 farklı lokasyon
- 10 farklı uçuş rotası
- Menü sistemi
- Kullanıcı girişi yönetimi

#### Menü Seçeneklerimiz:
1. Uçuşları Listele
2. Rezervasyon Yap
3. Uçak Bilgilerini Görüntüle
4. Lokasyon Bilgilerini Görüntüle
5. Uçuş Saatleri
6. Rezervasyon Görüntüle
7. Çıkış

### 2. Ucak.java
Uçak bilgilerini ve koltuk yönetimini içeren sınıf.

#### Özellikler:
- Model bilgisi
- Marka bilgisi
- Seri numarası
- Koltuk kapasitesi
- Koltuk durumu yönetimi

#### Metodlarımız:
- `koltuklariOlustur()`: Uçağın koltuklarını oluşturur
- `koltukDoluMu()`: Koltuk doluluk durumunu kontrol eder
- `koltukRezervasyonYap()`: Koltuk rezervasyonu yapar
- `getKoltukDurumu()`: Tüm koltukların durumunu gösterir
- `getBosKoltuklar()`: Boş koltukları listeler

### 3. DosyaIslemleri.java
Dosya işlemlerini yöneten sınıf.

#### Özellikler:
- JSON formatında veri saklama
- UTF-8 karakter kodlaması desteği
- Rezervasyon kaydetme ve okuma
- Koltuk durumlarını kaydetme ve yükleme

#### Metodlarımız:
- `rezervasyonKaydet()`: Yeni rezervasyonu JSON dosyasına kaydeder
- `rezervasyonlariOku()`: Kaydedilmiş rezervasyonları okur
- `rezervasyonGoruntule()`: Belirli bir kişinin rezervasyonunu görüntüler
- `koltukDurumuKaydet()`: Koltuk durumlarını JSON dosyasına kaydeder
- `koltukDurumuYukle()`: Kaydedilmiş koltuk durumlarını yükler

## Veri Yapıları

### Rezervasyon Bilgileri (JSON Formatı):
```json
{
    "ad": "Kullanıcı Adı",
    "soyad": "Kullanıcı Soyadı",
    "yas": 25,
    "ucus": "Kalkış - Varış - Uçak Bilgisi - Uçuş Saati",
    "koltukNo": "A1"
}
```

### Koltuk Durumları (JSON Formatı):
```json
{
    "UçakSeriNo": {
        "A1": true,
        "A2": false,
        ...
    }
}
```

## Kullanım

1. Program başlatıldığında ana menü görüntülenir
2. İstenilen işlem için menüden seçim yapılır
3. Rezervasyon yapmak için:
   - Uçuş seçilir
   - Koltuk seçilir
   - Kişisel bilgiler girilir
4. Rezervasyon görüntülemek için:
   - Ad ve soyad girilir
   - Sistem otomatik olarak rezervasyon bilgilerini gösterir

## Hata Yönetimi

- Geçersiz menü seçimleri kontrol edilir
- Koltuk doluluk durumu kontrol edilir
- Dosya okuma/yazma hataları yönetilir
- Türkçe karakter dönüşümleri kontrol edilir

## Güvenlik Özellikleri

- UTF-8 karakter kodlaması kullanılır
- Dosya işlemleri try-catch blokları ile korunur
- Veri doğrulama kontrolleri yapılır

## Geliştirme Notları

- Tüm sınıflar arası iletişim Java nesneleri üzerinden yapılır
- Veri kalıcılığı JSON dosyaları ile sağlanır
- Kullanıcı arayüzü konsol tabanlıdır