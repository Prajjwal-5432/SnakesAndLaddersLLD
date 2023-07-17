package com.SnakesAndLadders.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, ForeignEntity> foreignEntityMap;

    public Board(int size, List<ForeignEntity> foreignEntities) {
        this.size = size;
        this.foreignEntityMap = new HashMap<>();
        for(ForeignEntity foreignEntity: foreignEntities) {;
            this.foreignEntityMap.put(foreignEntity.getFrom(), foreignEntity);
        }
    }

    public int getSize() {
        return this.size;
    }
    public ForeignEntity getForeignEntity(Integer position) {
        if(!foreignEntityMap.containsKey(position)) return null;

        return foreignEntityMap.get(position);
    }
}
