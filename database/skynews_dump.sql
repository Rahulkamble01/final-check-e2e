CREATE DATABASE  IF NOT EXISTS `skynews` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `skynews`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: skynews
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `user_favourite_article`
--

DROP TABLE IF EXISTS `user_favourite_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_favourite_article` (
  `fa_id` int(11) NOT NULL AUTO_INCREMENT,
  `fa_ar_id` int(11) DEFAULT NULL,
  `fa_us_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fa_id`),
  KEY `fa_ar_fk` (`fa_ar_id`),
  KEY `fa_us_fk` (`fa_us_id`),
  CONSTRAINT `fa_ar_fk` FOREIGN KEY (`fa_ar_id`) REFERENCES `article` (`ar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_fk` FOREIGN KEY (`fa_us_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_favourite_article`
--

LOCK TABLES `user_favourite_article` WRITE;
/*!40000 ALTER TABLE `user_favourite_article` DISABLE KEYS */;
INSERT INTO `user_favourite_article` VALUES (458,49,11),(459,50,11),(460,46,11),(461,47,11),(462,51,11),(463,51,11),(464,55,11),(465,55,11),(466,55,11),(467,55,11),(481,52,5),(482,53,5),(483,55,5),(484,55,5),(485,55,5),(486,55,5),(487,56,5),(488,56,5),(489,56,5),(490,56,5),(491,56,5),(492,56,5),(493,58,5),(494,56,5),(495,59,9),(499,60,12),(500,61,12),(501,62,12);
/*!40000 ALTER TABLE `user_favourite_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ar_id` int(11) NOT NULL AUTO_INCREMENT,
  `ar_author` varchar(45) DEFAULT NULL,
  `ar_title` varchar(450) NOT NULL,
  `ar_description` varchar(450) NOT NULL,
  `ar_url` varchar(500) NOT NULL,
  `ar_urltoimage` varchar(500) NOT NULL,
  `ar_publishedat` varchar(45) DEFAULT NULL,
  `ar_content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ar_id`),
  UNIQUE KEY `ar_title_UNIQUE` (`ar_title`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (31,'Uri Bollag','Netanyahu, Kochavi make surprise visit to IDF base in central Israel','The visit to the emergency storage unit came after IDF Ombudsman Maj.-Gen. (res.) Yitzhak Brick harshly criticized the decision-making processes of the IDF.','https://www.jpost.com/Breaking-News/Netanyahu-Kochavi-make-surprise-visit-to-IDF-base-in-central-Israel-579199','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435042','2019-01-30T17:16:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2471 chars]'),(32,'Lahav Harkov','Netanyahu brings Trump into Likud election campaign','This is not the first time Donald Trump was brought in to support Prime Minister Benjamin Netanyahu.','https://www.jpost.com/Israel-Elections/Netanyahu-brings-Trump-into-Likud-election-campaign-579297','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/429791','2019-01-31T10:20:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2293 chars]'),(33,'Jon Fingas','China cracks down on Twitter users critical of its government','It won\'t surprise you to hear that China keeps a tight lid on homegrown social networks, but it\'s now doing more to stifle free expression on outside networks, too. The New York Times reported that Chinese law enforcement recently began a crackdown on residen…','https://www.engadget.com/2019/01/11/china-cracks-down-on-twitter-users/','https://o.aolcdn.com/images/dims?thumbnail=1200%2C630&quality=80&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fcrop%3D7024%252C4684%252C0%252C167%26quality%3D85%26format%3Djpg%26resize%3D1600%252C1067%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-images%252F2019-01%252Fd808b9c0-15c2-11e9-9edd-d035fc924704%26client%3Da1acac3e1b3290917d92%26signature%3D51f0490027cde1e5b3a0c4dc3bae3faffdd6c0f5&client=amp-blogside-v2&signature=40efc3b6b95cb63ba02834ee47b0b885b1bf4e04','2019-01-11T18:10:00Z','And when officials demand that tweets disappear, they don\'t necessarily take \"no\" for an answer. When human rights campaigner Wang Aizhong refused to delete his tweets, someone hijacked his account and deleted 3,000 of his messages. While there\'s no confirmat… [+537 chars]'),(34,'Amy Spiro','Hitler bell in German village church can stay, court rules','Appeals court rules that swastika church bell can remain with an explanatory plaque','https://www.jpost.com/International/Hitler-bell-in-German-village-church-can-stay-court-rules-579319','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435089','2019-01-31T12:17:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2455 chars]'),(35,'Yonah Jeremy Bob','Five IDF soldiers indicted for hitting Palestinians detainees','The soldiers were arrested on suspicion of beating the two detainees while they were handcuffed and blindfolded, leaving them severely injured as a result of the beating.','https://www.jpost.com/Breaking-News/Indictments-filed-against-five-soldiers-for-hitting-detained-Palestinians-579310','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/432992','2019-01-31T11:36:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+3043 chars]'),(36,'Tovah Lazaroff','Florida recognizes Jerusalem as Israel’s undivided capital','Florida placed itself on step ahead of the Trump Administration, which recognizes Jerusalem as Israel\'s capital but has not spoken of whether it supports a united or divided Jerusalem.','https://www.jpost.com/International/Florida-recognizes-Jerusalem-as-Israels-undivided-capital-579312','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/432316','2019-01-31T11:15:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+4404 chars]'),(37,'Gadgets Now Bureau','Samsung Galaxy Note 9, Google Pixel 3XL, Microsoft Surface Go and more win The Times of India Gadgets Now Awards 2019 | Gadgets Now','The inaugural edition of The Times of India Gadgets Now were held in Gurugram on January 30 to celebrate and honour the best of gadgets launched in 2018. The award ceremony saw some of the biggest names from the tech industry in attendance. Here is the comple…','https://www.gadgetsnow.com/slideshows/samsung-galaxy-note-9-google-pixel-3xl-microsoft-surface-go-and-more-win-the-times-of-india-gadgets-now-awards-2019/photolist/67771967.cms?utm_source=toiweb&amp;utm_medium=referral&amp;utm_campaign=toiweb_hptopnews','https://static.toiimg.com/photo/67771967.cms','2019-01-31T10:23:46.3355312Z','Times Internet Limited CEO Gautam Sinha and fitness Guru Vesna Jacob presenting ‘Smartphone of the Year (Jury\'s Choice)’ trophy to Samsung Galaxy Note 9, which was received by Ranjivjit Singh, Senior Vice President &amp; Head, Mobile Marketing, Samsung India,… [+188 chars]'),(38,'Tamar Beeri','Gallant: Gantz\'s speech did not reflect his stances','Yoav Gallant explained that \"the Likud is the only response to Benny Gantz and to what the left represents.\"','https://www.jpost.com/Israel-Elections/Gallant-Gantzs-speech-did-not-reflect-his-stances-579304','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435086','2019-01-31T10:53:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2019 chars]'),(39,NULL,'Four things to watch: Deutsche Bank’s year-end earnings','Sewing’s turnround story dogged by questions over low profitability and low share price','https://www.ft.com/content/310d1544-249f-11e9-8ce6-5db4543da632','https://www.ft.com/__origami/service/image/v2/images/raw/http%3A%2F%2Fprod-upp-image-read.ft.com%2F21b8def2-24e5-11e9-8ce6-5db4543da632?source=next-opengraph&fit=scale-down&width=900','2019-01-31T10:38:10.1742546Z','Christian Sewing has been in his job for 10 months and by some measures Deutsche Bank’s apprentice-turned-chief executive has done a decent job.\r\nWhen he presents his first annual results on Friday, Mr Sewing is expected to boast that he has delivered on his … [+6103 chars]'),(40,'The Economist','The battle for Venezuela’s future','The world’s democracies are right to seek change in Latin America’s worst-governed country','http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future','https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg','2019-02-02T00:00:00Z','IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]'),(41,'Jon Russell','Matrix India announces new $300M fund','Matrix India, one of India’s highest-profile tech VCs, is loading up for new deals after it announced a new $300 million fund for early stage investments. This is the third fund for the Indian firm, which is associated with U.S-based Matrix Partners. Matrix I…','http://techcrunch.com/2019/01/08/matrix-india-300-million/','https://techcrunch.com/wp-content/uploads/2019/01/india-flag2.jpg?w=750','2019-01-09T03:04:01Z','Matrix India, one of India’s highest-profile tech VCs, is loading up for new deals after it announced a new $300 million fund for early stage investments.\r\nThis is the third fund for the Indian firm, which is associated with U.S-based Matrix Partners. Matrix … [+4058 chars]'),(42,'Jon Russell','Emeritus, which develops online courses with universities, raises $40M','The funding streak for educational startups in Asia continues into 2019 after Emeritus, a U.S-Indian company that partners with universities to offer digital courses, landed a $40 million Series C round led by Sequoia India. The deal includes participation fr…','http://techcrunch.com/2019/01/10/emeritus-raises-40m/','https://techcrunch.com/wp-content/uploads/2019/01/university.jpg?w=749','2019-01-10T11:02:14Z','The funding streak for educational startups in Asia continues into 2019 after Emeritus, a U.S-Indian company that partners with universities to offer digital courses, landed a $40 million Series C round led by Sequoia India.\r\nThe deal includes participation f… [+2900 chars]'),(43,'Jennie Dusheck','How to Make Your Home as Energy Efficient as Possible','If the latest report from the Intergovernmental Panel on Climate Change was a jolting wake-up call, you may be wondering what else you can do to slow climate change. You’ve voted for people you knew would care about climate change, divested from companies tha…','https://lifehacker.com/how-to-make-your-home-as-energy-efficient-as-possible-1831263910','https://i.kinja-img.com/gawker-media/image/upload/s--IflTpZhu--/c_fill,fl_progressive,g_center,h_900,q_80,w_1600/pxdeykeclcwrtxjvghna.jpg','2019-01-07T15:00:00Z','If the latest report from the Intergovernmental Panel on Climate Change was a jolting wake-up call, you may be wondering what else you can do to slow climate change. Youve voted for people you knew would care about climate change, divested from companies that… [+8471 chars]'),(44,'Jordan Crook','American Airlines taps Apple Music for in-flight entertainment','American Airlines and Apple Music have closed a deal that would give passengers access to the full library of Apple Music songs on AA flights. Apple Music’s more than 50 million songs will be available on any domestic American Airlines flight equipped with Vi…','http://techcrunch.com/2019/01/30/american-airlines-taps-apple-music-for-in-flight-entertainment/','https://techcrunch.com/wp-content/uploads/2019/01/Apple-Music-takes-flight-on-American-Airlines-Playlist-animation-1-01302019.jpg?w=675','2019-01-30T14:18:38Z','American Airlines and Apple Music have closed a deal that would give passengers access to the full library of Apple Music songs on AA flights.\r\nApple Music’s more than 50 million songs will be available on any domestic American Airlines flight equipped with V… [+1989 chars]'),(45,'','Up Helly Aa festival - in pictures','Shetland celebrates its Viking heritage in a powerful visual display Continue reading...','https://www.theguardian.com/uk-news/gallery/2019/jan/30/up-helly-aa-festival-in-pictures','https://i.guim.co.uk/img/media/26af70e51e2a409901e74b9e9dd1c6ffda98901f/736_953_3481_2088/master/3481.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&s=701b68e9d7cdcb18cfc41b4d0e3e0e15','2019-01-30T09:00:29Z','Shetland celebrates its Viking heritage in a powerful visual display'),(46,'The Economist','How Brussels should respond to Britain’s confused demands','Brexit is a problem that only Britain can fix—but the EU must give it the time to do so','http://www.economist.com/leaders/2019/02/02/how-brussels-should-respond-to-britains-confused-demands','https://cdn.static-economist.com/sites/default/files/images/2019/01/articles/main/20190202_ldp501.jpg','2019-02-02T00:00:00Z','THERESA MAY has become so used to losing votes in the House of Commons that when, on January 29th, the prime minister got MPs to back her on a motion regarding her Brexit deal, it was treated as a breakthrough. She did it! announced one front page the next mo… [+4365 chars]'),(47,'The Economist','Italy’s slump reflects trouble both at home and abroad','The weak economy complicates a fraught fiscal position','http://www.economist.com/finance-and-economics/2019/02/02/italys-slump-reflects-trouble-both-at-home-and-abroad','https://cdn.static-economist.com/sites/default/files/images/2019/01/articles/main/20190202_fnp505.jpg','2019-02-02T00:00:00Z','ITALY BOASTS no glittering economic record. GDP growth has trailed the euro-area average every year since 1999. Despite a decent showing in 2016-17, the economy has yet to regain fully the output lost during the global crisis a decade ago and a domestic banki… [+4308 chars]'),(48,'Amy Spiro','Netta releases her first post-Eurovision song','\'Bassa Sababav,\' Netta  Barzilai\'s new video features her as a pink rhinoceros who \'grew a thicker skin.\'','https://www.jpost.com/Israel-News/Culture/Netta-releases-her-first-post-Eurovision-song-579393','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435133','2019-02-01T10:31:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2796 chars]'),(49,'Tovah Lazaroff','Mladenov arrives in Gaza to meet with Hamas ahead of weekly protests','Gaza’s health ministry says more than 220 Palestinians have been killed by Israeli forces in 10 months of protests. Israeli casualties have been minimal and there was one soldier’s death.','https://www.jpost.com/Middle-East/Mladenov-arrives-in-Gaza-to-meet-with-Hamas-ahead-of-weekly-protests-579396','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/434822','2019-02-01T12:04:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2373 chars]'),(50,'JENNI RUSSELL','Britain Is a Nation in Desperate Need of a Driver','Customers at the Red Lion pub near Parliament watching Prime Minister Theresa May speaking on Tuesday her Brexit agreement was voted down.','https://www.nytimes.com/2019/01/15/opinion/brexit-vote-corbyn-may.html','https://static01.nyt.com/images/2019/01/15/opinion/15RUSSELL02/merlin_149229060_fcaed141-5596-4dfe-8efc-9083da2b8801-facebookJumbo.jpg','2019-01-15T21:20:10Z','With the ruling Conservatives so divided, Mr. Corbyns Labour is in a potentially powerful position. If it threw its votes behind the Tories backing Mrs. Mays agreement, or supported a second referendum, or decided to back a softer Brexit that retained much cl… [+2507 chars]'),(51,'Salvador Hernandez','One Of The Biggest At-Home DNA Testing Companies Is Working With The FBI','The move is sure to raise privacy concerns as law enforcement gains the ability to match DNA from crime scenes to a vast library of possible relatives.','https://www.buzzfeednews.com/article/salvadorhernandez/family-tree-dna-fbi-investigative-genealogy-privacy','https://img.buzzfeed.com/buzzfeed-static/static/2019-02/1/3/campaign_images/buzzfeed-prod-web-05/one-of-the-biggest-at-home-dna-testing-companies--2-20133-1549008717-0_dblbig.jpg','2019-02-01T13:07:51.8353092Z','Family Tree DNA, one of the largest private genetic testing companies whose home-testing kits enable people to trace their ancestry and locate relatives, is working with the FBI and allowing agents to search its vast genealogy database in an effort to solve v… [+9928 chars]'),(52,'Ilanit Chernick','AOC slammed for call with Corbyn','Corbyn tweeted on Sunday that it was \"great\" to speak with AOC \"on the phone this evening and hear first hand how she’s challenging the status quo.','https://www.jpost.com/Diaspora/AOC-slammed-for-call-with-Corbyn-579610','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/432774','2019-02-04T08:58:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+7602 chars]'),(53,NULL,'Julian Edelman is Super Bowl MVP','','https://www.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503','2019-02-04T07:22:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+3111 chars]'),(55,NULL,'Test Article 1','','httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607','httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503','2019-02-04T07:22:00Z','Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publications,like ours, are being forced to look for new ways to keep'),(56,NULL,'Test Article 2','','httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607','httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503','2019-02-04T07:22:00Z','Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publications,like ours, are being forced to look for new ways to keep'),(57,'Kara Weisenstein, Alex Zaragoza','Please Let Snoop Dogg Adopt This Dog Named Snoop','It’s kismet.','https://www.vice.com/en_us/article/3k99q8/please-let-snoop-dogg-adopt-this-dog-named-snoop','https://video-images.vice.com/articles/5c2e4ceda3f04e00075e424c/lede/1546540842031-SNOOP-DOGGY-DOG.jpeg?crop=1xw:1xh;center,center&resize=1200:*','2019-01-03T18:52:57Z','On December 17, a soulless human dumped a sweet white Staffordshire bull terrier named Snoop on the side of the road in Stoke-on-Trent, England. Footage of this heinous affront to good dogs everywhere was captured on CCTV, released by the RSPCA around Christm… [+2575 chars]'),(58,NULL,'Test Articsle 2','','httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607','httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503','2019-02-04T07:22:00Z','Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publications,like ours, are being forced to look for new ways to keep'),(59,'Yonah Jeremy Bob','More than half of Israelis say Benjamin Netanyahu should resign','Despite Attorney-General Avichai Mandelblit\'s expected decision whether or not to indict Prime Minister Benjamin Netanyahu, a poll found 90% of Likud members supporting the leader staying on.','https://www.jpost.com/Israel-News/Over-half-of-Israelis-say-Netanyahu-should-resign-if-A-G-moves-to-indict-579628','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/434593','2019-02-04T12:09:00Z','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+2304 chars]'),(60,'Tóth Balázs','Most a Fortnite a legkeményebb ellenfele a Netflixnek','Most a Fortnite a legkeményebb ellenfele a Netflixnek - Ha a kijelz? el?tt töltött id? számít, a videojátékok verik a filmszolgáltatást.','https://index.hu/tech/godmode/2019/01/18/most_a_fortnite_a_legkemenyebb_ellenfele_a_netflixnek/','https://index.hu/assets/images/facebook_logo.png?v2','2019-01-18T12:34:00Z','Tavaly 16 milliárd dollár volt a Netflix bevétele, és bár rengetegen igyekeznek beszállni az online filmiparba, nem ezek a riválisok jelentik a legnagyobb veszélyt. A Netflix úgy látja, hogy mindenki a versenytársa, aki kijelzn nézhet tartalmat kínál, és ebbe… [+1473 chars]'),(61,'-bd-','Vége a papírozásnak, itt a kárbejelent? app','Vége a papírozásnak, itt a kárbejelent? app - Mostantól egyszer?en, mobilról intézhet? a baleseti kárbejelentés.','https://index.hu/tech/helpdeszka/2019/01/08/vege_a_papirozasnak_itt_a_karbejelento_app/','https://kep.cdn.index.hu/1/0/2479/24796/247964/24796449_1815061_160675f11840d31d33964643e9772314_wm.jpg','2019-01-08T14:20:00Z','Elkészült az E-kárbejelent nev mobilapp, így ezentúl a hagyományos kék-sárga kárbejelent töltögetése helyett már egyszeren egy mobillal is megoldható a baleset kárügyintézés  jelentette be a Magyar Biztosítók Szövetsége (MABISZ).\r\nEz már csak azért is egyszer… [+1088 chars]'),(62,NULL,'???????????????????????????? ???????????????????','?^??????B','http://nlab.itmedia.co.jp/nl/articles/1902/02/news021.html','http://image.itmedia.co.jp/nl/articles/1902/02/cover_news021.jpg','2019-02-02T03:09:00Z','@oDV_e^A21^xATCguoDV_?vRg\\B\r\n@Au{AoDV_\\se^BAWmFAAQyWF[l\\vRg\\B?AuAvB\r\n@AVe^2018N7Ah^}bT[WX\\s^BAVe^o2019NJ\\fuvzSLmtBYJTwitter\\A10\\BStWguvx~\\B\r\n@ANHKLT[rXuNHKIf}hvAuy~zmvVe^outFCNj[Xvu^cvv10gVK~B\r\n@hoDioAeoAe[oDcVAVe^vbZ[WcC[gBuAWvuA AA vAA AvuA iA A AAvRgAuAAAv… [+53 chars]');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL AUTO_INCREMENT,
  `ro_description` varchar(45) NOT NULL,
  PRIMARY KEY (`ro_id`),
  UNIQUE KEY `ro_description_UNIQUE` (`ro_description`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'admin'),(1,'news analyst');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(80) NOT NULL,
  `us_email` varchar(80) NOT NULL,
  `us_password` varchar(40) NOT NULL,
  `us_status` varchar(15) NOT NULL,
  `us_ro_id` int(11) DEFAULT NULL,
  `us_la_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE KEY `us_email_UNIQUE` (`us_email`),
  KEY `us_ro_fk` (`us_ro_id`),
  KEY `us_la_fk` (`us_la_id`),
  CONSTRAINT `us_la_fk` FOREIGN KEY (`us_la_id`) REFERENCES `language` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `us_ro_fk` FOREIGN KEY (`us_ro_id`) REFERENCES `role` (`ro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kiran Ravariya','abc@gmail.com','123456789','active',1,1),(3,'Kiran Ravariya','asd@gmail.com','1234567','active',1,1),(4,'Kiran Ravariya','ravariakiran@gmail.com','A123456','active',1,1),(5,'Kiran Ravariya','kiran@gmail.com','A123456','active',1,1),(8,'Kiran ','abc','abc','active',1,3),(9,'admin','admin','admin','active',2,1),(10,'Kiran Ravariya','admin@admin.com','adminadmin','active',1,1),(11,'Kiran Ravariya','abcd@gmail.com','123456','active',1,1),(12,'Kiran','kiran12@gmail.com','1234567','active',1,6),(13,'Kiran Ravariya','kiraln@gmail.com','A123456','active',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `la_id` int(11) NOT NULL AUTO_INCREMENT,
  `la_language` varchar(50) DEFAULT NULL,
  `la_code` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`la_id`),
  UNIQUE KEY `la_language_UNIQUE` (`la_language`),
  UNIQUE KEY `la_code_UNIQUE` (`la_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'English','en'),(2,'German','de'),(3,'Arabic','ar'),(6,'Hungarian','hu'),(7,'Zhuang, Chuang','za');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 14:15:45
