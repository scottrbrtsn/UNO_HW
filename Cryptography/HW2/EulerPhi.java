/**
*
*  Developers:  Pradeep Jakibanjar & Scott Robertson
*  This program calculates euler phi of a positive integer
*/

import java.util.Scanner;
import static java.lang.Math.*;

public class EulerPhi
{
	
	public static long divisor = 2;			//divisor declearing outside the main so that it can be used in methods isPrime and notPrime
	public static void main(String args[])
	{
		long number;
		long ePhi=0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a positive integer to find euler phi:");
		number = input.nextLong();			//taking input form the user

		if(number < 1)	//checking if the user input is less than 1
		{
			System.out.println(number + " is not a positive number.");
			System.out.println("This program is only for positive integer. Program is quiting."); //printing error message if the user's input is less than 1
		}

		else
		{
			ePhi = phi(number);		//gives the euler phi value of user's input by calling phi() method
			System.out.println("Euler phi of " + number + " = " + ePhi);	//printing the euler phi value of user's input
		}

	}
	//method to calculate the phi value of inserted number by recursively calling to itself if needed
	public static long phi(long n)
	{
		if(n == 0 || n == 1)	//checks if the n is 0 or 1
		{
			return 1;			//returns 1 if n is 0 or 1
		}

		if(isPrime(n) == true)	//checks if the n is prime or not by calling isPrime() method
		{
			return n-1;			//if n is prime retruns n-1;
		}

		else 
		{
			long[] result = new long[3];
			result = notPrime(n);
			return ((long)Math.pow(result[0],(result[1]-1)))*(result[0]-1)*phi(result[2]);
		}
		
	}
	
	//method to check if given number is prime or not
	public static boolean isPrime(long n)
	{
		boolean check = true;
		//loops while i = divisor to n-1
		for(int i = (int)divisor; i<n; i++)	//initilization i = divisor, so that every time will start dividing by pervious last divisor 
		{
			if(n%i == 0)		//checking if n is exactly divisible by i
			{
				check = false;	//if n is exactly divisible i it is not prime
				divisor = i;	//storing the i(which exactly divides n) into divisor so that later we can start form this number and we could use this in notPrime() method
				break;			//if n is exactly divisible by any one number it is not a prime number. so we donot need to check anymore and break the loop
			}

		}
		return check;
	}

	//method returns array which contains smallest(except 1)divisor of the number, how many times the divisor divide the number and remainder after that many divisions
	public static long[] notPrime(long n)
	{
		long[] array = new long[3];
		long count1 = 0;		//smallest divisor will be stored
		long count2 = 0;		//how many times the divisor divided n will be stored
		long count3 = 0;		//remainder after count2 division of n by count1 will be stored
		count1 = divisor;		//we know divisior will exactly divide n as we stored exactly dividing number in method isPrime()
		
		while(n%divisor == 0)	//loop until divisor exactly divides n
		{
			count2 = count2 + 1; //
			n = n/divisor;
		}
		array[0] = count1;
		array[1] = count2;
		array[2] = n;
	
		return array;
	}

}
