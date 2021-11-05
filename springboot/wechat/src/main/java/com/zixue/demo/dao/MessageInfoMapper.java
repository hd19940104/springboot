package com.zixue.demo.dao;

import com.zixue.demo.dto.model.MessageInfoDto;
import com.zixue.demo.dto.model.MessageInfoDtoExample;
import com.zixue.demo.dto.model.MessageInfoDtoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageInfoMapper {
    long countByExample(MessageInfoDtoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageInfoDtoWithBLOBs record);

    int insertSelective(MessageInfoDtoWithBLOBs record);

    List<MessageInfoDtoWithBLOBs> selectByExampleWithBLOBs(MessageInfoDtoExample example);

    List<MessageInfoDto> selectByExample(MessageInfoDtoExample example);

    MessageInfoDtoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageInfoDtoWithBLOBs record, @Param("example") MessageInfoDtoExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageInfoDtoWithBLOBs record, @Param("example") MessageInfoDtoExample example);

    int updateByExample(@Param("record") MessageInfoDto record, @Param("example") MessageInfoDtoExample example);

    int updateByPrimaryKeySelective(MessageInfoDtoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessageInfoDtoWithBLOBs record);

    int updateByPrimaryKey(MessageInfoDto record);
}