package core.basesyntax.readWriteFile.interfaces;

import core.basesyntax.makeTransaction.Transaction;

import java.util.List;

public interface IReadCSV {

    List<Transaction> readCSV(String pathName);
}
