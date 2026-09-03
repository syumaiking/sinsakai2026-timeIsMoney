package service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Shift;

public class ShiftService {
	private List<Shift> shifts;
	private Map<String, Integer> targetSalaries;
	private int currentHourlyWage;
	private int nextId;

	public void addShift(LocalDate workDate, LocalTime startTime, LocalTime endTime, int breakTime) {
		Shift shift = new Shift(nextId, workDate, startTime, endTime, breakTime, currentHourlyWage);
		shifts.add(shift);
		nextId++;
	}

	public ShiftService() {
		shifts = new ArrayList<>();
		targetSalaries = new HashMap<>();
		nextId = 1;
		currentHourlyWage = 1165;
	}

	public void showInfo() {
		for (Shift shift : shifts) {
			System.out.println("ID：" + shift.getId());
			System.out.println("勤務日：" + shift.getWorkDate());
			System.out.println("出勤時間：" + shift.getStartTime());
			System.out.println("退勤時間：" + shift.getEndTime());
			System.out.println("休憩時間：" + shift.getBreakTime() + "分");
			System.out.println("--------------------");
		}
	}

	public List<Shift> getAllShifts() {
		return shifts;
	}

	public Shift findShiftById(int id) {
		for (Shift shift : shifts) {
			if (shift.getId() == id) {
				return shift;
			}
		}
		return null;
	}

	public boolean updateShift(int id, LocalDate workDate, LocalTime startTime, LocalTime endTime, int breakTime) {
		Shift shift = findShiftById(id);
		if (shift == null) {
			return false;
		}
		shift.setWorkDate(workDate);
		shift.setStartTime(startTime);
		shift.setEndTime(endTime);
		shift.setBreakTime(breakTime);

		return true;
	}

	public boolean deleteShift(int id) {
		Shift shift = findShiftById(id);

		if (shift == null) {
			return false;
		}
		shifts.remove(shift);
		return true;
	}

	public long calculateWorkTime(Shift shift) {
		long workTimes = Duration.between(shift.getStartTime(), shift.getEndTime()).toMinutes();
		workTimes -= shift.getBreakTime();
		return workTimes;
	}

	public int calculateSalary(Shift shift) {
		long workTimes = calculateWorkTime(shift);
		double salay = workTimes * shift.getHourlyWage() / 60.0;
		return (int) salay;
	}

	public int calculateMonthSalary(int year, int Month) {
		int totalSalary = 0;
		for (Shift shift : shifts) {
			if (shift.getWorkDate().getYear() == year && shift.getWorkDate().getMonthValue() == Month) {
				totalSalary += calculateSalary(shift);
			}
		}
		return totalSalary;
	}

	public int getCurrentHourlyWage() {
		return currentHourlyWage;
	}

	public void setCurrentHourlyWage(int currentHourlyWage) {
		this.currentHourlyWage = currentHourlyWage;
	}

	public void setTargetSalary(int year, int month, int targetSalary) {
		String key = year + "-" + month;

		targetSalaries.put(key, targetSalary);
	}

	public Integer getTargetSalary(int year, int month) {
		String key = year + "-" + month;

		return targetSalaries.get(key);
	}

}
