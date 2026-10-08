public interface Set extends Iterable<Integer>{
    boolean contains(Integer i);
    int cardinal();
    String toString();
    boolean add(Integer i);
    boolean remove(Integer i);
    Set clone();
    boolean include(Set s);
    boolean equals(Set s);

    Set union(Set s);
    Set intersection(Set s);

}