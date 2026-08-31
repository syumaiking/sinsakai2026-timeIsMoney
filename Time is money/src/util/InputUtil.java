package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class InputUtil {
	public int inputInt(String message) {
		System.out.println(message);
		int number = Scanner.nextInt();
		return number;
	}

	public LocalDate inputDate(String message) {
		System.out.println(message);
		String input = Scanner.nextLine();
		LocalDate date = LocalDate.parse(input);
		return date;
	}

	public LocalTime inputTime(String message) {
		System.out.println(message);
		String input = Scanner.nextLine();
		LocalTime time = LocalTime.parse(input);
		return time;
	}
}
