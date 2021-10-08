package com.atv.services.contracts;

public interface WatchTimeService {
  public abstract double getDuration();

  public abstract void start();

  public abstract void end();
}
