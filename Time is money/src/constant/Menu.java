package constant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import model.Shift;
import service.ShiftService;
import util.InputUtil;

public class Menu {
	public InputUtil input;
	public ShiftService shiftService;

	public Menu(InputUtil input, ShiftService shiftService) {
		this.input = input;
		this.shiftService = shiftService;
	}

	public void showMainMenu() {
		System.out.println("メインメニュー");
		System.out.println("1.勤怠管理");
		System.out.println("2.給与管理");
		System.out.println("0.終了");
	}

	public void showShiftMenu() {
		System.out.println("勤怠管理");
		System.out.println("1.登録");
		System.out.println("2.一覧");
		System.out.println("3.更新");
		System.out.println("4.削除");
		System.out.println("0.戻る");
	}

	public void showSalaryMenu() {
		System.out.println("給与管理");
		System.out.println("1.給与確認");
		System.out.println("2.時給変更");
		System.out.println("3.目標給与の設定");
		System.out.println("4.目標給料の確認");
		System.out.println("0.戻る");
	}

	public void showShiftRegistration() {
		LocalDate workDate = input.inputDate("勤務日を入力してください 例(XXXX-YY-ZZ):");
		LocalTime startTime = input.inputTime("出勤時間を入力してください 例(SS:mm):");
		LocalTime endTime = input.inputTime("退勤時間を入力してください 例(EE:mm):");
		int breakTime = input.inputInt("休憩時間を入力してください 例(BB)分");
		shiftService.addShift(workDate, startTime, endTime, breakTime);
		System.out.println("勤務実績を登録しました。");
	}

	public void showAllShift(List<Shift> shifts) {
		System.out.println("--------------------");
		for (Shift shift : shifts) {
			System.out.println("ID：" + shift.getId());
			System.out.println("勤務日：" + shift.getWorkDate());
			System.out.println("出勤時間：" + shift.getStartTime());
			System.out.println("退勤時間：" + shift.getEndTime());
			System.out.println("休憩時間：" + shift.getBreakTime() + "分");
			System.out.println("--------------------");
		}
	}

	public void showUpdateShift() {
		int id = input.inputInt("更新するIDを入力してください:");
		Shift shift = shiftService.findShiftById(id);
		if (shift == null) {
			System.out.println("入力されたIDが存在しません");
			return;
		}
		LocalDate workDate = input.inputDate("新しい勤務日を入力してください 例(XXXX-YY-ZZ):");
		LocalTime startTime = input.inputTime("新しい出勤時間を入力してください 例(SS:mm):");
		LocalTime endTime = input.inputTime("新しい退勤時間を入力してください 例(EE:mm):");
		int breakTime = input.inputInt("新しい休憩時間を入力してください 例(BB)分");
		boolean result = shiftService.updateShift(id, workDate, startTime, endTime, breakTime);
		if (result) {
			System.out.println("勤務データを更新しました");
		}
	}

	public void showDeleteShift() {
		int id = input.inputInt("削除するIDを入力してください:");
		Shift shift = shiftService.findShiftById(id);
		if (shift == null) {
			System.out.println("入力されたIDが存在しません");
			return;
		}
		boolean result = shiftService.deleteShift(id);
		if (result) {
			System.out.println("勤務データを削除しました");
		}
	}

	public void showSalary() {
		int year = input.inputInt("確認する年を入力してください 例XXXX");
		int month = input.inputInt("確認する月を入力してください 例MM");
		int salary = shiftService.calculateMonthSalary(year, month);
		System.out.println(year + "年" + month + "月の給与額は" + salary + "円です");
	}

	public void showChangeHourlyWage() {
		System.out.println("現在の時給" + shiftService.getCurrentHourlyWage() + "円");
		int hourlyWage = input.inputInt("新しい時給を入力してください:");
		if (hourlyWage == 0) {
			System.out.println("正しい金額を入力してください");
			return;
		}

		shiftService.setCurrentHourlyWage(hourlyWage);
		System.out.println("時給を" + hourlyWage + "円に変更しました");
	}

	public void showTargetSalary() {
		int year = input.inputInt("目標を設定したい年を入力してください 例XXXX:");
		int month = input.inputInt("目標を設定したい月を入力してください 例MM:");
		int targetSalary = input.inputInt("目標給与を入力してください:");
		if (month < 1 || month > 12) {
			System.out.println("1~12月の中で入力してください");
			return;
		}

		if (targetSalary == 0) {
			System.out.println("正しい給与を入力してください");
			return;
		}
		shiftService.setTargetSalary(year, month, targetSalary);
		System.out.println(year + "年" + month + "月の目標給与を" + targetSalary + "円に設定しました");
	}

	public void showTargetSalaryConfirmation() {
		int year = input.inputInt("確認したい年を入力してください 例XXXX:");
		int month = input.inputInt("確認したい月を入力してください 例MM:");

		if (month < 1 || month > 12) {
			System.out.println("1~12月の中で入力してください");
			return;
		}
		Integer targetSalary = shiftService.getTargetSalary(year, month);

		if (targetSalary == null) {
			System.out.println(year + "年" + month + "月は目標が設定されていません");
			return;
		}
		int currentSalary = shiftService.calculateMonthSalary(year, month);
		int restSalary = targetSalary - currentSalary;
		double restWorkTime = (double) restSalary / shiftService.getCurrentHourlyWage();
		int hours = (int) restWorkTime;
		int minutes = (int) ((restWorkTime - hours) * 60);

		if (restSalary > 0) {
			System.out.println("目標金額まで残り" + restSalary + "円です");
			System.out.println("残り" + hours + "時間" + minutes + "分で達成できます");
		} else {
			System.out.println("目標金額を達成しました！");
		}
	}
}
