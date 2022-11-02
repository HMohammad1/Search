public class ASearch {


	private Entry[] catalogue;
	private int current;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/*
	 * Part 2: complete implementation
	 */
	public int linearSearch(String name){
		for(int i = 0; i < current; i++) {
			if(catalogue[i].getName().equals(name)) {
				return catalogue[i].getNumber();
			}
		}
		return -1;
	}

	/*
	 * Part 4: complete implementation
	 */
	private int binarySearch(int first,int last,String name){
		while (first <= last) {
			int middle = (first + last) / 2;
			if (catalogue[middle].getName().compareTo(name) > 0)
				last = middle - 1;
			else if (catalogue[middle].getName().compareTo(name) < 0)
				first = middle + 1;
			else
				return catalogue[middle].getNumber();
		}
		return -1;
	}

	// helper method exposed to the programmer
	public int binarySearch(String name){
		return binarySearch(0,current-1,name);
	}
	
	
}
