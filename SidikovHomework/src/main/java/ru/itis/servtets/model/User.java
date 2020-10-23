package ru.itis.servtets.model;
import lombok.*;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer id;
}
