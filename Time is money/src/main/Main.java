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

			menu.showMainMenu();//メインメニュー

			int number = input.inputInt("番号を入力してください:");

			switch (number) {
			case 1: {
				menu.showShiftMenu();

				int shiftNumber = input.inputInt("番号を入力してください:");

				switch (shiftNumber) {
				case 1: {
					menu.showShiftRegistration();//勤務登録
					break;
				}
				case 2: {
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);//勤務一覧
					break;
				}
				case 3: {
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					menu.showUpdateShift();//勤務データ更新
					break;
				}
				case 4: {
					List<Shift> shifts = shiftService.getAllShifts();
					menu.showAllShift(shifts);
					menu.showDeleteShift();//勤務データ削除
					break;
				}
				case 0: {
					break;//戻る
				}
				default:
					System.out.println("0~4の番号択してください");//例外処理
					break;
				}
				break;
			}
			case 2: {
				menu.showSalaryMenu();

				int SalaryNumber = input.inputInt("番号を入力してください:");
				switch (SalaryNumber) {
				case 1: {
					menu.showSalary();//給与確認
					break;
				}
				case 2: {
					menu.showChangeHourlyWage();//時給変更
					break;
				}
				case 3: {
					menu.showTargetSalary();//給与目標の設定
					break;
				}
				case 4: {
					menu.showTargetSalaryConfirmation();//目標給料の確認
					break;
				}
				case 0: {
					break;//戻る
				}
				default:
					System.out.println("0~4の番号を入力してください");//例外
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
