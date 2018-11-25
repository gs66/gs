package com.fh.shop.api.area.mapper;

import com.fh.shop.api.common.ServerResponce;

import java.awt.geom.Area;
import java.util.List;

public interface IAreaMapper {
    List<Area> findAreaListbyId(int id);
}
