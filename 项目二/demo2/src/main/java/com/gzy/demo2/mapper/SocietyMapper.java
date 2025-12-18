package com.gzy.demo2.mapper;

import java.util.List;

import com.gzy.demo2.entity.Society;

public interface SocietyMapper {
    /**
     * 插入社团信息
     * @param society 社团对象
     * @return 受影响的行数
     */
    int insertSociety(Society society);
    
    /**
     * 删除社团信息
     * @param id 社团ID
     * @return 受影响的行数
     */
    int deleteSocietyById(Integer id);
    
    /**
     * 更新社团信息
     * @param society 社团对象
     * @return 受影响的行数
     */
    int updateSociety(Society society);
    
    /**
     * 根据ID查询社团
     * @param id 社团ID
     * @return 社团对象
     */
    Society selectSocietyById(Integer id);
    
    /**
     * 查询所有社团
     * @return 社团列表
     */
    List<Society> selectAllSocieties();
    
    /**
     * 根据名称查询社团
     * @param name 社团名称
     * @return 社团对象
     */
    Society selectSocietyByName(String name);
    
    /**
     * 根据关键词查询多个社团
     * @param keyword 搜索关键词
     * @return 社团列表
     */
    List<Society> selectSocietiesByName(String keyword);
}