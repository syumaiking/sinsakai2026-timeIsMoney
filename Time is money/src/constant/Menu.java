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
}
