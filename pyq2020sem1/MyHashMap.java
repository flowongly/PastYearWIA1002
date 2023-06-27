import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    
    public class Entry {
        public String key;
        public String valuePairs;
    
        public Entry(String key, String valuePairs){
          this.key = key;
          this.valuePairs = valuePairs;
        }
    
        public String getKey(){
          return key;
        }
    
        public String getValue(){
          return valuePairs;
        }
    
        public void setValue(String value){
          this.valuePairs = valuePairs;
        }
    }
    
    public List<Entry>[] buckets;
    private int capacity;
    
    public MyHashMap(){
        this.capacity = 20;
        this.buckets = new ArrayList[capacity];
    }
    
    public void put(String key, String value){
        int hash = getHash(key);
        List<Entry> bucket = buckets[hash];
        
        if(bucket == null){
            bucket = new ArrayList<>();
            buckets[hash]=bucket;
        }
        for(Entry entry : bucket){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }
    
    public int getHash(String key){
        return key.hashCode()% capacity;
    }
    
    public Entry get(String key){
        int hash = getHash(key);
        List<Entry> bucket = buckets[hash];
        
        if(bucket != null){
            for(Entry entry : bucket){
                if(entry.getKey().equals(key)){
                    return entry;
                }
            }
        }
        return null;
    }
    public void display(){
        for (List<Entry> bucket : buckets) {
            if(bucket != null){
                for(Entry entry : bucket){
                    System.out.println(entry.getKey() + ": "+entry.getValue());
                }
            }
        }
    }
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        System.out.println("New Directory Entry : ");
        myHashMap.put("BruceW", "011-8998990");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402099");
        myHashMap.display();

        System.out.println("\nGet Directory");
        Entry e1 = myHashMap.get("DeanW");
        System.out.println("DeanW: " + e1.getValue());
        Entry e2 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e2.getValue());

        System.out.println("\nUpdate directory");
        myHashMap.put("BruceW", "011-5677900");
        myHashMap.put("JeanG", "0190-001123");
        
        // Get directory:
        System.out.println("Get Directory");
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("BruceW" + e3.getValue());
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("JeanG" + e4.getValue());
    }
}
