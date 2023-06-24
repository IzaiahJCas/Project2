import org.junit.*;
import static org.junit.Assert.*;
public class HW2Tester{
  @Test 
  public void testMatchingParentheses(){
    //test for zero
    assertEquals(true, HW2.matchingParentheses("There are no matching")); 
    assertEquals(false, HW2.matchingParentheses("(There are no matching")); 
    assertEquals(false, HW2.matchingParentheses("There are no matching)"));    
    //test for one
    assertEquals(true, HW2.matchingParentheses("T(h)ere are no matching")); 
    assertEquals(true, HW2.matchingParentheses("There are no m(a)tching")); 
    assertEquals(true, HW2.matchingParentheses("(There are no matching)")); 
    //test for many
    assertEquals(false, HW2.matchingParentheses("(There are no m)a)t)c)hing)")); 
    assertEquals(true, HW2.matchingParentheses("(There (are no mat)ching)")); 
    assertEquals(true, HW2.matchingParentheses("(The(re are (no matc)hin)g)")); 
    assertEquals(false, HW2.matchingParentheses("(There( (a(re no mat)ching)")); 
  }
  @Test
  public void testEveryNthExcept(){
    //test for first
    assertEquals("a", HW2.everyNthExcept("abcdefghijklmnop", 1, 1, 1));  
    //test for last
    assertEquals("p", HW2.everyNthExcept("abcdefghijklmnop", 16, 2, 4)); 
    //test for middle
    assertEquals("bdhlp", HW2.everyNthExcept("abcdefghijklmnop", 2, 2, 4));
    assertEquals("ceim", HW2.everyNthExcept("abcdefghijklmnop", 3, 2, 4));
    assertEquals("bgl", HW2.everyNthExcept("abcdefghijklmnop", 2, 5, 4));
    assertEquals("dgjm", HW2.everyNthExcept("abcdefghijklmnop", 4, 3, 4));
  }
  
  @Test
  public void testFlipEachK(){
    //test for zero
    assertEquals("abcdefghijklmn", HW2.flipEachK("abcdefghijklmn", 1));
    assertEquals("abcdefghijklmn", HW2.flipEachK("abcdefghijklmn", 16));
    //test for one 
    assertEquals("abcdefghijklnm", HW2.flipEachK("abcdefghijklmn", 12));
    //test for many
    assertEquals("abdcefhgijlkmn", HW2.flipEachK("abcdefghijklmn", 2));
    assertEquals("abcdeflkjihgmn", HW2.flipEachK("abcdefghijklmn", 6));
    assertEquals("abcdefghnmlkji", HW2.flipEachK("abcdefghijklmn", 8));
    assertEquals("abcdhgfeijklnm", HW2.flipEachK("abcdefghijklmn", 4));
  }
  
  @Test
  public void testReverseDigits(){
    //test for zero
    assertEquals("this is test one", HW2.reverseDigits("this is test one"));
    //test for one
    assertEquals("1this is test0 one", HW2.reverseDigits("0this is test1 one"));
    assertEquals("3this is test one1", HW2.reverseDigits("1this is test one3"));
    //test for many
    assertEquals("7this5 is2 test one1", HW2.reverseDigits("1this2 is5 test one7"));
    assertEquals("7thi4s is tes1t one", HW2.reverseDigits("1thi4s is tes7t one"));
    assertEquals("9this7 is t5est one3", HW2.reverseDigits("3this5 is t7est one9"));
    assertEquals("7this is 6test 5one2", HW2.reverseDigits("2this is 5test 6one7"));
  }
  
  @Test
  public void testEditOut(){
    //test for first
    assertEquals("T", HW2.editOut("T(his is zero)"));
    assertEquals("his is zero", HW2.editOut("(T)his is zero"));
    //test for last
    assertEquals("This is zer", HW2.editOut("This is zer(o)"));
    assertEquals("o", HW2.editOut("(This is zer)o"));
    //test for middle
    assertEquals("This is  one", HW2.editOut("This is (test) one"));
    assertEquals("s ", HW2.editOut("(This i)s (test one)"));
  }
  
  @Test 
  public void testReplaceText(){
    //test for zero
    assertEquals("", HW2.replaceText("(a test)", "a test"));
    //test for one
    assertEquals("a cool", HW2.replaceText("a (simple)", "(cool)"));
    //test for many
    assertEquals("a cool programming problem", HW2.replaceText("a (simple) programming (example)", "(cool) (problem)"));
    assertEquals("an answer with really (two) not three replacements ", HW2.replaceText("a ((nested) example) with (three) replacements (to (handle))", "the replacements are (answer) and (really (two) not three)"));
    assertEquals("The Last test is this one", HW2.replaceText("The (this is(to trick)) this one", "nothing here (last test)"));  
  }
}














    
    
    
    
    
    
 
    
    
  
  
  
  
  