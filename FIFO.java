import java.util.*;

public class FIFO
{
	static int page_fault=0;
	static int pageFaults(int pages[],int n, int capacity)
	{
		HashSet<Integer> s= new HashSet<>(capacity);
		Queue<Integer> index=new LinkedList<>();
		
		
		for(int i=0;i<n;i++)
			{
				if(s.size()<capacity)
				{
					if(!s.contains(pages[i]))
					{
					
					s.add(pages[i]);
					page_fault++;
					index.add(pages[i]);
					}
				}
				else
				{
					if(!s.contains(pages[i]))
					{
					
					int val=index.peek();
					index.poll();
					s.remove(val);
					
					s.add(pages[i]);
					index.add(pages[i]);
					page_fault++;
					
					
					}
				
				}
			}
	return page_fault;
	}

	public static void main(String args[])
	{
		int pages[]={7,0,1,2,0,3,0,4,2,3,0,3,2};
		int capacity=4;
		System.out.println(pageFaults(pages,pages.length,capacity));
		int page_hit=pages.length-page_fault;
		System.out.println(page_hit);
	
	}
}
