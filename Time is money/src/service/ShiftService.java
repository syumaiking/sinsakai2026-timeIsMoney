package service;

import java.util.ArrayList;
import java.util.List;

import model.Shift;

public class ShiftService {
	private List<Shift> shifts;
	private int targetSalary;
	private int currentHourlyWage;
	private int nextId;

	public ShiftService() {
		shifts = new ArrayList<>();
		nextId = 1;
	}
}
