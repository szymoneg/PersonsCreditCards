package com.szymon.creditcardscsv.domain.dto;


import com.szymon.creditcardscsv.domain.dao.Person;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonEditRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String creditCardType;
    private String creditCardNumber;

    public PersonEditRequest(Person person){
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.gender = person.getGender();
        this.creditCardNumber = person.getCreditCardNumber();
        this.creditCardType = person.getCreditCardType();
    }
}
