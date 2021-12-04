package net.leibi.adventofcode2020.day2;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Entry {

   int firstLimit;
   int secondLimit;
   char character;
   String password;
}
