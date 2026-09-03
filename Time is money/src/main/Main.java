package main;

import java.util.List;

import constant.Menu;
import model.Shift;
import service.ShiftService;
import util.InputUtil;

public class Main {
	public static void main(String[] args) {
		InputUtil input = new InputUtil();
		ShiftService shiftService = new ShiftService();
		Menu menu = new Menu(input, shiftService);
		while (true) {

			menu.showMainMenu();

			int number = input.inputInt("番号を入力してください:");

			switch (number) {
			case 1: {
				menu.showShiftMenu();

				int shiftNumber = input.inputInt("番号を入力してください:");

				switch (shiftNumber) {
				case 1: {
					menu.showShiftRegistration();
					break;
				}
				case 2: {
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					break;
				}
				case 3: {
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					menu.showUpdateShift();
					break;
				}
				case 4: {
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					menu.showDeleteShift();
					break;
				}
				case 0: {
					break;
				}
				default:
					System.out.println("0~4の番号択してください");
					break;
				}
				break;
			}
			case 2: {
				menu.showSalaryMenu();

				int SalaryNumber = input.inputInt("番号を入力してください:");
				switch (SalaryNumber) {
				case 1: {
					menu.showSalary();
					break;
				}
				case 2: {
					menu.showChangeHourlyWage();
					break;
				}
				case 3: {
					menu.showTargetSalary();
					break;
				}
				case 4: {
					menu.showTargetSalaryConfirmation();
					break;
				}
				case 0: {
					break;
				}
				default:
					System.out.println("0~4の番号を入力してください");
				}
				break;
			}
			case 0: {
				System.out.println("終了");
				return;
			}
			default:
				System.out.println("0~2の番号を入力してください");
				break;
			}
		}
	}
}
