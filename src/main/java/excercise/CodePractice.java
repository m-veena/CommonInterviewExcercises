package excercise;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodePractice {
	enum Days {MONDAY,TUESDAY,WEDNESDAY};
	

	public Map<String, Integer> duplicateWords2(String sentence) {
		String[] wordsArray = sentence.toLowerCase().split("\\s+");
		Map<String, Integer> wordsCountMap = new HashMap<>();
		Map<String, Integer> resultMap = new HashMap<>();
		for (String s : wordsArray) {
			if (!wordsCountMap.containsKey(s)) {
				wordsCountMap.put(s, 1);
			} else {
				wordsCountMap.put(s, wordsCountMap.get(s) + 1);
			}
		}
		Set<String> word_set = wordsCountMap.keySet();
		Integer maxCurrentCount = 0, maxCount = 0;
		String word = null;
		for (String s : word_set) {
			if (wordsCountMap.get(s) > 1) {
				maxCurrentCount = wordsCountMap.get(s);
				if (maxCount < maxCurrentCount) {
					maxCount = maxCurrentCount;
					word = s;
				}
			}
		}
		resultMap.put(word, maxCount);
		return resultMap;
	}
	
	public int findRepeatedChars(String s) {
		char[] cArray = s.toCharArray();
		int maxCount =0,currentMaxCount =0;
		char c = '\0';
		for(int i=0;i<cArray.length;i++) {
			for(int j =i+1;j<cArray.length;j++) {
				if(cArray[i]==cArray[j]) {
					currentMaxCount++;
				}
			}
			
			if(maxCount<currentMaxCount) {
				c = cArray[i];
				maxCount = currentMaxCount;
				currentMaxCount =0;
			}
				
		}
		
		return maxCount;
	}
	
	public List<String> streamProgram() {
		
	List<String> dataList = Arrays.asList("Team1","Team2","Team3","Team4","Team5","Team6","Team7","Team8");
	List<String> filterList = dataList.stream().filter(s-> "Team1".equals(s)).collect(Collectors.toList());
	filterList.forEach(System.out::println);
	return filterList;
	}
	
	
	public  void streamForFilterAny(){
		List<Person> personList = Arrays.asList(new Person("Tom",30, new Address("perina", null,"nsw")),new Person("Carl",20,new Address("perina", "bangor","nsw")),new Person("mans",33,new Address("perina", "bangor","nsw")));
		Person p =  personList.stream().filter(person->"tom".equalsIgnoreCase(person.name()) && 30 ==person.age()).findAny().orElse(null);
		System.out.println(p);
		Person person = new Person("Tom",30, new Address("perina", null,"nsw"));
		System.out.println("Testing java NPE: " + person.address().area().toLowerCase());
	}
	// 1,2,3,4,5 => 5 
	public int[] sumoftwo(int[] arr, int target) {
		Map<Integer,Integer> valuIndexMap = new HashMap<>();
		int remainingValue = 0;
		int[] returnArr = {-1,-1};
		for(int i=0;i<arr.length;i++) {
			remainingValue = target - arr[i];
			valuIndexMap.put(i, arr[i]);
			if(valuIndexMap.containsValue(remainingValue)) {
				returnArr[0] = i;
				for(Entry<Integer, Integer> entry:valuIndexMap.entrySet()) {
					if(entry.getValue()== remainingValue) {
						returnArr[1] = entry.getKey();
					}
				}
							
			}
            			
		}
		return returnArr;
	}
	
	public static int fib(int num) {
		if(num <=1)
			return num;
		return fib(num-1)+fib(num-2);
	}
	//example 5 => 0,1,1,2,3,5
	public int[] printFibNumbers(int num) {
		int returnArr[] = new int[num+1];
		for(int i=0;i<=num;i++) {
			if(i==0 || i==1) {
				returnArr[i] = i;
			}
			else {
				returnArr[i] = returnArr[i-1]+returnArr[i-2];
			}
		}
		return returnArr;
		
	}
	
	public boolean palindrome(String value) {
		//example bob, - obvious solution is that covert it into a char array and loop through from start and back
		// other one is, create reverse string and compare
		/*char[] charArr = value.replaceAll("\\s+","").toLowerCase().toCharArray();
		for(int i=0,j= charArr.length-1;i<charArr.length/2;i++,j--) {
			if(charArr[i] != charArr[j]) {
				return false;
			}
		}
		
		return true; 
		String reverseString = new StringBuilder(value).reverse().toString();
		return reverseString.equals(value); */
		String updatedText = value.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
	     char[] charArr = updatedText.toCharArray();
	        StringBuilder sb = new StringBuilder();
	        for(int i=charArr.length-1;i>=0;i--){
	            sb.append(charArr[i]);
	        }
	        System.out.println("reverse: "+sb.toString());
	        return updatedText.equals(sb.toString());

		
		//return IntStream.range(0, value.length()/2).allMatch(i->value.charAt(i)==value.charAt(value.length()-1-i));
	}
	
	public String latestSwitch() {
	 Days day = Days.WEDNESDAY;
	return switch(day) {
	 case MONDAY,TUESDAY -> "Monday and Tuesday";
	 case WEDNESDAY ->  "WEDNESDAY";
	 default -> "no value";
	 };
	}
	
  public void replaceMultipleSpaceWIthsingle() {
	  Pattern p = Pattern.compile("\\s+");
	  String text = "  replace Madhu is trying to get   job  ";
	  Matcher m = p.matcher(text.trim());
	 while(m.find()) {
		 System.out.println("space: "+ m.group());
		 String resultText = m.replaceAll(result->" ");
		 System.out.println(text +" : "+"result text"+ " :"+resultText+":");
	 }		 
  }
  
  public void extractNumbersFromString() {
	  Pattern p = Pattern.compile("[0-9]*");
	  String s = "Madhu is234 trying to55 get job557";
	  Matcher m = p.matcher(s);
	  while(m.find()) {
		  System.out.println(m.group());
		  String s2=  m.replaceAll(mr->"");
		  System.out.println(s2);
	  }  
  }
  
  public void isVowelsPresent(String text) {
	 // char[] charArr = text.toLowerCase().toCharArray();
	  Pattern pattern = Pattern.compile("[aeiuo].");
	  Matcher matcher = pattern.matcher(text);
	  boolean found = matcher.find();
	  String result = found ? "vowel found" : "vowel not found";
	  System.out.println(result);	  
  }
  
public void stringReverse(String text) {
	  //method 1
	if(text != null && !text.isBlank()) {
		StringBuilder sb = new StringBuilder(text);
		int length = sb.length();
		for(int i=0; i<length/2; i++) {
         char currentChar = sb.charAt(i);
         int lastChar = length-i-1;
         sb.setCharAt(i, sb.charAt(lastChar));
         sb.setCharAt(lastChar, currentChar);
			
		}
		System.out.println(sb.toString());		
	}	
  }

public void iterableForEach() {
	List<Integer> intList = Arrays.asList(1,4,5,8,9,10);
	intList.forEach(i->System.out.println(i));
}

public void findMissingNumber() {
	Map<Integer,Integer> intMap = new HashMap<>();
	intMap.put(0, 2);
	intMap.put(1, 56);
	intMap.put(2, 70);
	Integer value = intMap.computeIfPresent(2,(n,v)->n+v);
	System.out.println(value);
}

public void numberPresent() {
	Integer[] intArr = {3,6,8,9,1};
	List<Integer> intList = Arrays.asList(intArr);
	if(intList.contains(3)) {
		System.out.println("num found");
	}else {
		System.out.println("num not found");
	}
}

public void manipulateStringInput() {
	List<String> inputList = Arrays.asList(" madhu "," Rob", "\t meera"," ");
	List<String> modifiedList = inputList.stream().filter(s->!s.isBlank()).map(s->s.trim()).toList();
	modifiedList.forEach(System.out::println); 
}

public void dataFromString() {
	String text = "Madhu";
	char[] textArr = text.toCharArray();
	char c = text.charAt(2);
	if(text.contains("M")) {
		System.out.println(c +" : "+text.indexOf('M')+ ":"+text.subSequence(1, 4));	
	}
}

public void readFromFileAndProcess() {

	/*try (BufferedReader bf = new BufferedReader(new FileReader("/Users/madhuveena/eclipse-workspace/excercise/src/test/resources/TextFile.txt"))){
		String lines = null;
		while((lines = bf.readLine()) != null){
			System.out.println("Lines: "+ lines);			
		}
		
	} catch(IOException ex) {
		ex.printStackTrace();
	} */
	
	try {
	Files.lines(Paths.get("/Users/madhuveena/eclipse-workspace/excercise/src/test/resources/TextFile.txt")).filter(s->!s.isBlank()).forEach(System.out::println);
	//System.out.println("number of lines : "+lineCount);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void stringOperations() {
	String text = "mere jaise ban jaaoge jab ishk tumhe ho jaayga.raat kali ek khwaab.me aayi.jis gali me tera ghar ho balma.us gali se hume gujarna nahin.";
			   
	//String[] textArr = text.strip().split(" |-");
	//System.out.println(Arrays.asList(textArr));
	Pattern p = Pattern.compile("\\w*[.]");
	Matcher m = p.matcher(text);
	
	while(m.find()) {
		System.out.println(m.group());
	}
}

public void findVowelsConsonantCounter(String input) {
	String normalisedInput = input.replaceAll("\\s+", "").toLowerCase();
	System.out.println(normalisedInput);
	int vowelCount = 0;
	int consonantCount = 0;
	Pattern p = Pattern.compile("[(?i)aeiouy]");
	Matcher match = p.matcher(normalisedInput);
	while (match.find()) {
		System.out.println(match.group(0));
		vowelCount++;
	}
	consonantCount = normalisedInput.length() - vowelCount;
	System.out.println("Vowels: " + vowelCount + " Consonants: " + consonantCount);
	int countVowels = normalisedInput.replaceAll("[(?i)aeiouy]", "").length();
	System.out.println("Vowels: " + (normalisedInput.length() - countVowels) + " Consonants: " + countVowels);
}

public void swapElemInArray() {
	String[] availPets = {"cat","dog","fish"};
	String[] unavailPets = {"bird","rabbit","gerbil"};
	String tempVar = null;
	int indexAvailPets =-1;
	int indexUnAvailPets = -1;
	for(int i=0,j=0;i<availPets.length ||j<unavailPets.length ;i++,j++) {
		if(availPets[i].equals("fish")) {
			indexAvailPets = i;
		}
		if(unavailPets[j].equals("bird")) {
			indexUnAvailPets = j;
		}
	}
	tempVar = availPets[indexAvailPets];
	availPets[indexAvailPets] = unavailPets[indexUnAvailPets];
	unavailPets[indexUnAvailPets] = tempVar;
	System.out.println(Arrays.toString(availPets));
	System.out.println(Arrays.toString(unavailPets));
}

public void maximumProductOfTwoArray() {
	 int[] arr = {-2,-1,-3,4,8,0};
	 int max = Integer.MIN_VALUE;
	 int max_i = -1, max_j = -1;
	 for(int i=0;i<arr.length;i++) {
	     for(int j =i+1;j<arr.length-1;j++) {
	    	if(arr[i]*arr[j] > max) {
	    		max = arr[i]*arr[j];
	    		max_i = arr[i];
	    		max_j = arr[j];	    		
	    	}
	     }	   
	 }
	 //complexity o(n2)
 
	 System.out.println("MaxProduct: "+max+ " : "+max_i+" : "+max_j);
	 int len = arr.length;
	 Arrays.sort(arr);
	if((arr[0]*arr[1])>(arr[len-1]*arr[len-2])) {
		 System.out.println("MaxProduct: "+(arr[0]*arr[1])+ " : "+arr[0]+" : "+arr[1]);
	} else {
		System.out.println("MaxProduct: "+(arr[len-1]*arr[len-2])+ " : "+arr[len-1]+" : "+arr[len-2]);
	}
	//complexity o(nlogn)
	
	int max1 = arr[0], max2 = Integer.MIN_VALUE;
	int min1 = arr[0], min2 = Integer.MAX_VALUE;
	for(int i =1;i<len;i++) {
		if(arr[i]>max1) {
			max2 = max1;
			max1 = arr[i];
		} else if (arr[i]>max2) {
			max2 = arr[i];
		}
		if(arr[i]<min1) {
			min2 = min1;
			min1 = arr[i];
		} else if (arr[i]<min2) {
			min2 = arr[i];
		}
	}
	if((max1*max2) >(min1*min2)) {
		System.out.println(max1 + " : "+max2);
	} else {
		System.out.println(min1 + " : "+min2);
	}
	 
}
//{1,1,1,2,2,3,3,3};
public int[] removeDuplicates(int[] nums) {
	
if(nums.length == 0 || nums.length == 1)
     return nums;
	
    int uniqueElem = 0;
    int len = nums.length;
    int[] otherNums = new int[len];
    for(int i=0;i<len-1;i++) {
       if(nums[i] != nums[i+1]) {
           	otherNums[uniqueElem] = nums[i]; 
           uniqueElem++;
        }            
    }
    otherNums[uniqueElem] = nums[len-1];
    for(int i =0;i<=uniqueElem;i++)
        nums[i] = otherNums[i];
        
  return Arrays.copyOf(nums, uniqueElem+1);
}

public int[] plusOne(int[] digits) {
    int len = digits.length;   
     if(digits[len-1] <9) {
         digits[len-1]++; 
         return digits;
     } else {
         StringBuilder strValue = new StringBuilder();
         for(int i =0;i<len;i++) {
             strValue.append(digits[i]);                
         }
         System.out.println(strValue.toString());
         BigInteger bigValue = new BigInteger(strValue.toString());

         bigValue =bigValue.add(new BigInteger("1"));
         String updatedValue = String.valueOf(bigValue);
         char[] charArr = updatedValue.toCharArray();
         int[] newArr = Arrays.copyOf(digits, charArr.length);
         for(int j =0;j<charArr.length;j++) {
           newArr[j] =  Character.getNumericValue(charArr[j]);
         }
         
         return newArr;
     }
 }

public int maxSubArray(int[] nums) {
    int len = nums.length;
    if(len == 1){
        return nums[0];
    }
    
    int sum = 0;
    for(int i =0;i<len;i++) {
       sum += nums[i];        
    }
    System.out.println("Sum value = "+sum);
    
    int[] subArray = new int[len];
    int subArrIndex = 0;
    boolean startingIndex = true;
    boolean endingIndex = true;
    //[-2,1,-3,4,-1,2,1,-5,4]
    //[4,-1,2,1]
    for(int i =0, j=len-1;i<len;i++,j--) {
        if((sum - nums[i]) >=sum && startingIndex) {
          subArray[subArrIndex] = i; 
            subArrIndex++;    
            System.out.println("i: "+subArray[subArrIndex]);
        } else{
            startingIndex = false;
        }
        if((sum - nums[j]) >=sum && endingIndex) {
           subArray[subArrIndex] = j;  
            subArrIndex++;
            System.out.println("j: "+subArray[subArrIndex]);
        } else {
           endingIndex = false; 
        }
    }
    for(int k =0;k<subArrIndex;k++) {
       sum = sum-nums[subArray[k]];
       System.out.println("k: "+nums[subArray[k]]);
    }
    return sum;
}


public static void main(String[] args) {
	CodePractice codePractice = new CodePractice();
//	System.out.println(codePractice.duplicateWords2("the dog is the the dog dog"));
//	System.out.println(codePractice.findRepeatedChars("lalllaaaaa"));
//	System.out.println(codePractice.streamProgram());
  //codePractice.streamForFilterAny();
//	System.out.println(codePractice.printFibNumbers(5));
//	System.out.println(codePractice.latestSwitch());
//	codePractice.replaceMultipleSpaceWIthsingle();
//	codePractice.extractNumbersFromString();
//	codePractice.isVowelsPresent("thfdeaeo");
//	codePractice.stringReverse("australia");
//	codePractice.iterableForEach();
//	codePractice.findMissingNumber();
//	codePractice.numberPresent();
//	codePractice.manipulateStringInput();
	//codePractice.dataFromString();
	//codePractice.readFromFileAndProcess();
	//codePractice.stringOperations();
	//Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	//String text =scanner.next();
	//scanner.close();
    System.out.println(codePractice.palindrome("A man, a plan, a canal: Panama"));
	//codePractice.findVowelsConsonantCounter(text);

	codePractice.swapElemInArray();
	codePractice.maximumProductOfTwoArray();
	int[] nums = {1,1,1,2,2,3,3,3};
	int[] expectedNums = codePractice.removeDuplicates(nums);
	System.out.println("Array: "+Arrays.toString(expectedNums));
	System.out.println(Arrays.toString(codePractice.plusOne(new int[] {5,6,2,0,0,4,6,2,4,9})));
    System.out.println("Largest subarray sum problem:  "+codePractice.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    
	}



}