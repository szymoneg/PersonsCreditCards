package com.szymon.creditcardscsv.service;

import com.szymon.creditcardscsv.domain.dao.Person;
import com.szymon.creditcardscsv.domain.dto.PersonEditRequest;
import com.szymon.creditcardscsv.domain.dto.PersonRequest;
import com.szymon.creditcardscsv.domain.dto.StatisticsResponse;
import com.szymon.creditcardscsv.domain.dto.enums.PropertyType;
import com.szymon.creditcardscsv.domain.dto.enums.StatisticsType;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<Person> getById(int id);

    List<Person> getAll();

    List<Person> getByProperty(PropertyType propertyType, String query);

    Person create(PersonRequest personRequest);

    Optional<Person> update(int id, PersonEditRequest personEditRequest);

    void delete(int id);

    List<StatisticsResponse> getStatistics(StatisticsType statisticsType);

}
