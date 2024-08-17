package com.ind.lms.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    //@Column(name = "id")
    @Id
    private int id;
    //@Column(name = "first_name")
    private String firstName;
    //@Column(name = "last_name")
    private String lastName;

    //@Column(name = "email")
    private String email;

    //@Column(name = "isbn")
    private int isbn;

//    @Enumerated(EnumType.STRING)
  //  @Column(name = "gender")
    private Gender gender;


}
