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
					System.out.println("削除");
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
					System.out.println("給与確認");
					break;
				}
				case 2: {
					System.out.println("時給変更");
					break;
				}
				case 3: {
					System.out.println("目標給与の設定");
					break;
				}
				case 4: {
					System.out.println("目標給料の確認");
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
