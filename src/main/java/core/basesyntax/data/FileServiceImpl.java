package core.basesyntax.data;

import core.basesyntax.data.csv.FileReader;
import core.basesyntax.data.csv.FileWriter;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;

import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private final FileWriter fileWriter;
    private final FileReader fileReader;

    public FileServiceImpl(FileWriter fileWriter, FileReader fileReader) {
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
    }

    @Override
    public void saveReport(List<FruitResultingRow> resultingRows) {
        fileWriter.writeAll(resultingRows.stream().map(FruitResultingRow::toCsv).collect(Collectors.toList()));
    }

    @Override
    public List<FruitTransactionRow> getTransactions() {
        return fileReader.readAll().stream().map(FruitTransactionRow::of).toList();
    }
}
