package net.leibi.adventofcode2022.day7;


import java.util.ArrayList;
import java.util.List;
import net.leibi.helpers.InputHelper;

public class Day72022 {

  static final Integer SIZELIMIT = 100000;

  public static Integer getSmallDirectoriesSize(String s) {
    var output = InputHelper.getRowListFromInput(s);

    var root = getDirectoryHierachy(output.subList(1, output.size()), null, "/");

    return root.directoryList.stream().map(Directory::totalSize)
        .filter(directorySize -> directorySize < SIZELIMIT)
        .reduce(0, Integer::sum);
  }

  static Directory getDirectoryHierachy(List<String> output, Directory parentDirectory,
      String newDirectoryName) {
    if (newDirectoryName.equals("..")) {
      return parentDirectory;
    }
    var currentDirectory = new Directory(newDirectoryName);
    var addedDirectories = new ArrayList<Directory>();
    for (int i = 0; i < output.size(); i++) {
      String outputRow = output.get(i);
      String[] splittedOutput = outputRow.split(" ");
      if (splittedOutput[0].equals("$") && splittedOutput[1].equals("cd") && !splittedOutput[2].equals("..")) {
        addedDirectories.add(
            getDirectoryHierachy(output.subList(i + 1, output.size()), currentDirectory,
                splittedOutput[2]));
        break;
      } else if (isFile(splittedOutput)) {
        currentDirectory.files.add(new File(splittedOutput[1], Integer.valueOf(splittedOutput[0])));
      } else if (splittedOutput[0].equals("$") && splittedOutput[1].equals("cd") && splittedOutput[2].equals("..")){
        currentDirectory.directoryList.addAll(addedDirectories);
        return currentDirectory;
      }
    }
    currentDirectory.directoryList.addAll(addedDirectories);
    return currentDirectory;
  }

  private static boolean isFile(String[] splittedOutput) {
    return splittedOutput[0].matches("\\d+");
  }


  public record File(String name, Integer size) {

  }

  record Directory(String name, List<Directory> directoryList, List<File> files) {

    Directory(String name) {
      this(name, new ArrayList<>(), new ArrayList<>());
    }

    public Integer totalSize() {
      return files.stream().map(File::size).reduce(0, Integer::sum)
          + directoryList.stream().map(Directory::totalSize).reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
      return "Directory{" +
          "name='" + name + '\'' +
          '}';
    }
  }
}
