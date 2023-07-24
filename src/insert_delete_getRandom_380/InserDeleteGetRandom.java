package insert_delete_getRandom_380;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/solutions/1495119/java-tc-o-1-sc-o-n-using-arraylist-hashmap/?envType=study-plan-v2&envId=top-interview-150
// 380. Insert Delete GetRandom O(1)
//Implement the RandomizedSet class:
//
//RandomizedSet() Initializes the RandomizedSet object.
//bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
//bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
//int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
//You must implement the functions of the class such that each function works in average O(1) time complexity.
public class InserDeleteGetRandom {
  Map<Integer, Integer> map;
  List<Integer> list;
  Random random;

  public static void main(String[] args) {
    InserDeleteGetRandom r = new InserDeleteGetRandom();

    System.out.println(r.remove(0));
    System.out.println(r.remove(0));
    System.out.println(r.insert(0));
    System.out.println(r.getRandom());
    System.out.println(r.remove(0));
    System.out.println(r.insert(0));

  }



    public InserDeleteGetRandom() {
      list = new ArrayList<>();
      map = new HashMap<>();
      random = new Random();
    }

    public boolean insert ( int val){
      if (map.containsKey(val)) {
        return false;
      }

      map.put(val, list.size());
      list.add(val);
      return true;
    }

    public boolean remove ( int val){
      if (!map.containsKey(val)) {
        return false;
      }
      int lastElem = list.get(list.size() - 1);
      int index = map.get(val);
      list.set(index, lastElem);
      list.remove(list.size() - 1);
      map.put(lastElem, index);
      map.remove(val);

      return true;

    }

    public int getRandom () {

      return list.get(random.nextInt(list.size()));
    }
  }