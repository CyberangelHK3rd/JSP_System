/*
SQLyog v10.2 
MySQL - 5.5.41 : Database - db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `db`;

/*Table structure for table `yjwadmin` */

DROP TABLE IF EXISTS `yjwadmin`;

CREATE TABLE `yjwadmin` (
  `yjwuname` varchar(20) NOT NULL COMMENT '用户名',
  `yjwpw` varchar(20) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`yjwuname`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `yjwadmin` */

insert  into `yjwadmin`(`yjwuname`,`yjwpw`) values ('ll','456'),('ls','222'),('ww','111'),('zs','111');

/*Table structure for table `yjwbag` */

DROP TABLE IF EXISTS `yjwbag`;

CREATE TABLE `yjwbag` (
  `yjwbno` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `yjwbname` varchar(30) DEFAULT NULL COMMENT '名称',
  `yjwbcolor` varchar(20) DEFAULT NULL COMMENT '颜色',
  `yjwbnumber` int(11) DEFAULT NULL COMMENT '库存',
  `yjwbprice` double DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`yjwbno`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=gbk;

/*Data for the table `yjwbag` */

insert  into `yjwbag`(`yjwbno`,`yjwbname`,`yjwbcolor`,`yjwbnumber`,`yjwbprice`) values (1,'asd','ds',212,2),(2,'鞋子','绿色',1010,20),(3,'裤子','绿色',101,20),(4,'帽子','绿色',101,20),(5,'帽子','绿色',101,20),(6,'帽子','绿色',101,20),(7,'帽子','绿色',101,20),(9,'帽子','绿色',101,20),(10,'帽子','绿色',101,20);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
