import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayGenerator generator = new ArrayGenerator(1000, 1000);
        int[] vet = generator.getGenerated();

        Random rand = new Random();
        int alvo = rand.nextInt(1000);

        ArraySplitter splitter = new ArraySplitter(vet);
        int[][] splitted = splitter.split(10);

        int resultado = -1;
        for (int[] is : splitted) {
            Buscador buscador = new Buscador(is, alvo);

            buscador.start();
            buscador.join();

            resultado = buscador.getResultado();

            if (resultado != -1) {
                System.out.println(resultado);
                break;
            }
        }

        if (resultado == -1){
            System.out.println("Não encontrado...");
        }
    }
}
