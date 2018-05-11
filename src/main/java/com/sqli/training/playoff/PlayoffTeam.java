package com.sqli.training.playoff;

import java.util.Objects;

final class PlayoffTeam
{
  private final char label;
  private final int score;
  
  PlayoffTeam(char label, int score)
  {
    this.label = label;
    this.score = score;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(label);
  }

  @Override
  public boolean equals(Object other)
  {
    return other instanceof PlayoffTeam ? Objects.equals(label, ((PlayoffTeam)other).label) : false;
  }

  int getScore()
  {
    return score;
  }

  @Override
  public String toString()
  {
    return String.valueOf(label);
  }
}
