package net.leibi.adventofcode2023.day8;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day8 {
    public Long getNumberofSteps(String input) {

        var instructions = input.lines().findFirst().orElseThrow();
        log.info("We have {} instructions", instructions.length());
        var maze = getMaze(input);

        String currentNode = "AAA";
        Long counter = 0L;


        int idx = 0;
        while (true) {
            if (idx == instructions.length()) {
                idx = 0;
            }
            if (currentNode.equals("ZZZ")) break;
            var oldNode = currentNode;
            currentNode = maze.getNextNode(currentNode, instructions.charAt(idx));
            log.info("{}: Next Node: {} from {} with direction {}", counter, currentNode, oldNode, instructions.charAt(idx));
            counter++;
            idx++;
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
