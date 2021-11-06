 drop TABLE t_message_info;
 CREATE TABLE `t_message_info` (
  `id` int(11) NOT NULL   AUTO_INCREMENT COMMENT 'ID',
  `msg_type` varchar(32) NOT NULL DEFAULT 'text' COMMENT '消息类型',
  `from_user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '发送方帐号',
  `to_user_name` varchar(255) NOT NULL DEFAULT ''  COMMENT '开发者微信号',
  `response` text   COMMENT '响应内容',
  `request` text   COMMENT '请求内容',
  `msg_id` varchar(255) NOT NULL DEFAULT ''  COMMENT '消息Id',
  `status` tinyint(4) NOT NULL  DEFAULT 1 COMMENT '状态 0 发送失败 1 发送成功',
  `creator` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人',
  `updater` varchar(64) NOT NULL DEFAULT '' COMMENT '更新人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息信息表'  ;


ALTER TABLE t_message_info CONVERT TO CHARACTER SET utf8mb4;