package commands

import fileSystem.State

trait Command {
  
  def apply(state: State): State
}

object Command {
  def from(input: String): Command =
    new UnknownCommand
}