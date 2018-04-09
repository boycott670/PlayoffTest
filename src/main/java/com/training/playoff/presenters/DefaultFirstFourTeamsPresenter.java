package com.training.playoff.presenters;

import com.training.playoff.Team;

public final class DefaultFirstFourTeamsPresenter implements FirstFourTeamsPresenter
{

  @Override
  public String[] presentFirstFourTeams(Team[] teams)
  {
    return new String[] {
        String.format("%c vs %c", teams[0].getCode(), teams[3].getCode()),
        String.format("%c vs %c", teams[1].getCode(), teams[2].getCode())
    };
  }
  
}
