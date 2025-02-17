package net.leibi.adventofcode2023.day16;

public class Input {

    public static final String SMALL =
            """
                    .|...\\....
                    |.-.\\.....
                    .....|-...
                    ........|.
                    ..........
                    .........\\
                    ..../.\\\\..
                    .-.-/..|..
                    .|....-|.\\
                    ..//.|....
                    """;


    public static final String BIG =
            """
                    \\|.....-.....\\....../.....-....................................../....-.............|.......|....|...\\........
                    ...............|...|...........-............../......../..|.........|..../....-.-.|...........|..............|
                    .........|....\\......-..............................|.....\\..........\\........../.../...../..\\...........|....
                    ...-................................................./.-...-..................../....../..|....|..............
                    \\...|...|-.............................................................................-.................--|..
                    ...............|.....|.......\\..|.....-................................|.........../............/.........../.
                    .\\....\\............./............|...........\\...|.....................\\.-.\\......-............|...........\\..
                    ./..........................\\..\\.........|.-...............................|........|..-....-............/....
                    ............/....................-........../.....................................-.................|.........
                    ..................................|/....-......................|............./...............\\...............-
                    ............|||.....\\....|....|.........-................\\..............\\.................-...............\\...
                    ......-...........................-.......\\.....................-..............-...|....\\.....-...............
                    ./............/.-|.\\/.......-./\\........\\..\\-.............../....-.....-........././...........|............\\.
                    .-..-.............-\\...............................|....\\......||/.......|....../...|.................\\.......
                    ..|/..............................|.|............../........-..........\\/......./.......--...........|........
                    ...-/.....\\........\\...|.................................\\.../.................\\-......../...........\\........
                    ................-...|............/........./\\\\.................../......../|.........../.........|-..\\........
                    ............\\............./\\....................|//.......|-|...-/........\\..............................-....
                    ..................|...../..................\\..|.........\\.............|...................|........\\...-...|..
                    ........../................../............................./.........|.................\\...............-\\../..
                    .../...........\\....|.................\\.........................................../.......................//..
                    /..\\..................................\\....|.................|..-....|......................|.....|...........
                    .....-.......\\.........-.-.....|.................\\-.............|........./................/.\\-.........|.....
                    .........-....-...................../..//...../....../..........|......./../.........--....-......\\..../......
                    .....\\\\............................./.../....../...../......./.........../..-..........|-.....................
                    .............|.|........................../.......-......|..-..........|.............\\..................../../
                    .../...../..\\.........|.........................\\.....\\....-...........-.....\\....................\\...........
                    ..................../........./.|....|............................../......-..../................./...|.......
                    ..........................|....|...\\.............\\..................-.....\\-..................................
                    ......\\...\\......./..\\.-.....-.......-...|...........-.........\\.-....../...-.../................-............
                    .....................\\.........................|.............................-...\\............-.../...........
                    ...../\\...-../..|................/............../...........|/.-........-.................../.......-.....-...
                    ...../.......|...............................................................................|....-......\\....
                    -........................../....|.....\\.................|......-/...................|...|/....................
                    ..|...\\...............-.............\\.........../...../\\.....|...........-..-.\\....../....../...........|.....
                    ....../...-..\\...........\\....../......|...\\............../.................-...............|.\\.-.............
                    ../........|......../....../..|..........................\\......-.............\\.|.\\...|/...../|...............
                    ......|.......\\-....\\...|........-.........|.....|.....\\--................-............\\..................|...
                    |......../.......-.\\....\\...........|...................|......|...../...|..|........\\....\\....../............
                    ......|..............-../..\\..../................./.......\\.......\\...\\......../...../........................
                    .-........................|.../...|...........|.......\\...........|.\\........................-............/...
                    ............................../\\..........-.|.//..............................|/.........\\..................|.
                    .........................../................/......................../..........|...................\\./.......
                    .....|....../...../............../.....-.|./\\............|.....................|..............\\...............
                    .....\\|.........\\./.../.......|.\\................../..........-............/......\\...................-...|/..
                    ....--.........//.....-\\........................\\//.....-|......|./.............\\...............|-.../......|.
                    .\\....................................../..........-..\\....\\...\\...|..................-.......................
                    ../\\............|....|\\.|\\................/............|.../...............................\\......../.--......
                    ....................-............/....|.|....||.....................|..........|./...\\...--...../....\\....|...
                    ......-....|.................-.-.....|................|........../........\\...|.............|/...........\\....
                    ....................-...-................-./|./.............................-.............../.................
                    ........|.-.........../..../..||.......\\........../................................/..........................
                    .........|..-....-..-......./......|\\......................-..........-...\\...|....\\.../..|..\\........./......
                    ........................\\............/...........\\.-..........\\.\\..|\\.../.....\\...........|.....|..../....\\...
                    .......-.\\.......................-.../.........................\\/........\\.\\..|...............................
                    ................./..-.|................-..\\.......|....................\\.......................|.....-........
                    ./.-.....................|............./........||-......|......-../............-.....-.......|...-.|........-
                    .........-.\\../................/....--...-................-....-................/......./.....././-../\\.......
                    ...|......\\./.......\\|....\\....\\....\\.........../.....|..........|...................|................\\....../
                    ...|............\\-.........................-................................../.......\\.-..........//.........
                    ..\\....../...........................-...-....-.......-...............|..................../........./......|.
                    .././............................/............|...............-........|...............|.........-......\\./...
                    .......-.....\\............|.........-\\..............-\\-............/..\\.../\\.|..|..../........................
                    ............|..-....\\................................-...|-..-/...................-......./\\............./....
                    ........\\...................\\.|...|......................|.........../...\\-..\\...\\..........................\\.
                    ........\\......-.....|...-............./.......-...............\\...-..-..........-.-................-......\\..
                    ..|..........\\..............-.-..............\\........../................/....................................
                    .....................\\................../.........../..-...................-...\\...................|.\\..-.....
                    ...........|.................|../....\\........|...\\-./...............|...........\\...........\\..............-.
                    ...................................................................\\............|..........................-..
                    ............|..............\\....|................|............-.....|....|.................\\.........|..|.....
                    ........................|......\\..............-.../............-.|/.-........................\\................
                    .......................|......../....../........-............-......./....................|....../............
                    .........-............\\...........|....................\\.......\\.................\\.\\...../../-..............-.
                    .\\.......\\....-/...............-.......................-............................|.|......\\....-.......\\|..
                    ....\\..\\..........................\\/.\\...|.............-.|..................../.......-.\\/....|..............\\
                    ........................../.........|..-\\...-......-....\\.../.........-.../....-.......|...-............\\.-...
                    .....\\.........\\......|........../.../.............|.....\\../..|...........\\.......................-......\\...
                    |.........|....|../....\\..................................\\...../.........\\............................\\.\\.../
                    -...../...\\.............-...//...............\\........\\...|.-.....................\\....|.....\\...--...........
                    ....|...-..-...|\\.....-\\..........|..............|........................-/.....-............./..............
                    .-.........................\\../.......|............|..|.|..|.|....../.....|-../\\.............\\.../.\\......\\...
                    ................\\.........|...\\...|....|..........|..........\\................................-...............
                    .........../-\\.....-/.....|.\\./........-................/.-.....\\...........\\..........\\......................
                    ../..|\\...|./............................../.|.......|....\\...............|.................\\................-
                    ...-...............|.....|...-.........-.|........\\.....-...........\\...............-......-.|.\\..............
                    ................/.-.-.........................\\.-..|.\\................................................|....../
                    ....................-..|...........|.......|.........-.\\....................................-....../....-.....
                    .....................-..........................-.............................\\.\\....|...-...\\...|..|.........
                    ./\\........-..................................|................|..........................|...\\|......\\.......
                    ...\\.......-..........-......................|...........................-...|................................
                    ..................................././.....|....|........\\|.....|..-...............\\\\.................-.......
                    .-.....././.......|...................-...................-................................................../
                    ..-..|......../.....|...................\\..../....................................|..\\...-\\................/..
                    ..................|.........................../......\\..-....\\............|-/..-................\\|../...\\...-.
                    ............../-..-..../............................../........|.......................................\\./.|..
                    ....\\......\\....|....................-....|........................-\\...|........\\......................\\.....
                    .........|...........|.............................-..................\\.\\............/.../....................
                    .|..-.......................|...............|..-............../.\\................./.....\\......-..|...........
                    ..-.../.......................................-/.........|........-.............-......\\........./...\\../.....
                    ......................\\/...............|................\\../............-.........|......\\....................
                    ...........-|.................../...../\\..../........|.....-............................/-.|..\\\\.../..........
                    .........\\.......|......../......./.......\\..|.....-..............|................................|..........
                    ....................................|........|/.......-.......|.........|//...................................
                    ...........|......\\...../../....................\\..\\......................./..........-......-.....|..........
                    ../................./..-.........................-..........\\-|......./.....-.\\.........\\.....................
                    ..............................\\.......|....\\.....................................................-....\\....|..
                    .........-\\...............\\...../\\......-.....\\................./........................-....\\...............
                    .|............................................-..../../\\......................................./....\\........\\
                    -........-...........|............./..........-...............................-.......-..../..................
                    """;
}
