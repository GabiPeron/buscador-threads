import java.util.Random;

public class ArrayGenerator {
    private int size;
    private int[] generated;
    private Random rand;
    private int max;

    public ArrayGenerator(int size, int max) {
        this.size = size;
        this.rand = new Random();
        this.max = max;
        this.generated = new int[size];

        this.generate();
    }

    public int[] getGenerated() {
        return this.generated;
    }

    public void generate() {
        for (int i = 0; i < this.size; i++) {
            this.generated[i] = this.rand.nextInt(this.max);
        }
    }
}
