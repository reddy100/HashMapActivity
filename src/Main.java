import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
private static boolean exit = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		fileReader(hm);
		while(!exit)
		{
			int input1=promptUser1(sc,"Please enter a number");
			if(hm.containsKey(input1))
			{
				System.out.println(hm.get(input1));
			}
			else
			{
				String input2 = promptUser2(sc, "Please enter a string to be associated with this number");
				hm.put(input1, input2);
			}
			String exitNow = promptUser2(sc, "Do you want to add or check for more values? yes/no");
			if(exitNow.equalsIgnoreCase("no"))
			{
				exit=true;
			}
		}	
		System.out.println("you have exited the input zone");
		fileWriter(hm);
		
	}
	
	public static int promptUser1(Scanner sc, String prompt1)
	{
		int userInput=0;
		System.out.println(prompt1);
		userInput = sc.nextInt();
		return userInput;
	}
	
	public static String promptUser2(Scanner sc, String prompt1)
	{
		String userInput="";
		System.out.println(prompt1);
		userInput = sc.next();
		return userInput;
	}
	public static void fileWriter(HashMap<Integer, String> hm) throws IOException
	{
		File outFile = new File("output.txt");
		FileWriter fWriter = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(fWriter);
		for(Map.Entry<Integer, String> entry: hm.entrySet())
		{
			pWriter.println(entry.getKey()+" "+entry.getValue());
		}
		
		pWriter.close();
	}
	
	public static void fileReader(HashMap<Integer, String> hm) throws FileNotFoundException
	{
		File file = new File("output.txt");
		Scanner input = new Scanner(file);
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String [] inputs = line.split(" ");
			hm.put(Integer.parseInt(inputs[0]), inputs[1]);
		}
		
	}
}
