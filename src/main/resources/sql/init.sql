CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员用户表';

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `subTitle` varchar(45) DEFAULT NULL COMMENT '文章副标题（命中率等）',
  `category` varchar(45) DEFAULT NULL COMMENT '文章分类（赛事资讯等）',
  `label` varchar(255) DEFAULT NULL COMMENT '文章标签',
  `content` text COMMENT '文章内容',
  `date` date DEFAULT NULL COMMENT '发表日期',
  `isTop` tinyint(4) DEFAULT NULL COMMENT '是否置顶 0 否，1 是',
  `status` tinyint(4) DEFAULT NULL COMMENT '文章状态 0 草稿，1 发表，2 下架',
  `image` varchar(255) DEFAULT NULL COMMENT '列表缩略图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章表';

CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'banner id',
  `img` varchar(255) DEFAULT NULL COMMENT 'banner Url',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首页banner表';

CREATE TABLE `help` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帮助中心id',
  `title` varchar(255) DEFAULT NULL COMMENT '帮助标题',
  `content` text COMMENT '帮助中心内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='帮助中心表';

CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `content` varchar(45) DEFAULT NULL COMMENT '日志内容',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `logTime` datetime DEFAULT NULL COMMENT '日志时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志表';

CREATE TABLE `match` (
  `id` bigint(20) NOT NULL COMMENT '赛事id',
  `mainTeam` varchar(45) DEFAULT NULL COMMENT '主队',
  `clientTeam` varchar(45) DEFAULT NULL COMMENT '客队',
  `halfScore` varchar(45) DEFAULT NULL COMMENT '半场比分',
  `totalScore` varchar(45) DEFAULT NULL COMMENT '全场比分',
  `match` varchar(45) DEFAULT NULL COMMENT '所属联赛',
  `round` varchar(45) DEFAULT NULL COMMENT '轮次',
  `matchTime` datetime DEFAULT NULL COMMENT '比赛时间',
  `status` varchar(45) DEFAULT NULL COMMENT '比赛状态',
  PRIMARY KEY (`id`),
  KEY `INDEX_TEAM` (`mainTeam`,`clientTeam`,`matchTime`) /*!80000 INVISIBLE */,
  KEY `INDEX_TIME` (`matchTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='赛事表';

CREATE TABLE `note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '留言id',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `content` text COMMENT '留言内容',
  `optionalId` int(11) DEFAULT NULL COMMENT '方案id',
  `noteTime` datetime DEFAULT NULL COMMENT '留言日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='留言表';

CREATE TABLE `odd` (
  `id` bigint(20) NOT NULL COMMENT '赔率id',
  `matchId` bigint(20) NOT NULL COMMENT '赛事id',
  `category` varchar(45) DEFAULT NULL COMMENT '分类（非让球，主-1，比分 等）',
  `rate` varchar(45) DEFAULT NULL COMMENT '赔率',
  `content` varchar(45) DEFAULT NULL COMMENT '赔率内容（胜，负，0:1等）',
  `single` tinyint(4) DEFAULT NULL COMMENT '是否单关 0否 1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='赔率表';

CREATE TABLE `optional` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '方案id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `lotteryImg` text COMMENT '彩票单图片',
  `cost` varchar(45) DEFAULT NULL COMMENT '投注金额',
  `optionDate` datetime DEFAULT NULL COMMENT '投注日期',
  `name` varchar(45) DEFAULT NULL COMMENT '投注名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '方案状态 0 未提交，1 提交，2 已投注',
  `times` int(11) DEFAULT NULL COMMENT '倍数',
  `game` varchar(255) DEFAULT NULL COMMENT '玩法',
  `noteNumber` int(11) DEFAULT NULL COMMENT '注数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自选方案表';

CREATE TABLE `optional_detail` (
  `id` int(11) NOT NULL COMMENT '方案详情id',
  `matchId` bigint(20) NOT NULL COMMENT '赛事id',
  `optionalId` int(11) DEFAULT NULL COMMENT '方案id',
  `category` varchar(45) DEFAULT NULL COMMENT '分类（非让球，主-1，比分 等）',
  `rate` varchar(45) DEFAULT NULL COMMENT '赔率',
  `content` varchar(45) DEFAULT NULL COMMENT '赔率内容（胜，负，0:1等）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自选方案详情表';

CREATE TABLE `recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '推荐方案id',
  `articleId` int(11) DEFAULT NULL COMMENT '文章id',
  `matchId` bigint(20) DEFAULT NULL COMMENT '赛事id',
  `category` varchar(45) DEFAULT NULL COMMENT '分类（非让球，主-1，比分 等）',
  `rate` varchar(45) DEFAULT NULL COMMENT '赔率',
  `content` varchar(45) DEFAULT NULL COMMENT '赔率内容（胜，负，0:1等）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='推荐方案表';

CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复id',
  `content` text COMMENT '自动回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='自动回复表';

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `registerTime` datetime DEFAULT NULL COMMENT '注册日期',
  `lastLogin` datetime DEFAULT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
