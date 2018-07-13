/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : weibo-demo

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-07-14 00:39:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  UNIQUE KEY `admin_id` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_id` int(11) NOT NULL AUTO_INCREMENT,
  `weibo_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `collect_time` datetime DEFAULT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `weibo_id` int(11) DEFAULT NULL COMMENT '微博id',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `comment_content` varchar(100) NOT NULL COMMENT '评论内容',
  PRIMARY KEY (`comment_id`),
  KEY `FK_sendcom` (`user_id`),
  KEY `FK_getcom` (`weibo_id`),
  CONSTRAINT `FK_getcom` FOREIGN KEY (`weibo_id`) REFERENCES `weibo` (`weibo_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_sendcom` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `likes_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `weibo_id` int(11) DEFAULT NULL,
  `like_time` datetime DEFAULT NULL,
  PRIMARY KEY (`likes_id`),
  KEY `FK_sendlikes` (`user_id`),
  KEY `FK_getlikes` (`weibo_id`),
  CONSTRAINT `FK_getlikes` FOREIGN KEY (`weibo_id`) REFERENCES `weibo` (`weibo_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_sendlikes` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likes
-- ----------------------------

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('00', '神秘');
INSERT INTO `location` VALUES ('01', '北京');
INSERT INTO `location` VALUES ('02', '深圳');
INSERT INTO `location` VALUES ('03', '上海');
INSERT INTO `location` VALUES ('04', '重庆');
INSERT INTO `location` VALUES ('05', '天津');
INSERT INTO `location` VALUES ('06', '广东');
INSERT INTO `location` VALUES ('07', '河北');
INSERT INTO `location` VALUES ('08', '山西');
INSERT INTO `location` VALUES ('09', '内蒙古');
INSERT INTO `location` VALUES ('10', '辽宁');
INSERT INTO `location` VALUES ('11', '吉林');
INSERT INTO `location` VALUES ('12', '黑龙江');
INSERT INTO `location` VALUES ('13', '江苏');
INSERT INTO `location` VALUES ('14', '浙江');
INSERT INTO `location` VALUES ('15', '安徽');
INSERT INTO `location` VALUES ('16', '福建');
INSERT INTO `location` VALUES ('17', '江西');
INSERT INTO `location` VALUES ('18', '山东');
INSERT INTO `location` VALUES ('19', '河南');
INSERT INTO `location` VALUES ('20', '湖北');
INSERT INTO `location` VALUES ('21', '湖南');
INSERT INTO `location` VALUES ('22', '广西');
INSERT INTO `location` VALUES ('23', '海南');
INSERT INTO `location` VALUES ('24', '四川');
INSERT INTO `location` VALUES ('25', '贵州');
INSERT INTO `location` VALUES ('26', '云南');
INSERT INTO `location` VALUES ('27', '西藏');
INSERT INTO `location` VALUES ('28', '陕西');
INSERT INTO `location` VALUES ('29', '甘肃');
INSERT INTO `location` VALUES ('30', '青海');
INSERT INTO `location` VALUES ('31', '宁夏');
INSERT INTO `location` VALUES ('32', '新疆');
INSERT INTO `location` VALUES ('33', '香港');
INSERT INTO `location` VALUES ('34', '澳门');
INSERT INTO `location` VALUES ('35', '台湾');
INSERT INTO `location` VALUES ('0101', '东城区');
INSERT INTO `location` VALUES ('0102', '西城区');
INSERT INTO `location` VALUES ('0103', '崇文区');
INSERT INTO `location` VALUES ('0104', '宣武区');
INSERT INTO `location` VALUES ('0105', '朝阳区');
INSERT INTO `location` VALUES ('0106', '海淀区');
INSERT INTO `location` VALUES ('0107', '丰台区');
INSERT INTO `location` VALUES ('0108', '石景山');
INSERT INTO `location` VALUES ('0201', '罗湖');
INSERT INTO `location` VALUES ('0202', '福田');
INSERT INTO `location` VALUES ('0203', '南山');
INSERT INTO `location` VALUES ('0204', '盐田');
INSERT INTO `location` VALUES ('0205', '宝安');
INSERT INTO `location` VALUES ('0206', '龙岗');
INSERT INTO `location` VALUES ('0301', '宝山');
INSERT INTO `location` VALUES ('0302', '金山');
INSERT INTO `location` VALUES ('0303', '南市');
INSERT INTO `location` VALUES ('0304', '长宁');
INSERT INTO `location` VALUES ('0305', '静安');
INSERT INTO `location` VALUES ('0306', '青浦');
INSERT INTO `location` VALUES ('0307', '崇明');
INSERT INTO `location` VALUES ('0308', '卢湾');
INSERT INTO `location` VALUES ('0309', '松江');
INSERT INTO `location` VALUES ('0310', '奉贤');
INSERT INTO `location` VALUES ('0311', '浦东');
INSERT INTO `location` VALUES ('0312', '杨浦');
INSERT INTO `location` VALUES ('0313', '虹口');
INSERT INTO `location` VALUES ('0314', '普陀');
INSERT INTO `location` VALUES ('0315', '闸北');
INSERT INTO `location` VALUES ('0316', '黄浦');
INSERT INTO `location` VALUES ('0317', '闵行');
INSERT INTO `location` VALUES ('0318', '徐汇');
INSERT INTO `location` VALUES ('0319', '嘉定');
INSERT INTO `location` VALUES ('0320', '南汇');
INSERT INTO `location` VALUES ('0401', '渝中');
INSERT INTO `location` VALUES ('0402', '江北');
INSERT INTO `location` VALUES ('0403', '沙坪坝');
INSERT INTO `location` VALUES ('0404', '南岸');
INSERT INTO `location` VALUES ('0405', '九龙坡');
INSERT INTO `location` VALUES ('0406', '大渡口');
INSERT INTO `location` VALUES ('0501', '和平');
INSERT INTO `location` VALUES ('0502', '河北');
INSERT INTO `location` VALUES ('0503', '河西');
INSERT INTO `location` VALUES ('0504', '河东');
INSERT INTO `location` VALUES ('0505', '南开');
INSERT INTO `location` VALUES ('0506', '红桥');
INSERT INTO `location` VALUES ('0507', '塘沽');
INSERT INTO `location` VALUES ('0508', '汉沽');
INSERT INTO `location` VALUES ('0509', '大港');
INSERT INTO `location` VALUES ('0510', '东丽');
INSERT INTO `location` VALUES ('0511', '西青');
INSERT INTO `location` VALUES ('0512', '津南');
INSERT INTO `location` VALUES ('0513', '北辰');
INSERT INTO `location` VALUES ('0514', '武清');
INSERT INTO `location` VALUES ('0515', '滨海');
INSERT INTO `location` VALUES ('0601', '广州');
INSERT INTO `location` VALUES ('0602', '珠海');
INSERT INTO `location` VALUES ('0603', '中山');
INSERT INTO `location` VALUES ('0604', '佛山');
INSERT INTO `location` VALUES ('0605', '东莞');
INSERT INTO `location` VALUES ('0606', '清远');
INSERT INTO `location` VALUES ('0607', '肇庆');
INSERT INTO `location` VALUES ('0608', '阳江');
INSERT INTO `location` VALUES ('0609', '湛江');
INSERT INTO `location` VALUES ('0610', '韶关');
INSERT INTO `location` VALUES ('0611', '惠州');
INSERT INTO `location` VALUES ('0612', '河源');
INSERT INTO `location` VALUES ('0613', '汕尾');
INSERT INTO `location` VALUES ('0614', '汕头');
INSERT INTO `location` VALUES ('0615', '梅州');
INSERT INTO `location` VALUES ('0701', '石家庄');
INSERT INTO `location` VALUES ('0702', '唐山');
INSERT INTO `location` VALUES ('0703', '秦皇岛');
INSERT INTO `location` VALUES ('0704', '邯郸');
INSERT INTO `location` VALUES ('0705', '邢台');
INSERT INTO `location` VALUES ('0706', '张家口');
INSERT INTO `location` VALUES ('0707', '承德');
INSERT INTO `location` VALUES ('0708', '廊坊');
INSERT INTO `location` VALUES ('0709', '沧州');
INSERT INTO `location` VALUES ('0710', '保定');
INSERT INTO `location` VALUES ('0711', '衡水');
INSERT INTO `location` VALUES ('0801', '太原');
INSERT INTO `location` VALUES ('0802', '大同');
INSERT INTO `location` VALUES ('0803', '阳泉');
INSERT INTO `location` VALUES ('0804', '朔州');
INSERT INTO `location` VALUES ('0805', '长治');
INSERT INTO `location` VALUES ('0806', '临汾');
INSERT INTO `location` VALUES ('0807', '晋城');
INSERT INTO `location` VALUES ('0901', '呼和浩特');
INSERT INTO `location` VALUES ('0902', '包头');
INSERT INTO `location` VALUES ('0903', '乌海');
INSERT INTO `location` VALUES ('0904', '临河');
INSERT INTO `location` VALUES ('0905', '东胜');
INSERT INTO `location` VALUES ('0906', '集宁');
INSERT INTO `location` VALUES ('0907', '锡林浩特');
INSERT INTO `location` VALUES ('0908', '通辽');
INSERT INTO `location` VALUES ('0909', '赤峰');
INSERT INTO `location` VALUES ('0910', '海拉尔');
INSERT INTO `location` VALUES ('0911', '乌兰浩特');
INSERT INTO `location` VALUES ('1001', '沈阳');
INSERT INTO `location` VALUES ('1002', '大连');
INSERT INTO `location` VALUES ('1003', '鞍山');
INSERT INTO `location` VALUES ('1004', '锦州');
INSERT INTO `location` VALUES ('1005', '丹东');
INSERT INTO `location` VALUES ('1006', '盘锦');
INSERT INTO `location` VALUES ('1007', '铁岭');
INSERT INTO `location` VALUES ('1008', '抚顺');
INSERT INTO `location` VALUES ('1009', '营口');
INSERT INTO `location` VALUES ('1010', '辽阳');
INSERT INTO `location` VALUES ('1011', '阜新');
INSERT INTO `location` VALUES ('1012', '本溪');
INSERT INTO `location` VALUES ('1013', '朝阳');
INSERT INTO `location` VALUES ('1014', '葫芦岛');
INSERT INTO `location` VALUES ('1101', '长春');
INSERT INTO `location` VALUES ('1102', '吉林');
INSERT INTO `location` VALUES ('1103', '四平');
INSERT INTO `location` VALUES ('1104', '辽源');
INSERT INTO `location` VALUES ('1105', '通化');
INSERT INTO `location` VALUES ('1106', '白山');
INSERT INTO `location` VALUES ('1107', '松原');
INSERT INTO `location` VALUES ('1108', '白城');
INSERT INTO `location` VALUES ('1109', '延边');
INSERT INTO `location` VALUES ('1201', '哈尔滨');
INSERT INTO `location` VALUES ('1202', '齐齐哈尔');
INSERT INTO `location` VALUES ('1203', '牡丹江');
INSERT INTO `location` VALUES ('1204', '佳木斯');
INSERT INTO `location` VALUES ('1205', '大庆');
INSERT INTO `location` VALUES ('1206', '伊春');
INSERT INTO `location` VALUES ('1207', '黑河');
INSERT INTO `location` VALUES ('1208', '鸡西');
INSERT INTO `location` VALUES ('1209', '鹤岗');
INSERT INTO `location` VALUES ('1210', '双鸭山');
INSERT INTO `location` VALUES ('1211', '七台河');
INSERT INTO `location` VALUES ('1212', '绥化');
INSERT INTO `location` VALUES ('1213', '大兴安岭');
INSERT INTO `location` VALUES ('1301', '南京');
INSERT INTO `location` VALUES ('1302', '苏州');
INSERT INTO `location` VALUES ('1303', '无锡');
INSERT INTO `location` VALUES ('1304', '常州');
INSERT INTO `location` VALUES ('1305', '镇江');
INSERT INTO `location` VALUES ('1306', '连云港');
INSERT INTO `location` VALUES ('1307', '扬州');
INSERT INTO `location` VALUES ('1308', '徐州');
INSERT INTO `location` VALUES ('1309', '南通');
INSERT INTO `location` VALUES ('1310', '盐城');
INSERT INTO `location` VALUES ('1311', '淮阴');
INSERT INTO `location` VALUES ('1312', '泰州');
INSERT INTO `location` VALUES ('1313', '宿迁');
INSERT INTO `location` VALUES ('1401', '杭州');
INSERT INTO `location` VALUES ('1402', '湖州');
INSERT INTO `location` VALUES ('1403', '丽水');
INSERT INTO `location` VALUES ('1404', '温州');
INSERT INTO `location` VALUES ('1405', '绍兴');
INSERT INTO `location` VALUES ('1406', '舟山');
INSERT INTO `location` VALUES ('1407', '嘉兴');
INSERT INTO `location` VALUES ('1408', '金华');
INSERT INTO `location` VALUES ('1409', '台州');
INSERT INTO `location` VALUES ('1410', '衢州');
INSERT INTO `location` VALUES ('1411', '宁波');
INSERT INTO `location` VALUES ('1501', '合肥');
INSERT INTO `location` VALUES ('1502', '芜湖');
INSERT INTO `location` VALUES ('1503', '蚌埠');
INSERT INTO `location` VALUES ('1504', '滁州');
INSERT INTO `location` VALUES ('1505', '安庆');
INSERT INTO `location` VALUES ('1506', '六安');
INSERT INTO `location` VALUES ('1507', '黄山');
INSERT INTO `location` VALUES ('1508', '宣城');
INSERT INTO `location` VALUES ('1509', '淮南');
INSERT INTO `location` VALUES ('1510', '宿州');
INSERT INTO `location` VALUES ('1511', '马鞍山');
INSERT INTO `location` VALUES ('1512', '铜陵');
INSERT INTO `location` VALUES ('1513', '淮北');
INSERT INTO `location` VALUES ('1514', '阜阳');
INSERT INTO `location` VALUES ('1515', '池州');
INSERT INTO `location` VALUES ('1516', '巢湖');
INSERT INTO `location` VALUES ('1517', '亳州');
INSERT INTO `location` VALUES ('1601', '福州');
INSERT INTO `location` VALUES ('1602', '厦门');
INSERT INTO `location` VALUES ('1603', '泉州');
INSERT INTO `location` VALUES ('1604', '漳州');
INSERT INTO `location` VALUES ('1605', '龙岩');
INSERT INTO `location` VALUES ('1606', '南平');
INSERT INTO `location` VALUES ('1607', '宁德');
INSERT INTO `location` VALUES ('1608', '莆田');
INSERT INTO `location` VALUES ('1609', '三明');
INSERT INTO `location` VALUES ('1701', '南昌');
INSERT INTO `location` VALUES ('1702', '景德镇');
INSERT INTO `location` VALUES ('1703', '九江');
INSERT INTO `location` VALUES ('1704', '萍乡');
INSERT INTO `location` VALUES ('1705', '新余');
INSERT INTO `location` VALUES ('1706', '鹰潭');
INSERT INTO `location` VALUES ('1707', '赣州');
INSERT INTO `location` VALUES ('1708', '宜春');
INSERT INTO `location` VALUES ('1709', '吉安');
INSERT INTO `location` VALUES ('1710', '上饶');
INSERT INTO `location` VALUES ('1711', '抚州');
INSERT INTO `location` VALUES ('1801', '济南');
INSERT INTO `location` VALUES ('1802', '青岛');
INSERT INTO `location` VALUES ('1803', '淄博');
INSERT INTO `location` VALUES ('1804', '德州');
INSERT INTO `location` VALUES ('1805', '烟台');
INSERT INTO `location` VALUES ('1806', '潍坊');
INSERT INTO `location` VALUES ('1807', '济宁');
INSERT INTO `location` VALUES ('1808', '泰安');
INSERT INTO `location` VALUES ('1809', '临沂');
INSERT INTO `location` VALUES ('1810', '菏泽');
INSERT INTO `location` VALUES ('1811', '威海');
INSERT INTO `location` VALUES ('1812', '枣庄');
INSERT INTO `location` VALUES ('1813', '日照');
INSERT INTO `location` VALUES ('1814', '莱芜');
INSERT INTO `location` VALUES ('1815', '聊城');
INSERT INTO `location` VALUES ('1816', '滨州');
INSERT INTO `location` VALUES ('1817', '东营');
INSERT INTO `location` VALUES ('1901', '郑州');
INSERT INTO `location` VALUES ('1902', '开封');
INSERT INTO `location` VALUES ('1903', '洛阳');
INSERT INTO `location` VALUES ('1904', '平顶山');
INSERT INTO `location` VALUES ('1905', '安阳');
INSERT INTO `location` VALUES ('1906', '鹤壁');
INSERT INTO `location` VALUES ('1907', '新乡');
INSERT INTO `location` VALUES ('1908', '焦作');
INSERT INTO `location` VALUES ('1909', '濮阳');
INSERT INTO `location` VALUES ('1910', '许昌');
INSERT INTO `location` VALUES ('1911', '漯河');
INSERT INTO `location` VALUES ('1912', '三门峡');
INSERT INTO `location` VALUES ('1913', '南阳');
INSERT INTO `location` VALUES ('1914', '商丘');
INSERT INTO `location` VALUES ('1915', '周口');
INSERT INTO `location` VALUES ('1916', '驻马店');
INSERT INTO `location` VALUES ('1917', '信阳');
INSERT INTO `location` VALUES ('1918', '济源');
INSERT INTO `location` VALUES ('2001', '武汉');
INSERT INTO `location` VALUES ('2002', '黄石');
INSERT INTO `location` VALUES ('2003', '十堰');
INSERT INTO `location` VALUES ('2004', '荆州');
INSERT INTO `location` VALUES ('2005', '宜昌');
INSERT INTO `location` VALUES ('2006', '襄樊');
INSERT INTO `location` VALUES ('2007', '鄂州');
INSERT INTO `location` VALUES ('2008', '荆门');
INSERT INTO `location` VALUES ('2009', '孝感');
INSERT INTO `location` VALUES ('2010', '黄冈');
INSERT INTO `location` VALUES ('2011', '咸宁');
INSERT INTO `location` VALUES ('2012', '恩施');
INSERT INTO `location` VALUES ('2013', '随州');
INSERT INTO `location` VALUES ('2014', '仙桃');
INSERT INTO `location` VALUES ('2015', '天门');
INSERT INTO `location` VALUES ('2016', '潜江');
INSERT INTO `location` VALUES ('2017', '神农架');
INSERT INTO `location` VALUES ('2101', '长沙');
INSERT INTO `location` VALUES ('2102', '株州');
INSERT INTO `location` VALUES ('2103', '湘潭');
INSERT INTO `location` VALUES ('2104', '衡阳');
INSERT INTO `location` VALUES ('2105', '邵阳');
INSERT INTO `location` VALUES ('2106', '岳阳');
INSERT INTO `location` VALUES ('2107', '常德');
INSERT INTO `location` VALUES ('2108', '郴州');
INSERT INTO `location` VALUES ('2109', '益阳');
INSERT INTO `location` VALUES ('2110', '永州');
INSERT INTO `location` VALUES ('2111', '怀化');
INSERT INTO `location` VALUES ('2112', '娄底');
INSERT INTO `location` VALUES ('2113', '湘西');
INSERT INTO `location` VALUES ('2201', '南宁');
INSERT INTO `location` VALUES ('2202', '柳州');
INSERT INTO `location` VALUES ('2203', '桂林');
INSERT INTO `location` VALUES ('2204', '梧州');
INSERT INTO `location` VALUES ('2205', '北海');
INSERT INTO `location` VALUES ('2206', '防城港');
INSERT INTO `location` VALUES ('2207', '钦州');
INSERT INTO `location` VALUES ('2208', '贵港');
INSERT INTO `location` VALUES ('2209', '玉林');
INSERT INTO `location` VALUES ('2210', '贺州');
INSERT INTO `location` VALUES ('2211', '百色');
INSERT INTO `location` VALUES ('2212', '河池');
INSERT INTO `location` VALUES ('2301', '海口');
INSERT INTO `location` VALUES ('2302', '三亚');
INSERT INTO `location` VALUES ('2303', '通什');
INSERT INTO `location` VALUES ('2304', '琼海');
INSERT INTO `location` VALUES ('2305', '琼山');
INSERT INTO `location` VALUES ('2306', '文昌');
INSERT INTO `location` VALUES ('2307', '万宁');
INSERT INTO `location` VALUES ('2308', '东方');
INSERT INTO `location` VALUES ('2309', '儋州');
INSERT INTO `location` VALUES ('2401', '成都');
INSERT INTO `location` VALUES ('2402', '自贡');
INSERT INTO `location` VALUES ('2403', '攀枝花');
INSERT INTO `location` VALUES ('2404', '泸州');
INSERT INTO `location` VALUES ('2405', '德阳');
INSERT INTO `location` VALUES ('2406', '绵阳');
INSERT INTO `location` VALUES ('2407', '广元');
INSERT INTO `location` VALUES ('2408', '遂宁');
INSERT INTO `location` VALUES ('2409', '内江');
INSERT INTO `location` VALUES ('2410', '乐山');
INSERT INTO `location` VALUES ('2411', '南充');
INSERT INTO `location` VALUES ('2412', '宜宾');
INSERT INTO `location` VALUES ('2413', '广安');
INSERT INTO `location` VALUES ('2414', '达川');
INSERT INTO `location` VALUES ('2415', '巴中');
INSERT INTO `location` VALUES ('2416', '雅安');
INSERT INTO `location` VALUES ('2417', '眉山');
INSERT INTO `location` VALUES ('2418', '阿坝');
INSERT INTO `location` VALUES ('2419', '甘孜');
INSERT INTO `location` VALUES ('2420', '凉山');
INSERT INTO `location` VALUES ('2501', '贵阳');
INSERT INTO `location` VALUES ('2502', '六盘水');
INSERT INTO `location` VALUES ('2503', '遵义');
INSERT INTO `location` VALUES ('2504', '铜仁');
INSERT INTO `location` VALUES ('2505', '毕节');
INSERT INTO `location` VALUES ('2506', '安顺');
INSERT INTO `location` VALUES ('2507', '黔西南');
INSERT INTO `location` VALUES ('2508', '黔东南');
INSERT INTO `location` VALUES ('2509', '黔南');
INSERT INTO `location` VALUES ('2601', '昆明');
INSERT INTO `location` VALUES ('2602', '东川');
INSERT INTO `location` VALUES ('2603', '曲靖');
INSERT INTO `location` VALUES ('2604', '玉溪');
INSERT INTO `location` VALUES ('2605', '昭通');
INSERT INTO `location` VALUES ('2606', '思茅');
INSERT INTO `location` VALUES ('2607', '临沧');
INSERT INTO `location` VALUES ('2608', '保山');
INSERT INTO `location` VALUES ('2609', '丽江');
INSERT INTO `location` VALUES ('2610', '文山');
INSERT INTO `location` VALUES ('2611', '红河');
INSERT INTO `location` VALUES ('2612', '西双版纳');
INSERT INTO `location` VALUES ('2613', '楚雄');
INSERT INTO `location` VALUES ('2614', '大理');
INSERT INTO `location` VALUES ('2615', '德宏');
INSERT INTO `location` VALUES ('2616', '怒江');
INSERT INTO `location` VALUES ('2617', '迪庆');
INSERT INTO `location` VALUES ('2701', '拉萨');
INSERT INTO `location` VALUES ('2702', '那曲');
INSERT INTO `location` VALUES ('2703', '昌都');
INSERT INTO `location` VALUES ('2704', '山南');
INSERT INTO `location` VALUES ('2705', '日喀则');
INSERT INTO `location` VALUES ('2706', '阿里');
INSERT INTO `location` VALUES ('2707', '林芝');
INSERT INTO `location` VALUES ('2801', '西安');
INSERT INTO `location` VALUES ('2802', '铜川');
INSERT INTO `location` VALUES ('2803', '宝鸡');
INSERT INTO `location` VALUES ('2804', '咸阳');
INSERT INTO `location` VALUES ('2805', '渭南');
INSERT INTO `location` VALUES ('2806', '延安');
INSERT INTO `location` VALUES ('2807', '汉中');
INSERT INTO `location` VALUES ('2808', '榆林');
INSERT INTO `location` VALUES ('2809', '商洛');
INSERT INTO `location` VALUES ('2810', '安康');
INSERT INTO `location` VALUES ('2901', '兰州');
INSERT INTO `location` VALUES ('2902', '金昌');
INSERT INTO `location` VALUES ('2903', '白银');
INSERT INTO `location` VALUES ('2904', '天水');
INSERT INTO `location` VALUES ('2905', '嘉峪关');
INSERT INTO `location` VALUES ('2906', '定西');
INSERT INTO `location` VALUES ('2907', '平凉');
INSERT INTO `location` VALUES ('2908', '庆阳');
INSERT INTO `location` VALUES ('2909', '陇南');
INSERT INTO `location` VALUES ('2910', '武威');
INSERT INTO `location` VALUES ('2911', '张掖');
INSERT INTO `location` VALUES ('2912', '酒泉');
INSERT INTO `location` VALUES ('2913', '甘南');
INSERT INTO `location` VALUES ('2914', '临夏');
INSERT INTO `location` VALUES ('3001', '西宁');
INSERT INTO `location` VALUES ('3002', '海东');
INSERT INTO `location` VALUES ('3003', '海北');
INSERT INTO `location` VALUES ('3004', '黄南');
INSERT INTO `location` VALUES ('3005', '海南');
INSERT INTO `location` VALUES ('3006', '果洛');
INSERT INTO `location` VALUES ('3007', '玉树');
INSERT INTO `location` VALUES ('3008', '海西');
INSERT INTO `location` VALUES ('3101', '银川');
INSERT INTO `location` VALUES ('3102', '石嘴山');
INSERT INTO `location` VALUES ('3103', '银南');
INSERT INTO `location` VALUES ('3104', '固原');
INSERT INTO `location` VALUES ('3201', '乌鲁木齐');
INSERT INTO `location` VALUES ('3202', '克拉玛依');
INSERT INTO `location` VALUES ('3203', '石河子');
INSERT INTO `location` VALUES ('3204', '吐鲁番');
INSERT INTO `location` VALUES ('3205', '哈密');
INSERT INTO `location` VALUES ('3206', '和田');
INSERT INTO `location` VALUES ('3207', '阿克苏');
INSERT INTO `location` VALUES ('3208', '喀什');
INSERT INTO `location` VALUES ('3209', '克孜勒苏');
INSERT INTO `location` VALUES ('3210', '巴音郭楞');
INSERT INTO `location` VALUES ('3211', '昌吉');
INSERT INTO `location` VALUES ('3212', '博尔塔拉');
INSERT INTO `location` VALUES ('3213', '伊犁');

-- ----------------------------
-- Table structure for mention
-- ----------------------------
DROP TABLE IF EXISTS `mention`;
CREATE TABLE `mention` (
  `mention_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `repostCount` int(11) DEFAULT NULL,
  `commentCount` int(11) DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  `likeCount` int(11) DEFAULT NULL,
  `fansCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`mention_id`),
  KEY `FK_at` (`user_id`),
  CONSTRAINT `FK_at` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mention
-- ----------------------------

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `followid` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`relation_id`),
  KEY `FK_follow` (`user_id`),
  CONSTRAINT `FK_follow` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relation
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) DEFAULT NULL,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `reply_content` varchar(100) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `face` varchar(50) DEFAULT NULL COMMENT '头像',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `bir` date DEFAULT NULL COMMENT '出生日期',
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  `city` varchar(10) DEFAULT NULL COMMENT '市',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for weibo
-- ----------------------------
DROP TABLE IF EXISTS `weibo`;
CREATE TABLE `weibo` (
  `weibo_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微博id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `post_time` datetime DEFAULT NULL COMMENT '发送时间',
  `content` varchar(100) NOT NULL COMMENT '文字内容',
  `pic1` varchar(50) DEFAULT NULL,
  `pic2` varchar(50) DEFAULT NULL,
  `pic3` varchar(50) DEFAULT NULL,
  `pic4` varchar(50) DEFAULT NULL,
  `pic5` varchar(50) DEFAULT NULL,
  `pic6` varchar(50) DEFAULT NULL,
  `pic7` varchar(50) DEFAULT NULL,
  `pic8` varchar(50) DEFAULT NULL,
  `pic9` varchar(50) DEFAULT NULL,
  `original` int(11) DEFAULT NULL,
  `repost_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`weibo_id`),
  KEY `FK_Relationship_1` (`user_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibo
-- ----------------------------
