package com.lwl.studentstatistics.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lwl.studentstatistics.domain.Student;
import com.lwl.studentstatistics.dto.StudentBasicInfoDTO;

public class StudentServiceTest {

	private StudentStatService studentStatService = new StudentStatServiceImpl("src/test/resources/testdata.csv");

	@Test
	public void getAllStudentsByQualificationTest() {

		List<Student> students = studentStatService.getStudentsByQualification("MCA");
		Assertions.assertEquals(1, students.size());

	}

	@Test
	public void getStudentBasicInfoTest() {
		List<StudentBasicInfoDTO> studentBasics = studentStatService.getStudentBasicInfo();
		Assertions.assertEquals("JOHNSON", studentBasics.get(0).getName());
		Assertions.assertEquals("BE", studentBasics.get(0).getQualification());
		Assertions.assertEquals("70.0", studentBasics.get(0).getScore());
	}

	@Test
	public void getCountOfPlacedStudentsTest() {
		int countOfPlaced = studentStatService.getCountOfPlacedStudents();
		Assertions.assertEquals(10, countOfPlaced);
	}

	@Test
	public void getCountOfCompletedAndNotPlacedTest() {
		int CountOfCompletedAndNotPlaced = studentStatService.getCountOfCompletedAndNotPlaced();
		Assertions.assertEquals(0, CountOfCompletedAndNotPlaced);
	}

	@Test
	public void getCountOfPlacedNotPlacedTest() {
		int[] studentCount = studentStatService.getCountOfPlacedNotPlaced();
		Assertions.assertEquals(10, studentCount[0]);
		Assertions.assertEquals(5, studentCount[1]);
	}

	@Test
	public void getStudentDetailsTest() {
		Student student = studentStatService.getStudentDetails("WILLIAMS");
		Assertions.assertEquals("BCJ1", student.getBatch());
		Assertions.assertEquals("BE", student.getQualification());
	}

	@Test
	public void getMaxPercentageScoredTest() {
		Student student = studentStatService.getMaxPercentageScored();
		Assertions.assertEquals("WILLIAMS", student.getName());
	}

}
