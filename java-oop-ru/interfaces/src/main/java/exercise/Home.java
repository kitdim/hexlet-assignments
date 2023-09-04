package exercise;

// BEGIN
public interface Home extends Comparable<Home> {
    double getArea();

    default int compareTo(Home another) {
        double area1 = getArea();
        double area2 = another.getArea();
        if (area1 > area2)
            return 1;
        else if (area1 < area2)
            return -1;
        else
            return 0;
    }
}
// END
