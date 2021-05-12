package com.lwl.studentstatistics.service;

import java.util.List;

import com.lwl.studentstatistics.domain.Student;
import com.lwl.studentstatistics.dto.StudentBasicInfoDTO;

public interface StudentStatService {
	
	List<Student> getStudentsByQualification(String qualification);
	List<StudentBasicInfoDTO> getStudentBasicInfo();
	int getCountOfPlacedStudents();
	int getCountOfCompletedAndNotPlaced();
	int[] getCountOfPlacedNotPlaced();
	Student getStudentDetails(String name);
	Student getMaxPercentageScored();
	List<String> getStudentNames();
	
}
