package assigment1;

	import java.util.Scanner;

	public class ass1 {

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int counter = 0;
			double Total_G = 0, Total_C = 0;
			double Max = 0;
			int Max_Id=0;
			int Max_Age=0;
			while (true) {

				System.out.println("please enter person ID");// user enter id then check if id=-1 get out of loop
				int Person_Id = input.nextInt();// read the id that user enter it
				if (Person_Id == -1)// check if the id =-1 get out of loop
					break;


				System.out.println("please enter person age");//user enter age then check if age=-1 get out of loop
				int Person_Age = input.nextInt();// read the age that user enter it
				if (Person_Age == -1)// check if the age =-1 get out of loop
					break;


				System.out.println("please enter the amount of carbohydrates in gram");// user enter amount of carbohydrates then check if it =-1 get out of loop
				int Amount_Carbo = input.nextInt();// read the amount of carbohydrates that user enter it
				if (Amount_Carbo == -1)// check if the amount of carbohydrates =-1 get out of loop
					break;


				System.out.println("please enter the amount of fat in gram");// user enter amount of Fat then check if it =-1 get out of loop
				int Amount_Fat = input.nextInt();// read the amount of fat that user enter it
				if (Amount_Fat == -1)// check if the amount of fat =-1 get out of loop
					break;



				System.out.println("please enter the amount of protein in gram");// user enter amount of protein then check if it =-1 get out of loop
				int Amount_Protein = input.nextInt();// read the amount of protein that user enter it
				if (Amount_Protein == -1)// check if the amount of  protein =-1 get out of loop
					break;


				// calling function
				Total_G = Total_Grams(Amount_Carbo, Amount_Fat, Amount_Protein);
				System.out.println("The total  gram is: " +Total_G);
				Total_C = Total_Calories(Amount_Carbo, Amount_Fat, Amount_Protein);
				System.out.println("The total calories gram is :"  +Total_C);
				

				Percent_of_Calories(Amount_Carbo, Amount_Fat, Amount_Protein);
				double Protine_Energy_Ratio=(float)((Amount_Protein*1.0)/(Amount_Carbo + Amount_Fat));
				if (Protine_Energy_Ratio > Max) {
					Max = Protine_Energy_Ratio;
					Max_Id=Person_Id;
					Max_Age=Person_Age;
				}
				counter++;

			}
		
			
			System.out.println("The averge gram is: " + (Total_G / counter));// this sentence to print the averge gram
			System.out.println("The averge calories is:  " + (Total_C / counter));// this sentence to print the averge calories
			System.out.println("The ID  person who has the maximum protine energy ratio: "+ Max_Id);// this sentence to print the Id and age of  person who has the maximum protine energy ratio
			System.out.println("The Age  person who has the maximum protine energy ratio: "+ Max_Age);
		}
		
		
		
		
		

		// This method to calculate the total gram
		public static int Total_Grams(int Carbo_In_Gram, int Fat_In_Gram, int Protein_In_Gram) {
			int Total_Of_Grams;
			// calculate total gram
			Total_Of_Grams = Carbo_In_Gram + Fat_In_Gram + Protein_In_Gram;

			return Total_Of_Grams;
		}

		// this method to calculate the total calories
		public static int Total_Calories(int Carbo_In_Gram, int Fat_In_Gram, int Protein_In_Gram) {
			int Total_Of_Calories;
			// calculate total calories
			Total_Of_Calories = (Carbo_In_Gram * 4) + (Fat_In_Gram * 9) + (Protein_In_Gram * 4);
			return Total_Of_Calories;
		}

		public static void Percent_of_Calories(int Carbo_Gram, int Fat_Gram, int Protein_Gram) {
			// define variables to calculate calories of each gram of macronutrient
			float Cloria_Carb;
			float Cloria_Fat;
			float Cloria_Protine;
			float Cloria_Total;

			// define variables to calculate the percent of each calories in macronutrient
			float Cloria_Carb_Percent;
			float Cloria_Fat_Percent;
			float Cloria_Protine_Percent;
			float Protine_Energy_Ratio;

			// this sentences to find calories in each gram
			Cloria_Carb = Carbo_Gram * 4;
			Cloria_Fat = Fat_Gram * 9;
			Cloria_Protine = Protein_Gram * 4;
			Cloria_Total = Cloria_Carb + Cloria_Fat + Cloria_Protine;
			Protine_Energy_Ratio = (float) ((Protein_Gram * 1.0) / (Carbo_Gram + Fat_Gram));

			// this sentences to find percent of calories of each macronutrient
			Cloria_Carb_Percent = (Cloria_Carb / Cloria_Total) * 100;
			Cloria_Fat_Percent = (Cloria_Fat / Cloria_Total) * 100;
			Cloria_Protine_Percent = (Cloria_Protine / Cloria_Total) * 100;

			System.out.printf("the persntage of caloris in carbo=%.1f%%\n", Cloria_Carb_Percent);
			System.out.printf("the persntage of caloris in fat=%.1f%%\n", Cloria_Fat_Percent);
			System.out.printf("the persntage of caloris in protine=%.1f%%\n", Cloria_Protine_Percent);
			System.out.printf("Protein Energy Ratio=%.1f\n" ,Protine_Energy_Ratio);

		}

	}



