package core.basesyntax.service.serviceimpl;

import core.basesyntax.service.interfaces.CheckFilePath;

public class CheckFilePathImpl implements CheckFilePath {
    @Override
    public boolean checkFilePath(String filePath) {
        return (filePath == null || filePath.isEmpty());
    }
}
