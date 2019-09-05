package beans;

import java.time.LocalDate;
import org.codehaus.jackson.annotate.JsonProperty;

public class Student{

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
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setFirstName(String firstName) {
         this.firstName = firstName;
     }
     public String getFirstName() {
         return firstName;
     }

    public void setLastName(String lastName) {
         this.lastName = lastName;
     }
     public String getLastName() {
         return lastName;
     }

    public void setEmail(String email) {
         this.email = email;
     }
     public String getEmail() {
         return email;
     }

    public void setGender(String gender) {
         this.gender = gender;
     }
     public String getGender() {
         return gender;
     }

    public void setIpAddress(String ipAddress) {
         this.ipAddress = ipAddress;
     }
     public String getIpAddress() {
         return ipAddress;
     }

    public void setDob(LocalDate dob) {
         this.dob = dob;
     }
     public LocalDate getDob() {
         return dob;
     }

    public void setMarks(int marks) {
         this.marks = marks;
     }
     public int getMarks() {
         return marks;
     }

}