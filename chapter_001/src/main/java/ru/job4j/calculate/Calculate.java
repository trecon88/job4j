package ru.job4j.calculate;

/**
 * Class Класс для вывода строки "Hello World".
 * @author contre
 * @since 07.09.2018
 * @version 1
*/
public class Calculate {
	/**
	 * Main.
	 * @param args - args.
	*/
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
	
}