package core.basesyntax;

import core.basesyntax.files.FileReader;

public class Main {
    private static final String FILE_NAME = "path";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        fileReader.getLinesFromCsv(FILE_NAME);

        // TODO: logic part
        // 1. read file
        // 2. put in storage
        // 3. operate storage data ?? and return new db or just array ??
        // 4. create report

    }

}
