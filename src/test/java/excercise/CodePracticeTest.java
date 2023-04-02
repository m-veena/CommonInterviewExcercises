package excercise;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CodePracticeTest {
	CodePractice codePractice;

	@BeforeEach
	public void beforeTest() {
		codePractice = new CodePractice();
		
	}
	
	@Test
	@DisplayName("DuplicateWords")
	void testDuplicateWords() {
		Map<String, Integer> valueMap = codePractice.duplicateWords2("mama rama kama mama mama");
		String expectedKey = null;
		Integer expectedValue = 0;
		for(Map.Entry<String, Integer> entry: valueMap.entrySet()) {
			expectedKey = entry.getKey();
			expectedValue = entry.getValue();	
		}

		assertEquals(expectedKey, "mama", "This is to check duplicate words in a sentence");
		assertEquals(expectedValue, 3, "This is to check duplicate words in a sentence");		
	}
	@Test
	@Disabled("in progress")
	void testDuplicateWordsException() {
		assertThrows(NullPointerException.class, ()-> codePractice.duplicateWords2(null), "If null is passed, it should throw exception");
	}
	@Test
	void testPrintFibNumbers() {
		int num =5;
		int[] expectedArr = {0,1,1,2,3,5};
		int[] actualArr = codePractice.printFibNumbers(num);
		int[] expectedArr2 = {0,1,1,2,3,5,8};
		int[] actualArr2 = codePractice.printFibNumbers(6);
		assertAll(()->assertArrayEquals(expectedArr,actualArr, "Fibonacci series is tested"), ()->assertArrayEquals(expectedArr2,actualArr2, "Fibonacci series is tested"));
	}
	
	@Test
	void testSumoftwo() {
	  int[] expectedArr1 = {3,1};
	  int[] expectedArr2 = {-1,-1};
	  int[] valueArr = {3,5,9,0}; 
	  assertAll(() -> assertArrayEquals(expectedArr1,codePractice.sumoftwo(valueArr, 5),"Value is matching"),()-> assertArrayEquals(expectedArr2,codePractice.sumoftwo(valueArr, 13),"Value is matching"));
	}
	@Test
	void testPalindrome() {
		assertAll(()->assertEquals(true,codePractice.palindrome("deed"),"Palindrome is true"), ()->assertEquals(false,codePractice.palindrome("mama"),"Palindrome is false"), ()->assertThrows(NullPointerException.class,()->codePractice.palindrome(null),"value is null"));
	}
	
	@Test
	void testStripAndTrimSame() {
		String s= "\t abc \n";
		assertEquals("abc",s.trim(),"test trim");
		assertEquals("abc",s.strip(),"test strip");
	}
	
	@Test
	void testStringEmptyBlank() {
		assertEquals(true, "   ".isBlank(),"Blank string check with one white space");
		assertEquals(true, "".isEmpty(),"Empty string check with one white space");
	}
}