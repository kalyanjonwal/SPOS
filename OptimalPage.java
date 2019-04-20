import java.util.*;

public class OptimalPage
{
	public void Execute()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of pages");
		int nop=sc.nextInt();
		int pages[]=new int[nop];
		int capacity=0;
		System.out.println("Enter page reference string");
		for(int i=0; i<nop; i++)
		{
				pages[i] = sc.nextInt();
		}
		System.out.println("Enter number of frame");
		{
				capacity=sc.nextInt();
		}
		HashSet<Integer> frame = new HashSet<Integer>(capacity);

		HashMap<Integer,Integer> index = new HashMap<Integer,Integer>();
		int page_fault=0;
		int page_hit=0;

		for(int i=0; i<nop ; i++)
		{
			if(frame.size()<capacity)
			{
				if(!frame.contains(pages[i]));
				{
				page_fault++;
				frame.add(pages[i]);
				int farthest=nextIndex(pages,i);
				index.put(pages[i],i);
				}
				else
				{
					page_hit++;
					//frame.add(pages[i]);
					index.put(pages[i],nextIndex(pages,i));
				}			
			}
			else
			{
				if(!frame.contains(pages[i]))
				{
					int farthest=-1;
					int val=0;

					Iterator<Integer> itr = frames.iterator();
					while(itr.hasNext())
						{
							int temp = itr.next();

							if(index.get(temp)>farthest)
							{
								farthest = index.get(temp);
								val=temp;
							}

						}
						frame.remove(val);
						index.remove(farthest);
						frame.add(pages[i]);
						page_fault++;
						int nextUse = nextIndex(pages,i);
						index.put(pages[i],nextUse);					
				}
				else
				{
					page_hit++;
					index.put(pages[i],nextIndex(pages,i));
				}
			}
			frame.forEach(System.out::print);
			System.out.println();	
		}
		System.out.println(page_hit);
		System.out.println(page_fault);
	}

	public static int intNextIndex(int pages[], int curIndex)
	{
		int farthest=curIndex;
		int currentPage = pages[curIndex];
		int j=farthest;
		for(int j=farthest+1;j<pages.length;j++)
		{
			if(pages[j]==currentPage)
			{
				farthest=j;
				return farthest;
			}
		}
return Integer.MAX_VALUE;

		
	}
	public static void main(String[] args)
	{
		OptimalPage ob = new OptimalPage();
		ob.Execute();
	}
}