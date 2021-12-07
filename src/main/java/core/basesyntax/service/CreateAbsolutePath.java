package core.basesyntax.service;

import java.io.File;

public class CreateAbsolutePath {

    public File createFilePath(String filename) {
        File file = new File("src" + File.separator + "main"
                + File.separator + "resources" + File.separator + filename);
        return new File(file.getAbsolutePath());
    }
}
