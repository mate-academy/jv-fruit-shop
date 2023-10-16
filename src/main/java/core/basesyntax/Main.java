package core.basesyntax;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.Impl.FileWriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.write("salty", null);
    }
}
