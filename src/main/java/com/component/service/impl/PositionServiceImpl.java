package com.component.service.impl;

import com.component.entity.Position;
import com.component.service.PositionServiec;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@CacheConfig(cacheNames = "position")
@Service
public class PositionServiceImpl implements PositionServiec{
    List<Position> positions = new ArrayList();
    @Override
    @CachePut()
    public void save(Position position) {
        int i =0;
        for (Position position1 :positions){
            if (position1.getCarNumber().equals(position.getCarNumber())){
                position.setPrvePoint(position1.getNewPoint());
                positions.remove(i);
                break;
            }
            i++;
        }
        positions.add(position);
    }

    @Override
    @Cacheable(cacheNames = {"positions"})
    public List<Position> get() {
        return positions;
    }
}
