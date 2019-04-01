import java.util.*;

public class Program{

	public static void main(String[] args) {
		
		String num = "\\d+";
		String id = "[a-zA-Z][a-zA-Z0-9_]*";
		String term = num+"|"+id;
		String expr = "("+term+")(\\+("+term+"))*";
		String stmnt = id+"="+expr;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Statement : ");
		String input = sc.nextLine();

		String[] assign = input.split("=");
		String[] operands = assign[1].split("\\+");

		if(input.matches(stmnt) && operands.length < 7){
			System.out.println(input + " is a valid Statement");
		}
		else{
			System.out.println(input + " is an invalid Statement");
			return;
		}

		print("Input  ", "Op ", "Arg1 ", "Arg2 ", "Res ");
		System.out.println();

		int count = 0;

		if(operands.length == 1){
			print(input, "=", assign[1], "nill", assign[0]);
			return;
		}

		else{
			String temp_a = "", temp_b = "";

			for(int i=0; i < operands.length-1; i++){
				temp_b = "temp"+count;
				count++;
				temp_a = "temp"+count;

				if(i==0){
					print(input, "+", operands[i], operands[i+1], temp_a);
				}
				else{
					print("", "+", temp_b, operands[i+1], temp_a);
				}
			}
			print("", "=", temp_a, "nil", assign[0]);
		}
		System.out.println();
	}

	public static void print(String input, String op, String arg1, String arg2, String res){
		System.out.println();
		System.out.printf("%15s%10s%10s%10s%10s", input, op, arg1, arg2, res);
	}


}