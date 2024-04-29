package com.dux.challenge.factory;

import java.util.ArrayList;
import java.util.List;

public class TeamNamesFactory {

    public static List<String> sampleTeamNamesList() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            names.add("Real Madrid");
        }
        return names;
    }
}
