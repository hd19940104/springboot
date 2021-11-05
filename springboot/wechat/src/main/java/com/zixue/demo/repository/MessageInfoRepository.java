package com.zixue.demo.repository;

import com.zixue.demo.dao.MessageInfoMapper;
import com.zixue.demo.dto.model.MessageInfoDto;
import com.zixue.demo.dto.vo.MessageInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Objects;

/**
 * Description:
 * <p>
 * date: 2021/11/5 11:04 上午
 *
 * @author aidenhou@tencent.com
 * @version 1.0
 * @since JDK 1.8
 */
@Repository
@Slf4j
public class MessageInfoRepository {
    @Autowired
    private MessageInfoMapper messageInfoMapper;

    /**
     * 操作数据唯一入口
     *
     * @param infoVo
     */
    public void saveMessageInfo(MessageInfoVo infoVo) {
        if (Objects.isNull(infoVo)) {
            return;
        }
        Integer id = infoVo.getId();

        MessageInfoDto record = new MessageInfoDto();
        record.setFromUserName(infoVo.getFromUserName());
        record.setMsgId(infoVo.getMsgId());
        record.setMsgType(infoVo.getMsgType());
        record.setRequest(infoVo.getRequest());
        record.setResponse(infoVo.getResponse());
        record.setStatus(infoVo.getStatus());
        record.setToUserName(infoVo.getToUserName());
        record.setUpdater(infoVo.getUpdater());
        record.setUpdateTime(new Date());
        if (Objects.isNull(id) || id <= 0) {
            record.setCreateTime(new Date());
            record.setCreator(infoVo.getCreator());
            messageInfoMapper.insertSelective(record);
        } else {
            record.setId(infoVo.getId());
            messageInfoMapper.updateByPrimaryKeySelective(record);
        }
    }
}
