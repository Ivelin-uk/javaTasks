import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public  class Tasks {
    private static Scanner scan = new Scanner(System.in);

    public static void task1(){
        System.out.print("Please enter text: ");
        String input = scan.nextLine();
        System.out.println("Text before reverse: { " + input + " }");
        printArray(input);

        input = reverseString(input);

        System.out.println();
        System.out.println("Text after reverse: { " + input + " }");
        printArray(input);
    }

    public static void task2(){
        System.out.println("Please words separated by space: ");
        System.out.println("Example format:word1 word2 word3 word4...");
        System.out.print("Enter your words:");
        String[] words = scan.nextLine().split(" ");
        HashMap<String,Integer> hashMap = createHashMap(words);
        printHashMapSortedByValue(hashMap);
    }

    public static void task3(){
        System.out.println("Please numbers separated by space: ");
        System.out.println("Example format:1 2 3 4 5 6...");
        System.out.print("Enter your numbers:");
        String line = scan.nextLine();
        printArrayList(creatingArrayList(line));
    }

    public  static void task4(){
        String text = "ddadddddddddddddddddddddddaddd";
        Pattern pattern = Pattern.compile("o", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools!");

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
    /* methods task1 */
    private static void printArray(String text){
        for (int i = 0; i < text.length(); i++) {
            System.out.println("Index[" + i + "] value: " + text.charAt(i));
        }
    }

    private static String reverseString(String text){
        StringBuilder str = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            char current = text.charAt(i);
            str.append(current);
        }
        return  str.toString();
    }

    /* methods task2 */
    private static HashMap<String,Integer> createHashMap(String[] words){
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length;i++) {
            String currentWord = words[i];
            if(!hashMap.containsKey(currentWord)){
                hashMap.put(currentWord,1);
            }else {
                int count = hashMap.get(currentWord);
                count++;
                hashMap.put(currentWord,count);
            }
        }
        return  hashMap;
    }

    private static void printHashMapSortedByValue(HashMap<String,Integer> hashMap){

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String,Integer> e: list){
            String key = e.getKey();
            int value = e.getValue();
            System.out.println("Word: { " + key + " } is repeat:  { " + value + " } times");
        }
    }

    /* methods task3 */
    private  static  ArrayList<Integer> creatingArrayList(String line){
        int[] array = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> list = new ArrayList<Integer>(array.length);
        for (int i : array)
        {
            list.add(i);
        }
        return list;
    }

    private  static void printArrayList(ArrayList<Integer> list){
        System.out.println("For Loop for iterating ArrayList");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index[" + i + "] value: " + list.get(i));
        }
        System.out.println();

        System.out.println("Advanced For Loop");
        for (Integer e: list){
            System.out.println(e);
        }
        System.out.println();

        System.out.println("While Loop for iterating ArrayList");
        int index = 0;
        while (index != list.size()){
            System.out.println("index[" + index + "] value: " + list.get(index));
            index++;
        }
        System.out.println();

        System.out.println("Looping Array List using Iterator");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();
    }

    /* methods task4 */

}
