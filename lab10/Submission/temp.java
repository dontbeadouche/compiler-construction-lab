import java.util.*;
import java.io.*;
public class Program
{
  public static void main (String[]args) throws Exception
  {
    Scanner sc = new Scanner (System.in);

    String input = "";

      System.out.println (".global main");
      System.out.println ("msg:");
      System.out.println ("Final result of LHS var = %d\n");
      System.out.println (".comm a,4");
      System.out.println (".comm b,4");
      System.out.println (".comm c,4");
      System.out.println (".comm d,4");
      System.out.println (".comm e,4");
      System.out.println (".comm f,4");
      System.out.println ("main:");
      System.out.println ("pushl %ebp");
      System.out.println ("movl %esp, %ebp");

    int result = 0;

    String path = args[0];
    File input_File = new File (path);

    BufferedReader reader = new BufferedReader (new FileReader (input_File));
    input = reader.readLine ();

    while (input != null)
      {

       	if (input.equals (" "))
          break;
        

        StringTokenizer st = new StringTokenizer (input, " ");
        while (st.hasMoreTokens ())
          {
            System.out.println ();

            String op = st.nextToken ();
            String arg1 = st.nextToken ();
            String arg2 = st.nextToken ();
            String res = st.nextToken ();

            if (op.equals ("="))
              {
               	System.out.print ("movl ");
              }

            else if(op.equals("-"))
              {
                System.out.print ("subl ");
              }

            if (Character.isDigit (arg1.charAt (0)))
              {
               	System.out.print ("$" + arg1);
                result += Integer.parseInt (arg1);
              }
            else if (arg1.equals ("eax"))
              {
               	System.out.print ("%" + arg1);
              }
            else
              {
               	System.out.print (arg1);
              }
            
            if (res.equals ("eax"))
              {
                System.out.print (", %" + res);
              }
            else
              {
                System.out.print ("," + res);
              }
            }

          input = reader.readLine ();
        }

    System.out.println ("\n\npushl z");
    System.out.println ("pushl $msg");
    System.out.println ("call printf");
    System.out.println ("leave");
    System.out.println ("ret");

    System.out.println ("Final Result of LHS variable :" + result);
    System.out.println();

  }
}

