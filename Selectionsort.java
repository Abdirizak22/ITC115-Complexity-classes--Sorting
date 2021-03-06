public class SelectionSort<T extends Comparable<T>> implements SortingAlg<T> {

    @Override
    public void sort(List<T> elements) {
        if (elements == null) return;
        for (int i = 0; i < elements.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < elements.size(); j++) {
                if (isLessThan(elements.get(j), elements.get(min)))
                    min = j;
            }
            T temp = elements.get(i);
            elements.set(i, elements.get(min));
            elements.set(min, temp);
        }
    }
    private boolean isLessThan(T first, T second) {
        return first.compareTo(second) < 0;
    }
    public static void main(String[] args) {
        SortingAlg<Integer> alg = new SelectionSort<Integer>();
        List<Integer> elems = java.util.Arrays.asList(9,5,2,7,3,8,2,1,4,7,5,3,9);
        alg.sort(elems);
        for (int i = 0; i < elems.size() - 1; i++) {
            if (elems.get(i).compareTo(elems.get(i+1)) > 0)
                throw new java.lang.RuntimeException("Elems should be sorted.");
        }
        System.out.println("All tests passed.");
    }

}
