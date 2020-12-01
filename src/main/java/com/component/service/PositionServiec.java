package com.component.service;

import com.component.test.entity.Position;

import java.util.List;

public interface PositionServiec {
    void save(Position position);

    List<Position> get();
}
