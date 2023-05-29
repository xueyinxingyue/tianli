-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tianli
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book`
(
    `book_id`       int         NOT NULL AUTO_INCREMENT,
    `book_name`     varchar(45) NOT NULL,
    `writer`        varchar(45) NOT NULL,
    `introduction`  text,
    `book_image`    varchar(255)         DEFAULT NULL,
    `categories_id` int         NOT NULL,
    `gender`        int         NOT NULL DEFAULT '0' COMMENT '分类：0：both  1：男  2：女',
    PRIMARY KEY (`book_id`),
    KEY             `bookCategories_idx` (`categories_id`),
    CONSTRAINT `categories` FOREIGN KEY (`categories_id`) REFERENCES `bookcategories` (`categories_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK
TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book`
VALUES (1, '偷偷藏不住', '竹已',
        '  高一那年，路念义正言辞拒绝了校草的表白，“我们现在可还是念书的年纪，早恋个鬼啊！”  打脸的是，她却偷偷喜欢上了哥哥的好友何嘉树。  那个男人长得真好看，眼尾微微上挑，很勾人，薄唇轻轻抿着，透出坚毅和执着。  为了他，她一直努力扮演着乖乖女的角色。  鼓起勇气表白却被拒，他说只把她当妹妹而已。  六年后他却把她扯入怀里，一边亲吻一边哑声责问，“你已经对我表白过了难道还想移情别恋？”  “……”  心机小可爱VS矜贵傲娇男神  ***********************  接档文《偷偷动了心》，求收藏！',
        'https://wp2.xiaowu007.com/view.php/2dbbff542e861ae6f8d6006528b68948.jpg', 1, 0),
       (2, '满眼皆是你', '是沙沙吖',
        '游戏网恋对象竟然是同年级的校草，甜甜的恋爱就此开始。但没想到同班同学也喜欢自己？尽力了重重坎坷，却又因为绿茶的打扰而又分又合，他们能否坚持到最后？',
        'https://wp2.xiaowu007.com/view.php/494ae630de4bea8d7f8c87fe7c2369e1.jpg', 1, 0),
       (3, '盗墓笔记', '南派三叔',
        '故事起源於1952年，主角吴邪的祖父吴老狗在长沙的血屍墓里发现战国帛书，而引发后来吴邪从帛书解谜途中的一段段冒险。五十年後，吴邪一个看似单纯的吴家富二代，大学毕业後便经营著古董店，日子过一天是一天，殊不知其身世冒险之离奇，因为发现先人笔记中一个秘密就此展开。抱著好奇和一颗想见世面的心，他硬是跟上他三叔及一群盗墓高手的鲁王宫之旅，欲解开帛书之谜。在这个过程中他遇见了闷油瓶和胖子。在途中，很多他一辈子都没见过的东西，或是连想都没想过的东西，一个接著一个出现。遭遇的每件事，越来越离奇。就在他发现自己的生活满是谜题，并欲寻求解答时，唯一的线索──「三叔」却消失了。不甘放弃的吴邪，决定追根究柢，也决定今後不凡但却不为人知的冒险旅程。',
        'https://wp2.xiaowu007.com/view.php/dcc511f9e81bd495313311f1b9ae4732.jpg', 5, 0),
       (4, '红楼梦', '曹雪芹、无名氏',
        '《红楼梦》是中国古代的章回体长篇小说，又名叫做《石头记》，被列为中国的古典四大名著之首，一般认为是清代作家曹雪芹所写。',
        'https://wp2.xiaowu007.com/view.php/ee3d0c4b042a429e372273eac4c50652.jpg', 7, 0),
       (5, '西游记', '吴承恩', '《西游记》是中国古代第一部浪漫主义章回体长篇神魔小说。',
        'https://wp2.xiaowu007.com/view.php/2b0eb48ffd055946e2575950bbcdd6d0.jpg', 7, 0),
       (6, '水浒传', '施耐庵',
        '《水浒传》是元末明初施耐庵（现存刊本署名大多有施耐庵、罗贯中两人中的一人，或两人皆有）编著的章回体长篇小说。',
        'https://wp2.xiaowu007.com/view.php/750d0817416b3f064276525777c8b767.jpg', 7, 0),
       (7, '三国演义', '罗贯中',
        '《三国演义》可大致分为黄巾起义、董卓之乱、群雄逐鹿、三国鼎立、三国归晋五大部分，描写了从东汉末年到西晋初年之间近百年的历史风云，以描写战争为主，诉说了东汉末年的群雄割据混战和魏、蜀、吴三国之间的政治和军事斗争，最终司马炎一统三国，建立晋朝的故事。反映了三国时代各类社会斗争与矛盾的转化，并概括了这一时代的历史巨变，塑造了一群叱咤风云的三国英雄人物。',
        'https://wp2.xiaowu007.com/view.php/d09023da9b5d61772d01c14783ab28a9.jpg', 7, 0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `bookcategories`
--

DROP TABLE IF EXISTS `bookcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookcategories`
(
    `categories_id`   int         NOT NULL,
    `categories_name` varchar(45) NOT NULL,
    PRIMARY KEY (`categories_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcategories`
--

LOCK
TABLES `bookcategories` WRITE;
/*!40000 ALTER TABLE `bookcategories` DISABLE KEYS */;
INSERT INTO `bookcategories`
VALUES (1, '现代言情'),
       (2, '古代言情'),
       (3, '青春文学'),
       (4, '影视原著'),
       (5, '悬疑'),
       (6, '科幻'),
       (7, '名著'),
       (8, '仙侠'),
       (9, '玄幻'),
       (10, '武侠'),
       (11, '历史'),
       (12, '现实'),
       (13, '军事'),
       (14, '时代经典'),
       (15, '经管励志');
/*!40000 ALTER TABLE `bookcategories` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `user_id`      int         NOT NULL AUTO_INCREMENT,
    `username`     varchar(45) NOT NULL,
    `password`     varchar(45) NOT NULL,
    `phone_number` varchar(45) DEFAULT NULL,
    `name`         varchar(45) DEFAULT '萌新',
    `school`       varchar(45) DEFAULT '未填',
    `gender`       int         DEFAULT '0' COMMENT '分类：0：未填  1：男  2：女',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK
TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user`
VALUES (1001, 'tianli', '123', '12345678901', 'tl', '广东邮电职业技术学院', 1),
       (1002, 'hcl', 'hcl', '11111111111', 'hcl', NULL, 1),
       (1006, 'tianli12', '123', NULL, NULL, NULL, 2),
       (1007, 'test', '123', NULL, NULL, NULL, 2),
       (1008, 'test11', '123', NULL, NULL, NULL, 1),
       (1009, 'itest', '123', NULL, NULL, NULL, 2),
       (1010, 'itest1', '1234', '1452', '', NULL, 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-29 23:55:01
