
/*
 * CIS 2122
 * 02/23/2020
 * A console program that takes in a Arabic numeral and converts it to a
 * Roman numeral
 * */

import java.util.Scanner;

public class ShepherdJeremyArabic2Roman {
	
	static Scanner input = new Scanner(System.in);
	
	public static int getNum() {
		int inp;
		System.out.print("Enter an integer (enter -1 to quit). ");
		inp = input.nextInt();
		return inp;
	}
	
	public static int placeValue(int num, int div) {
		return (int) Math.floor(num / div);
	}
	
	public static String romVal(int total, String rep) {
		String val = "";
		for(int i = 0; i < total; i++) {
			val += rep;
		}
		return val;
	}
	
	public static String arabicToRoman(int arabic) {
		int thousands, ninehundreds, fivehundreds, hundreds, fourhundreds, nineties, fifties, forties, tens, nines, fives, fours, ones, next;
		String roman = "";
		
		thousands = placeValue(arabic, 1000);
		roman += romVal(thousands, "M");
		next = arabic%1000;
		
		ninehundreds = placeValue(next, 900);
		roman += romVal(ninehundreds, "CM");
		next %= 900;
		
		fivehundreds = placeValue(next, 500);
		roman += romVal(fivehundreds, "D");
		next %= 500;
		
		fourhundreds = placeValue(next, 400);
		roman += romVal(fourhundreds, "CD");
		next %= 400;
		
		hundreds = placeValue(next, 100);
		roman += romVal(hundreds, "C");
		next %= 100;
		
		nineties = placeValue(next, 90);
		roman += romVal(nineties, "XC");
		next %= 90;
		
		fifties = placeValue(next, 50);
		roman += romVal(fifties, "L");
		next %= 50;
		
		forties = placeValue(next, 40);
		roman += romVal(forties, "XL");
		next %= 40;
		
		tens = placeValue(next, 10);
		roman += romVal(tens, "X");
		next %= 10;
		
		nines = placeValue(next, 9);
		roman += romVal(nines, "IX");
		next %= 9;
		
		fives = placeValue(next, 5);
		roman += romVal(fives, "V");
		next %= 5;
		
		fours = placeValue(next, 4);
		roman += romVal(fours, "IV");
		next %= 4;
		
		ones = next;
		roman += romVal(ones, "I");		
		
		return roman;
	}

	public static void main(String[] args) {
		
		// Variables
		int num;
		String output;
		
		num = getNum();
		
		while(num != -1) {
			
			//Check range parameters
			while(num < 1 || num > 3999) {
				if(num < 1) {
					System.out.println("Rpmans did not have a way to represent negative numbers or zero.");
				}
				System.out.print("Outside of range, please choose a number from 1 to 3999. ");
				num = input.nextInt();
				
				//Ensure the ability to exit even inside the inner loop
				if(num == -1) {					
					System.out.println("Goodby-ee!");
					System.exit(0);
				}
			}
			
			output = arabicToRoman(num);
			
			System.out.println(output);
			
			num = getNum();
			
		}
		input.close();
		System.out.println("Goodbye!");

	}

}

