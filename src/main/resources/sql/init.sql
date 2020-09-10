CREATE TABLE `admin_user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` VARCHAR(45) NULL COMMENT '用户名',
  `password` VARCHAR(45) NULL COMMENT '密码',
  PRIMARY KEY (`id`))
COMMENT = '管理员用户表';

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` VARCHAR(45) NULL COMMENT '用户名',
  `password` VARCHAR(45) NULL COMMENT '密码',
  `phone` VARCHAR(45) NULL COMMENT '手机号',
  PRIMARY KEY (`id`))
COMMENT = '用户表';

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `subTitle` varchar(45) DEFAULT NULL COMMENT '文章副标题（命中率等）',
  `category` varchar(45) DEFAULT NULL COMMENT '文章分类（赛事资讯等）',
  `lable` varchar(255) DEFAULT NULL COMMENT '文章标签',
  `content` text COMMENT '文章内容',
  `date` date DEFAULT NULL COMMENT '发表日期',
  `isTop` tinyint(4) DEFAULT NULL COMMENT '是否置顶 0 否，1 是',
  `status` tinyint(4) DEFAULT NULL COMMENT '文章状态 0 草稿，1 发表，2 下架',
  `image` varchar(255) DEFAULT NULL COMMENT '列表缩略图',
  PRIMARY KEY (`id`)
) COMMENT='文章表';


CREATE TABLE `match` (
  `id` BIGINT NOT NULL COMMENT '赛事id',
  `mainTeam` VARCHAR(45) NULL COMMENT '主队',
  `clientTeam` VARCHAR(45) NULL COMMENT '客队',
  `halfScore` VARCHAR(45) NULL COMMENT '半场比分',
  `totalScore` VARCHAR(45) NULL COMMENT '全场比分',
  `match` VARCHAR(45) NULL COMMENT '所属联赛',
  `round` VARCHAR(45) NULL COMMENT '轮次',
  `matchTime` DATETIME NULL COMMENT '比赛时间',
  `status` VARCHAR(45) NULL COMMENT '比赛状态',
  PRIMARY KEY (`id`),
  INDEX `INDEX_TEAM` (`mainTeam` ASC, `clientTeam` ASC, `matchTime` ASC) INVISIBLE,
  INDEX `INDEX_TIME` (`matchTime` ASC) VISIBLE)
COMMENT = '赛事表';

CREATE TABLE `odd` (
  `id` BIGINT NOT NULL COMMENT '赔率id',
  `matchId` BIGINT NOT NULL COMMENT '赛事id',
  `category` VARCHAR(45) NULL COMMENT '分类（非让球，主-1，比分 等）',
  `rate` VARCHAR(45) NULL COMMENT '赔率',
  `content` VARCHAR(45) NULL COMMENT '赔率内容（胜，负，0:1等）',
  PRIMARY KEY (`id`))
COMMENT = '赔率表';

CREATE TABLE `optional` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '方案id',
  `userId` INT NOT NULL COMMENT '用户id',
  `lotteryImg` TEXT NULL COMMENT '彩票单图片',
  `status` TINYINT NULL COMMENT '方案状态 0 未提交，1 提交，2 已投注',
  PRIMARY KEY (`id`))
COMMENT = '自选方案表';

CREATE TABLE `optional_detail` (
  `id` INT NOT NULL,
  `matchId` BIGINT NOT NULL,
  `optionalId` INT NULL COMMENT '方案id',
  `category` VARCHAR(45) NULL COMMENT '分类（非让球，主-1，比分 等）',
  `rate` VARCHAR(45) NULL COMMENT '赔率',
  `content` VARCHAR(45) NULL COMMENT '赔率内容（胜，负，0:1等）',
  PRIMARY KEY (`id`))
COMMENT = '自选方案详情表';
