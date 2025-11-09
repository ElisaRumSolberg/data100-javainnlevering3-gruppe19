package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class

Blogg {

    // a) Objektvariabler
    private Innlegg[] innleggtabell;
    private int nesteledig;

    public Blogg() {
        this(20);
    }

    public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
        nesteledig = 0;
    }

    public int getAntall() {
        return nesteledig;
    }

    public Innlegg[] getSamling() {
        return innleggtabell;
    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
    }

    public boolean ledigPlass() {
        return nesteledig < innleggtabell.length;

    }

    public boolean leggTil(Innlegg innlegg) {
        if (finnes(innlegg) || !ledigPlass()) {
            return false;
        }
        innleggtabell[nesteledig++] = innlegg;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesteledig).append("\n");
        for (int i = 0; i < nesteledig; i++) {
            sb.append(innleggtabell[i].toString());
        }
        return sb.toString();
    }

    // valgfrie oppgaver nedenfor

    public void utvid() {
        Innlegg[] ny = new Innlegg[Math.max(1, innleggtabell.length * 2)];
        for (int i = 0; i < nesteledig; i++) {
            ny[i] = innleggtabell[i];
        }
        innleggtabell = ny;
    }

    public boolean leggTilUtvid(Innlegg innlegg) {

        if (finnes(innlegg)) return false;
        if (!ledigPlass()) {
            utvid();
        }
        innleggtabell[nesteledig++] = innlegg;
        return true;

    }

    public boolean slett(Innlegg innlegg) {

        int idx = finnInnlegg(innlegg);
        if (idx == -1) return false;


        for (int i = idx; i < nesteledig - 1; i++) {
            innleggtabell[i] = innleggtabell[i + 1];
        }
        innleggtabell[nesteledig - 1] = null;
        nesteledig--;
        return true;
    }

    public int[] search(String keyword) {

        throw new UnsupportedOperationException(TODO.method());

    }
}