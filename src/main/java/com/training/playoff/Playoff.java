package com.training.playoff;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.training.playoff.parsers.DefaultTeamPairParser;
import com.training.playoff.parsers.TeamPairParser;
import com.training.playoff.presenters.DefaultFirstFourTeamsPresenter;
import com.training.playoff.presenters.FirstFourTeamsPresenter;

public final class Playoff
{
  private final TeamPairParser parser = new DefaultTeamPairParser();
  private final FirstFourTeamsPresenter presenter = new DefaultFirstFourTeamsPresenter();
  private final Collection<Team> teams;
  
  public Playoff (final String[] pairs)
  {
    teams = Arrays.stream(pairs)
      .map(parser::parsePair)
      .flatMap(Arrays::stream)
      .collect(Collectors.toList());
  }
  
  public String[] layout ()
  {
    final Team[] firstFourTeams = teams.stream()
      .collect(Collectors.groupingBy(Team::getCode, Collectors.summingInt(Team::getScore)))
      .entrySet()
      .stream()
      .map(Team::of)
      .sorted()
      .limit(4)
      .toArray(Team[]::new);
    
    return presenter.presentFirstFourTeams(firstFourTeams);
  }
}
