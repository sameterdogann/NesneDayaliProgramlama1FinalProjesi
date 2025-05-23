package kodlar;

public class ucakDetaylari implements arayuz {
    private String ucakKodu;
    private String model;
    private int kapasite;

    public ucakDetaylari() {}

    public ucakDetaylari(String ucakKodu, String model, int kapasite) {
        this.ucakKodu = ucakKodu;
        this.model = model;
        this.kapasite = kapasite;
    }

    @Override
    public void bilgileriGoster() {
        System.out.println("Uçak: " + ucakKodu + ", Model: " + model + ", Kapasite: " + kapasite);
    }

    public String getUcakKodu() {
        return ucakKodu;
    }
}