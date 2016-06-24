import java.util.HashMap;
import java.util.Map;

public class PB6_3 {
	private static Map<String, Member> map = new HashMap<String, Member>();
	static {
		map.put("00IE00", new Member("00IE00", "miya", Gender.MALE));
		map.put("00ID00", new Member("00ID00", "kohama", Gender.MALE));
		map.put("14JKM17", new Member("14JKM17", "horikawa", Gender.FEMALE));
		map.put("14JKM13", new Member("14JKM13", "harakawa", Gender.MALE));
		map.put("14JKM18", new Member("14JKM18", "matsui", Gender.MALE));
	}
	public static void main(String[] args) {
		System.out.println(map.containsKey("14JKM17"));
	}
}