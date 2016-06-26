package PracticeLang;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DataStructs {

    public static void link_list() {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.remove("F");
        ll.remove(2);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll);
        for (String item : ll) {
            System.out.print(item);
        }
        System.out.println("");
        for (Iterator<String> iterator = ll.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.print(next);
        }
        System.out.println("");
        ll.forEach(item -> System.out.print(item));
        System.out.println("");
        ll.forEach(System.out::print);
        System.out.println("");
        ll.stream().filter(s -> s.contains("B")).forEach(System.out::print);
    }

    public static void array_list() {
//        ArrayList and list same but ArrayList has more functions it inherits from List
        ArrayList<String> al = new ArrayList<>();
        al.add("A");
	al.add("B");
	al.add("C");
	al.add("D");
	al.add("E");
        al.add("F");
        al.remove("F");                
        System.out.println("");
        System.out.println(al.get(0));
        
        System.out.println("");
        for (Iterator<String> iterator = al.iterator(); iterator.hasNext();) {
            String next = iterator.next();            
            System.out.print(next);
        }
        System.out.println("");
        for (String next : al) {
            System.out.print(next);
        }
        System.out.println("");
        al.forEach(System.out::print);
        System.out.println("");
        al.forEach(item->System.out.print(item));
        System.out.println("");
        //Output : C
	al.forEach(item->{
		if("C".equals(item)){
			System.out.println(item);
		}
	});
        al.stream().filter(s->s.contains("B")).forEach(System.out::println);
    }

    public static void hash_map() {
        Map<String, Integer> items = new HashMap<>();
        HashMap<String, Integer> items_hash = new HashMap<>();
        items.put("Zara", 1);
        items.put("Mahnaz", 1);
        items.put("Ayan", 2);
        items.put("Daisy", 4);
        items.put("Qadir", 5);

        items_hash.put("Zara", 1);
        items_hash.put("Mahnaz", 1);
        items_hash.put("Ayan", 2);
        items_hash.put("Daisy", 4);
        items_hash.put("Qadir", 5);

        System.out.println(items.keySet());
        System.out.println(items.get("Zara"));
        System.out.println(items.containsValue(3));
        System.out.println(items.containsValue(2));
        System.out.println(items.containsKey("Ayan"));
        System.out.println(items.containsKey("a"));

        System.out.println(items_hash.keySet());
        System.out.println(items_hash.get("Zara"));
        System.out.println(items_hash.containsValue(3));
        System.out.println(items_hash.containsValue(2));
        System.out.println(items_hash.containsKey("Ayan"));
        System.out.println(items_hash.containsKey("a"));

        System.out.println("Entry Set");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        System.out.println("Iterator Set");
        Set set = items.entrySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.println("Item : " + me.getKey() + " Count : " + me.getValue());
        }
        System.out.println("Entry Set");
        for (Map.Entry<String, Integer> entry : items_hash.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        System.out.println("Iterator Set");
        set = items_hash.entrySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.println("Item : " + me.getKey() + " Count : " + me.getValue());
        }

        System.out.println("Lambda Best");
        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
        });
        System.out.println("Lambda Best");
        items_hash.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
        });

    }

    public static void main(String[] args) {
//        link_list();
//        hash_map();
        array_list();
    }

}
