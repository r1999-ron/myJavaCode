import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abba";
		String s = "dog cat cat dog";
		String[] arr = s.split(" ");
		if (arr.length != pattern.length())
			System.out.println(false);
		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			char temp = pattern.charAt(i);
			if (map.containsKey(temp)) {
				if (!map.get(temp).equals(arr[i]))
					System.out.println(false);
			} else if (set.contains(arr[i]))
				System.out.println(false);
			else {
				set.add(arr[i]);
				map.put(temp, arr[i]);
			}

		}
		System.out.println(true);

	}

}
