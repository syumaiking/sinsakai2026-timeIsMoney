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
		shiftService.loadFromFile();
		Menu menu = new Menu(input, shiftService);
		while (true) {

			//メインメニュー
			menu.showMainMenu();

			int number = input.inputInt("番号を入力してください:");

			switch (number) {
			case 1: {
				menu.showShiftMenu();

				int shiftNumber = input.inputInt("番号を入力してください:");

				switch (shiftNumber) {
				case 1: {
					//勤務登録
					menu.showShiftRegistration();
					break;
				}
				case 2: {
					//勤務一覧
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					break;
				}
				case 3: {
					//勤務データ更新
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					menu.showUpdateShift();
					break;
				}
				case 4: {
					//勤務データ削除
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					menu.showDeleteShift();
					break;
				}
				case 0: {
					//戻る
					break;
				}
				default:
					//戻る
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
					//給与確認
					menu.showSalary();
					break;
				}
				case 2: {
					//時給変更
					menu.showChangeHourlyWage();
					break;
				}
				case 3: {
					//給与目標の設定
					menu.showTargetSalary();
					break;
				}
				case 4: {
					//目標給料の確認
					menu.showTargetSalaryConfirmation();
					break;
				}
				case 0: {
					//戻る
					break;
				}
				default:
					//例外
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
