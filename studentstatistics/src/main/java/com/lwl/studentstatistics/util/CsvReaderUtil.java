package com.lwl.studentstatistics.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lwl.studentstatistics.domain.Student;

public final class CsvReaderUtil {
	
	private CsvReaderUtil() {
		
	}

	public static List<Student> loadDataFromCSV(String fileName){
		List<Student> students = new ArrayList<Student>();
		
		try {
			List<String> data = Files.readAllLines(Paths.get(fileName));
			students = data.stream().skip(1).map(line->convertIntoStudent(line)).collect(Collectors.toList());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	
	public static Student convertIntoStudent(String line) {
		int count=0;
		String[] arr = line.split(",");
		String name = arr[count++];
		String batch=arr[count++];
		String courseStatus=arr[count++];
		String placedStatus=arr[count++];
		String qualification=arr[count++];
		float score=Float.parseFloat(arr[count++]);
		Student student = Student.builder().name(name).batch(batch).courseStatus(courseStatus).placedStatus(placedStatus).qualification(qualification).score(score).build();
		return student;
	}
}
