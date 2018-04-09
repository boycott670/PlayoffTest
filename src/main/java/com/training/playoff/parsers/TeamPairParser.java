package com.training.playoff.parsers;

import com.training.playoff.Team;

public interface TeamPairParser
{
  Team[] parsePair (final String pair);
}
