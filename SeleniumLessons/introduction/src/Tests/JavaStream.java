package introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;
import org.testng.annotations.*;

public class JavaStream {

//	@Test
	public void test1() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Professor");
		names.add("Tokyo");
		names.add("Nairobi");
		names.add("Denver");
		names.add("Berlin");
		names.add("Arya");

		long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
	}

	// @Test
	public void test2() {
		// To print the stream names without storing in arraylist
		long d = Stream.of("Professor", "Tokyo", "Nairobi", "Denver", "Berlin", "Arya").filter(s -> {
			s.startsWith("P");
			return true;
		}).count();

		System.out.println(d);

		Stream.of("Professor", "Tokyo", "Nairobi", "Denver", "Berlin", "Arya").filter(s -> s.length() > 5)
				.forEach(s -> System.out.println(s));
	}

//	@Test
	public void StreamMap() {
		// To filter the stream with words ending with letter a and mapping them into
		// uppercase.
		Stream.of("Professor", "Tokyo", "Nairobi", "Denver", "Berlin", "Arya").filter(s -> s.endsWith("r"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// Convert the list to array list and filter the word starts with A and sort.
		List<String> listNames = Arrays.asList("Professor", "Tokyo", "Nairobi", "Denver", "Berlin", "Arya");
		listNames.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

	}

	//@Test
	public void concatStreams() {
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Professor");
		names1.add("Tokyo");
		names1.add("Nairobi");
		names1.add("Denver");
		names1.add("Berlin");
		names1.add("Arya");

		List<String> names2 = Arrays.asList("Abhijeet", "Ram", "Naira");
		Stream<String> stream1 = names1.stream();
		Stream<String> stream2 = names2.stream();
		Stream<String> newStream = Stream.concat(stream1, stream2);
		newStream.sorted().forEach(s -> System.out.println(s));

		// Match function
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Tokyo"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void collectStream() {
		
		List<String> listNames = Arrays.asList("Professor", "Tokyo", "Nairobi", "Denver", "Berlin", "Arya");
		List<String> ls = listNames.stream().filter(s->s.startsWith("P")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
	}
	
	@Test()
	public void printUniqueValues(){
		//To print the unique numbers from arraylist
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().sorted().distinct().forEach(s->System.out.println(s));
		
		//To get only value at 3rd index
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
