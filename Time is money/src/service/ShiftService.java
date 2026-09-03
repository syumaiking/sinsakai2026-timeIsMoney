package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Shift;

public class ShiftService {
	private List<Shift> shifts;
	private int targetSalary;
	private int currentHourlyWage;
	private int nextId;

	public void addShift(LocalDate workDate, LocalTime startTime, LocalTime endTime, int breakTime) {
		Shift shift = new Shift(nextId, workDate, startTime, endTime, breakTime, currentHourlyWage);
		shifts.add(shift);
		nextId++;
	}

	public ShiftService() {
		shifts = new ArrayList<>();
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

}
