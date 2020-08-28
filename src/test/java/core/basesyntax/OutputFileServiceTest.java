package core.basesyntax;

import core.basesyntax.service.InputFileService;
import core.basesyntax.service.OutputFileService;
import core.basesyntax.service.impl.InputFileServiceImpl;
import core.basesyntax.service.impl.OutputFileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class OutputFileServiceTest {
    private static OutputFileService outputFileService = new OutputFileServiceImpl();
    private static InputFileService inputFileService = new InputFileServiceImpl();
    private static Storage storage = new Storage();

//    @Test
//    public void outputFileOkTest() {
//        Transaction transaction = new Transaction()
//        storage.addFruit(new Fruit("banana, "));
//        outputFileService.writeToFile();
//    }
}
