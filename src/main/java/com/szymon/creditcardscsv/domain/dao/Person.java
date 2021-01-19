package com.szymon.creditcardscsv.domain.dao;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "gender")
    private String gender;

    @CsvBindByName(column = "credit card type")
    private String creditCardType;

    @CsvBindByName(column = "credit card number")
    private String creditCardNumber;
}
