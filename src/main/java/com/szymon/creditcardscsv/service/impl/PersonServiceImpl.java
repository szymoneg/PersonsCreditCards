package com.szymon.creditcardscsv.service.impl;

import com.szymon.creditcardscsv.domain.dao.Person;
import com.szymon.creditcardscsv.domain.dto.PersonEditRequest;
import com.szymon.creditcardscsv.domain.dto.PersonRequest;
import com.szymon.creditcardscsv.domain.dto.StatisticsResponse;
import com.szymon.creditcardscsv.domain.dto.enums.PropertyType;
import com.szymon.creditcardscsv.domain.dto.enums.StatisticsType;
import com.szymon.creditcardscsv.service.PersonService;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    @Override
    public Optional<Person> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> getByProperty(PropertyType propertyType, String query) {
        return null;
    }

    @Override
    public Person create(PersonRequest personRequest) {
        return null;
    }

    @Override
    public Optional<Person> update(int id, PersonEditRequest personEditRequest) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<StatisticsResponse> getStatistics(StatisticsType statisticsType) {
        return null;
    }
}
