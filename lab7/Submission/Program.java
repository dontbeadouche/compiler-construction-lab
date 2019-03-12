import java.util.*;
import java.io.*;

class SymbolTable
{
	ArrayList < String > table[];

	SymbolTable(){

		table = new ArrayList[6];

		for(int i=0; i < table.length; i++){
			table[i] = new ArrayList < String > ();
		}
	}

		

	public int compMap (int key) {
		return key % 6; 
	}

	public int hashCodeMap (String id){

		char[] data = id.toCharArray ();
		int value = 0;
		char temp;
		int len = data.length;

		if(Character.isDigit(data[0])){
			System.out.println("Error in input : " + id);
			System.exit(0);
		}

		for(int i = 0; i < len; i++){

			temp = data[i];
			if(Character.isLetter(temp)){
				value += (int)temp;
			}
			else if(Character.isDigit(temp)){
				value += 2*temp;
			}
			else{
				System.out.println("Error in input : " + id);
				System.exit(0);
			}				
		}
		return value*17+5;
	}

	public void insert(String id){
		int index = compMap(hashCodeMap(id));
		table[index].add(id);
	}

	public void display(){

		ArrayList < String > tableList;

		for(int i = 0; i < table.length; i++){
			
			tableList = table[i];
			System.out.println("\nSymbol Table index " + i);
			for(int j = 0; j < tableList.size(); j++){
				System.out.print("id : " + tableList.get(j) + "\t");
			}
			System.out.println();
		}
	}
}

class Program{

	public static void main(String[] args) throws Exception{

		SymbolTable st = new SymbolTable();

		String path = args[0];
		File input_File = new File(path);

		BufferedReader reader = new BufferedReader(new FileReader(input_File));
		String input = reader.readLine();

		while(input != null){
			st.insert(input);
			input = reader.readLine();
		}
		
		reader.close();
		st.display();
	}
}
