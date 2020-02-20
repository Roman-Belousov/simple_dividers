

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Sequence implements Iterable<Integer>, Iterator<Integer> {
	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	private Integer prev1 = 1;
	private Integer prev2 = 0;
	private int count = 0;
	private int max;

	public Sequence(int max) {
		this.max = max;
	}

	@Override
	public boolean hasNext() {
		return count < max;
	}

	@Override
	public Integer next() {
		Integer curr = prev1 + prev2;
		prev1 = prev2;
		prev2 = curr;
		count++;
		return curr;
	}
}

public class Runner {

	<T> void out(Iterable<T> iterable) {
		for (T element : iterable) {
			System.out.println("\t" + element); 
		}
	}

	void test(Collection<String> collection) {
		Iterator<String> it = collection.iterator();
		while (it.hasNext()) {
			String element = it.next();
			System.out.println("Делители числа :" + element);
			if (Integer.parseInt(element) != 0) {
				for (int i = Integer.parseInt(element); i > 0; i--) {
					int b = Integer.parseInt(element) % i;
					if (b == 0)
						System.out.println("\t" + i);
				}
				
			} else {
				System.out.println("У числа <0> не может быть делителей!");
			}

		}

	}

	public static void main(String[] args) {
		Runner runner = new Runner();
		List<String> list = new ArrayList<>();
		list.add("128");
		list.add("256");
		list.add("512");
		list.add("1024");
		System.out.println("Натуральные числа : ");
		runner.out(list);
		runner.test(list);

	}
}
