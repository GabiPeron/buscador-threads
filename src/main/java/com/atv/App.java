package com.atv;

import java.util.Random;

import javax.swing.JFrame;

import com.atv.services.SystemWatchTimeService;

import org.math.plot.Plot2DPanel;

public class App {
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

          continue;
        }

        watchTimeService.end();

        resultsX[i] = arraySize;
        resultsY[i] = watchTimeService.getDuration();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    try {
      var plot = new Plot2DPanel();
      var frame = new JFrame("Comparativo Tempos de Execução");

      plot.addBarPlot("my plot", resultsX, resultsY);

      frame.setContentPane(plot);
      frame.setLocationRelativeTo(null);
      frame.setSize(640, 480);
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
