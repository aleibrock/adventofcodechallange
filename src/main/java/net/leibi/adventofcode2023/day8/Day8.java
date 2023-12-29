package net.leibi.adventofcode2023.day8;

public class Day8 {
    public Long getNumberofSteps(String input) {

        var instructions = input.lines().findFirst().orElseThrow();
        var maze = getMaze(input);

        String currentNode = maze.getFirstNode();
        Long counter = 0L;

        for (char c : instructions.repeat(100).toCharArray()) {
            if (currentNode.equals("ZZZ")) break;
            currentNode = maze.getNextNode(currentNode, c);
            counter++;
        }
        return counter;
    }

    private Maze getMaze(String input) {

        var mazeItems = input.lines().skip(1)
                .filter(s -> !s.isEmpty())
                .map(MazeItem::new).toList();

        return new Maze(mazeItems);
    }
}
