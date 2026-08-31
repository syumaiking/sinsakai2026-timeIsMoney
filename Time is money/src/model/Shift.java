package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Shift {
	private int id;
	private LocalDate workDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private int breakTime;
	private int hourlyWage;

	public Shift(int id, LocalDate workDate, LocalTime startTime, LocalTime endTime, int breakTime, int hourlyWage) {
		this.id = id;
		this.workDate = workDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.breakTime = breakTime;
		this.hourlyWage = hourlyWage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getWorkDate() {
		return workDate;
	}

	public void setWorkDate(LocalDate workDate) {
		this.workDate = workDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public int getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(int breakTime) {
		this.breakTime = breakTime;
	}

	public int getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

}
