package core.basesyntax;

import core.basesyntax.filevalidatorservice.FileValidatorImpl;
import core.basesyntax.reportgeneratorservice.RecordBalance;
import core.basesyntax.reportgeneratorservice.RecordResult;

public class HelloWorld {
    public static void main(String[] args) {
        String sourceFile = "src/main/resources/filetest";
        String resultFile = "src/main/resources/result.txt";
        FileValidatorImpl fileValidator = new FileValidatorImpl();
        System.out.println(fileValidator.validateFile(sourceFile));
        RecordBalance recordBalance = new RecordBalance();
        recordBalance.recordBalance(sourceFile, resultFile);
        RecordResult recordResult = new RecordResult();
        recordResult.recordResultInFile(sourceFile, resultFile);
    }
}
