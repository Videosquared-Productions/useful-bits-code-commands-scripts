import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BuildingNavigation {
    public static void main(String[] args) {
        ArrayList<Integer[]> data = new ArrayList<>();
        data.add(new Integer[]{0, 1});
        data.add(new Integer[]{1, 2});
        data.add(new Integer[]{1, 3});
        data.add(new Integer[]{2, 4});
        data.add(new Integer[]{4, 5});
        data.add(new Integer[]{3, 4});

        System.out.println(furthestRoom(data));
    }


    // An access control system defines a building using rooms and doors, where a door goes from one room to another. 
    // Write a function which calculates the minimum number of doors we need to pass through to get from room 0 to 
    // the furthest room? Room numbers may not be sequential, and the highest numbered room may not be the one which 
    // is furthest from the start point.
    //
    //The input to your function will, depending on your choice of language, be an array or list, each element of 
    // which is either an array or tuple of size two, where the two elements represent the rooms which the door 
    // joins. For example, [3,4] means there is a door between room 3 and room 4 i.e. it’s possible to pass from 
    // room 3 to room 4, or from room 4 to room 3.
    //
    //e.g.
    //    doors = [[0,1], [1,2], [1,3], [2,4], [4,5], [3,4]]
    //    The rooms are defined implicitly if they appear in the doors list; in the example above the rooms are 0,1,2,3,4,5
    //    In this case the shortest path to
    //        room 1 = 1 (0->1)
    //        room 2 = 2 (0->1->2)
    //        room 3 = 2 (0->1->3)
    //        room 4 = 3 (0->1->2->4)
    //        room 5 = 4 (0->1->3->4->5)
    //    So the function should return 4


    public static int furthestRoom(ArrayList<Integer[]> input) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (Integer[] data : input) {
            ArrayList<Integer> mapData = map.computeIfAbsent(data[0], k -> new ArrayList<>());
            mapData.add(data[1]);
        }

        System.out.println(map);

        return findDepth(map, 0);
    }

    public static int findDepth(Map<Integer, ArrayList<Integer>> roomMap, int currRoom) {

        if (roomMap.get(currRoom) == null) {
            return 0;
        }

        ArrayList<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < roomMap.get(currRoom).size(); i++) {
            tempList.add(findDepth(roomMap, roomMap.get(currRoom).get(i)));
        }

        return 1 + Collections.max(tempList);

    }


}