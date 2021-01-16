package com.szymon.creditcardscsv.domain.dto;


import com.szymon.creditcardscsv.domain.dto.enums.PropertyType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SearchRequest {
    PropertyType propertyType;
    String value;
}
