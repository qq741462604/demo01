CREATE TABLE if not exists `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `permissions` text COMMENT '权限列表（JSON格式）',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账号状态：0-禁用，1-启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `last_login_ip` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE if not exists  `operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `method` varchar(100) NOT NULL COMMENT '请求方法名',
  `path` varchar(255) NOT NULL COMMENT '请求路径',
  `ip` varchar(50) NOT NULL COMMENT '请求IP',
  `params` text COMMENT '请求参数',
  `result` text COMMENT '返回结果',
  `execution_time` bigint(20) NOT NULL COMMENT '执行时间(毫秒)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志表';


