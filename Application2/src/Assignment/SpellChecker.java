package Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

    public ArrayList<String> spell(String filename) {
	// method body
        String line = null;
        ArrayList<String> token= new ArrayList<String>();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =   new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String newLine[] = line.split("[^a-zA-Z]+");
                for(int i = 0; i < newLine.length; i += 1)
                {
                    if(newLine[i].length()<=1){
                        
                    }else{
                        token.add(newLine[i]);
                    }
                }
                
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filename + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return token;
        
    }

   /**
    * This method takes the list of words not found in the dictionary	
    * and prints a list of non-duplicate words
    * @param ArrayList<String> List of words not found in dictionary	
    */
    public void printNonDuplicates(ArrayList<String> nonDuplicate) {
	// method body
        for(String s:nonDuplicate){
            System.out.println(s);
        }
    }
   
   /**
    * This method returns true if a word in input file stream	
    * (i.e. bonk.txt) is in the dictionary, false otherwise.	
    * @param word a string that contains a word to be checked	
    * @return the boolean status of the word (i.e. true or false)	
    */
    public boolean inDictionary(String word, String[] dictionary) {
	int flag=0;
        for(String s:dictionary){
            if(s.equalsIgnoreCase(word)){
                flag=1;
            }
        }
        if(flag==1) {return true;}
        else {return false;}
        
    }

    public static void main(String[] args) {
      // Prompt the user to enter a file to be spell checked
       ArrayList<String> words= new ArrayList<String>();
      System.out.println("Enter the files name");
      Scanner scanner = new Scanner( System.in );
      String filename = scanner.nextLine();
      SpellChecker sc = new SpellChecker();
      words=sc.spell(filename);
     
      for(String s:words){
          System.out.println(s);
      }
      
      ArrayList<String> dictonary= new ArrayList<String>();
      dictonary=sc.spell("dictionary.txt");
      
      for(String s:dictonary){
          System.out.println(s);
      }
      
      ArrayList<String> unmatched= new ArrayList<String>();
  
      for(String s:words){
          int flag=0;
          for(String d:dictonary){
            if (d.equalsIgnoreCase(s)){
                flag=1;
            }
        }
          if(flag==0){
              unmatched.add(s);
          }
      }
     System.out.println("*************************************************");
     System.out.println("Printing non duplicates"); 
     sc.printNonDuplicates(unmatched);
      
    }
}