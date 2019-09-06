package beans;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate dob;

    public static Person build(Student student){
        return new Person(student.getFirstName(), student.getLastName(), student.getEmail(), student.getGender(), student.getDob());
    }
}
