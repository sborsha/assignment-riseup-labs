package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCostDataSet {
    @DataProvider(name = "AddCostData")
    public Object[][] getCSVData() throws IOException {
        String filePath="./src/test/resources/addCost.csv";
        List<Object[]> data=new ArrayList<>();
        CSVParser csvParser=new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for(CSVRecord csvRecord: csvParser){

            String name = csvRecord.get("name");
            String amount = csvRecord.get("amount");
            int quantity = Integer.parseInt(csvRecord.get("quantity"));
            String date = csvRecord.get("purchase_date");
            String month = csvRecord.get("month");
            String remark = csvRecord.get("remarks");



            data.add(new Object[]{name,amount,quantity,date,month,remark});
        }
        return data.toArray(new Object[0][]);
    }

}
