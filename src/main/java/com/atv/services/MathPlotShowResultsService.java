package com.atv.services;

import javax.swing.JFrame;

import com.atv.services.contracts.ShowResultsService;

import org.math.plot.Plot2DPanel;


public class MathPlotShowResultsService implements ShowResultsService {
  private final double[] xData;
  private final double[] yData;
  private final int xResolution = 820;
  private final int yResolution = 480;

  public MathPlotShowResultsService(double[] xData, double[] yData) {
    this.xData = xData;
    this.yData = yData;
  }

  @Override
  public void show(String title, String message) {
    var plot = new Plot2DPanel();
    var frame = new JFrame(title);

    plot.addBarPlot(message, xData, yData);

    frame.setContentPane(plot);
    frame.setLocationRelativeTo(null);
    frame.setSize(xResolution, yResolution);
    frame.setVisible(true);
  }
}
