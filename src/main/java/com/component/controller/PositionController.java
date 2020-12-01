package com.component.controller;

import com.component.entity.Position;
import com.component.service.PositionServiec;
import com.component.test.entity.Position;
import com.component.test.service.PositionServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionServiec positionServiec;

    @RequestMapping("saveposition")
    public void saveposition(Position position){
        positionServiec.save(position);
    }
    @RequestMapping("getposition")
    public List<Position> getposition(){
        return positionServiec.get();
    }
}
