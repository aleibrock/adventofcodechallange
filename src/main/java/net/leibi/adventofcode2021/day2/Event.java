package net.leibi.adventofcode2021.day2;

import java.util.Objects;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Event {

  private String direction;
  private int amount;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Event event)) {
      return false;
    }
    return getAmount() == event.getAmount() && Objects.equals(getDirection(),
        event.getDirection());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDirection(), getAmount());
  }
}
