package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertFileToList;
import core.basesyntax.service.Distributor;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportFromData;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ConvertFileToListImpl;
import core.basesyntax.service.impl.DistributorImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportFromDataImpl;
import core.basesyntax.service.impl.WriterImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        ConvertFileToList convertFileToList = new ConvertFileToListImpl();
        Distributor distributor = new DistributorImpl();
        ReportFromData reportFromData = new ReportFromDataImpl();
        Writer writer = new WriterImpl();
        List<String> data = reader.read("src\\main\\resources\\FileWithInputData.csv");
        List<FruitTransaction> fruitTransactions = convertFileToList.convert(data);
        distributor.distribute(fruitTransactions);
        String finalData = reportFromData.storageToString();
        writer.write(finalData,"src\\main\\resources\\FileWithRestOfFruits.csv");
    }
}
