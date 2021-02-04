package fileSystem

import commands.Command
import files.Directory

import java.util.Scanner

object FileSystem extends App {

  val root = Directory.root // returns empty Directory
  var state = State(root, root) // returns State with root
  val scanner = new Scanner(System.in)

  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }

}
