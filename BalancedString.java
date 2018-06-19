import java.util.Scanner;
import java.util.Stack;

public class BalancedString {

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		while (sc.hasNext()) {
			String input=sc.next();
			char[] carr = input.toCharArray();
			for(int i=0;i < carr.length;i++){
				if(carr[i] == '(' )
						s.push(carr[i]);
				else if (carr[i]== ')')
					s.pop();

			}
			if(s.empty()) 
				System.out.print(true);
			else
				System.out.print(false);
		}
	}
}
