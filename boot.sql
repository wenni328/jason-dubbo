/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : boot

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 27/08/2018 20:45:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `author` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `authorId` int(11) DEFAULT NULL COMMENT '作者id',
  `content` mediumtext COLLATE utf8_bin COMMENT '博客内容md',
  `html` mediumtext COLLATE utf8_bin COMMENT '博客内容html',
  `createTime` datetime DEFAULT NULL COMMENT '发表时间',
  `mark` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '标签',
  `sorts` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '分类',
  `picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '随机一张图',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=324 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='博客表';

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES (13, '面试随笔', '谢勇', 1, '> 2018-05-25，某医疗互联网\n\n 1.自我介绍。\n 2.介绍简历中的项目\n     >扯到一个发布动态的问题，然后直接问微博这样的多线程情况下怎么整，好吧，没考虑到这样的情况。\n \n 3.JVM内存模型\n >**java堆**：Java虚拟机所管理的内存中最大的一块。Java堆是被所有线程共享的一块内存区域，在虚拟机启动时创建。此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。\n >\n >**方法区**：方法区（Method Area）与Java堆一样，是各个线程共享的内存区域，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。\n >**程序计数器**：程序计数器（Program Counter Register）是一块较小的内存空间，它的作用可以看做是当前线程所执行的字节码的行号指示器。\n >**java虚拟机栈**：与程序计数器一样，Java虚拟机栈（Java Virtual Machine Stacks）也是线程私有的，它的生命周期与线程相同。虚拟机栈描述的是Java方法执行的内存模型：每个方法被执行的时候都会同时创建一个栈帧（Stack Frame）用于存储局部变量表、操作栈、动态链接、方法出口等信息。每一个方法被调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中从入栈到出栈的过程。\n >**本地方法栈**：本地方法栈（Native Method Stacks）,本地方法栈（Native Method Stacks）与虚拟机栈所发挥的作用是非常相似的，其区别不过是虚拟机栈为虚拟机执行Java方法（也就是字节码）服务，而本地方法栈则是为虚拟机使用到的Native方法服务。\n\n 4.ES2.X支持中文搜索吗，底层数据结构是什么？\n> （没回答出来）es2.x支持中文搜索,底层数据结构是倒序索引，有兴趣的同学们可以去了解下，\n\n 5.HashMap原理，HashMap在多线程下的机制是什么？\n>  [HashMap原理](https://blog.csdn.net/qq_26118603/article/details/79849555)，多线程下的机制？有用到这个吗？多线程下不是不用HashMap吗，面试官让我回去百度。。。\n\n 6.mysql行锁表锁介绍（忘了）\n > 表锁：开销小，加锁快；不会出现死锁；锁定力度大，发生锁冲突概率高，并发度最低，使用场景：查询为主，少量索引\n > 行锁：开销大，加锁慢；会出现死锁；锁定粒度小，发生锁冲突的概率低，并发度高，场景：有大量按索引条件并发更新少量不同数据，伴随并发查询\n \n 7.ConcurrentHashMap实现原理\n \n\n> CAS无锁算法，分段锁机制\n\n8.CAS算法介绍以及全称\n\n> CAS算法（Compare And Swap）：CAS操作（compare and swap）CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则返回V。因为线程不必再等待锁定，只要执行CAS操作就可以，会在预期中完成，所以叫无锁算法。（嘴贱扯了ABA）\n> ABA：如果另一个线程修改V值假设原来是A，先修改成B，再修改回成A。当前线程的CAS操作无法分辨当前V值是否发生过变化。解决办法：自动记录仪记录下线程操作。面试官：这是怎么记录的，我：奔溃。。。\n\n9.LinkList实现了哪些接口，底层数据结构是什么\n\n> List、AbstractList、Iterable.....接口，底层使用双向环形链表数据结构，问：双向链表的实现方式，我：猝\n\n```\n面试总体感觉不好，每些都懂点儿，但是往深了问，死翘翘，所以去互联网公司面试，这些基础一定要打牢，架构这块可能面试官没这么注重，（要是注重起来那就是底层实现了）。主要就是基础这块：集合框架、锁、多线程\n```\n\n ', '<blockquote>\n<p>2018-05-25，某医疗互联网</p>\n</blockquote>\n<p> 1.自我介绍。<br> 2.介绍简历中的项目</p>\n<pre><code> &gt;扯到一个发布动态的问题，然后直接问微博这样的多线程情况下怎么整，好吧，没考虑到这样的情况。\n</code></pre><p> 3.JVM内存模型</p>\n<blockquote>\n<p><strong>java堆</strong>：Java虚拟机所管理的内存中最大的一块。Java堆是被所有线程共享的一块内存区域，在虚拟机启动时创建。此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。</p>\n<p><strong>方法区</strong>：方法区（Method Area）与Java堆一样，是各个线程共享的内存区域，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。<br><strong>程序计数器</strong>：程序计数器（Program Counter Register）是一块较小的内存空间，它的作用可以看做是当前线程所执行的字节码的行号指示器。<br><strong>java虚拟机栈</strong>：与程序计数器一样，Java虚拟机栈（Java Virtual Machine Stacks）也是线程私有的，它的生命周期与线程相同。虚拟机栈描述的是Java方法执行的内存模型：每个方法被执行的时候都会同时创建一个栈帧（Stack Frame）用于存储局部变量表、操作栈、动态链接、方法出口等信息。每一个方法被调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中从入栈到出栈的过程。<br><strong>本地方法栈</strong>：本地方法栈（Native Method Stacks）,本地方法栈（Native Method Stacks）与虚拟机栈所发挥的作用是非常相似的，其区别不过是虚拟机栈为虚拟机执行Java方法（也就是字节码）服务，而本地方法栈则是为虚拟机使用到的Native方法服务。</p>\n</blockquote>\n<p> 4.ES2.X支持中文搜索吗，底层数据结构是什么？</p>\n<blockquote>\n<p>（没回答出来）es2.x支持中文搜索,底层数据结构是倒序索引，有兴趣的同学们可以去了解下，</p>\n</blockquote>\n<p> 5.HashMap原理，HashMap在多线程下的机制是什么？</p>\n<blockquote>\n<p> <a href=\"https://blog.csdn.net/qq_26118603/article/details/79849555\">HashMap原理</a>，多线程下的机制？有用到这个吗？多线程下不是不用HashMap吗，面试官让我回去百度。。。</p>\n</blockquote>\n<p> 6.mysql行锁表锁介绍（忘了）</p>\n<blockquote>\n<p>表锁：开销小，加锁快；不会出现死锁；锁定力度大，发生锁冲突概率高，并发度最低，使用场景：查询为主，少量索引<br>行锁：开销大，加锁慢；会出现死锁；锁定粒度小，发生锁冲突的概率低，并发度高，场景：有大量按索引条件并发更新少量不同数据，伴随并发查询</p>\n</blockquote>\n<p> 7.ConcurrentHashMap实现原理</p>\n<blockquote>\n<p>CAS无锁算法，分段锁机制</p>\n</blockquote>\n<p>8.CAS算法介绍以及全称</p>\n<blockquote>\n<p>CAS算法（Compare And Swap）：CAS操作（compare and swap）CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则返回V。因为线程不必再等待锁定，只要执行CAS操作就可以，会在预期中完成，所以叫无锁算法。（嘴贱扯了ABA）<br>ABA：如果另一个线程修改V值假设原来是A，先修改成B，再修改回成A。当前线程的CAS操作无法分辨当前V值是否发生过变化。解决办法：自动记录仪记录下线程操作。面试官：这是怎么记录的，我：奔溃。。。</p>\n</blockquote>\n<p>9.LinkList实现了哪些接口，底层数据结构是什么</p>\n<blockquote>\n<p>List、AbstractList、Iterable…..接口，底层使用双向环形链表数据结构，问：双向链表的实现方式，我：猝</p>\n</blockquote>\n<pre><code>面试总体感觉不好，每些都懂点儿，但是往深了问，死翘翘，所以去互联网公司面试，这些基础一定要打牢，架构这块可能面试官没这么注重，（要是注重起来那就是底层实现了）。主要就是基础这块：集合框架、锁、多线程\n</code></pre>', '2018-06-11 10:49:22', '', ',2,5', 'static/images/24.jpg');
INSERT INTO `blog` VALUES (323, '代收款', '都说对', NULL, '单身了咖啡店；麻烦来看待；德累斯顿； ', NULL, NULL, NULL, NULL, NULL);
COMMIT;


