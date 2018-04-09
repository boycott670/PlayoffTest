package com.training.playoff.parsers;

import com.training.playoff.Team;

public final class DefaultTeamPairParser implements TeamPairParser
{

  @Override
  public Team[] parsePair(String pair)
  {
    final char[] tokens = pair.toCharArray();
    
    return new Team[] {
      Team.of(tokens[0], 1),
      Team.of(tokens[2], 0)
    };
  }
  
}
