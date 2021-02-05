package commands

import fileSystem.State

trait Command {

  def apply(state: State): State
}

object Command {
  val MkDir = "mkdir"
//  anonymous class
  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }
  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(s"$name : incomplete command")
  }
  
  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    
    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (tokens(0).equals(MkDir)) {
      if (tokens.length < 2) incompleteCommand(MkDir)
      else new MkDirCommand(tokens(1))
    }
    else new UnknownCommand
  }
}