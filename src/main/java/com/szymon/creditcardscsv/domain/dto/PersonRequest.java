package com.szymon.creditcardscsv.domain.dto;

import com.szymon.creditcardscsv.domain.dao.Person;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String creditCardType;
    private String creditCardNumber;

    public PersonRequest(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.gender = person.getGender();
        this.creditCardNumber = person.getCreditCardNumber();
        this.creditCardType = person.getCreditCardType();
    }
}
