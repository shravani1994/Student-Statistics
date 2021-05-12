package com.lwl.studentstatistics.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lwl.studentstatistics.domain.Student;
import com.lwl.studentstatistics.util.CsvReaderUtil;

public class CSVReaderUtilTest {
	
	private String fileName = "src/test/resources/testdata.csv";
	
	@Test
	public void loadStudentsFromCSVFile() {
		
		List<Student> students = CsvReaderUtil.loadDataFromCSV(fileName);
		students.forEach(s->{
			System.out.println(s.getName());
		});
		Assertions.assertEquals(15, students.size());
	}

}
