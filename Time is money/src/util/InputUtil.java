package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
	private Scanner scanner;

	public InputUtil() {
		scanner = new Scanner(System.in);
	}

	public int inputInt(String message) {
		while (true) {
			try {
				System.out.println(message);
				String input = scanner.nextLine();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください");
			}
		}
	}

	public LocalDate inputDate(String message) {
		while (true) {
			try {
				System.out.println(message);
				String input = scanner.nextLine();
				return LocalDate.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("正しい日付を入力してください 例(XXXX-YY-ZZ)");
			}

		}
	}

	public LocalTime inputTime(String message) {
		while (true) {
			try {
				System.out.println(message);
				String input = scanner.nextLine();
				return LocalTime.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("正しい時間を入力してください 例(HH-MM)");
			}
		}
	}
}
