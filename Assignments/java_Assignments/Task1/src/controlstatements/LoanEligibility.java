package controlstatements;


	import java.util.Scanner;

	public class LoanEligibility {

		public static void main(String[] args) {
			
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter the credit score: ");
					int creditscore=sc.nextInt();
					System.out.println("Enter the annual income: ");
					double annualincome=sc.nextDouble();
					if(creditscore>700 && annualincome>=50000) {
						System.out.println("Congratulations! You are eligible for the loan");
					}
					else {
						System.out.println("Sorry! You are not eligible for the loan");
					}
					

				}

			


		}





