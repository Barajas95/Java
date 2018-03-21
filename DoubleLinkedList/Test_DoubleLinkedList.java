import java.util.Iterator;

public class Test_DoubleLinkedList
{
	public static void main(String[] args)
	{
		DoubleLinkedList <Integer> list1=new DoubleLinkedList<Integer>();
		
		list1.add(0, 10);
		list1.add(1, 11);
		list1.add(2, 12);
		list1.add(3, 13);
		list1.add(4, 14);
		
		list1.add(1, 99);
		list1.add(1, 88);
		list1.add(1, 77);
		
		list1.addFirst(20);
		list1.addFirst(21);
		list1.addFirst(22);
		list1.addFirst(23);
		
		list1.addLast(30);
		list1.addLast(31);
		list1.addLast(32);
		list1.addLast(33);
		
		System.out.println(list1.toString());
		
		for(Integer n:list1)
		{
			System.out.println("[" + n + "]");
		}
		Iterator<Integer> it=list1.iterator();
		while(it.hasNext())
		{
			Integer n=it.next();
			System.out.println("[" + n + "]");
		}
	}
}