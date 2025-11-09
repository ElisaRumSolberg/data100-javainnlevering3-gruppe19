package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

        File file = (mappe == null || mappe.isBlank())
                ? new File(filnavn)
                : new File(mappe, filnavn);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {


            String line = br.readLine();
            if (line == null) return null;

            int antall = Integer.parseInt(line.trim());
            Blogg blogg = new Blogg(antall);

            for (int i = 0; i < antall; i++) {
                String type = br.readLine();                 // TEKST eller  BILDE
                int id      = Integer.parseInt(br.readLine().trim());
                String bruker = br.readLine();
                String dato   = br.readLine();
                int likes   = Integer.parseInt(br.readLine().trim());
                String tekst = br.readLine();

                if (TEKST.equals(type)) {
                    blogg.leggTil(new Tekst(id, bruker, dato, likes, tekst));
                } else if (BILDE.equals(type)) {
                    String url = br.readLine();
                    blogg.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
                } else {

                    return null;
                }
            }

            return blogg;

        } catch (IOException | NumberFormatException e) {
            return null;
        }
    }
}
