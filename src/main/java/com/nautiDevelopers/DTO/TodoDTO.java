package com.nautiDevelopers.DTO;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    //Constructors, Setters, Getters and toString() by LOMBOK
    // Write only those fields you want other to see.
    // This Class represents the data you want to transfer.
}
