package com.zixue.demo.dao;

import com.zixue.demo.dto.model.MessageInfoDto;
import com.zixue.demo.dto.model.MessageInfoDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageInfoMapper {
    long countByExample(MessageInfoDtoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageInfoDto record);

    int insertSelective(MessageInfoDto record);

    List<MessageInfoDto> selectByExample(MessageInfoDtoExample example);

    MessageInfoDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageInfoDto record, @Param("example") MessageInfoDtoExample example);

    int updateByExample(@Param("record") MessageInfoDto record, @Param("example") MessageInfoDtoExample example);

    int updateByPrimaryKeySelective(MessageInfoDto record);

    int updateByPrimaryKey(MessageInfoDto record);
}