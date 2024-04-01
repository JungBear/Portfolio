package com.study.domain.main;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BridgeDTO {
	private String name;
	private String startPosition;
	private LocalDate date;
	private LocalTime time;
	private double congestionRate;

}
