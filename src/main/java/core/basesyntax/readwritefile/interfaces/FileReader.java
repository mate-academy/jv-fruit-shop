package core.basesyntax.readwritefile.interfaces;

import core.basesyntax.maketransaction.Transaction;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {

    List<Transaction> readCsv(String pathName) throws FileNotFoundException;
}
