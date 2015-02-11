/**
*
*  Developers:  Pradeep Jakibanjar & Scott Robertson
*
*  Affine Cipher Encryption
*
*		This code proceeds through the following steps:
*   Let n be a positive integer, and a,b be in Z/n with (a,n)=1.  Implement the affine code y = (ax + b) mod n.  Your code should:
*
* (1) Check that (a,n)=1 via the Euclidean algorithm.  Output error if they are not relatively prime.  We use the method gcd() to recursively calculate the GCD
*
* (2)Use the extended Euclidean algorithm to find the inverse c of a mod n. We use the method gcd() to recursively calculate the inverse while calculating the GCD.
*
* (3) Be able to de-crypt the original code as well via x = (c(y-b)) mod n.  After geting the inverse (c), we can easily calculate x and decrypt.  
*
*   Output will be provided via hard-copy along with this source code
**/



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class AffineCipher
{
	
	public static void main(String args[])
	{

	//Initialize variables as BigInteger to  numbers with more than 9 digits
		BigInteger a;
		BigInteger n;
		BigInteger b;
		BigInteger x;
		BigInteger y;
		BigInteger c;
		int option;  //for user input
		
// Test (a,n,b) to make sure inputs are positive, and a & b are less than n

		Scanner input = new Scanner(System.in);

			do
			{
				System.out.println("Enter only positive integers.");
				System.out.println("a and b should be less than n.");
				System.out.println("Enter the value for n(only positive integers):");
				n = input.nextBigInteger();

				System.out.println("Enter the value for a(only positive integers):");
				a = input.nextBigInteger();

				System.out.println("Enter the value for b(only positive integers):");
				b = input.nextBigInteger();
			}while ((n.compareTo(new BigInteger("0")) == -1)|| (a.compareTo(new BigInteger("0")) == -1) || (b.compareTo(new BigInteger("0")) == -1) );




//Calculate GCD and store the GCD and the Inverse into an ArrayList
		ArrayList<BigInteger> gcd = new ArrayList<BigInteger>();
		gcd = gcd(n,a,new BigInteger("0"),new BigInteger("1"),n);


//If (a,n) = 1 they are relatively prime then inverse (c) exists
//If not, an error is printed at the close of this condition
		if (gcd.get(0).compareTo(new BigInteger("1")) == 0)
		{
			c = gcd.get(1);

			System.out.println("Your values for a & n are realtively prime");

//Encrypt or Decrypt
								do
								{
									System.out.println("Enter 1 for encrypting or 2 for decrypting or 0 to quit:");
									option = input.nextInt();

									if(option == 0)
									{
										System.out.println("You quit the program.");

									}

						//Encrypt x => y
									else if(option == 1)
									{
										System.out.println("Enter the value of x you want to encrypt:");
										x = input.nextBigInteger();
										y = a.multiply(x).add(b).remainder(n);   // ( y = (ax + b) mod n ) to solve for y

								//Ensure y > 0
										if(y.compareTo(new BigInteger("0")) == -1)
										{
											do
											{
												y = y.add(n);
											}while(y.compareTo(new BigInteger("0")) == -1);
										}

										System.out.println("The encrypted value of x is y = " + y);
									}

						//Decrypt y => x
									else if(option == 2)
									{
										System.out.println("Enter the value of y you want to decrypt:");
										y = input.nextBigInteger();
										x = c.multiply(y.subtract(b)).remainder(n);  // ( x = (c(y-b)) mod n ) to solve for x
								//Ensure x > 0
										if(x.compareTo(new BigInteger("0")) == -1)
										{
											do
											{
												x = x.add(n);
											}while(x.compareTo(new BigInteger("0")) == -1);
										}

										System.out.println("The decrypted value of y is x = " + x);
									}

									else
									{
										System.out.println("Option are either 0 or 1 or 2:");
									}
								}while ((option <0) || (option > 2));

			

		}
		
//Print error message if (a,n) are not relatively prime
		else
		{
			System.out.println("a and n are not relatively prime");
			System.out.println("Program is quiting. This program is only for relatively prime numbers.");
		}

	}


//Method to calculate GCD and Inverse if it exists
//Returns an ArrayList holding the GCD at index (0) and the Inverse at index (1)
	public static ArrayList<BigInteger> gcd(BigInteger first, BigInteger second, BigInteger p1, BigInteger p2, BigInteger n)
	{
		BigInteger quioent;
		BigInteger remain;
		BigInteger pi1 = p1;  //p1 = 0;  from the initial method call from main()
		BigInteger pi2 = p2;  //p2 = 1;  from the initial method call from main()
		BigInteger inverse;

		ArrayList<BigInteger> grcd = new ArrayList<BigInteger>(); //temp ArrayList

		quioent = first.divide(second);  
		remain = first.remainder(second);

//If the last non-zero remainder occurs at step k, x has an inverse and it is pk+2
		inverse = pi1.subtract(pi2.multiply(quioent)).remainder(n);   	 //calculate the inverse ( (pi) = pi-2 - pi-1 qi-2 (mod n) ) recursively

//if the remainder = 0, the last non-zero remainder is GCD
		if (remain.compareTo(new BigInteger("0")) == 0)
		{
			grcd.add(0,second);   //insert GCD into the ArrayList at index (0)

			if(pi2.compareTo(new BigInteger("0")) == -1)  //Ensure inverse > 0
			{
				pi2 = pi2.add(n);
			}
			grcd.add(1,pi2);  //insert inverse into the ArrayList at index (1)


			return grcd;  //return ArrayList

		}

		else
		{
			return gcd(second, remain,pi2,inverse,n);  //if the remainder is not (0) recursive call gcd method until remainder = 0;
		}
	}


}

