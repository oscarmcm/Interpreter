package interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Interpreter {
    
    public static void main(String[] args) throws IOException {
        
        InputStreamReader teclado = new  InputStreamReader(System.in);
        BufferedReader lectura = new BufferedReader(teclado);
        String roman;
        
        System.out.println("Número Romano: ");
        roman = lectura.readLine();
	Context context = new Context(roman);

	      // Build the 'parse tree' 
	      ArrayList<Expression> tree = new ArrayList<Expression>();
	      tree.add(new ThousandsExpression());
	      tree.add(new HundredExpression());
	      tree.add(new TenExpression());
	      tree.add(new OneExpression());

	      // Interpret 
	      for (Iterator it = tree.iterator(); it.hasNext();)
	      {
	    	  Expression exp = (Expression)it.next();
	    	  exp.interpret(context);
	      }

	      System.out.println(roman + " = " + Integer.toString(context.getOutput()));
	}
}
