package main;

import constant.Menu;
import util.InputUtil;

public class Main {
	public static void main(String[] args) {

		while (true) {

			Menu menu = new Menu();
			menu.showMainMenu();

			InputUtil input = new InputUtil();
			int number = input.inputInt("番号を入力してください:");

			switch (number) {
			case 1: {
				menu.showShiftMenu();

				int shiftNumber = input.inputInt("番号を入力してください:");

				switch (shiftNumber) {
				case 1: {
					System.out.println("登録");
					break;
				}
				case 2: {
					System.out.println("一覧");
					break;
				}
				case 3: {
					System.out.println("更新");
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
