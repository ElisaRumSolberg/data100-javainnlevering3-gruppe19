package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

    public HtmlBlogg() {
        super();
    }

    private static final String HTMLPREFIX =
            "<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";

    private static final String HTMLPOSTFIX =
            "\t</body>\n</html>\n";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HTMLPREFIX);
        for (int i = 0; i < getAntall(); i++) {
            sb.append("\t\t")
                    .append(getSamling()[i].toHTML())
                    .append("<hr>\n");
        }
        sb.append(HTMLPOSTFIX);
        return sb.toString();
    }
}
