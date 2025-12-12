package com.gzy.demo2.Dao;

import com.gzy.demo2.entity.Society;
import java.util.List;

public interface SocietyDao {
    /**
     * 添加社团
     * @param society 社团对象
     * @return 受影响的行数
     */
    Integer addSociety(Society society);
    
    /**
     * 根据ID删除社团
     * @param id 社团ID
     * @return 受影响的行数
     */
    Integer deleteSociety(Long id);
    
    /**
     * 更新社团信息
     * @param society 社团对象
     * @return 受影响的行数
     */
    Integer updateSociety(Society society);
    
    /**
     * 根据ID查询社团
     * @param id 社团ID
     * @return 社团对象
     */
    Society getSocietyById(Long id);
    
    /**
     * 查询所有社团
     * @return 社团列表
     */
    List<Society> getAllSocieties();
    
    /**
     * 根据社团名称查询社团
     * @param name 社团名称
     * @return 社团对象
     */
    Society getSocietyByName(String name);
}