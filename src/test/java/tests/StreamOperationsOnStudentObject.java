package tests;

import beans.Student;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperationsOnStudentObject {
    @Test
    public void countMaleStudents_usingFilter() throws Exception{
        final ImmutableList<Student> students = MockData.getStudent();
        final long male = students.stream().filter(student -> student.getGender().equalsIgnoreCase("Male")).count();
        Assert.assertEquals(493, male);
    }

    @Test
    public void countTogetherMaleAndFemaleStudents_usingGroupBy() throws Exception{
        final ImmutableList<Student> students = MockData.getStudent();
        final Map<String, Long> genderMap = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        Assert.assertEquals(Long.valueOf(493), genderMap.get("Male"));
        Assert.assertEquals(Long.valueOf(507), genderMap.get("Female"));
    }
}
