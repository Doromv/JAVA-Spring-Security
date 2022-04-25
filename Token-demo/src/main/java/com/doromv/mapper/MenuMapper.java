package com.doromv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doromv.pojo.Menu;

import java.util.List;

/**
 * @author Doromv
 * @create 2022-04-25-8:17
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long id);
}
