package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {

	// objektvariable
    private String tekst;

	
	public Tekst () {
        super();
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
        super(id, bruker, dato);
        this.tekst = tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
        super(id, bruker, dato, likes);
        this.tekst = tekst;
	}
	
	public String getTekst() {
        return tekst;

	}

	public void setTekst(String tekst) {

        this.tekst = tekst;
	}

	@Override
	public String toString() {
        // TEKST\n
        // id\n
        // bruker\n
        // dato\n
        // likes\n
        // tekst\n
        return "TEKST\n"
                + getId() + "\n"
                + getBruker() + "\n"
                + getDato() + "\n"
                + getLikes() + "\n"
                + tekst + "\n";

	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
			
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
