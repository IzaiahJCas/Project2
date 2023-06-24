/* Izaiah Caston
 * this class is used to manipulate strings in various different ways to create new strings that have
 * been modified in various different ways */

public class HW2{
 
  /*this method loops through an inputed string and checks that for each parentheses there is a matching
   * parentheses, such that there is ()*/
  public static boolean matchingParentheses(String x){
    //this variable acts as a counter for the different types of parentheses
    int position = 0;
    //this method acts as an indicater stating that matching parentheses have been found
    boolean found = false;
    
    /* this loop starts at the beginning of the string, and iterates through by an increment of one
     * until the end of the string.
     * the goal of the loop is to count whether or not there is a matching pair of parentheses */
    for(int i = 0; i < x.length(); i++){
      if(x.charAt(i) == '('){
        position = position + 1;      
      }     
      else if(x.charAt(i) == ')'){
        position = position - 1; 
        found = true;
      }
    }
    return (position == 0 && true);
  }
  
  /* This method loops through a given string, it starts are the int value that is given
   * the method will skip over a certain number of characters in the string based on input
   * and the method will ignore the values that are inputed*/
  public static String everyNthExcept(String string, int start, int skip, int except){
    //this is the string builder that we are appending the characters into
    StringBuilder stringBuilder = new StringBuilder();
    //this is just making sure that the start value we choose wont skip over a character accidently
    start = start - 1;
    stringBuilder.append(string.charAt(start));   
    
    /* This loop starts are the start value that is inputed, and it iterates through the length
     * of the string on an increment of the current index plus the inputted skip value*/
    for(int i = start; i < string.length(); i = i + skip){
      if((start - i)%except != 0){
        stringBuilder.append(string.charAt(i));
      }
    }
    return stringBuilder.toString(); 
  }
  
  /* This method takes the first k characters of the input in order
   * the next k characters of the input in reverse order
   * and the next k characters of the input string in normal order*/
  public static String flipEachK(String string, int k){
    //This string builder is the main string that will be appended to and outputted
    StringBuilder stringBuilder = new StringBuilder();
    /*This string builder takes the set of characters in the string that need to be reversed
     *and stores them*/
    StringBuilder reverseString = new StringBuilder();
    //this is a counter that counts the set of characters the loop is on
    int position = 0;
    
    /*this loop starts at the begging of the string, lasts until the end of the string
     * and increments by one*/
    for(int i = 0; i < string.length(); i++){
      //checks if the position character is even or zero
      if((position % 2) == 0){
        /*starts at zreo and continues till the end of the string as long as w is less than the 
         * input k, increments by one*/
        for(int w = 0; i < string.length() && w < k; w++){
          stringBuilder.append(string.charAt(i));
          i = i + 1;
        }
        //keeps the index from going out of bounds
        i = i - 1;
        //counts that one set of characters has been passed through
        position = position + 1;
      }
      
      else{
        reverseString = new StringBuilder();
        /*starts at the beginning of the string, and continues to iterate to the end of the string
         * as long as w is less than the input k, increments by one*/
        for(int w = 0; i < string.length() && w < k; w++){ 
          reverseString.append(string.charAt(i));
          i = i + 1;
        }     
        //keeps the index from going out of bounds
        i = i - 1;
        /* starts at the beginning length of the reverse string, continues aslong as w is greater than
         * or equal to zero, increment decreases by one*/
        for(int w = reverseString.length() - 1; w >= 0; w--){
          stringBuilder.append(reverseString.charAt(w)); 
        }
        //counts that another set of characters had been passed through
        position = position + 1;
      }
    }
    
    return stringBuilder.toString();
  }
  
  /*This method takes the inputted string and reverses the order in which the numbers appear
   * in the code while keeping the alphabet characters in place*/
  public static String reverseDigits(String string){
    //string builder that will be appended to and outputted
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0; 
    int l = string.length() - 1;
    //loops until the index reaches the end of the string
    while(i < string.length()){
      /* iterates through the string until the end of the string
       * only appends characters if the character at the index is not a digit*/
      while(i < string.length() && (((Character.isDigit(string.charAt(i))) != true))){
        stringBuilder.append(string.charAt(i));
        i++;
      }
      /* while the index is greater than or equal to 0 and the character at the index between
       * 9 and 0, causes the string to loop from the end*/
      while(l >= 0 && (string.charAt(l) > '9' || string.charAt(l) < '0'))
        l--;
      //while the index is greater than or equal to zero, append the characters at l index
      if(l >= 0)
        stringBuilder.append(string.charAt(l));
      //keeps i index inbounds and increasing
      i++;
      //keeps the l index inbounds, and decreasing
      l--;
    }
    return stringBuilder.toString();
  }
  
  /*This method takes a string and checks if matchingParentheses is true
   * if it is true then the method passes through the string looking for parentheses to remove
   * the method then checks if the position variable is an even number, and appends to the string*/
  public static String editOut(String string){
    //makes sure that the string is not matching parentheses
    if(matchingParentheses(string) != true){
      return null; 
    }
    //String builder that will be appended into and outputted
    StringBuilder stringBuilder = new StringBuilder();
    //Counts the parentheses that are inside the string
    int parenthesesCt = 0;
    
    //starts at the beginning of the string and continues until the end, increments by one
    for(int i = 0; i < string.length(); i++){
      //checks if the character at the current index is a open parentheses increases counter by one
      if(string.charAt(i) == '('){
        parenthesesCt = parenthesesCt + 1;      
      }
      //checks if the character at the current index is a closed parentheses decreases counter by one
      else if(string.charAt(i) == ')'){
        parenthesesCt = parenthesesCt - 1; 
      }
      //checks if the counter is even or not, if it is then append the character at current index
      else if((parenthesesCt % 2) == 0){
        stringBuilder.append(string.charAt(i));
      }
      else;
      
    }
    return stringBuilder.toString();    
  }
  
  /*This method takes two input strings
   * the first string will only append characters not in matching parentheses
   * the second string will only append characters that are in matching parentheses*/
  public static String replaceText(String string1, String string2){
    if(matchingParentheses(string2) != true){
      return null; 
    }
    //the main string
    StringBuilder stringBuilder = new StringBuilder();
    //the temp string for string 2 that gets added to the main string
    StringBuilder tempString = new StringBuilder();
    //to indicate when the sub string has been found
    boolean found = false;
    //the counter for the parentheses of string 1
    int position = 0;
    //the counter for sub strings
    int counter = 1;
    int openParenth = 0;
    int closedParenth = 0;
    int l = 0;
    //iterates through string 1 and appends characters that aren't in matching parentheses
    for(int i = 0; i < string1.length(); i++){   
      if(string1.charAt(i) == '('){
        position = position + 1;      
      }
      else if(string1.charAt(i) == ')'){
        position = position - 1; 
      }
      else if((position % 2) == 0){
        stringBuilder.append(string1.charAt(i));
      }
      else;
    }
    counter--; 
    //iterates through string 2 and appends characters that are in matching parentheses
    for(int i = 0; i < string2.length(); i++){   
      if(string2.charAt(i) == '('){
        openParenth++; 
      }
      else if(string2.charAt(i) == ')'){
        closedParenth--; 
      }
      else if(((openParenth % 2) != 0 || (closedParenth % 2) != 0)){
        stringBuilder.append(string2.charAt(i)); 
      }
      else;
    }
    stringBuilder.append(tempString);
    
    return stringBuilder.toString(); 
  }
  
}

 
