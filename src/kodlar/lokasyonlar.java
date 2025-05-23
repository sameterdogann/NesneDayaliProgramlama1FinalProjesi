package kodlar;

public class lokasyonlar implements arayuz {
    private String kod;
    private String sehir;

    public lokasyonlar() {}

    public lokasyonlar(String kod, String sehir) {
        this.kod = kod;
        this.sehir = sehir;
    }

    @Override
    public void bilgileriGoster() {
        System.out.println("Lokasyon: " + kod + ", Şehir: " + sehir);
    }

    public String getKod() {
        return kod;
    }
}