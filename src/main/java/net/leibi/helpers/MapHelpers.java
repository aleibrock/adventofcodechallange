package net.leibi.helpers;

import lombok.extern.log4j.Log4j2;

import java.util.Map;

@Log4j2
public class MapHelpers {

    public static void printMap(Map<?, ?> map) {
        map.forEach((k,v) -> log.info("{}: {}", k, v));
    }


}
