package list.maintaince;

package staticClasses;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Scoreboard
{
	// Define our inner class called score
	// It holds the players name, score and an implementation of toString() which returns the name.
	private class score {
		public String name;
		public int score;
		public String toString() { return name; }
	}

	// Public method to create an instance of our private score class.
	public score score() {
		return new score();
	}

	public static void main (String args[])
	{
		Scanner input = new Scanner( System.in);
		LinkedList playerName = new LinkedList(); //Using linkedlist to store objects instead of map as names or score either can not act as an appropriate key
		String command;

		do
		{
			System.out.println( "Welcome to the score-keeping program, please choose your command. Press A to add a name, L to show the list, and Q to quit." );
			command = input.nextLine();


			if ( command.equalsIgnoreCase( "A" ) )
			{
				// Prompt for the name and the score
  
				System.out.println( "Please enter your name!" );
				String name = input.nextLine();

				System.out.println( "Please enter your score!" );
				String score = input.nextLine();

				// Create an instance of our inner class and set its properties.

				Scoreboard highs = new Scoreboard();
				Scoreboard.score p = highs.new score();
				p.name = name;
				p.score = Integer.parseInt(score);
				
				// Adding the name here boxes it up into an "object"
				playerName.add( p );
  
			}
	
			if ( command.equalsIgnoreCase( "L" ) )
			{

				// Sort using our comparator defined below. Passing it objects in our linkedlist.
				Collections.sort(playerName,MakeComparator);

				for ( Object nameAgain : playerName )
				{
					score player = (score) nameAgain;
					System.out.printf( "\n%s" , player.name + " " + player.score );
				}
				System.out.println();
			}

		}
		while ( !command.equalsIgnoreCase( "Q" ) );
	}

	
	// Implement our comparator using an inline function. Here we override the compare method and tell
	// java how to compare our two objects (using their score).
	public static Comparator MakeComparator = new Comparator() {
		public int compare(Object a, Object b){
			// We unbox them from objects back to score objects and get their scores
			Integer aval = ((score)a).score;
			Integer bval = ((score)b).score;

			// Using a negative sign we flip from ascending to decending by reversing the natural sort order i.e. Highest score first.
			return -aval.compareTo(bval); 
		}
	};
}
