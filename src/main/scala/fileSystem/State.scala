package fileSystem

import files.Directory

class State(val root: Directory, val workingDirectory: Directory, val output: String) {

  def show: Unit = {
    println(output)
    print(State.ShellToken)
  }
  
  def setMessage(message: String): State = State(root, workingDirectory, message) // calls the apply method in object
}

object State {
  val ShellToken = "$ "
  // we avoid creating objects by hand
  def apply(root: Directory, workingDirectory: Directory, output: String =""): State =
    new State(root, workingDirectory, output)
}
