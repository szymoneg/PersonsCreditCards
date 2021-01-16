package com.szymon.creditcardscsv.domain.dao;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String creditCardType;
    private String creditCardNumber;
}
