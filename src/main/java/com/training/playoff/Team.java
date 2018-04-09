package com.training.playoff;

import java.util.Comparator;
import java.util.Map.Entry;

public class Team implements Comparable<Team>
{
  private final char code;
  private final int score;
  
  private Team (final char code, final int score)
  {
    this.code = code;
    this.score = score;
  }
  
  public static Team of (final char code, final int score)
  {
    return new Team(code, score);
  }
  
  public static Team of (final Entry<? extends Character, ? extends Integer> pairOfCodeAndScore)
  {
    return new Team(pairOfCodeAndScore.getKey(), pairOfCodeAndScore.getValue());
  }

  public char getCode()
  {
    return code;
  }

  public int getScore()
  {
    return score;
  }

  @Override
  public int compareTo(final Team other)
  {
    return Comparator.comparing(Team::getScore)
        .reversed()
        .thenComparing(Team::getCode)
        .compare(this, other);
  }
}
