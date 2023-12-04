package net.leibi.adventofcode2022.day7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import net.leibi.adventofcode2022.day7.Day72022.Directory;
import net.leibi.adventofcode2022.day7.Day72022.File;
import net.leibi.helpers.InputHelper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day72022Test {

  @Test
  void getDirectoryHierachy() {

    String input = """
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
          """;

    Directory directoryHierachy = Day72022.getDirectoryHierachy(
        InputHelper.getRowListFromInput(input), null, "/");
    assertThat(directoryHierachy).isNotNull();
    assertThat(directoryHierachy.directoryList()).isEmpty();
    assertThat(directoryHierachy.files()).hasSize(2);



  }

  @Test
  @Disabled
  void getDirectoryHierachyWithFilesInA() {

    String input = """
      $ ls
      dir a
      14848514 b.txt
      8504156 c.dat
      dir d
      $ cd a
      $ ls
      dir e
      29116 f
      2557 g
      62596 h.lst
      """;

    Directory directoryHierachy = Day72022.getDirectoryHierachy(
        InputHelper.getRowListFromInput(input), null, "/");
    assertThat(directoryHierachy).isNotNull();
    assertThat(directoryHierachy.directoryList()).hasSize(1);
    assertThat(directoryHierachy.directoryList().get(0).files()).hasSize(2);
    assertThat(directoryHierachy.files()).hasSize(2);

  }

  @Test
  void getDirectoryHierachyWithFilesInAAndE() {

    String input = """
      $ ls
      dir a
      14848514 b.txt
      8504156 c.dat
      dir d
      $ cd a
      $ ls
      dir e
      29116 f
      2557 g
      62596 h.lst
      $ cd e
      $ ls
      584 i
      """;

    Directory directoryHierachy = Day72022.getDirectoryHierachy(
        InputHelper.getRowListFromInput(input), null, "/");
    assertThat(directoryHierachy).isNotNull();
    assertThat(directoryHierachy.directoryList()).hasSize(1);
    assertThat(directoryHierachy.directoryList().get(0).name()).isEqualTo("a");
    assertThat(directoryHierachy.directoryList().get(0).files()).hasSize(3);
    assertThat(directoryHierachy.directoryList().get(0).directoryList()).hasSize(1);
    assertThat(directoryHierachy.directoryList().get(0).directoryList().get(0).name()).isEqualTo("e");
    assertThat(directoryHierachy.directoryList().get(0).directoryList().get(0).files()).hasSize(1);
    assertThat(directoryHierachy.files()).hasSize(2);
  }


  @Test
  void getDirectoryHierachySmall() {

    List<String> rowListFromInput = InputHelper.getRowListFromInput(Input.small);
    Directory directoryHierachy = Day72022.getDirectoryHierachy(
        rowListFromInput.subList(1,rowListFromInput.size()), null, "/");
    assertThat(directoryHierachy).isNotNull();
    assertThat(directoryHierachy.directoryList()).hasSize(1);
    assertThat(directoryHierachy.directoryList().get(0).name()).isEqualTo("a");
    assertThat(directoryHierachy.directoryList().get(0).files()).hasSize(3);
    assertThat(directoryHierachy.directoryList().get(0).directoryList()).hasSize(1);
    assertThat(directoryHierachy.directoryList().get(0).directoryList().get(0).name()).isEqualTo("e");
    assertThat(directoryHierachy.directoryList().get(0).directoryList().get(0).files()).hasSize(1);
    assertThat(directoryHierachy.files()).hasSize(2);
  }


  @Test
  @Disabled
  void getSmallDirectoriesSize() {
    assertThat(Day72022.getSmallDirectoriesSize(Input.small)).isEqualTo(95437);
  }

  @Test
  void TestDirectoryTotalSize() {

    var dir = new Directory("a", new ArrayList<>(), new ArrayList<>());
    dir.directoryList().add(new Directory("b", new ArrayList<>(), List.of(new File("f_a", 10))));
    dir.files().add(new File("f_b", 100));
    dir.files().add(new File("f_c", 5));
    assertThat(dir.totalSize()).isEqualTo(115);
  }


}