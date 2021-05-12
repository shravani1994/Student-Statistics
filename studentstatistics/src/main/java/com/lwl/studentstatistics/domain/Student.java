package com.lwl.studentstatistics.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString


public class Student {
	private String name;
	private String batch;
	private String courseStatus;
	private String placedStatus;
	private String qualification;
	private float score;
}
