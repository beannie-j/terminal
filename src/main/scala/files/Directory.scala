package files

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry]) 
  extends DirEntry(parentPath, name) {
  
  def hasEntry(name: String): Boolean = ???
}

object Directory {
  // constants
  val Separator = "/"
  val RootPath = "/"
  
  def root: Directory = Directory.empty("", "")
  
  def empty(parentPath: String, name: String): Directory =
    new Directory(parentPath, name, List())
}
