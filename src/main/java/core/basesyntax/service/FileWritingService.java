package core.basesyntax.service;

import java.io.File;

public interface FileWritingService {
    File writeFile(String fileName, String data);
}
