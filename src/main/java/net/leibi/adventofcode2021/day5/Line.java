package net.leibi.adventofcode2021.day5;

import java.util.Objects;

public class Line {

  Point from;
  Point to;

  public Line(int x1, int y1, int x2, int y2) {
    this(new Point(x1, y1), new Point(x2, y2));
  }

  public Line(Point from, Point to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Line line)) {
      return false;
    }
    return Objects.equals(from, line.from) && Objects.equals(to, line.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }

  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Point point)) {
        return false;
      }
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
