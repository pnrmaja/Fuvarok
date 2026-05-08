package main;

public class Auto {

    private String rsz;
    private int ido;
    private double osszeg;
    private String fizetesiMod;

    public Auto(String rsz, int ido, double osszeg, String fizetesiMod) {
        this.rsz = rsz;
        this.ido = ido;
        this.osszeg = osszeg;
        this.fizetesiMod = fizetesiMod;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdo() {
        return ido;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizetesiMod() {
        return fizetesiMod;
    }

    

}