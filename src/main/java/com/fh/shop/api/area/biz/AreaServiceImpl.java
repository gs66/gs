package com.fh.shop.api.area.biz;

import com.fh.shop.api.area.mapper.IAreaMapper;
import com.fh.shop.api.common.ServerResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Area;
import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private IAreaMapper areaMapper;
    public ServerResponce findAreaListbyId(int id) {
        List<Area> areaList = areaMapper.findAreaListbyId(id);
        return  ServerResponce.success(areaList);
    }
}
