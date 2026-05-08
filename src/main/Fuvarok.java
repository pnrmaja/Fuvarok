package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Fuvarok {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("fuvarok.csv");
        List<Auto> autok = new ArrayList<>();
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
    }
}