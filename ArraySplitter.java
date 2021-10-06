import java.util.Arrays;

public class ArraySplitter {
    private int[] vet;

    public ArraySplitter(int[] vet) {
        this.vet = vet;
    }

    public int[][] split(int quantidade) {
        int dimensao = this.vet.length / quantidade;
        int[][] resultado = new int[quantidade][dimensao];

        int index = 0;
        for (int i = 0; i < this.vet.length; i = i + dimensao) {
            int[] piece = Arrays.copyOfRange(vet, i, dimensao + i);

            resultado[index] = piece;

            index++;
        }

        return resultado;
    }
}
