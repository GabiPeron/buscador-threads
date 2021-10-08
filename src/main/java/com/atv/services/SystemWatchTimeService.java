package com.atv.services;

import com.atv.services.contracts.WatchTimeService;


public class SystemWatchTimeService implements WatchTimeService {
  private double startTime;
  private double endTime;

  @Override
  public double getDuration() {
    return endTime - startTime;
  }

  @Override
  public void start() {
    startTime = System.nanoTime();
  }

  @Override
  public void end() {
    endTime = System.nanoTime();
  }
}
