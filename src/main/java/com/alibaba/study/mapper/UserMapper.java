package com.alibaba.study.mapper;

import com.alibaba.study.io.output.UerResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 10:37
 */
@Mapper
public interface UserMapper {

    List<UerResponse> queryUser ();
}
