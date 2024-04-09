package core.basesyntax;

import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.WriterImpl;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> list = reader.readFile("src/main/resources/database.csv");
        Parser parser = new ParserImpl();
        String report = parser.parse(list);
        System.out.println(report);
        Writer writer = new WriterImpl();
        writer.write(report, "src/main/resources/report.csv");
    }
}
