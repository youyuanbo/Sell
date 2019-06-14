
DROP DATABASE IF EXISTS sell;

CREATE DATABASE sell;

USE sell;

DROP TABLE IF EXISTS product_info;

CREATE TABLE product_info (
  product_id VARCHAR(32) NOT NULL ,
  product_name VARCHAR(64) NOT NULL COMMENT '商品名称',
  product_price DECIMAL(8,2) NOT NULL COMMENT '单价',
  product_stock INT NOT NULL COMMENT '库存',
  product_description VARCHAR(64) COMMENT '描述',
  product_icon VARCHAR(512) COMMENT '图标',
  product_status TINYINT(3) COMMENT '商品状态',
  category_type INT NOT NULL COMMENT '类目编号',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (product_id)
)engine = Innodb COMMENT '商品表';

DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category(
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(64) NOT NULL COMMENT '类目名称',
  category_type INT NOT NULL COMMENT '类目编号',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (category_id),
  UNIQUE KEY `index_category_type` (category_type)
)engine = Innodb COMMENT '类目表';

DROP TABLE IF EXISTS order_master;

CREATE TABLE order_master(
  order_id VARCHAR(32) NOT NULL COMMENT '订单ID',
  buyer_name VARCHAR(32) NOT NULL COMMENT '买家姓名',
  buyer_phone VARCHAR(32) NOT NULL COMMENT '买家电话',
  buyer_address VARCHAR(128) NOT NULL COMMENT '买家地址',
  buyer_openid VARCHAR(64) NOT NULL COMMENT '买家微信ID',
  buyer_amount DECIMAL(8,2) NOT NULL COMMENT '订单总金额',
  order_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '订单状态, 0:默认状态，新订单',
  pay_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '支付状态，0:默认状态未支付',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (order_id),
  UNIQUE KEY `index_buyer_openid` (buyer_openid)
)engine = Innodb COMMENT '订单表';

DROP TABLE IF EXISTS order_detail;

CREATE TABLE `order_detail`(
  `detail_id` VARCHAR(32) NOT NULL COMMENT '订单详情',
  `order_id` VARCHAR(32) NOT NULL COMMENT '订单ID',
  `product_id` VARCHAR(32) NOT NULL COMMENT '商品ID',
  `product_name` VARCHAR(64) NOT NULL COMMENT '商品名称',
  `product_price` DECIMAL(8,2) NOT NULL COMMENT '商品价格',
  `product_quantity` INT NOT NULL COMMENT '商品数量',
  `product_icon` VARCHAR(512) NOT NULL COMMENT '商品图片',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (detail_id),
  KEY `index_order_id` (order_id)
)COMMENT '订单详情表';
