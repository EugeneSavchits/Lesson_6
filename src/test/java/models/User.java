package models;


import lombok.*;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Builder
@ToString(exclude = "password")

public class User {
    private String email;
    private String password;
    }
