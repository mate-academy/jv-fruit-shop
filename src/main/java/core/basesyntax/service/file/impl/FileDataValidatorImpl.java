package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.FileDataValidator;

public class FileDataValidatorImpl implements FileDataValidator {
    private static final int KEY_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_NUMBER_INDEX = 2;

    @Override
    public void checkFileData(String[] fileData, String filePath) {
        int count = 0;

        for (int i = 0; i < fileData.length; ) {
            String[] fileLine = fileData[i].split(",");
            if (fileLine.length == 3) {
                if (!fileLine[KEY_INDEX].isEmpty()
                        && fileLine[KEY_INDEX].replaceAll("[bspr]", "")
                        .length() == 0
                        && !fileLine[FRUIT_NAME_INDEX].isEmpty()
                        && fileLine[FRUIT_NAME_INDEX].replaceAll("[a-z[^\\W+_]]", "")
                        .length() == 0
                        && !fileLine[FRUIT_NUMBER_INDEX].isEmpty()
                        && fileLine[FRUIT_NUMBER_INDEX].replaceAll("[\\d[^A-z\\W+]]", "")
                        .length() == 0) {
                    count++;
                }
            }
            if (count != ++i) {
                throw new RuntimeException("Invalid data in file: \"" + filePath
                        + "\" Line: " + (count + 2));
            }
        }
    }
}
