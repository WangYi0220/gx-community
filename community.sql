/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25-0ubuntu0.16.04.2 : Database - db_community
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_community` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `db_community`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `adminUUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `account` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账号',
  `passwords` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `phone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `grade` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '等级(0为最高，不可删，仅有一个)',
  PRIMARY KEY (`adminUUID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='管理员表';

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`adminUUID`,`account`,`passwords`,`name`,`phone`,`grade`) values (1,'admin','1','王','13719664496',NULL);

/*Table structure for table `tb_class_info` */

DROP TABLE IF EXISTS `tb_class_info`;

CREATE TABLE `tb_class_info` (
  `classUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '班级编号',
  `colID` int(11) DEFAULT NULL COMMENT '学院编号',
  `grade` char(4) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '年级 如:2017',
  `className` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班级名字',
  `teaUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '辅导员编号',
  PRIMARY KEY (`classUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='班级';

/*Data for the table `tb_class_info` */

insert  into `tb_class_info`(`classUUID`,`colID`,`grade`,`className`,`teaUUID`) values ('460396da82894b52abddcf27988dadcd',5,'2017','17前端','4ebc5ac6d6194a788f7f9512f3c87833'),('e8347ade544811e99df21c1b0db597bb',1,'2017','17JAVA班','4ebc5ac6d6194a788f7f9512f3c87833');

/*Table structure for table `tb_class_schedule` */

DROP TABLE IF EXISTS `tb_class_schedule`;

CREATE TABLE `tb_class_schedule` (
  `scheduleUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `classUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班级编号',
  `classSchedule` text COLLATE utf8_unicode_ci COMMENT '课程表',
  PRIMARY KEY (`scheduleUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='课表';

/*Data for the table `tb_class_schedule` */

insert  into `tb_class_schedule`(`scheduleUUID`,`classUUID`,`classSchedule`) values ('cb7184be12d24705bbaec7b9de449d40','e8347ade544811e99df21c1b0db597bb','test2');

/*Table structure for table `tb_college` */

DROP TABLE IF EXISTS `tb_college`;

CREATE TABLE `tb_college` (
  `colID` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `colName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`colID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学院';

/*Data for the table `tb_college` */

insert  into `tb_college`(`colID`,`colName`) values (1,'信息工程学院'),(2,'经济与管理学院'),(3,'机电与自动化学院'),(4,'建筑与艺术学院'),(5,'互联网学院');

/*Table structure for table `tb_graduate_job` */

DROP TABLE IF EXISTS `tb_graduate_job`;

CREATE TABLE `tb_graduate_job` (
  `graUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `stuUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '学生编号',
  `graStartTime` date NOT NULL COMMENT '开始工作时间',
  `graEndTime` date NOT NULL COMMENT '结束工作时间',
  `graCompany` varchar(70) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `graPost` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司职位',
  `pay` float NOT NULL COMMENT '薪资',
  `graAddress` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司详细地址',
  PRIMARY KEY (`graUUID`),
  KEY `FK_tb_graduate_job_student` (`stuUUID`),
  CONSTRAINT `FK_tb_graduate_job_student` FOREIGN KEY (`stuUUID`) REFERENCES `tb_student` (`stuUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='毕业生就业表';

/*Data for the table `tb_graduate_job` */

insert  into `tb_graduate_job`(`graUUID`,`stuUUID`,`graStartTime`,`graEndTime`,`graCompany`,`graPost`,`pay`,`graAddress`) values ('112ebd2c04384637b78185369e5ea26f','313b5e93b58b4196beafe7dcb8e11a09','2019-04-09','2019-04-18','aaaa','aaaa',11111,'啊啊'),('2412f719011e4c31b3b13ec2c211d1fa','313b5e93b58b4196beafe7dcb8e11a09','2019-04-09','2019-04-05','萨达啊','啊啊啊啊',1123130,'啊啊啊啊'),('27136b3d500745069f51b874bed2b10d','313b5e93b58b4196beafe7dcb8e11a09','2019-04-02','2019-04-12','啊啊啊','啊啊啊',112331,'啊啊啊啊啊'),('3985a6ef59ad11e99df21c1b0db597bb','3fbeb5ee544a11e99df21c1b0db597bb','2019-01-01','2019-01-03','Java公司','前段工程师',10000,'这是一个好地方'),('4d65eabd59a711e99df21c1b0db597bb','3dbd1751544a11e99df21c1b0db597bb','2019-01-01','2019-01-03','Java公司','工程师',10000,'好地方'),('7578617159ad11e99df21c1b0db597bb','313b5e93b58b4196beafe7dcb8e11a09','2019-01-01','2019-01-03','Java公司','前段工程师',10000,'这是一个很好好地方'),('76be6b2413dd43fa9a645cf26e1a1a27','313b5e93b58b4196beafe7dcb8e11a09','2019-04-01','2019-04-05','啊啊啊啊','凄凄切切',111111,'啊啊啊啊啊啊'),('8c339bfb60a0427880394d1385a375ac','63c96ff7544c11e99df21c1b0db597bb','2019-01-01','2019-01-03','UI公司','UI工程师',10000,'这是一个好地址！！'),('bae796e5e4154daba071f22bc5894ea5','de5dec1a544911e99df21c1b0db597bb','2019-01-01','2019-01-03','ui公式','ui工程师',10000,'这是一个好地方'),('ea627efe39544aa4b357e093e4bd457b','63c96ff7544c11e99df21c1b0db597bb','2017-02-03','2017-02-04','Java公司','Java工程师',10000,'一个地址'),('f46308d8476241c8bc5d2cab41234362','313b5e93b58b4196beafe7dcb8e11a09','2019-04-09','2019-04-20','啊啊啊啊','1大大',111111,'啊啊啊啊啊'),('fed7c9e573f04b058cf647c9eec35f1d','313b5e93b58b4196beafe7dcb8e11a09','2019-04-19','2019-04-17','哈哈哈','牛',123456,'啊啊啊啊啊');

/*Table structure for table `tb_industry` */

DROP TABLE IF EXISTS `tb_industry`;

CREATE TABLE `tb_industry` (
  `industryID` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业编号',
  `industry` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '行业名称',
  PRIMARY KEY (`industryID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='行业分类';

/*Data for the table `tb_industry` */

insert  into `tb_industry`(`industryID`,`industry`) values (1,'软件开发'),(2,'销售'),(3,'cat');

/*Table structure for table `tb_job_post` */

DROP TABLE IF EXISTS `tb_job_post`;

CREATE TABLE `tb_job_post` (
  `jobUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '就业贴编号',
  `industryID` int(11) DEFAULT NULL COMMENT '行业分类',
  `parUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '家长编号',
  `postName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `orgName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司名称',
  `orgAddress` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作地点',
  `orgRemark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司描述',
  `job` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '岗位',
  `jobRequest` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作要求',
  `jobRemark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '岗位描述',
  `salary` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '薪水范围',
  `phone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `linkman` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`jobUUID`),
  KEY `parUUID` (`parUUID`),
  KEY `industryID` (`industryID`),
  CONSTRAINT `tb_job_post_ibfk_1` FOREIGN KEY (`parUUID`) REFERENCES `tb_parent` (`parUUID`),
  CONSTRAINT `tb_job_post_ibfk_2` FOREIGN KEY (`industryID`) REFERENCES `tb_industry` (`industryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='就业贴';

/*Data for the table `tb_job_post` */

insert  into `tb_job_post`(`jobUUID`,`industryID`,`parUUID`,`postName`,`orgName`,`orgAddress`,`orgRemark`,`job`,`jobRequest`,`jobRemark`,`salary`,`phone`,`linkman`,`createTime`) values ('939b787eafa142d4b1a594b5fcfbf5e0',1,'f7c71ff2820942029721a630d8eb522a','招后端开发工程师','今日头条','深圳今日头条科技有限公司','今日头条，抖音是北京字节跳动科技有限公司开发的一款基于数据挖掘的推荐引擎产品，为用户推荐信息，提供连接人与信息的服务的产品。由张一鸣于2012年3月创建，2012年8月发布第一个版本。 [1] \n2016年9月20日，今日头条宣布投资10亿元用以补贴短视频创作。后独立孵化 UGC 短视频平台火山小视频 [2] 。2017年1月，今日头条中国新第一批认证的8组独立音乐人入驻今日头条。2017年2月2日，全资收购美国短视频应用Flipagram','后端开发工程师','1、良好的设计和编码品味，热爱写代码；\n2、较好的产品意识，愿意将产品效果做为工作最重要的驱动因素；\n3、掌握WEB后端开发技术: 协议、架构、存储、缓存、安全等；\n4、积极乐观，认真负责，乐于协作。','1、负责字节跳动企业办公套件类产品研发，包含自动化工作流、审批等；\n2、负责后台开发工作，具体包括需求分析、文档撰写、设计编码、测试运维、效果追踪等工作；\n3、负责高质量的设计和编码；承担重点、难点的技术攻坚；\n4、参与产品讨论和开发实现；\n5、主要语言为Golang/Java。','20k-40k',' 李先生','13650052140','2019-04-15 16:52:30'),('a75a92e5ef164563993fdb3c5a61cf38',1,'d2e3b655cbb54a18a828f0402dd7b200','招Web前端工程师','搞快点有限公司','中国科教之城武汉','  搞快点技术有限责任公司（以下简称“搞快点”）致力成为中国领先的数字技术服务提供商，总部位于中国科教之城武汉（光谷软件园）。自2006年成立以来，佰钧成秉承“创造价值 承诺必达”的服务宗旨，迅速成长为IBM、华为、Google、Microsoft，爱立信等全球500强企业在信息服务领域的重要合作伙伴。','Web前端','1、熟练掌握HTML5\\CSS3等基础技术 \n2、熟练使用Javascript、Ajax等开发技术，且能熟练运用es6语法 \n3、熟练使用Vue进行组件化开发，对组件的划分和封装有自己的理解 \n4、熟练使用echarts进行图标开发 \n5、熟练掌握webpack构建工具','五险一金补充医疗保险定期体检带薪年假节日福利','10k-18k',' 马先生','13681182140','2019-04-15 16:43:37'),('ca5c6ed65ec411e99df21c1b0db597bb',1,'5ecc818912494c908fc508cccf47d0e1','帖子标题','公司名称','工作地点','公司描述','岗位','工作要求','岗位描述','10000-20000','13144103270','yuan','2019-04-14 22:51:31'),('faf9c663c8074fbfb94128ccb67b41ad',1,'f7c71ff2820942029721a630d8eb522a','Java后端开发工程师急聘','Fordeal','广州市 海珠区 环球贸易中心(新港东路) 27楼2702','Fordeal，面向海外C端消费者的电商一站式购物平台（B2C），目前主要在中东地区运营，是国家“一带一路”核心战略的坚定践行者。\n\nFordeal自2017年上线至今，在中东Shopping类APP中排名稳居前列，已为过千万中东用户提供一站式产品购买服务。','Java后端开发工程师','- 至少熟练掌握一门静态类型语言(比如Java)\n- 熟悉Linux系统的基本操作\n- 良好的算法/数据结构基础\n- 良好的搜索公开资料的能力(Google,Stack Overflow,开源项目的公开文档等)\n- 拥有本科学位','1. 负责电商技术系统中重要模块的设计和实现\n2. 负责攻克团队遇到的技术难题\n3. 对线上突发问题进行及时响应并解决\n4. 持续对线上系统进行性能优化及稳定性提升','15k-30k',' 张先生','13640042140','2019-04-15 16:59:29');

/*Table structure for table `tb_nation` */

DROP TABLE IF EXISTS `tb_nation`;

CREATE TABLE `tb_nation` (
  `nationID` int(11) NOT NULL COMMENT '民族编号',
  `nationName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '民族名称',
  PRIMARY KEY (`nationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='民族';

/*Data for the table `tb_nation` */

insert  into `tb_nation`(`nationID`,`nationName`) values (1,'汉族'),(2,'蒙古族'),(3,'回族'),(4,'藏族'),(5,'维吾尔族'),(6,'苗族'),(7,'彝族'),(8,'壮族'),(9,'布依族'),(10,'朝鲜族'),(11,'满族'),(12,'侗族'),(13,'瑶族'),(14,'白族'),(15,'土家族'),(16,'哈尼族'),(17,'哈萨克族'),(18,'傣族'),(19,'黎族'),(20,'傈僳族'),(21,'佤族'),(22,'畲族'),(23,'高山族'),(24,'拉祜族'),(25,'水族'),(26,'东乡族'),(27,'纳西族'),(28,'景颇族'),(29,'柯尔克孜族'),(30,'土族'),(31,'达斡尔族'),(32,'仫佬族'),(33,'羌族'),(34,' 布朗族'),(35,' 撒拉族'),(36,' 毛难族'),(37,' 仡佬族'),(38,' 锡伯族'),(39,' 阿昌族'),(40,' 普米族'),(41,' 塔吉克族'),(42,' 怒族'),(43,' 乌孜别克族'),(44,' 俄罗斯族'),(45,' 鄂温克族'),(46,' 崩龙族'),(47,' 保安族'),(48,' 裕固族'),(49,' 京族'),(50,' 塔塔尔族'),(51,' 独龙族'),(52,' 鄂伦春族'),(53,' 赫哲族'),(54,' 门巴族'),(55,' 珞巴族'),(56,' 基诺族'),(57,' 其他');

/*Table structure for table `tb_parent` */

DROP TABLE IF EXISTS `tb_parent`;

CREATE TABLE `tb_parent` (
  `parUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '家长编号',
  `password` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `parName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '家长姓名',
  `telephone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `employer` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作单位',
  PRIMARY KEY (`parUUID`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='家长';

/*Data for the table `tb_parent` */

insert  into `tb_parent`(`parUUID`,`password`,`parName`,`telephone`,`employer`) values ('5ecc818912494c908fc508cccf47d0e1','13812345666','梁光华老爸','13812345666','个体'),('ba4e2d4954434cccb82ee49fc12777b8','12345678901','谢远阳老爸','12345678901','个体'),('d2e3b655cbb54a18a828f0402dd7b200','12345678904','李小雷老爸','12345678904','个体'),('d2e3b655cbb54a18a828f0402dd7b211','65449863134','李小雷姑父','65449863134','个体'),('d2e3b655cbb54a18a828f0402dd7b222','31654846116','李小雷阿姨','31654846116','个体'),('d2e3b655cbb54a18a828f0402dd7b233','14789355233','李小雷阿叔','14789355233','个体'),('d2e3b655cbb54a18a828f0402dd7b244','17896335744','李小雷伯伯','17896335744','个体'),('d2e3b655cbb54a18a828f0402dd7b255','14896325745','李小雷伯母','14896325745','个体'),('d2e3b655cbb54a18a828f0402dd7b290','18963547863','谢远阳老妈','18963547863','个体'),('f7c71ff2820942029721a630d8eb522a','12345678903','许智涛老爸','12345678903','个体'),('f7c71ff2820942029721a630d8eb522z','123','hello','123','老板');

/*Table structure for table `tb_parent_student` */

DROP TABLE IF EXISTS `tb_parent_student`;

CREATE TABLE `tb_parent_student` (
  `parUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '家长编号',
  `stuUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生编号',
  `relation` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关系',
  KEY `fk_parent_UUID` (`parUUID`),
  KEY `fk_student_UUID` (`stuUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='家长-学生关系表';

/*Data for the table `tb_parent_student` */

insert  into `tb_parent_student`(`parUUID`,`stuUUID`,`relation`) values ('ba4e2d4954434cccb82ee49fc12777b8','3dbd1751544a11e99df21c1b0db597bb','父子'),('5ecc818912494c908fc508cccf47d0e1','3fbeb5ee544a11e99df21c1b0db597bb','父子'),('f7c71ff2820942029721a630d8eb522a','63c96ff7544c11e99df21c1b0db597bb','父子'),('d2e3b655cbb54a18a828f0402dd7b200','de5dec1a544911e99df21c1b0db597bb','父子');

/*Table structure for table `tb_post` */

DROP TABLE IF EXISTS `tb_post`;

CREATE TABLE `tb_post` (
  `postUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '帖子编号',
  `postTab` int(11) DEFAULT NULL COMMENT '帖子分类',
  `stuUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生编号',
  `createTime` datetime DEFAULT NULL COMMENT '发帖时间',
  `postTitle` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `postContent` text COLLATE utf8_unicode_ci COMMENT '发帖内容',
  PRIMARY KEY (`postUUID`),
  KEY `postTab` (`postTab`),
  KEY `stuUUID` (`stuUUID`),
  CONSTRAINT `tb_post_ibfk_1` FOREIGN KEY (`postTab`) REFERENCES `tb_post_tab` (`tabID`),
  CONSTRAINT `tb_post_ibfk_2` FOREIGN KEY (`stuUUID`) REFERENCES `tb_student` (`stuUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='帖子';

/*Data for the table `tb_post` */

insert  into `tb_post`(`postUUID`,`postTab`,`stuUUID`,`createTime`,`postTitle`,`postContent`) values ('2ded07afaa9246f9b8346a6b43a2e4d6',2,'de5dec1a544911e99df21c1b0db597bb','2019-04-15 17:01:28','这是个不一样的社区！！','实属弟弟程序猿'),('56dbe531544d11e99df21c1b0db597bb',1,'3dbd1751544a11e99df21c1b0db597bb','2019-04-01 15:11:15','标题1','物理学是研究物质运动最一般规律和物质基本结构的学科。作为自然科学的带头学科，物理学研究大至宇宙，小至基本粒子等一切物质最基本的运动形式和规律，水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水'),('56e6a1d6544d11e99df21c1b0db597bb',2,'3fbeb5ee544a11e99df21c1b0db597bb','2019-04-01 15:11:15','标题2','校园热水app下载|校园热水app是一款专为校园设计的打热水神器,学校使用校园热水app,既为学生提供了二十四小时的热水供应,同时也避免了热水浪费的情况,'),('56f021a3544d11e99df21c1b0db597bb',3,'de5dec1a544911e99df21c1b0db597bb','2019-04-01 15:11:15','标题3','的动机便成为人的爱好了。兴趣和爱好都和人的积极情感相联系，培养良好的兴趣爱好是推动人努力学习、积极... '),('5706f77c544d11e99df21c1b0db597bb',4,'63c96ff7544c11e99df21c1b0db597bb','2019-04-01 15:11:16','标题4','网易娱乐是最全面最专业的娱乐资讯平台,提供娱乐八卦新闻和专题报道,集明星、女星、电影、电视、音乐、视频等娱乐资讯。'),('5794ff5c546311e99df21c1b0db597bb',4,'63c96ff7544c11e99df21c1b0db597bb','2019-04-01 17:48:45','标题5','爱奇艺娱乐频道拥有全网热门娱乐视频资源,娱乐新闻资讯头条视频在线观看。包含娱乐热点、影视娱乐、明星资讯、八卦、选秀、情感、时尚娱乐、明星圈动态、明星演出活动等'),('7ae05f8012a14bd3a685e593af4c18d9',1,'3fbeb5ee544a11e99df21c1b0db597bb','2019-04-10 14:45:34','这是个标题','这里是内容哦'),('9a4e7ffb5efb42f5846657b3e899f195',4,'313b5e93b58b4196beafe7dcb8e11a09','2019-04-15 16:12:02','如何评价马云？','马·对钱不感兴趣·后悔创立阿里巴巴·英语教师·云！！'),('b6f71e9022924697aefd3dd25364560b',2,'de5dec1a544911e99df21c1b0db597bb','2019-04-15 14:29:22','如何评价996？','别问，问就是幸福！！！'),('d0360c9035ba4ad3813f334919731270',3,'63c96ff7544c11e99df21c1b0db597bb','2019-04-01 20:01:16','标题6','新浪娱乐是最新最全面的娱乐新闻信息综合站点,包括明星 、电影、最新影讯/影评、电影院在线购票订座、电视剧、音乐、戏剧、演出等娱乐信息'),('d8900a4809cf45a1a95dec0f85be71a9',2,'3fbeb5ee544a11e99df21c1b0db597bb','2019-04-02 09:09:44','帖子标题9','是指通过阅读、听讲、思考、研究、实践等途径获得知识或技能的过程。学习分为狭义与广义两种：狭义：通过阅读、听讲、研究、观察、理解、探索、实验、实践等手段获得知识'),('d9c4d99eeb1e4c32a66bd965a5ef5fee',1,'de5dec1a544911e99df21c1b0db597bb','2019-04-12 11:23:04','开车啦','搞快点，臭弟弟们，冲冲冲');

/*Table structure for table `tb_post_discuss` */

DROP TABLE IF EXISTS `tb_post_discuss`;

CREATE TABLE `tb_post_discuss` (
  `discussUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '评论编号',
  `postUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '帖子编号',
  `stuA` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生编号A',
  `stuB` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生编号B',
  `discussContent` text COLLATE utf8_unicode_ci COMMENT '回复内容',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`discussUUID`),
  KEY `postUUID` (`postUUID`),
  KEY `stuA` (`stuA`),
  KEY `stuB` (`stuB`),
  CONSTRAINT `tb_post_discuss_ibfk_1` FOREIGN KEY (`postUUID`) REFERENCES `tb_post` (`postUUID`),
  CONSTRAINT `tb_post_discuss_ibfk_2` FOREIGN KEY (`stuA`) REFERENCES `tb_student` (`stuUUID`),
  CONSTRAINT `tb_post_discuss_ibfk_3` FOREIGN KEY (`stuB`) REFERENCES `tb_student` (`stuUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评论';

/*Data for the table `tb_post_discuss` */

insert  into `tb_post_discuss`(`discussUUID`,`postUUID`,`stuA`,`stuB`,`discussContent`,`createTime`) values ('3e75c42de868412894b1fbb034235353','2ded07afaa9246f9b8346a6b43a2e4d6','313b5e93b58b4196beafe7dcb8e11a09','de5dec1a544911e99df21c1b0db597bb','你好','2019-04-18 14:51:59'),('b3da36b4eb314faebea7c09274aae9b6','2ded07afaa9246f9b8346a6b43a2e4d6','313b5e93b58b4196beafe7dcb8e11a09','de5dec1a544911e99df21c1b0db597bb','加一个','2019-04-16 17:07:10'),('bf08ac80b1de4bd5ba4579f7d1c1aefc','2ded07afaa9246f9b8346a6b43a2e4d6','313b5e93b58b4196beafe7dcb8e11a09','de5dec1a544911e99df21c1b0db597bb','臭弟弟','2019-04-18 14:14:35');

/*Table structure for table `tb_post_tab` */

DROP TABLE IF EXISTS `tb_post_tab`;

CREATE TABLE `tb_post_tab` (
  `tabID` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签编号',
  `tabName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签名',
  PRIMARY KEY (`tabID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='帖子标签';

/*Data for the table `tb_post_tab` */

insert  into `tb_post_tab`(`tabID`,`tabName`) values (1,'学习'),(2,'校园热事'),(3,'爱好'),(4,'娱乐'),(5,'岗位提供');

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `stuUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '学生编号',
  `stuHeadImg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生头像',
  `password` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `stuNO` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学号',
  `classUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班级编号',
  `stuName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '学生性别',
  `nationID` int(11) DEFAULT NULL COMMENT '民族编号',
  `accountLoc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '户口所在地',
  `telephone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `idCard` char(18) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `polStatus` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0：群众 1：共青团员 2：其他',
  `accountType` tinyint(1) DEFAULT NULL COMMENT '户口类型 0：城镇户口 1：农村户口',
  `familyAdd` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '家庭地址',
  `graSchool` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '毕业中学',
  `eduLevel` tinyint(1) DEFAULT NULL COMMENT '文化程度 0：中专 1：高中',
  PRIMARY KEY (`stuUUID`),
  UNIQUE KEY `UK_student_stuNo` (`stuNO`),
  KEY `classUUID` (`classUUID`),
  KEY `nationID` (`nationID`),
  CONSTRAINT `tb_student_ibfk_1` FOREIGN KEY (`classUUID`) REFERENCES `tb_class_info` (`classUUID`),
  CONSTRAINT `tb_student_ibfk_2` FOREIGN KEY (`nationID`) REFERENCES `tb_nation` (`nationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学生';

/*Data for the table `tb_student` */

insert  into `tb_student`(`stuUUID`,`stuHeadImg`,`password`,`stuNO`,`classUUID`,`stuName`,`sex`,`nationID`,`accountLoc`,`telephone`,`idCard`,`polStatus`,`accountType`,`familyAdd`,`graSchool`,`eduLevel`) values ('313b5e93b58b4196beafe7dcb8e11a09','stu/9ee948fc64a94070961531425da05fd4.png','201700148','201700148','460396da82894b52abddcf27988dadcd','老王',1,1,'广东惠州','12345678908','441322199803026840','1',1,'惠州市博罗县','博罗xx中学',1),('3dbd1751544a11e99df21c1b0db597bb','stu/ca0dec2ec201414aaf6e939a00fc5557.jpg','201700143','201700143','e8347ade544811e99df21c1b0db597bb','谢桑',1,1,'广东河源','13421674407','441322199803026839','1',1,'河源市','河源xx中学',1),('3fbeb5ee544a11e99df21c1b0db597bb','stu/e70fb95538954920931159f51306cb0a.jpg','201700144','201700144','e8347ade544811e99df21c1b0db597bb','梁光华',1,1,'广东佛山','13025715372','441322199803026838','1',1,'广东省佛山市','佛山xx中学',1),('63c96ff7544c11e99df21c1b0db597bb','stu/5d5dcb55ab814616929ccd272777e5af.jpg','201700145','201700145','e8347ade544811e99df21c1b0db597bb','许桑',1,1,'广东清远','13025715372','441322199803026838','1',1,'广东省清远市','清远xx中学',1),('de5dec1a544911e99df21c1b0db597bb','stu/433e798d47e6472b90bba72a845a5b71.jpg','201700142','201700142','e8347ade544811e99df21c1b0db597bb','李小雷',1,1,'广东惠州','13025715370','441322199803026836','0',1,'广东省惠州市博罗县','博罗中等专业学校',0);

/*Table structure for table `tb_student_score` */

DROP TABLE IF EXISTS `tb_student_score`;

CREATE TABLE `tb_student_score` (
  `scoreUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '成绩编号',
  `stuUUID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生编号',
  `semester` char(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学期 如：2017-2018',
  `subject` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '科目',
  `score` char(3) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`scoreUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学生成绩';

/*Data for the table `tb_student_score` */

insert  into `tb_student_score`(`scoreUUID`,`stuUUID`,`semester`,`subject`,`score`) values ('0410768657144cf88c12f61e943a9d5b','3dbd1751544a11e99df21c1b0db597bb','2017-2018','JAVA面向对象','100'),('c5933f98ccde47baa53c6ab81c1d7872','63c96ff7544c11e99df21c1b0db597bb','2017-2020','JAVA面向对象','100'),('ec66ef9492f546fe8cf9bb421ec204d4','de5dec1a544911e99df21c1b0db597bb','2017-2021','JAVA面向对象','100'),('f9fdc3c756d74eeab3a0d8bb7f6dcade','3fbeb5ee544a11e99df21c1b0db597bb','2017-2019','JAVA面向对象','100');

/*Table structure for table `tb_teacher` */

DROP TABLE IF EXISTS `tb_teacher`;

CREATE TABLE `tb_teacher` (
  `teaUUID` char(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '教师编号',
  `password` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `teaName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '教师姓名',
  `telephone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`teaUUID`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='教师';

/*Data for the table `tb_teacher` */

insert  into `tb_teacher`(`teaUUID`,`password`,`teaName`,`telephone`) values ('0c88ebf6943e47b2b5e6e1cda7fe1971','11111111','张三','13719664409'),('28f02a70205a4f268dab2e4f4dfcbbe4','123','test','123'),('303f3416def144459fafa776850c753d','13719664445','张伟','13719664445'),('36acedf3a1864986afe992e93e5ba5ea','13812345666','李四','13812345666'),('47082b23005e4634bfa48a1c5f8dbf4c','13712345678','李五','13712345678'),('4ebc5ac6d6194a788f7f9512f3c87833','123456','张三','13719664493'),('57e10e05f9f5431dbeb26e741c47bca5','10000','王老师','10000'),('6bab094973eb4d419155355fe1c01e48','13719664410','王三','13719664410'),('77cfb2e2a64744048b49cb90fa181973','13812345678','李四','13812345678'),('9077feeb33774d19bda4745647460258','13719664412','李三','13719664412'),('a9ceafc6a04a46c8bf9d69d68aea1e8c','13712345677','李五','13712345677'),('cedeeedbdd024838b26f4273b950f44b','13719664496','骑三','13719664496'),('dd09737acdae48d7952e8ee57b0dce28','13719664432','哈哈哈','13719664432'),('ff3844d06d9b43e1a9e273fdf3d7251c','13719664411','干','13719664411');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
