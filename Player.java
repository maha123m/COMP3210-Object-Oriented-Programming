package ass2;
import java.util.Scanner;

public class Player {
	private String name;
	private int age;
	private double height;
	public static Player[][] theTeam;

	public final static double[][]randomNum= {
			{2,3,1,5,9,8,4,7,6},//index0
			{1.8,2.5,-2.9,-1.5,1.3,1.4,2.9,3.6,4.5},//index1
			{30,45,60,90,180,270,135,180,0},//index2
			{2,4,8,16,32,64,128,256,512}//index3
	};

	Player(){// constructor with no argument
	}

	Player(String name,int age,double height){//constructor with the argument
		this.name=name;
		this.age=age;
		this.height=height;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public static void defineTeam(int K){
		theTeam = new Player[K][];
	}


	// this method to find the average height of all players
	public static double avgHeight (Player [][] players) {
		int sumHeight =0;
		int  numberOfPlayers=0;
		for(int i=0;i<players.length;i++) {// for loop for the rows
			for(int j=0;j<players[i].length;j++) {//for loop for the coulms
				sumHeight +=players[i][j].getHeight();// to find the sum of height
				numberOfPlayers +=1;// increment number of players
			}
		}
		return sumHeight/numberOfPlayers ;// return the average height of all players
	}


	// this method  to choose different two  player from diffrent team
	public static Player[] choosePlayer(Player [][] player){
		Player[]choseTwoPlayers=new Player[2];//define array with size equal 2
		int K=player.length;//the length of array equal K which mean equal the number of team
		int firstTeam=(int)(Math.random()*K);//to choose the first random team
		int secondTeam=0;
		do {
			secondTeam=(int)(Math.random()*K);//to choose the second random team
		} while(firstTeam==secondTeam);// the loop end when select different team 

		int playearOne=(int)(Math.random()*player[firstTeam].length);//to choose random players from team one
		int playearTwo=	(int)(Math.random()*player[secondTeam].length);	//to choose random players from team two

		choseTwoPlayers[0]=player[firstTeam][playearOne];//the zero index in array with row referance to the first random team and coulms represnt the random player from first team 
		choseTwoPlayers[1]=player[secondTeam][playearTwo];//the first index in array with row referance to the second random team and coulms represnt the random player from second team

		return choseTwoPlayers;// return array of object of Player

	}

	private static int randomMathQustion() {
		Scanner input=new Scanner(System.in);
		int score=0;
		char[] operationZero= {'*','/','%','^'};//operation in index zero for qustion one
		String []operationTwo= {"floor","ceil"};//operation in index one for qustion two
		String[] operationOne= {"sin","cos"};//operation in index two for qustion three
		String operThree= "log2";//operation in index three for qustion four

		char opZero=operationZero[(int)(Math.random()*4)];//to choose random operation for index zero(which mean random operation for qustion one)
		String opOne=operationOne[(int)(Math.random()*2)];//to choose random operation for index one (which mean random operation for qustion two)
		String opTwo=operationTwo[(int)(Math.random()*2)];//to choose random operation for index two (which mean random operation for qustion three)

		// operation for index 0(first qustion)
		double first= randomNum[0][(int)(Math.random()*9)];//this to choose first random number for operation 0
		double second =randomNum[0][(int)(Math.random()*9)];//this to choose second random number for operation 0 
		double op0=0;//this to store the result of operation 

		if(opZero=='*')
			op0=first*second;

		else if(opZero=='/')
			op0=first/second;

		else if(opZero=='%')
			op0=first%second;

		else
			op0=Math.pow(first,second);

		op0=(int)(Math.round(op0*100))/100.0;// to return the value of closet integer


		System.out.println("First Qustion");
		System.out.println("Plese Find"+first+opZero+second);
		double  resultZero=input.nextDouble();
		if(resultZero==op0)
			score+=1;

		// operation for index one(qustion two)
		double first1=randomNum[1][(int)(Math.random()*9)];//this to choose  random number for operation 0
		double op1=0;
		if(opOne.equals("ceil"))
			op1=Math.ceil(first1);

		else
			op1=Math.floor(first1);

		op1=(int)(Math.round(op1*100))/100.0;// to return the value of closet integer

		System.out.println("this is Qustion two ");
		System.out.println("please find"+opOne+'('+first1+')');
		double resultOne=input.nextDouble();
		if(resultZero==op1)
			score+=1;

		// operation two(qustion three)
		double first2=randomNum[2][(int)(Math.random()*9)];//this to choose  random number for operation 2
		double op2=0;
		if(opTwo.equals("sin"))
			op2=Math.sin(Math.toRadians(first2));

		else
			op2=Math.cos(Math.toRadians(first2));;

			op2=(int)(Math.round(op2*100))/100.0;// to return the value of closet integer

			System.out.println("this is Qustion three ");
			System.out.println("please find"+opTwo+'('+first2+')');
			double resultTwo=input.nextDouble();
			if(resultTwo==op2)
				score+=1;

			// operation three(qustion four)
			double first3=randomNum[3][(int)(Math.random()*9)];//this to choose  random number for operation 0
			double op3=Math.log10(first3)/Math.log10(2);//
			op3=(int)(Math.round(op2*100))/100.0;// to return the value of closet integer

			System.out.println("this is Qustion Four ");
			System.out.println("please find"+operThree+'('+first3+')');
			double resultThree=input.nextDouble();
			if(resultThree==op2)
				score+=1;

			return score;
	}

	public static int [] askPlayer(Player[] player) {// this method to ask user qustion
		int result[]=new int[2];
		for(int i=0;i<2;i++) {
			System.out.println(player[i].getName()+"please answer Qustion");
			result[i]= randomMathQustion() ;
		}
		return result;
	}


}




