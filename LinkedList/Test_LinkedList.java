package LinkedList;

public class Test_LinkedList
{
	public static void main(String[] args)
	{
		LinkedList <Double> list1=new LinkedList<Double>();
		
		list1.addFirst(1.1);
		list1.add(0, 0.0);
		list1.add(1, 9.9);
		list1.add(2, 2.2);
		list1.addLast(99.99);
		System.out.println(list1.toString());
		
		list1.clear();
		System.out.println(list1.isEmpty());
	}
}