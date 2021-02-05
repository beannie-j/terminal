package commands
import fileSystem.State
import files.Directory

class MkDirCommand(name: String) extends Command {
  override def apply(state: State): State = {
    val workingDirectory: Directory = state.workingDirectory
    if (workingDirectory.hasEntry(name)) {
      state.setMessage(s"Entry ${name} already exists")
    } else if (name.contains(Directory.Separator)) {
      // mkdir something/something
      state.setMessage(s"${name} must not contain separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(s"${name} : Illegal entry name")
    } else {
      doMkdir(state, name)
    }
  }
  
  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }
  
  def doMkdir(state: State, name: String): State = {
    ???
  }
}
