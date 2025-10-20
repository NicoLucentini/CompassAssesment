package org.lucentininicolas;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class CsvImporter {
   public static <T> List<T> readFile(String path, Class<T> type){

        try (Reader reader = new FileReader(path)) {
            List<T> data = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();

            return  data;
        }
        catch (Exception e){
            return List.of();
        }
    }
}
