import java.util.*;
import java.io.*;
public class	Program
{
	public static void main(String[] args) throws Exception
	{
		    Scanner	sc = new Scanner(System.in);

		    String input = "";

				System.	out.	println(".global main");
				System.	out.	println("msg:");
				System.	out.	println(".string \"Final result of LHS var = %d\\n\"");
				System.	out.	println(".comm a,4");
				System.	out.	println(".comm b,4");
				System.	out.	println(".comm c,4");
				System.	out.	println(".comm d,4");
				System.	out.	println(".comm e,4");
				System.	out.	println(".comm f,4");
        			System. out.  	println(".comm z,4");
				System.	out.	println("\nmain:");
				System.	out.	println("pushl %ebp");
				System.	out.	println("movl %esp, %ebp");
				System.	out.	println();


		String path = args[0];
		File input_File = new File(path);

		BufferedReader reader = new BufferedReader(new FileReader(input_File));
		input =	reader.readLine();


		String [] tokens = input.split(" ");

		String op = tokens[0];
		String arg1 = tokens[1];
		String arg2 = tokens[2];
		String res = tokens[3];
		
    int result =	2 *	Integer.parseInt(tokens[1]);

		while (input != null) {

			tokens = input.split(" ");

			op = tokens[0];
			arg1 = tokens[1];
			arg2 = tokens[2];
			res = tokens[3];

			if (op.equals("=")) {
				System.out.print("movl ");
			} 
      else if (op.equals("-")) {
				System.out.print("subl ");
			}

			if (Character.isDigit(arg1.charAt(0))) {
				System.out.print("$" + arg1);
				result -= Integer.parseInt(arg1);
			} 
      else if (arg1.equals("eax")) {
				System.out.print("%" + arg1);
			} 
      else {
				System.out.print(arg1);
			}

			if (res.equals("eax")) {
				System.out.println(", %" + res);
			} else {
				System.out.println("," + res);
			}


			input = reader.readLine();
		}

		System.out.println("\n\npushl z");
		System.out.println("pushl $msg");
		System.out.println("call printf");
		System.out.println("leave");
		System.out.println("ret");

	}
}
