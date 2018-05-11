package com.sqli.training.playoff;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Playoff
{
  private final PlayoffTeam[] teams;
  
  Playoff(final String[] qualificationsResults)
  {
    final Function<Character[], PlayoffTeam[]> qualificationsResultsEntryParser = entry -> new PlayoffTeam[] {
        new PlayoffTeam(entry[0], 1),
        new PlayoffTeam(entry[1], 0)
    };
    
    teams = Arrays.stream(qualificationsResults)
        .map(entry -> Arrays.stream(entry.split(" "))
            .map(team -> team.charAt(0))
            .toArray(Character[]::new))
        .map(qualificationsResultsEntryParser)
        .flatMap(Arrays::stream)
        .toArray(PlayoffTeam[]::new);
  }
  
  String[] layout()
  {
    final Deque<PlayoffTeam> FourBestPlayoffTeams = Arrays.stream(teams)
        .collect(Collectors.toMap(Function.identity(), PlayoffTeam::getScore, Integer::sum))
        .entrySet()
        .stream()
        .sorted(Entry.<PlayoffTeam, Integer>comparingByValue()
            .reversed())
        .map(Entry::getKey)
        .limit(4)
        .collect(Collectors.toCollection(ArrayDeque::new));
    
    return Stream
        .generate(
            () -> String.format("%s vs %s", FourBestPlayoffTeams.removeFirst(), FourBestPlayoffTeams.removeLast()))
        .limit(2)
        .toArray(String[]::new);
  }
}
