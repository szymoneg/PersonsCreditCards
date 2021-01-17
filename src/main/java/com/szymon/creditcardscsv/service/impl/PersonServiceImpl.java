package com.szymon.creditcardscsv.service.impl;

import com.szymon.creditcardscsv.domain.dao.Person;
import com.szymon.creditcardscsv.domain.dto.PersonEditRequest;
import com.szymon.creditcardscsv.domain.dto.PersonRequest;
import com.szymon.creditcardscsv.domain.dto.StatisticsResponse;
import com.szymon.creditcardscsv.domain.dto.enums.PropertyType;
import com.szymon.creditcardscsv.domain.dto.enums.StatisticsType;
import com.szymon.creditcardscsv.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    ArrayList<Person> personArrayList;

    public PersonServiceImpl(){
        this.personArrayList = new ArrayList<>();
    }


    @Override
    public Optional<Person> getById(int id) {
        return personArrayList.stream().filter(person -> person.getId() == id).findFirst();
    }

    @Override
    public List<Person> getAll() {
        return personArrayList;
    }

    @Override
    public List<Person> getByProperty(PropertyType propertyType, String query) {
        List<Person> personList;
        switch (propertyType){
            case id:
                personList = personArrayList.stream().filter(person -> person.getId() == Integer.parseInt(query)).collect(Collectors.toList());
                break;
            case firstName:
                personList = personArrayList.stream().filter(person -> person.getFirstName().startsWith(query)).collect(Collectors.toList());
                break;
            case lastName:
                personList = personArrayList.stream().filter(person -> person.getLastName().startsWith(query)).collect(Collectors.toList());
                break;
            case email:
                personList = personArrayList.stream().filter(person -> person.getEmail().startsWith(query)).collect(Collectors.toList());
                break;
            case gender:
                personList = personArrayList.stream().filter(person -> person.getGender().startsWith(query)).collect(Collectors.toList());
                break;
            case creditCardType:
                personList = personArrayList.stream().filter(person -> person.getCreditCardType().startsWith(query)).collect(Collectors.toList());
                break;
            case creditCardNumber:
                personList = personArrayList.stream().filter(person -> person.getCreditCardNumber().startsWith(query)).collect(Collectors.toList());
                break;
            default:
                return Collections.emptyList();
        }
        return personList;
    }

    @Override
    public Person create(PersonRequest personRequest) {
        int index = personArrayList.isEmpty() ? 1 : (personArrayList.stream().mapToInt(Person::getId).max().getAsInt()) + 1;
        Person newPerson = Person.builder()
                .id(index)
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .email(personRequest.getEmail())
                .gender(personRequest.getGender())
                .creditCardType(personRequest.getCreditCardType())
                .creditCardNumber(personRequest.getCreditCardNumber())
                .build();
        personArrayList.add(newPerson);
        return newPerson;
    }

    @Override
    public Optional<Person> update(int id, PersonEditRequest personEditRequest) {
        return personArrayList.stream().filter(person -> person.getId() == id).peek(person -> {
            person.setFirstName(personEditRequest.getFirstName());
            person.setLastName(personEditRequest.getLastName());
            person.setGender(personEditRequest.getGender());
            person.setEmail(personEditRequest.getEmail());
            person.setCreditCardType(personEditRequest.getCreditCardType());
            person.setCreditCardNumber(personEditRequest.getCreditCardNumber());
        }).findFirst();
    }

    @Override
    public void delete(int id) {
        personArrayList.stream().filter(person -> person.getId() == id).findFirst().ifPresent(personArrayList::remove);
    }

    @Override
    public List<StatisticsResponse> getStatistics(StatisticsType statisticsType) {
        List<String> statisticsList;
        switch (statisticsType){
            case gender:
                statisticsList = personArrayList.stream().map(Person::getGender).collect(Collectors.toList());
                break;
            case creditCard:
                statisticsList = personArrayList.stream().map(Person::getCreditCardType).collect(Collectors.toList());
                break;
            default:
                statisticsList = Collections.emptyList();
        }

        Set<String> uniqueStatisticsList = new HashSet<>(statisticsList);
        Map<String, Integer> map = new HashMap<>();

        for (String key : uniqueStatisticsList){
            map.put(key, Collections.frequency(statisticsList, key));
        }

        ArrayList<StatisticsResponse> statsList = new ArrayList<>();
        map.forEach((key, value) -> statsList.add(new StatisticsResponse(key,value)));

        return statsList;
    }
}
