package onv.recursive;

public class Factorial {

    public int compute(int num) {
        if (num == 1)
            return 1;
        return num * compute(num - 1);
    }

    private int compute(int accumulator, int num) {
        if (num == 1) return accumulator;
        return compute(accumulator * num, num - 1);
    }

    public int computeWithAccumulator(int num) {
        return compute(1, num);
    }
}
