package service;

public interface PathValidator {
    /**
     * Read data from  CSV-file and return list of lines.
     *
     * @return boolean of lines.
     */

    boolean filePathValidator(String filePath);
}
