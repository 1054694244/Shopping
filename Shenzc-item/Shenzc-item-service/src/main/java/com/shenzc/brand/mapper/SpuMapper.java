package com.shenzc.brand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shenzc.entity.Spu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shenzc
 * @create 2019-09-02-10:21
 */
@Mapper
@Repository
public interface SpuMapper extends BaseMapper<Spu> {

}
