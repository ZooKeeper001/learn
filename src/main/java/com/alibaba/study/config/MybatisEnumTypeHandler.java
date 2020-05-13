package com.alibaba.study.config;

import com.alibaba.study.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Configuration;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 13:29
 */
@Configuration
public class MybatisEnumTypeHandler extends BaseTypeHandler<BaseEnum> {

    private Map<Integer,BaseEnum> enumMap = new HashMap<>();

    public MybatisEnumTypeHandler() {

    }

    public MybatisEnumTypeHandler(Class<BaseEnum> enumType){
        BaseEnum[] enums = enumType.getEnumConstants();
        for (BaseEnum e : enums) {
            enumMap.put(e.getCode(),e);
        }
    }

    /**
     * 数据库类型转换为对应的Java类型
     */
    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int value = resultSet.getInt(columnName);
        BaseEnum baseEnum = null;
        if (!resultSet.wasNull()) {
            baseEnum = enumMap.get(value);
        }
        return baseEnum;
    }

    /**
     * 数据库类型转换为对应的Java类型
     */
    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int value = resultSet.getInt(columnIndex);
        BaseEnum baseEnum = null;
        if (!resultSet.wasNull()) {
            baseEnum = enumMap.get(value);
        }
        return baseEnum;
    }

    /**
     * 数据库类型转换为对应的Java类型
     */
    @Override
    public BaseEnum getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int value = callableStatement.getInt(columnIndex);
        BaseEnum baseEnum = null;
        if (!callableStatement.wasNull()) {
            baseEnum = enumMap.get(value);
        }
        return baseEnum;
    }

    /**
     * Java类型 转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int parameterIndex, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(parameterIndex, baseEnum.getCode());
    }
}
