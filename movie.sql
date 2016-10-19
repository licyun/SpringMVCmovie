-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: movie
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

CREATE DATABASE movie DEFAULT CHARACTER SET utf8;

USE movie;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'licyun','123456','licyun@qq.com','2345_logo.png'),(2,'mzkwy','123456','mzkwy@qq.com','p2029391009.jpg'),(4,'李呈云123','123456','licyun@163.com',NULL),(5,'lichengyun','123456','lichengyun@gmail.com',NULL),(6,'李呈云','123456','lcy456@qq.com','p2291070523.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permission`
--

DROP TABLE IF EXISTS `user_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permission`
--

LOCK TABLES `user_permission` WRITE;
/*!40000 ALTER TABLE `user_permission` DISABLE KEYS */;
INSERT INTO `user_permission` VALUES (2,'licyun@qq.com','user:user'),(3,'mzkwy@qq.com','user:vipplus'),(5,'licyun@163.com','user:user'),(6,'lichengyun@gmail.com','user:user'),(7,'lcy456@qq.com','user:user');
/*!40000 ALTER TABLE `user_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'vip','licyun@qq.com',0),(2,'vip','mzkwy@qq.com',1),(4,'user','licyun@163.com',0),(5,'vip','lichengyun@gmail.com',0),(6,'user','lcy456@qq.com',0);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `starring` varchar(255) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `vid` varchar(100) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `playtype` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (10,'陆垚知马俐','文章','包贝尔 宋佳 朱亚文 焦俊艳','喜剧 爱情','中国大陆',5,'汉语普通话','2015-07-15','XMTY4MjQ1MjAzMg==','p2361036748.jpg','free','陆垚（包贝尔 饰）在上大学时重逢幼儿园同学马俐（宋佳 饰），虽然彼此心存好感，但由于陆垚有严重的“表白障碍症”，只能眼巴巴看着自己的女神马俐与别人谈恋爱。而自此之后很多年，陆垚只能以朋友的名义爱着马俐，也与她开始了一段“友情不甘、恋人不敢”的长跑。'),(11,'西游记之孙悟空三打白骨精','郑保瑞','郭富城 巩俐 冯绍峰 小沈阳','喜剧 动作 奇幻','中国大陆 香港',4,'汉语普通话','2016-02-08','XMTUzNTg0ODM1Ng==','p2315805100.jpg','free','影片讲述了师徒四人在西行的路上，白骨精（巩俐 饰）为夺唐僧（冯绍峰 饰）而巧设圈套，被孙悟空（郭富城 饰）识破，屡次受挫。唐僧却误会孙悟空滥杀无辜，将其逐出师门。白骨精趁虚而入，掳走唐僧。悟空闻讯前往营救，彻底击溃白骨精。师徒冰释前嫌，重新上路。'),(12,'我的新野蛮女友','赵根植','宋茜 车太贤 藤井美菜','喜剧 爱情','韩国 中国大陆',6,'韩语 汉语普通话','2016-04-02','XMTY3ODAyOTM1Mg==','p2339686339.jpg','free','影片讲述了男主人公牵牛（车太贤 饰）与新“野蛮”女友星星（宋茜 饰）从相恋到结婚的浪漫经历。星星是牵牛的小学初恋，由于韩语不流利常常被周围同学欺负。牵牛最初仍无法忘记分手离别的前任“她”，直到有一天，牵牛再次遇见初恋星星后，便不顾身边人的反对和她走进婚姻殿堂，没想到摆在他面前的却是超出想象的烦恼。'),(13,'老炮儿','管虎','冯小刚 许晴 张涵予 刘桦 李易峰','剧情 犯罪','中国大陆',7,'汉语普通话',NULL,'XMTQ3NjIyNjQzNg==','p2292976849.jpg','free','老炮儿在北京话中，专指提笼遛鸟，无所事事的老混混儿。 \r\n　　六爷（冯小刚 饰）就曾是”横行“老北京的老炮儿之一，如今过着悠闲自得的日子，却不想自己的儿子晓波（李易峰 饰）被卷入了与“小爷”小飞（吴亦凡 饰）的纠纷中。六爷试图出面摆平这起纠纷，并找来了昔日老友闷三儿（张涵予 饰）、话匣子（许晴 饰）、灯罩儿（刘桦 饰）帮忙，却发现这个时代已经有了一群新的“话事人”，自己这个顽主的江湖地位已经动摇，并且以往固守的生活方式已经渐渐被时代所抛弃，廉颇老矣尚能饭否？'),(14,'伦敦陷落','巴巴克·纳加非','杰拉德·巴特勒 艾伦·艾克哈特 摩根·弗里曼','动作 惊悚 犯罪','英国 美国 保加利亚',6,'英语','2016-04-08','XMTU4MTkwODkxMg==','p2325735117.jpg','user','班宁（杰拉德·巴特勒 Gerard Butler 饰）是美国特勤局的特工，最近，他接到了一个重要的任务，那就是联手局长琳（安吉拉·贝塞特 Angela Bassett 饰），护送总统本杰明（艾伦·艾克哈特 Aaron Eckhart 饰）前往伦敦圣保罗教堂，参加英国首相的葬礼。 \r\n　　英国首相死得蹊跷，班宁和琳知道，他们的行程一定受到了不法分子的密切关注，与此同时，在葬礼上，各国首脑均有出席，伦敦这座繁华靓丽的城市霎时间成为了世界关注的焦点。'),(15,'唐人街探案','陈思诚','王宝强 刘昊然 佟丽娅 陈赫','喜剧 动作 悬疑','中国大陆',6,'汉语普通话 泰语 英语','2015-12-31','XMTQ2NTc4MTk1Ng==','p2302930556.jpg','free','天赋异禀的结巴少年秦风（刘昊然 饰）警校落榜，被姥姥遣送泰国找远房表舅——号称“唐人街第一神探”，实则猥琐的大叔唐仁（王宝强 饰）散心。不想一夜花天酒地后，唐仁沦为离奇凶案嫌疑人，不得不和秦风亡命天涯……穷追不舍的警探黄兰登（陈赫 饰）、无敌幸运的警察坤泰（肖央 饰）、穷凶极恶的匪帮三人组、高深莫测的唐人街教父、美艳风骚的老板娘阿香（佟丽娅 饰）等悉数登场！七天！唐仁、秦风必须取长补短、同仇敌忾！'),(16,'心花路放','宁浩','黄渤 徐峥 袁泉 周冬雨','喜剧 爱情','中国大陆',8,'汉语普通话 粤语 云南方言','2014-09-30','XODMzOTcyNjg0','p2199268153.jpg','free','二手音响商耿浩（黄渤 饰）婚姻失败，他想用锤子爆小三（李晨 饰）的头，却迟迟没有勇气，幸亏在剧组做制片的兄弟郝义（徐峥 饰）及时发现自暴自弃的耿浩，他决定带着耿浩开启一段“治愈之旅”。于是一对好基友带着一只狗上路，邂逅三千公里的“桃花”。“阿凡达女郎”（陶慧 饰）、“杀马特”周丽娟（周冬雨 饰）、“白富美”（张俪 饰），各式各样的女人接连登场，耿浩一路艳遇一路疗伤。'),(17,'叶问3','叶伟信','甄子丹 迈克·泰森 张晋 熊黛林','剧情 动作 传记 历史','中国大陆 香港',6,'汉语普通话 粤语 英语','2016-03-04','XMTU0OTE5MDg2NA==','p2322954776.jpg','free','已在香港立足开馆的叶问（甄子丹 饰）与太太张永成（熊黛林 饰）平静地生活，不料小儿子叶正就读的小学发生了流氓滋扰事件，参与闹事的正是田傲山（梁家仁 饰）昔日的徒弟马鲸笙（谭耀文 饰）。于是叶问带领徒弟徐力（张继聪 饰）等人保护了黄老师（吴千语 饰）、校长（刘以达 饰）以及众小学生，并结识了同样是永春传人的车夫张天志（张晋 饰），二人惺惺相惜。'),(18,'万万没想到','易小星','白客 杨子姗 陈柏霖 马天宇 刘循子墨','喜剧 奇幻 冒险 古装','中国大陆',5,'汉语普通话',NULL,'XMTQ0OTE3NzQ5Mg==','p2291070523.jpg','vip','屌丝小妖王大锤（白客 饰），他生来便与常人不同，两耳尖尖，又有些小法力，总是自诩本地妖王。但让他万万没想到的是，在遇到唐僧师徒四人组后，他的命运发生了逆转；而对于唐僧师徒四人组来说，遇见王大锤也是无比郁闷的第八十二难。双方因此上演了一出相爱相杀，令人捧腹的奇幻冒险。'),(19,'流感','金成洙','张赫 秀爱 朴敏荷 柳海真 李熙俊','剧情 惊悚 灾难','韩国',7,'韩语 英语 印度尼西亚语','2013-08-04','XNzA0OTIwMzg4','p2029391009.jpg','vipplus','一群东南亚偷渡客历经艰险来到韩国，但是整个集装箱内的偷渡客几乎全部死亡，只有一人拖着羸弱的身体侥幸逃入闹市之中。殊不知此人身上携带致命猪流感病毒，短短一天时间，病毒迅速蔓延城市的各个角落。许多人在不知不觉间被感染，进而将死亡的阴影引向周围所有的人。美丽的女医生金仁海（秀爱 饰）是一位单身妈妈，她不久前遭遇一场车祸，幸被消防队救援人员姜智久（张赫 饰）救出，却因丢失重要论文资料而备受上司苛责。值此期间，韩国蛇头的弟弟因流感送入仁海的医院治疗，经诊断终于发现流感的起因，死尸横陈的集装箱无疑成为查找病源的关键。');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-19 17:52:16
