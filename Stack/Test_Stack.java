package Stack;

public class Test_Stack
{
	public static void main(String[] args)
	{
		Stack<String> stack1=new Stack<String>();
		stack1.push("A");
		stack1.push("R");
		stack1.push("P");
		stack1.push("E");
		stack1.push("N");
		
		System.out.println(stack1.toString());
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.getSize());
		
		stack1.pop();
		stack1.pop();
		
		System.out.println(stack1.toString());
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.getSize());
		
		System.out.println(stack1.top());
		
		stack1.clear();
		
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.getSize());		
	}
}
