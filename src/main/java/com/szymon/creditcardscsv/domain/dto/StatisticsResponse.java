package com.szymon.creditcardscsv.domain.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticsResponse {
    String name;
    int count;
}
