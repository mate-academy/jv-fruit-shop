package core.basesyntax.readwritefile.interfaces;

import core.basesyntax.maketransaction.Transaction;
import java.util.List;

public interface IReadCsv {

    List<Transaction> readCsv(String pathName);
}
