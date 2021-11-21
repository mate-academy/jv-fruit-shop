package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.FileDataValidator;

public class FileDataValidatorImpl implements FileDataValidator {
    @Override
    public void checkFileData(String[] fileData, String filePath) {
        int count = 0;

        for (int i = 0; i < fileData.length; ) {
            String[] fileLine = fileData[i].split(",");
            if (fileLine.length == 3) {
                if (!fileLine[0].isEmpty()
                        && fileLine[0].replaceAll("[bspr]", "").length() == 0
                        && !fileLine[1].isEmpty()
                        && fileLine[1].replaceAll("[a-z[^\\W+_]]", "").length() == 0
                        && !fileLine[2].isEmpty()
                        && fileLine[2].replaceAll("[\\d[^A-z\\W+]]", "").length() == 0) {
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
