# 🛫 Uçak Bilet Rezervasyon Sistemi

Bu proje, uçak bileti rezervasyonu için konsol tabanlı bir sistemdir. Kullanıcılar uçuşları listeleyebilir, kendi bilgileriyle rezervasyon oluşturabilir ve daha önce yapılan rezervasyonları görüntüleyebilirler.

## 👨‍💻 Proje Sahibi

- ****Ad Soyad:**** Samet ERDOĞAN

- ****Öğrenci Numarası:**** 20230108039

- ****Bölüm:**** Bilgisayar Programcılığı

- ****Ders Adı:**** Nesneye Dayalı Programlama 1

- ****Ders Kodu:**** BIP1026

- ****Öğretim Görevlisi:**** Emrah SARIÇİÇEK

- ****Teslim Tarihi:**** 25/05/2025

## 📌 Proje Hakkında

Bu Java uygulaması, uçuş ve rezervasyon yönetimini simüle eden bir sistemdir. Uçuşlar ve rezervasyonlar CSV dosyalarında saklanır. Sistem başlangıçta tüm uçuşları yükler ve kullanıcıya dört temel işlem sunar:

- Uçuşları listeleme

- Rezervasyon yapma

- Rezervasyonları listeleme

- Programdan çıkış

### Başlangıç Verileri:

- `ucuslar.csv`: 3-5 adet önceden tanımlı uçuş

- `rezervasyonlar.csv`: Rezervasyon kayıtlarının tutulduğu dosya

## 🚀 Özellikler

### ✈️ Uçuş Listeleme

Tüm uçuşlar `ucuslar.csv` dosyasından okunur ve kalkış-varış, tarih, uçuş kodu ve kalan koltuk bilgileri ile listelenir.

### 🧾 Rezervasyon Yapma

Kullanıcıdan TC Kimlik Numarası, ad, soyad ve uçuş kodu alınarak `rezervasyonlar.csv` dosyasına yeni kayıt eklenir.

### 📋 Rezervasyon Listeleme

Mevcut rezervasyonlar `rezervasyonlar.csv` dosyasından okunarak listelenir.

### 🧠 Hata Kontrolleri

Geçersiz girişler veya uçuş kodu bulunamazsa kullanıcıya uygun uyarılar gösterilir.

## ⚙️ Gereksinimler

- Java 8 veya üzeri

- Tavsiye Edilen IDE : IntelliJ IDEA

- `src/csvDosyalari/` dizininde uçuş ve rezervasyon CSV dosyaları

## ▶️ Nasıl Çalıştırılır?

1. Bu repoyu klonlayın veya indirin:

Projeyi bir Java IDE'sinde açın (tavsiyem:IntelliJ IDEA).

src/csvDosyalari/ucuslar.csv ve rezervasyonlar.csv dosyalarının mevcut olduğundan emin olun.

Zip olarak indirdiyseniz veya klonladıysanız 'src' klasörünün içindeki kodlar klasörüne girin onun içindeki Main.java dosyasını çalıştırın ve konsoldan işlemleri yönetin.

✅ Örnek Kullanım

1 - Uçuşları Listele

2 - Rezervasyon Yap

3 - Rezervasyonları Listele

4 - Çıkış

Seçim: 2

TC Kimlik Numaranız: 12345678901

Adınız: SAMET

Soyadınız: ERDOĞAN

Uçuş Kodu (Örnek: TK2320): TK2320

Rezervasyon başarıyla oluşturuldu!
