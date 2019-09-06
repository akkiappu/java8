package beans;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
public class Student {

    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String gender;
    @JsonProperty("ip_address")
    private String ipAddress;

    private LocalDate dob;
    private int marks;
}