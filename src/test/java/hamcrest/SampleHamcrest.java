package hamcrest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Teddy
 *
 */
public class SampleHamcrest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testMatchers() {
		
		assertThat("0이 아니다.", 1, not(0));
        assertThat("1000보다 크다.", 5000, greaterThan(1000));
        assertThat("1000보다 크거나 같다.", 2000, greaterThanOrEqualTo(1000));
        assertThat("앞에값이 작겠지?", 2000, lessThan(5000));
        assertThat("앞에값이 작거나 같겠지?", 1000, lessThanOrEqualTo(1000));
        assertThat("앞뒤가 같겠지?", "하이", equalTo("하이"));
        assertThat("앞뒤가 대소문자 구분없이 같겠지?", "aabbcc", equalToIgnoringCase("AaBbCc"));
        assertThat("앞뒤 공백은 좀 바주고 같겠지?", "하이 ", equalToIgnoringWhiteSpace(" 하이"));
        assertThat("널이 아니겠지?", new String("널 아니다"), notNullValue());
        assertThat("리스트가 비어있겠지?", new ArrayList<Object>(), empty());
        assertThat("배열이 비어있겠지?", new String[0], emptyArray());
        assertThat("문자열에 포함되어 있지?", "abc", containsString("b"));
        assertThat("시작하는 단어가 맞지?", "abc", startsWith("a"));
        assertThat("끝나는 단어가 맞지?", "abc", endsWith("c"));
 
        List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "ddakkerTest");
        map.put("age", "100");
        maps.add(map);
        map = new HashMap<String, String>();
        map.put("name", "ddakker");
        map.put("age", "0");
        maps.add(map);
        assertThat("배열중에서 특정 키의 값이 존재 하지?", maps, Matchers.<Map<String, String>>hasItem(hasEntry("name", "ddakker")));
        assertThat("해쉬맵에서 해당 필드의 값이 동일하지?", map, hasEntry("name", "ddakker"));
 
//        List<User> userList = new ArrayList<User>();
//        User user = new User("ddakkerTest", 100);
//        userList.add(user);
//        user = new User("ddakker", 0);
//        userList.add(user);
//        assertThat("배열중에서 특정 필드의 값이 존재 하지?", userList, Matchers.<User>hasItem(hasProperty("name", is("ddakker"))));
//        assertThat("빈에서 해당 필드의 값이 동일하지?", user,hasProperty("name", is("ddakker")));
//		fail("Not yet implemented");
	}

}
