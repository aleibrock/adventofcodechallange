package net.leibi.adventofcode2023.day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {
    private final Map<String, MazeItem> mazeItemMap = new HashMap<>();

    public Maze(List<MazeItem> mazeItems) {
        mazeItems.forEach(mazeItem -> mazeItemMap.put(mazeItem.from(), mazeItem));
    }

    public String getFirstNode() {
        return mazeItemMap.keySet().stream().toList().getFirst();
    }

    public String getNextNode(String currentNode, char direction) {
        var mazeItem = mazeItemMap.get(currentNode);
        return switch (direction) {
            case 'R' -> mazeItem.right();
            case 'L' -> mazeItem.left();
            default -> throw new RuntimeException("Unknown direction");
        };
    }
}
