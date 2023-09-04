package exercise;

// BEGIN
public interface Home extends Comparable<Home> {
    double getArea();

    default int compareTo(Home another) {
        double area1 = getArea();
        double area2 = another.getArea();
        return Double.compare(area1, area2);
    }
}
// END
