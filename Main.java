package ass2;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int count=0;
		Scanner input=new Scanner(System.in);
		System.out.println("please enter number of players");
		int  N=input.nextInt();
		System.out.println("please enter the number of teams");
		int K=input.nextInt();
		Player[][]players=new Player[K][];// create array of object
		for(int i=0;i<K;i++) {
			if(i==K-1) {
				players[i]=new Player[N];
			}
			else {
				int  R=(int)(Math.random()*(N));//to choose random playear
				players[i]=new Player[R];
				int Z=N-R;
			}
			for(int r=0;r<players[i].length;r++) {
				System.out.println("plese enter name for the team # "+(i+1)+" to the player :"+(r+1));
				String name=input.next();
				System.out.println("plese enter age  for the team # "+(i+1)+" to the player :"+(r+1));
				int age=input.nextInt();
				System.out.println("plese enter Height for the team # "+(i+1)+" to the player :"+(r+1));
				double height=input.nextDouble();
				players[i][r]=new Player(name,age,height);

			}
		}
		for(int m=0;m<Player.theTeam.length;m++){//get the name of team
			System.out.println("Team: " + m);
			for(int x = 0; x < Player.theTeam[m].length; x++){
				System.out.println(Player.theTeam[m][x].getName());
			}
		}

		System.out.println("the average height is"+Player.avgHeight(players)); // call the method to print average height


		Player[] choseThePlayer=Player.choosePlayer(players);// to choose random playear	
		for (Player thePlayer:choseThePlayer)			
			System.out.println(thePlayer.getName());

	}
	// to find the score 
	int[] theResult=Player.askPlayer(choseThePlayer);
	for(int f=0;f<2;f++) {
		System.out.println(choseThePlayer[f].getName()+"score is:");
		System.out.println(theResult[f]);

	}
}
}
