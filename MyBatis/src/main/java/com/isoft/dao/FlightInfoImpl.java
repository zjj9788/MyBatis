package com.isoft.dao;

import com.isoft.dbutils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class FlightInfoImpl implements IFlightDAO {
    @Override
    public List<Map<String,String>> findAllFlightInfo() {
        SqlSession sessionFactory = MyBatisUtils.getSessionFactory();
        String sql="com.isoft.mapper.FlightMapper.findAll";
        List<Map<String,String>> objects = sessionFactory.selectList(sql);
        return objects;
    }
}
