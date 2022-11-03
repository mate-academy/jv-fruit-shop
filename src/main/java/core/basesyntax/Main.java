package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.impl.FileServiceImpl;

public class Main {

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        fileService.doTransaction();
    }
}
