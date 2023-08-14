package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
    void initIntegerList() {
        this.numbers = new ArrayList<>();
        this.numbers.add(5);
        this.numbers.add(7);
        this.numbers.add(6);
    }

    @Test
    void testTake1() {
        List<Integer> actual = App.take(numbers, 8);
        assertThat(actual).isEqualTo(numbers);
    }
    @Test
    void testTake2() {
        List<Integer> actual = App.take(numbers, 0);
        List<Integer> expect = new ArrayList<>();
        assertThat(actual).isEqualTo(expect);
    }
    @Test
    void testTake3() {
        List<Integer> actual = App.take(numbers, 1);
        List<Integer> expect = new ArrayList<>();
        expect.add(5);
        assertThat(actual).isEqualTo(expect);
    }
    @Test
    void testTake4() {
        List<Integer> actual = App.take(numbers, -5);
        List<Integer> expect = new ArrayList<>();
        assertThat(actual).isEqualTo(expect);
    }
    @Test
    void testTake5() {
        List<Integer> actual = App.take(new ArrayList<>(), 5);
        List<Integer> expect = new ArrayList<>();
        assertThat(actual).isEqualTo(expect);
    }
}
