package com.example.JobService.Job.External;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
    Integer id;
    String title;
    String description;
    double rating;

}
