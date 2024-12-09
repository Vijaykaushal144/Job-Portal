package com.example.JobService.Job.Entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int jid;
    String title;
    String description;
    int minSalary;
    int maxSalary;
    String location;
    int companyId;


}
