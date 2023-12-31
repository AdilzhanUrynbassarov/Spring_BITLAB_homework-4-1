package com.homework.homework41.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    private Long id;
    private String name;
    private String deadlineDate;
    boolean isCompleted;
}
