CREATE TABLE `inbound_order` (
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
`code` varchar(30) NOT NULL DEFAULT '' COMMENT '单据编码',
`outer_code` varchar(50) DEFAULT '' COMMENT '外部单据编码',
PRIMARY KEY (`id`),
UNIQUE KEY `uniq_code` (`code`),
KEY `idx_business_code` (`business_code`, `business_type`),
KEY `idx_business_type` (`business_type`),
KEY `idx_status` (`status`)
) ENGINE = InnoDB AUTO_INCREMENT = 1671484 DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC COMMENT = '核心入库单据表'