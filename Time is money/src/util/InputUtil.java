package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class InputUtil {
	private Scanner scanner;

	public InputUtil() {
		scanner = new Scanner(System.in);
	}

	public int inputInt(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		return Integer.parseInt(input);
	}

	public LocalDate inputDate(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		LocalDate date = LocalDate.parse(input);
		return date;
	}

	public LocalTime inputTime(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		LocalTime time = LocalTime.parse(input);
		return time;
	}
}
