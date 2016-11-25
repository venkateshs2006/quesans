drop database quesans;
create database quesans;
USE quesans;

CREATE TABLE `quesans` (
  `id` bigint(20) NOT NULL,
  `question` varchar(250) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;


insert into `quesans` values(1,'Who is founder of facebook?',' Mark Zuckerberg with his college roommates and fellow Harvard University students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz and Chris Hughes');
insert into `quesans` values(2,'Who is founder of google','Google was founded by Larry Page and Sergey Brin while they were Ph.D. students at Stanford University');
insert into `quesans` values(3,'What is Linux OS?','The Linux open source operating system, or Linux OS, is a freely distributable, cross-platform operating system based on Unix that can be installed on PCs, laptops, netbooks, mobile and tablet devices, video game consoles, servers, supercomputers and more.');
insert into `quesans` values (4,'Who is father of internet','Timber lee');
insert into `quesans` values (5,'What is internet','The Internet is a global system of interconnected computer networks that use the standard Internet protocol suite (TCP/IP) to link several billion devices worldwide.');
insert into `quesans` values (6,'What are the services of internet','World Wide Web,Communication,Data transfer');
insert into `quesans` values (7,'What is adds on','a piece of software which enhances another software application and usually cannot be run independently');
insert into `quesans` values (8,'When network was invented ','The Advanced Research Projects Agency Network (ARPANET) was one of the world''s first operational packet switching networks, the first network to implement TCP/IP, and one of the progenitors of what was to become the global Internet');
insert into `quesans` values (9,'Who is founder of facebook',' Mark Zuckerberg with his college roommates and fellow Harvard University students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz and Chris Hughes');
insert into `quesans` values (10,'What is facebook','Facebook (formerly [thefacebook]) is an online social networking service headquartered in Menlo Park, California.');
insert into `quesans` values (11,'Who is founder of google','Google was founded by Larry Page and Sergey Brin while they were Ph.D. students at Stanford University');
insert into `quesans` values (12,'What is google','Google /gu?g(?)l/ is a U.S. headquartered, multinational corporation specializing in Internet-related services and products. These include online advertising technologies, search, cloud computing, and software');

select * from quesans;

create table quesans.SearchEngine (
`id` bigint(20) NOT NULL,
`searchEngineName` varchar(50) DEFAULT NULL,
`searchEngineURL` varchar(150) DEFAULT NULL,
`resultTag` varchar(50) DEFAULT NULL,
`resultAttribute` varchar(50) DEFAULT NULL,
`resultTagID` varchar(50) DEFAULT NULL,
`TagPosition` bigint(5) DEFAULT NULL,
`regexDetails` varchar(50) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;


insert into searchengine values(1,"google","http://www.google.co.in/search?q=","div","class","_Oke",0,'');
insert into searchengine values(2,"wikipedia","http://en.wikipedia.org/wiki/","div","class","mw-body-content",0,'');
insert into searchengine values(3,"bing","http://www.bing.com/search?q=","div","class","b_entityTP",0,'');
insert into searchengine values(4,"yahoo","http://search.yahoo.com/search?p=","div","class","right",0,'');
insert into searchengine values(5,"duckduckgo","http://duckduckgo.com/?q=","div","class","js-about-module-title module__title",0,'');

select * from searchengine;