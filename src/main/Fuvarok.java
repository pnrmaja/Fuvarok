package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Fuvarok {
    private static List<Auto> autok = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        Path path = Path.of("fuvarok.csv");
        //List<Auto> autok = new ArrayList<>();
        List<String> sorok = Files.readAllLines(path);
        for (int i = 1; i < sorok.size(); i++) {
            String sor = sorok.get(i);
            String[] s = sor.split(";");
            String rsz = s[0];
            int ido = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String fizetesiMod = s[3];
            Auto auto = new Auto(rsz, ido, osszeg, fizetesiMod);
            autok.add(auto);
        }

        for (Auto auto : autok) {
            System.out.println(
                auto.getRsz() + " " +
                auto.getIdo() + " " +
                auto.getOsszeg() + " " +
                auto.getFizetesiMod()
            );
}

        osszesFuvarErteke();
        legdragabbFuvar();
        legolcsobbFuvar();
        kartyasFizetesek();
        mindenFizetesiModMeghatarozott();
    }
    
    /*1. összes fuvar értéke
    2.legdragább fuvar rendszáma:
    3.legolcsobb fuvar forintban:
    4.hány kártyás fizetés volt:
    5. minden fizetési mód meghatározott:
    6.hány darab autó van a rendszerben:
    7.Hány féle fizetési mód van:
    8.melyik autó mennyi fuvart teljesitett:
    */
    private static void osszesFuvarErteke() {

    double osszeg = 0;

    for (Auto auto : autok) {
        osszeg += auto.getOsszeg();
    }

    System.out.println("1. Összes fuvar értéke: " + osszeg + " €");
}
    private static void legdragabbFuvar() {

    int maxIndex = 0;

    for (int i = 1; i < autok.size(); i++) {

        if (autok.get(i).getOsszeg() >
            autok.get(maxIndex).getOsszeg()) {

            maxIndex = i;
        }
    }

    System.out.println(
        "2. Legdrágább fuvar rendszáma: "
        + autok.get(maxIndex).getRsz()
    );
}
    private static void legolcsobbFuvar() {

    int minIndex = 0;

    for (int i = 1; i < autok.size(); i++) {

        if (autok.get(i).getOsszeg() <
            autok.get(minIndex).getOsszeg()) {

            minIndex = i;
        }
    }

    double arfolyam = 356.16;

    double forint =
        autok.get(minIndex).getOsszeg() * arfolyam;

    System.out.println(
        "3. Legolcsóbb fuvar forintban: "
        + forint + " Ft"
    );
}
    private static void kartyasFizetesek() {

    int db = 0;

    for (Auto auto : autok) {

        if (auto.getFizetesiMod().equals("kártya")) {
            db++;
        }
    }

    System.out.println(
        "4. Kártyás fizetések száma: " + db
    );
}
    private static void mindenFizetesiModMeghatarozott() {

    int i = 0;

    while (i < autok.size()
            && !autok.get(i)
            .getFizetesiMod()
            .equals("-")) {

        i++;
    }

    if (i < autok.size()) {

        System.out.println(
            "5. Nem minden fizetési mód meghatározott."
        );

    } else {

        System.out.println(
            "5. Minden fizetési mód meghatározott."
        );
    }
}
}