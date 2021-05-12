package com.lwl.studentstatistics.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.lwl.studentstatistics.domain.Student;
import com.lwl.studentstatistics.dto.StudentBasicInfoDTO;
import com.lwl.studentstatistics.util.CsvReaderUtil;

public class StudentStatServiceImpl implements StudentStatService {

	private List<Student> students = new ArrayList<Student>();

	public StudentStatServiceImpl(String fileName) {
		students = CsvReaderUtil.loadDataFromCSV(fileName);
	}

	ModelMapper modelMapper = new ModelMapper();

	private StudentBasicInfoDTO convertToDto(Student student) {
		StudentBasicInfoDTO studentBasicInfoDTO = modelMapper.map(student, StudentBasicInfoDTO.class);
		return studentBasicInfoDTO;

	}

	@Override
	public List<Student> getStudentsByQualification(String qualification) {

		return students.stream().filter(s -> s.getQualification().equalsIgnoreCase(qualification))
				.collect(Collectors.toList());

	}

	@Override
	public List<StudentBasicInfoDTO> getStudentBasicInfo() {
		return students.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public int getCountOfPlacedStudents() {
		
		return (int) students.stream().filter(s -> "Y".equalsIgnoreCase(s.getPlacedStatus())).count();
	}

	@Override
	public int getCountOfCompletedAndNotPlaced() {
		
		return (int) students.stream()
				.filter(s -> ("N".equalsIgnoreCase(s.getPlacedStatus()) && "Y".equalsIgnoreCase(s.getCourseStatus())))
				.count();
	}

	@Override
	public int[] getCountOfPlacedNotPlaced() {
		int placed = (int) students.stream().filter(s -> "Y".equalsIgnoreCase(s.getPlacedStatus())).count();
		int notPlaced = (int) students.stream().filter(s -> "N".equalsIgnoreCase(s.getPlacedStatus())).count();
		return new int[] { placed, notPlaced };
	}

	@Override
	public Student getStudentDetails(String name) {
		return students.stream().filter(s -> name.equalsIgnoreCase(s.getName())).findAny().orElse(null);

	}

	@Override
	public Student getMaxPercentageScored() {
		return students.stream().max(Comparator.comparing(Student::getScore)).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<String> getStudentNames() {

		return students.stream().map(Student::getName).collect(Collectors.toList());
	}

}
