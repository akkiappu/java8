package tests;

import beans.Person;
import mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TransformStudentObjToPersonObj {
    @Test
    public void transform_LengthyWay() throws Exception{
        final List<Person> personList = MockData.getStudent()
                .stream()
                .map(student -> new Person(student.getFirstName(), student.getLastName(), student.getEmail(), student.getGender(), student.getDob()))
                .collect(Collectors.toList());
        Assert.assertEquals(MockData.getStudent().size(), personList.size());
    }

    @Test
    public void transform_EasyWay() throws Exception{
        final List<Person> personList = MockData.getStudent()
                .stream()
                .map(Person::build)
                .collect(Collectors.toList());
        Assert.assertEquals(MockData.getStudent().size(), personList.size());
    }
}
