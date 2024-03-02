package controls.Slenium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("lia");
		arr.add("joanna");
		arr.add("renu");
		arr.add("reena");
		arr.add("reena");
		arr.add("isabella");

		  int count=0;
		  
		  for(int i=0;i<arr.size();i++) { String val=arr.get(i);
		  if(val.startsWith("r")) { count++; } } System.out.println(count);
		 

		Long countS = arr.stream().filter(j -> j.length() > 4).count();
		System.out.println(countS);

		arr.stream().filter(j -> j.length() > 4).forEach(s -> System.out.println(s));

		arr.stream().filter(j -> j.length() > 4).limit(1).forEach(s -> System.out.println(s));

		boolean find = arr.stream().anyMatch(s -> s.equalsIgnoreCase("reesna"));
		System.out.println(find);

		arr.stream().filter(j -> j.startsWith("r")).sorted().map(r -> r.toUpperCase())
				.forEach(s -> System.out.println(s));

		List<String> lst = arr.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(lst);
	}

}
