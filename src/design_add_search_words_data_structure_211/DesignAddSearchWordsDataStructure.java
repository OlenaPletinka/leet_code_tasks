package design_add_search_words_data_structure_211;

/**
 * 211. Design Add and Search Words Data Structure
 *https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false
 * otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 */
public class DesignAddSearchWordsDataStructure {
  DesignAddSearchWordsDataStructure []children;
  boolean isEnd;
  public DesignAddSearchWordsDataStructure() {
    children = new DesignAddSearchWordsDataStructure[26];
    isEnd = false;
  }

  public void addWord(String word) {
    DesignAddSearchWordsDataStructure curr = this;
    for(char c:word.toCharArray()){
      if(curr.children[c-'a'] == null){
        curr.children[c-'a'] = new DesignAddSearchWordsDataStructure();
      }
      curr = curr.children[c-'a'];
    }
    curr.isEnd = true;
  }

  public boolean search(String word) {
    DesignAddSearchWordsDataStructure curr = this;
    for(int i = 0; i<word.length(); ++i){
      char c = word.charAt(i);
      if(c == '.'){
        for(DesignAddSearchWordsDataStructure node:curr.children){
          if(node != null && node.search(word.substring(i+1))){
            return true;
          }

        }
        return false;
      }
      if(curr.children[c-'a'] == null){
        return false;
      }
      curr = curr.children[c-'a'];

    }
    return  curr.isEnd;
  }

  public static void main(String[] args) {
    DesignAddSearchWordsDataStructure d = new DesignAddSearchWordsDataStructure();

    d.addWord("bad");
    d.addWord("dad");
    d.addWord("mad");
    System.out.println(d.search("pad"));
    System.out.println(d.search("bad"));
    System.out.println(d.search(".ad"));
    System.out.println(d.search("b.."));
  }
}

