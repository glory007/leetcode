import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MergeSortedLists {
	
	static class Pair{
		boolean b;
		int v;
		public Pair(boolean b, int v){
			this.b = b;
			this.v = v;
		}
	}
	
	
	
	public static void main(String[] args){
		List<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(4);
		list1.add(5);
		
		List<Integer> list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(6);
		List<Integer> list3 = merge2(list1, list2);
		
		for(Integer i : list3){
			System.out.println(i);
		}
	}
	
	
	public static Pair advance(Iterator<Integer> i){
		if(i.hasNext()){
			return new Pair(false, i.next());
		}
		else{
			return new Pair(true,-1);
		}
		
	}
	
	public static List<Integer> merge2 (List<Integer> a, List<Integer> b){
		List<Integer> c = new ArrayList<Integer>();
		
		Iterator<Integer> i1 =  a.iterator();
		Iterator<Integer> i2 =  b.iterator();

		boolean l1 = a.size()==0 ? true:false;  // true means already reach end of list a
		boolean l2 = b.size()==0 ? true:false;
		
		Integer a1 = a.size()>0 ? i1.next() : 0;
		Integer b1 = b.size()>0 ? i2.next() : 0;
		
		while(true){
			if(l1 && l2) 
				return c;
			
			if(l1 == false && l2== true){
				c.add(a1);
				Pair p = advance(i1);
				l1 = p.b;
				a1 = p.v;
			}
			else if (l1 == true && l2 == false){
				c.add(b1);
				Pair p = advance(i2);
				l2 = p.b;
				b1 = p.v;
			}
			else{
				c.add(a1 > b1 ? b1 : a1);
				if(a1 > b1){
					Pair p = advance(i2);
					l2 = p.b;
					b1 = p.v;
				}
				else{
					Pair p = advance(i1);
					l1 = p.b;
					a1 = p.v;
				}
			}
		}
	}
	
	public static List<Integer> merge (List<Integer> a, List<Integer> b){
		Iterator<Integer> i1 = a.iterator();
		Iterator<Integer> i2 = b.iterator();
		
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		boolean f1 = true; boolean f2= true;
		int x = 0,y =0;
		while( (!f1 || i1.hasNext()) && (!f2 || i2.hasNext()) ){
			if (f1)
				x = i1.next();
			if (f2)
			    y = i2.next();
			if(x<y){
				c.add(x);
				f2= false;
				f1= true;
			}
			else{
				c.add(y);
				f1= false;
				f2= true;
			}
		}
		
		int last = x>y ? x : y;
		c.add(last);

		while(i1.hasNext()){
			x = i1.next();
			c.add(x);
		}
		
		while(i2.hasNext()){
			x = i2.next();
			c.add(x);
		}
		
		return c;
		
	}

}

