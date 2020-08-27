package core.basesyntax.service;

import java.io.File;

public class DirCreatorImpl implements DirCreator {
    @Override
    public boolean createDir(String dirPath) {
        return new File(dirPath).mkdir();
    }
}
