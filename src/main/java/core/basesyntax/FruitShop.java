package core.basesyntax;

import core.basesyntax.fileservice.LocalFileParser;
import core.basesyntax.fileservice.LocalFileParserImpl;
import core.basesyntax.fileservice.LocalFileReader;
import core.basesyntax.fileservice.LocalFileReaderImpl;
import core.basesyntax.fileservice.LocalFileWriter;
import core.basesyntax.fileservice.LocalFileWriterImpl;
import core.basesyntax.fruitoperations.FruitOperationStrategy;
import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import java.util.List;

public class FruitShop {
    private Storage storage = new Storage();

    public void runFruitShop(String pathToFile) {
        Storage storage = new Storage();
        String[] path = getPath(pathToFile);
        List<FruitBatch> fruitBatchList = readAndParseFile(path);
        applyOperationOnBatch(fruitBatchList);
        writeFile(path);
    }

    private String[] getPath(String pathToFile) {
        return pathToFile.split(" ");
    }

    private List<FruitBatch> readAndParseFile(String[] path) {
        LocalFileReader fileReader = new LocalFileReaderImpl();
        LocalFileParser fileParser = new LocalFileParserImpl();
        return fileParser.parseList(fileReader.readFile(path));
    }

    private void applyOperationOnBatch(List<FruitBatch> fruitBatchList) {
        FruitOperationStrategy fruitOperation = new FruitOperationStrategy(storage);
        for (FruitBatch fruitBatch : fruitBatchList) {
            fruitOperation.applyOperationOnBatch(fruitBatch);
        }
    }

    private void writeFile(String[] path) {
        LocalFileWriter fileWriter = new LocalFileWriterImpl();
        fileWriter.writeToFile(path, storage);
    }

}
