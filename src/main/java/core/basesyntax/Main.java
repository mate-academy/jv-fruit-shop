package core.basesyntax;

import core.basesyntax.service.CreateFile;
import core.basesyntax.service.WriteDataToFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CreateFile createFile = new CreateFileImpl();
        String fileName = createFile.createFile("source.csv");
        //Write data to file source
        ArrayList<String> morningBalance = new ArrayList<>();
        Collections.addAll(morningBalance, "b,banana,200", "b,apple,100",
                "s,banana,100", "p,banana,13", "r,apple,10", "p,apple,70",
                "p,banana,5", "s,banana,60", "b,ananas,150", "s,ananas,50",
                "p,ananas,100", "r,ananas,20");
        WriteDataToFile writeDataInFile = new WriteDataInFileImpl();
        writeDataInFile
                .writeDataToFile(morningBalance, fileName);
        //read morning balance from source file
        core.basesyntax.service.ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
        String string = readDataFromFile.readDataFromFile(fileName);
        //count balance, seply, purches, reture
        core.basesyntax.service.CountFruits countFruits = new CountBalanceImpl();
        int balanceApply = countFruits.countFruit("b", string, "apple");
        int suplyApply = countFruits.countFruit("s", string, "apple");
        int purchesApply = countFruits.countFruit("p", string, "apple");
        int retureApply = countFruits.countFruit("r", string, "apple");
        int balanceBanana = countFruits.countFruit("b", string, "banana");
        int suplyBanana = countFruits.countFruit("s", string, "banana");
        int purchesBanana = countFruits.countFruit("p", string, "banana");
        int retureBanana = countFruits.countFruit("r", string, "banana");
        int balanceAnanas = countFruits.countFruit("b", string, "ananas");
        int suplyAnanas = countFruits.countFruit("s", string, "ananas");
        int purchesAnanas = countFruits.countFruit("p", string, "ananas");
        int retureAnanas = countFruits.countFruit("r", string, "ananas");
        core.basesyntax.service.CreateReport createReport = new CreateReportImpl();
        Map<String,Integer> apples = createReport.countBalanceOfFruits(
                "apple", balanceApply, suplyApply, purchesApply, retureApply);
        Map<String,Integer> ananases = createReport.countBalanceOfFruits(
                "ananas", balanceAnanas, suplyAnanas, purchesAnanas, retureAnanas);
        Map<String,Integer> bananas = createReport.countBalanceOfFruits(
                "banana", balanceBanana, suplyBanana, purchesBanana, retureBanana);
        String fileTo = createFile.createFile("result.csv");
        core.basesyntax.service.WriteReportToFile writeReportToFile = new WriteReportInFile();
        writeReportToFile.writeReportIntoFile(fileTo,apples);
        writeReportToFile.writeReportIntoFile(fileTo,ananases);
        writeReportToFile.writeReportIntoFile(fileTo,bananas);
    }
}
