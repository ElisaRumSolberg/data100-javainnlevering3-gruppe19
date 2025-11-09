package no.hvl.dat100.oppgave4;


import no.hvl.dat100.oppgave3.Blogg;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        try {
            String path = (mappe == null || mappe.isBlank())
                    ? filnavn
                    : mappe + "/" + filnavn;

            try (PrintWriter pw = new PrintWriter(path)) {
                pw.print(samling.toString());
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
