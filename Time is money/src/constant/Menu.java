package constant;

public class Menu {
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
}
