package com.szymon.creditcardscsv.domain.utilities;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.szymon.creditcardscsv.domain.dao.Person;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Component
public class CsvParser {

    public ArrayList<Person> loadList() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Persons.csv"));
            return importList(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static ArrayList<Person> importList(Reader reader) {
        try (reader) {
            CsvToBean csvToBean = new CsvToBeanBuilder<>(reader)
                    .withType(Person.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return (ArrayList<Person>) csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
