package com.atv;

import java.util.Random;

import com.atv.services.MathPlotShowResultsService;
import com.atv.services.SystemWatchTimeService;

public class WithTheads {
  public static void main(String[] args) throws InterruptedException {
    int[] arraySizes = {100, 500, 1000, 5000};
    double resultsX[] = new double[4];
    double resultsY[] = new double[4];

    for (int i = 0; i < arraySizes.length; i++) {
      var arraySize = arraySizes[i];
      var resultado = -1;
      var watchTimeService = new SystemWatchTimeService();

      ArrayGenerator generator = new ArrayGenerator(arraySize, arraySize);
      int[] vet = generator.getGenerated();

      Random rand = new Random();
      int alvo = rand.nextInt(arraySize);

      ArraySplitter splitter = new ArraySplitter(vet);
      int[][] splitted = splitter.split(10);

      try {
        watchTimeService.start();

        for (int[] is : splitted) {
          Buscador buscador = new Buscador(is, alvo);

          buscador.start();
          buscador.join();

          resultado = buscador.getResultado();

          if (resultado != -1) {
            System.out.println(resultado);
          }
        }

        if (resultado == -1) {
          System.out.println("Não encontrado...");
        }

        watchTimeService.end();

        resultsX[i] = arraySize;
        resultsY[i] = watchTimeService.getDuration();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    try {
      var showResultsService = new MathPlotShowResultsService(resultsX, resultsY);

      showResultsService.show("Comparativo Tempos de Execução", "Comparativo Tempos de Execução");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
