package tests;

import beans.Student;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
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
        final Map<String, Long> genderMap = students.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));

        Assert.assertEquals(Long.valueOf(493), genderMap.get("Male"));
        Assert.assertEquals(Long.valueOf(507), genderMap.get("Female"));
    }

    @Test
    public void countFailedStudents_usingFilter() throws Exception{
        final ImmutableList<Student> students = MockData.getStudent();
        final long failedStudentCount = students
                .stream()
                .filter(student -> student.getMarks() < 33)
                .count();
        Assert.assertEquals(322, failedStudentCount);
    }

    @Test
    public void countFailedFemaleStudents_usingFilter() throws Exception{
        final ImmutableList<Student> students = MockData.getStudent();
        final long failedFemaleStudentCount = students
                .stream()
                .filter(student -> student.getGender().equalsIgnoreCase("Female"))
                .filter(student -> student.getMarks() < 33)
                .count();
        Assert.assertEquals(160, failedFemaleStudentCount);
    }

    @Test
    public void countTogetherFailedMaleAndFemaleStudents_usingGroupBy_approach1() throws Exception{
        final ImmutableList<Student> students = MockData.getStudent();
        final Map<String, List<Student>> genderMap = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

        genderMap.computeIfPresent("Male", (k,v)-> v = v.stream().filter(student -> student.getMarks() <33).collect(Collectors.toList()));
        genderMap.computeIfPresent("Female", (k,v)-> v = v.stream().filter(student -> student.getMarks() <33).collect(Collectors.toList()));

        Assert.assertEquals(162, genderMap.get("Male").size());
        Assert.assertEquals(160, genderMap.get("Female").size());
    }

    @Test
    public void countTogetherFailedMaleAndFemaleStudents_usingGroupBy_approach2() throws Exception{
        final ImmutableList<Student> students = MockData.getStudent();
        final Map<String, List<Student>> failedStudentCount = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()
                        .stream()
                        .filter(student -> student.getMarks() < 33)
                        .collect(Collectors.toList())));

        Assert.assertEquals(162, failedStudentCount.get("Male").size());
        Assert.assertEquals(160, failedStudentCount.get("Female").size());
    }
}
