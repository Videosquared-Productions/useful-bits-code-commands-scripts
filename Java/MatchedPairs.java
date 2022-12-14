import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchedPairs {
    public static void main(String[] args) {
        System.out.println(countUnpaired(new ArrayList<>(Arrays.asList(1,2,3,4))));
        System.out.println(countUnpaired(new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4))));
        System.out.println(countUnpaired(new ArrayList<>(Arrays.asList(1,2,2,3,3,3,4,4,4,4))));
        System.out.println(countUnpaired(new ArrayList<>(Arrays.asList(4,3,2,1,3,2,1,2,1,1))));
    }


    // You have a list of numbers. Write a function which takes the list (either as a list or array, depending on your choice of language) as an 
    // input, and returns a count of how many numbers can not be paired up with another identical number in the list. Each element in the list 
    // can only be a member of a single pair - if we have three elements the same, two of those can pair with each other, leaving the third unpaired.
    // e.g.
    // [1,2,3,4] returns 4 (1,2,3,4 can’t be paired)
    // [1,1,2,2,3,3,4,4] returns 0 (all numbers can be paired)
    // [1,2,2,3,3,3,4,4,4,4] returns 2 (the 1 and one of the 3s can’t be paired)
    // [4,3,2,1,3,2,1,2,1,1] returns 2 (the 4 and one of the 2s can’t be paired)

    public static int countUnpaired(ArrayList<Integer> numbers) {
        Map<Integer, Long> tempMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() % 2));

        return Math.toIntExact(tempMap.values().stream().reduce(Long::sum).get());
    }
}