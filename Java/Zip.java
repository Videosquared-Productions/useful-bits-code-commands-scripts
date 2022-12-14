private <T> ArrayList<T> zip(List<ArrayList<T>> listOfLists) {
    int size = listOfLists.get(0).size();
    ArrayList<T> result = new ArrayList<>(size);
    for (int i = 0; i < size; ++i) {
        int finalI = i;
        result.addAll(listOfLists.stream().map(list -> list.get(finalI)).collect(Collectors.toList()));
    }
    return result;
}

/**
 * Zips lists. E.g. given [[1,2,3],[4,5,6]], returns [[1,4],[2,5],[3,6]].
 * @param listOfLists an N x M list
 * @returns an M x N list
 */
static <T> List<List<T>> zip(List<List<T>> listOfLists) {
    int size = listOfLists.get(0).size();
    List<List<T>> result = new ArrayList<>(size);
    for (int i = 0; i < size; ++i)
        result.add(
                listOfLists.stream()
                        .map(list -> list.get(i))
                        .collect(toList()));
    return result;
}