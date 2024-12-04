package net.leibi.adventofcode2024.day3;

public class Input {

    public static final String SMALL = """
     xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
     """;

    public static final String SMALL2 = """
     xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
     """;

    public static final String BIG = """
@why(692,996)[&}}^where(81,407)mul(247,89):[&[{<mul(980,958),?mul(529,895)!<#~!$&~when()+mul(519,986)what())#mul(710,934)%??*'!<mul(813,338)! +$what()<don't(){^mul(396,693)mul(337,541)}what()*<](@?~mul(64,644)[where()who()~,))mul(528,450)!' -do()who()#]where():(mul(909,368)mul(259,743)''when()^?from()]select()#;mul(227,252)<mul(118,202)-&!(when(806,911)~]who(58,451)- mul(135,37);mul(75,773)?~when()where()]mul(93,321)where(),where()!when(769,449)where(616,323)@&mul(489,237)&;do()<mul(803,622)mul(616,264)!from()why()~@],@from()mul(499,593)#<?/&(when()':mul(237,54)&-],+mul(856,447)})select()mul(540,283)don't()'@how()@mul(701,900)?!['mul(958,898)mul(403,891)+*why()&-)mul(877,695)where()&}{<when()]:[(mul(70,638)<who()[mul(219,485)[why()+% +what()*who()>do())[when()![mul(681,521)when(130,722)@ ->)<,mul(658,134)what()who()}+}@/mul(458,625)when()}&mul(390,728)don't()?)(;mul(196,925);&*#&select()'$mul(57,17)~/#,?&/mul(470,374), do()%@mul(328,216) >what()]when()mul(788,804)mul(873,961)who()^&{>when()why()mul(246,793)~)why()& '>?mul(200,670)[what()~/how()why()#)mul(914,790)>mul(296,84)$>)  mul(176,130);from()from()mul(373,460)from()*>@/when()don't()'select()>when()</@#+mul(529,694){{what()why();#mul(827,797)when()why()><(<&'mul(549,679)from()]##(#mul(149,690)^:}[$!&<* mul(340,101)who()@who(829,301)@do()mul(663,477)who()~<~:+why()what()mul(675,2)select()from(264,335)'-mul(706,937)^who(),~mul(159,226)+&@;mul(432,401),^],^]]mul(481,229)who()^+?how()who()+mul(785,889)mul(353,752)# ]mul(194,854){>from()(<:(mul(796,423)#+$why()]mul(230,206)(mul(339,962){why():%'select()/^~mul(346,831)from()#{/where()]what()mul(489,415)how()!how();select()  mul(313,553)(from();?&@mul(276,256)'$mul(84,330)/{,;mul(540,534)(^]what(648,915){+-:}how()mul(979,837)who()@{mul(766,495)who()/'+/*<mul(587,194)/how()mul(516,226)',+from()?what()>don't()@why(){<!]who()&mul(365,928)from()what()what()@why(607,617) {mul(407+#what()+mul(516,503)@&>}who()do()[<'-who())+;mul(552,743)-}&<%%!mul(680,379)'?%(;))mul(713,945)mul(344,235)]<who()[~[('mul(688,707)]?&where()'@mul(508,935)how()]where()select()do()!%]:mul(498,637)'how()& (mul(32,268)~from()from()where()/-@[*who()do()$mul(475,443^% @why()!what()mul(357,992)['mul(926,286){mul(355,744)}mul(410,461);(!:mul(133,384)from()')what()$mul(538,201)mul(336,633)select()why()>^,&%!mul(462,965)where()select()^]when()*from()<#mul(801,899)?why()?,select(){mul(163,717)mul(309,666)!?mul(244,557)[(:mul(590,151):when()from()why()mul(734,459)#[from()@mul(599,980)when(){where()&,^who()>^select()mul(832,947)@-mul(986,539)mul(355,307)-#+mul(854,733)[/({how()*^mul(696,97))+++##what()mul(880,393);??how(958,390)when()(select()^:who()mul(184,872)why() [mul(180,329)what() don't()]~/from():[<>-(mul(330,122)]don't()^*}[from()mul(147,831)-where(486,652):#who()/mul(274,754)why()+;$]#,[mul(703,607)[<]&;&&@mul(277,256),mul(106,665)
>$~when()^;mul(914,586)why()$mul(383,297)when()when()select(85,106)select()!$;mul(566,651) mul(928,762)mul(302,399))( !)<mul(926,250))(mul(842,947)}from()mul(53,294)&mul(784,942)mul(614,108))[from()&,;mul(67,626)%-[mul(516,770)/<?}#$;({from()mul(77,888)how()what(){@/mul(392,76)how()^when()[<'where(){mul(357,569)$mul(866,257)^?what())*-who(87,183)<mul(371,728){'what()!+mul(359,893)!;who()^{)%where()/%mul(350,660)/from()select()%^+)@when()mul(331,754)} * )(mul(98,91)[/*from()?-do()^:,when())when()$~who()mul(457,779)mul(825,607)(from()from()<mul(888,364)#how(){(<})what()[mul(356,842);>-{[%;:$}mul(973,195)* #$from()who()/mul(383,305):]~}+'^what(92,64)mul(360,235who();mul(186,635)[}?,/why()#what()&select()mul(249,256)&/ mul(851,885)?:mul(797@,mul(87,662)what(309,502)$#}-mul(144,693),</from(621,475);who()+-;mul(489,471)select()where(){mul(101,882)mul(399,691) -:mul(203-how()from()when()(}'!from()>mul(148,850)*mul(781,765)select()do()?> @*mul(262^who()[&!mul(557,94)select()don't()'from()mul(850,693)mul(589,25)<select()(who()* @(]?mul(389,321)~mul(403,382)what()*,)who()when()mul(994,907)$mul(510,490)&where()mul(758+({mul(221,746)where()^!select()$mul(950,866)when(),$}how()do())<how(): ~^mul(978,411)[@how()how() mul(133,168)what()who()when()$@[(@{>mul ?;&why(),mul(285,937)mul(138,969)[/~[mul(580,479)~~^^-mul(880,273)])select()(%[select()why()mul(693,345)()why()!mul(113,820)(?%  mul(362,763);when()mul(321,344)~^){{#how()who() mul(850,506)?;][~@'<when()mul(594,30);>[mul(806,297)# ) @]when()mul(697,524)&[<--+mul(830,463)mul(172,696>how())?mul(52,131)select()how()<mul(939,710)  ~how())?mul(429,147)[-?&}what()}@+~mul(87,386)>^{:%[mul(472,843)<who(579,643)<~,**mul(749,472){from()^?who(46,513)}>who()mul(921,645)+^&how()how()(why()?*~mul(291,7)?+when()$+$&:{~mul(484,416)!+;-+mul(433,280)*!mul(442,92)where()why()where()'):how()}^don't()from(){where()how()>mul(163,420)^do()#select();'-&why(13,360)>mul(156,867)who()]how()?<mul(645,208)(mul*select()>how(129,950)+-!where()'mul(883,613)where(436,425)mul(878,282)from()from()]~?select()&{:!mul(329,320):-<?why()>@what()^mul(335,177)$#],^/select()&&from()mul(119,515)^+?~%who():!#mul(620,743):!who()/:@*$/{mul(708what(),-<{who()$what()':how(573,320)mul(85,259)why()who()#-mul(869,677)}]*{mul(6,929)- <mul(613,450),:?*/)#>mul(729,549)}]^,mul(6,598) who()^][mul(104,228);-!mul(28,630){>#what()%}{how()>#mul(827,504)-mul(613,193)who(140,26)[%?select()!]mul(707,956))#]@-:when()@<mul(391,848)?where(361,233)/%;>]who()mul(716,823)mul(619,201)when();:$>,^mul; what(535,875)[<!who(){how()how()mul(484,775)when()who()+~[',mul(611,484);/!who()*how()from()mul(475,311)/{how()^when(428,781)mul(783,439)mul(474,38)mul(188,9)]who()when(192,361)when()how()mul(297,838[{+who() }))select()-how()mul(363,38)+when()~how()[>mul(19,577)(select()* /*where()/?mul(922,251)why():!what()mul(555,531)!&(*{why()-*mul(997,855)mul(301,699)'[@when(32,211)@mul(544,929)/select()from()'select():mul@^[*#who()'~select()<mul(639,724):#;what()how()/when()mul(391,707)+ ^why()&when()$select()~%mul(822#$from()/;<#what(200,13)(@@mul(787,474)&+where()mul(161,733)
!~ why()where()mul(730,677)#}]<-:??mul(674,45)?[select()'/;{;>#mul:from(){@''how()}$+[mul(823,4)mul(21,959)*!where(214,815)({>^mul(630,855)<(select()&mul(92,744)where()+from()?#/where(108,36)-mul(636,727)from()@how()@when()/:%how()mul(722,483)*:where()[do()select()*[<;~+$mul(916,381 select()%when()$@mul(782,526)how()select()@&@!/mul(568,269)+~%<(}>how()&mul(568,865)?}(*^-!mul(781,583)* (:^mul(815,903)(:who()what()select():who()^how()(mul(468,302)where()%mul(940,777):<<[#+,mul(185,55)mul(470,850), '-' mul(361,647)mul(629,265)![;mul(259,739)mul(209,270)+where()~#mul(340,946)!how()?]don't()mul(137,227)don't()why() how()}}>~&mul(761,163)]<#@mul-+how()select()mul(228,162),from(164,406)$what()>don't())who()]when()how()-why()!mul(236,693)who()<;how()who(): !:'mul(153,600)]what()#from()mul(687,964)^+{ (mul(277,968)'&don't()>%what()(]&/}mul(951,592)}+<don't()-[when()who()&+when()&mul(945,705)&^{:mul(517,673)from()+[['from()mul(123,745))mul(735,471)#who()!-mul(218,491)how() ]what()<mul(775,865)[%who()$#+mul(836,889)where()&how()why()![mul(557,141)mul(565,994)&from(){}*%(:do()'}>mul(675,946),where()mul(316,184)]<'[<*why()*select(597,725)/mul(58,34)/when();:how());mul(60,439)<?from()>who()from()}mul(300,852)mul(278,762)?</}!%mul(461,331how()!%>:}@<why()<mul(961,437)+~)[mul(340,101)!;'from())why()^,!mul(485,861#[/mul(710,417)%' -$&where())what()*mul(91,947)}(don't()select()-<why()(who()[};mul(294,617)who()$;how(){mul(540,968)mul(653,727)who(608,146)!mul(525,266){where()%select()where())(:*mul(503,274),how(35,5)mul(26;:;{ [mul(940,877)%*[@'@({do()>?&]mul(46,664)mul(291,306))-{(>mul(332,272)~,how()-mul(800,174)@%how()-where(171,403)mul-( mul(758,259)>what()what()+what()who()why()+@mul(945)&when()]mul(197,968)(?]#!where(876,487)-mul(409,744) /what()](what()mul(228,485)(!select(){(mul(898,295)}why()^<how()(who(233,695)%mul(808,397)^who():mul(871,11)>)?mul(189,119)&mul(564,374))-,:[>mul(866,802)@(++why()/!mul(800,861)mul(657,743)who();* ?mul(785,52){/!when()select(550,561)&(/+*mul(407,66)who()^&mul(455,769)<mul(998,994)'mul(306,933)mul(603,638)why()&mul(262,761)where()?^}mul(631,682)how(483,667)why(490,860)}}~ 'when()>mul(608,695)select()how()#[what()select()^(:mul(559,247)*-mul(684,443)< :)*mul(390,946)how()/,mul(207,219)'''when()^mul(452,554)+<%,%mul(744,656)@~>from(),&!mul(851,699)when(),::%what()do()@/mul(304,149)}/why()$#-,*!what()mul(337,566)&who(109,924)where()*mul(223,512)'; }mul(98,573)do()[[{$/*<]mul<how()where()'mul(819,187),&'(}@how()$what()?mul(348,685)where();how(628,764):!!~mul(930,521)(what(829,497)':}:;;)mul(740,633)mul(679,522)*(<<-(mul(144,935)+*+!mul(216,40)]@(do()mul(912,141)why()from(964,599) where()mul(336,700)mul(865,243)%**how()' when()<[when()mul(349,355)]mul(749,166)%>(,*mul(953,484)]who()select() :}how()!%don't()where() !;mul(533,762)-$-+what(124,118)mul(326,999)where()&($what()(mul(796,908) )<~~ mul(127,960))~%/who()]do()&#-&#mul(367,46)>where():;# %[]&mul(547,568)#^[from(883,557)mul}#!/usr/bin/perl)#-mul(547,116)$^when()mul(370,569)
<->from()*>}?^don't()<>:,where()why()mul(449,470)?when()%+^-{/mul(184,484)from(214,259)'mul(959,719)select()how(606,892)-;mul(106,758)where()select(562,544)$#/%mul(675from()~%}mul(732,953):}<mul(869,791): *~mul(344,486)&%*mul(446+mul(409,699)how(652,866);((~who()(mul(507,268)[>,?-^mul(504,99))[:~!]what()mul(204,85)@^do()>$>{select()%how()select();%mul(551,71)%(,when():)from()when()select()mul(278,290)/ {who();where()$%-mul(843,684)how()'{from()select()mul(607,965) [[/]mul(876,854)#where()where()![}%mul(62,79)from()where()(]+select()]]mul(668,758)>select()what()[who()where()[&!mul(551,543)<from()what()%[[do()?how()});:''}mul(598,746)mul(462@(mul(565,27)who()when()mul(650,760)<{$<:@&select()mul(337,243)~&,(+mul(483,254)what()from()'mul+]::?what()@?$>#mul(924,697)*+<do()!!$,mul(70,420)what()mul(170,21),who()]mul(916,819where()'($#]%from(27,77)/[>mul(807,301)*where(381,893)}where()(+mul(846,431)from()why() %what()why(802,698)?mul(122,673)!:}mul(672,150)~?mul(567,146)?who()&@/*&mul(922,901)]when()>$~{>mul(271,971):)select()who(91,572)~$why(),mul(695,885)where()'#from()from()mul(252,860)>^:who()({])(mul(233,472)who()where(906,494)where()--mul(347,46)}mul&don't()%who()((}who()((]mul(52,854)where()why(363,933) ?+mul(203,35)<[$*from()},who()'mul(849,519)mul(841,351)]]mul(444,689):from()*!&)*'! mul(943,690)how()^}]why()((mul(935,524)mul(935,806)who()~mul(703,737))]?:/+%when()(do()mul(968,713)[who(561,712)(/mul(97,572)who();~+why()-mul(942,777)))&^[,where()mul%*)?from()mul(462,688)>how()[++(who()~%@mul(940,121)~- {who()-{why()mul(49,417)mul(353,70)what())?<-from()how()/where():don't()select()$(>/[what())::mul(515,851)what())~[don't()?+; mul(302,236~mul(38,849)[[{when(635,431)who()^who()?when()<mul(539,198)(,%#*:&why()*mul(646,12)^&%where()select()#-mul(234,72)>&%]:do()select()',<where()select(180,720)mul(117,684)?who()%mul(840,264)who():{+($mul(649,6)who()+mul(232,471^*mul(788,243)where();{'/select()(mul(900what(528,554)[(+&):mul(390,369)>where()<;-@mul(349,121),*[,<!/^;mul(877,679)?[,when()<^mul(81,108)-*@how()[mul(126,985)from()why();}$:,*mul(361,691)^when()[>! *~what()mul(604,91)how(301,723)what()how(67,829)mul(247,535)~~$<~where() #(mul(949,539)+{'&&({why(),mul(578,991)^!who();@select()how()who()@[mul(746,832)%mul(654,124)mul(637,556)-who(983,938)where()#[don't()mul(707,216)[~$(*select()]-<'mul(580,979))+?mul(439,653)&when()why())who()-#~-mul(748,900)%{^)mul(439,528){){$what()}]why()]mul(842,468where()+when()$mul(740,495)what(216,648)/who()@+what()%mul(206,411)mul(791,423)' what()what();!&})mul(758,695) {where()}mul(896,607)what()^;from()+mul(457,902)$from()#mul(683,733){>mul(209,811)what()#from()@mul(53,51![-*mul(107,114)}&%^mul(578,688)*)<mul(901,341) ,;/mul(16,607)$?[>/]mul(14,783)*#when()@>-mul(494,115)when()mul(655,203), #!-& don't(),}mul(154,778)/)>}*select()@why()-mul(442,92)(mul(596,263)how()#>from()-mul(159,308),mul(369,319)why()do():#^when()~$mul(627,260)##;from()@mul(146,672)~where()~mul(661,627)]&#/+mul(634,624))]}how()what()from()@]*&mul(836,150)%;?-#]&&&)mul(243,782){{~:> <where()mul(420,881) [how()don't()<& %?mul(67,722)#/what():mul(160,274)**from()[,- @)mul(603,336)?from()]'%mul(292,56)
$what(){;where(474,989)<{!mul(178,109)mul(799,888) >[%@when()mul(636,74);'who()mul(484,564)from()where()^+@<(&mul(559,305)*?[<),/&-mul(994,131)}%)mul(242,758)~ ;!select()?what()what()how()mul(165,179)/^>*how()/!?mul(178,438)' 'why()mul(726,788)mul(466,85)}mul(32,334)!+:@[&~]mul(796,940)mul(391,854)why()@~who(406,979))(^mul(652,996),mul$who(){mul(390,599)select()/}'-?,})from()mul(496,458){&select()where() ,$,mul(304,108)who()^what(52,141)<>why()/mul(916,266)+who()^'@:;mul(785,513);)<<!)*mul(854,23)mul(137,548)@-!^~mul(764,451)mul(391,768){<]from(388,963)$!/#*mul(617,146)}#what()@/}}when()do()*mul(609,18)@;who()^>!,mul(17,331)what()<]<<^}from()<$mulwhere()#@mul(276,743)how()&mul(89,923)>~where(769,105)!why();who()mul(188,537)when()(who()where():%?)mul(326,794)when()<,select()<~*{/^mul(106,934)%,&<mul(444<{^mul(690,660)#![who()+<why()}+mul(472,89)^+from() +{mul(902,82){mul(148,406)/[when()from()don't()&?@#why()?mul(609,571)^{;select()from()how()*#'*mul(215,633)who()who()#'select()+^why()what()mul(336,910)mul(472,299)from()mul(16,149)/[*mul(902,563)what()%)^^select()mul(514,108)!mul(955,588){how()@!)from()]}what()when()mul(104,512)!select()mul(188,411)who()/${when(15,634)do()<&mul(889,797)~-when()},mul(93,599),select(890,669)why()mul(344,755)*%from())mul(585,747)%mul(398,764)#from()from())/(%^?}mul(581,877)where()*/%mul(170,622 *%<select()mul(538,578)~:+!?([mul(20,539) (select()++don't()'-why()'mul(295,426)where(),$/':[mul(758,121),~mul(238,732)!why(427,957)']~select()(mul(308,145)/:&*don't()what(379,178)mul(188,515)$+@don't(),@where(526,553)!mul(297,406)$!where()mul(402,859)how(){<!]<~mul(488,557)mul(570,433)>>mul(435,196)where()@?^-%>select()mul(4?%/:>mul(579,464)+#when()}}$'!mul(997,496)*mul(307,914){why():how()[what()<?,don't()mul(170,862)when()~$;#why()+how()mul(377,975)-$~%-what()*}$mul(994,691)<-!'~*mul(160,609)>''>,why()when()$[{mul(145,574)?>mul(789,315)!,)+mul(266,109)select()!mul(885,712))^^&mul(610,195)!*who()mul(892,578)+*where() ]+what()select()^/mul(560,601)@'?(<mul(214,365)&how()who()@/where()'mul(840,310)why()^>)!::!<mul(475,358)?[#mul(197,145)$<what()where()>why()mul(630,917)*[mul(583,335)#?where())!{+,;what()do():~[&(,[!mul(5,120)from()mul(98,868)? {!mul(555,65)?~^when()where()mul(451,352)%<]from(746,31)mul(141,885)-mul(122,934)#who(636,694){>;@%{from()'mul(690,533)<//]when(),(~@from()mul(472,128)#*[mul(143,30)mul(121,540){what(): do()?mul(704,732)($(select()select()~what()mul(88,529)~;)'><^mul(676,840)}~<-what(421,598)*mul(550,833):){$ %mul(921,637)~(@$@how(193,897),:[mul(711,995)select()mul(107,767){&~mul(351,157)?!mul(188,958)}:mul(781,512)what(961,371)^@mul(148,962)where(270,721)!when(),when()>@what()mul(640,811){++-]/]-/mul(7,244){why()~/select():%:mul(842,953)who()$}who()^)mul(265'how()when()mul(39,60)]%mul(399,85)'/[don't() select())^mul(314,937) ][what()where(){~select()^when()mul(884,888)
mul(935,879)%;]!]who()mul(511,968)&mul(529,394)when()mul(779,690)&$~@:from()mul(900,553)@don't()$>-@how()where()(#select()mul(714,939)where(200,556)>/ why()what()>-[!mul(581,4)$why()why();mul(769,428)'who()mul(561,314) {#/<^from()mul(50,184)}#*[how()how(){@'!mul(827,821)::-)}mul(779,557)from()why()where(682,979)%:%>mul(806,900)~&how();$why()mul(554,252)[/#^(from()~[&why()mul(70,686)mul]what()don't()-!mul(698,743)}+# ? *from()%~mul(318,624)^/mul(921,343)/^/select()mul(329,594)<')^(#mul(424,720)-'why()*why()&where()mul(665,924){!-~$don't()}:%(?&from(),#mul(105,692)~/~''how(771,222):>mul(296,616)+%'[??(^mul(790,296) >when()what()mul(271,491),when()-~%*do()what()%)!-'mul(914,243);from()&from()where(349,831)&@mul(360,913)mul(396,166)select()?'when(236,698),%-(select()mul(409,263)>]from()(/mul{where()>!), mul(954,312)>who()where()do(){select() why()mul(317,979)why()^do()mul(132,710)%#}mul )+' $mul(989,387)+:~%>(mul(209,606)what()<)*#:mul(37,222);)!why(756,194)'mul(604,71)?+ +what()$]@don't();+mul(613,127)who()}[how(195,543)select(){-)('mul(879,421]select()mul(380,232);?[%;^>>mul(46,941)#,'where(),mul(149,205)where()^from()&)[who()mul(337,461)why()],how()%don't()]@'from(463,678){mul(59,532)when()mul(517,186)how();when()*do()]'/(,mul(195,769){how()##;!%*)don't()#+mul(449,953)%#who()]+@$;mul(25,123)$^what();don't()<who()where(353,919)(mul(507,127),!why()-)select()mul(877,96)^mul(336,330)*?mul(586,329) {/mul(777,773)/ ?/#when()&mul(623,804)^+,+-mul(551,935),[mul(896,32)} when()(~mul(781,541)](){from()'){mul(265,990):$%+why()) '[(mul(793,705)}why()' %<$(-+mul(779,734)what()who(185,147)when()?where()@mul(615,204) #from(976,635)?mul(430,577)/~>why()why()why()what()mul(631,446);^[[{~! )mul(379,911):why()-why()who()mul(45,209)when()%who()~-[mul(752,243)$who()!}] !mul(624,570)[why()mul(587,283)#>[select()what()mul(581,554)who()from()mul(39,13) <mul(360,384)@-){*<mul(381,140)>*$}-mul(720,140)- /;{-why()mul(989,958)where()^@select(243,837):}mul(87,422)!%when()who()>]mul(285,451)*how()mul(427,132)how(){&;from()]<&mul(670,229)+how(809,912),{who()mul(512,888))^)}*)/mul(83,730)mul(525,735)what()#}who()mul(867,63){^&,})- mul(544,377)%{$mul(870,448)from()select()%&:>^:!how()mul(119,830):*:?+'<['mul(106,75) }when()don't()<> why()mul(447,647):+[^- <mul(918,729):;~:why()[?mul(812,791)what()~>(select()}mul(684,895)why()what()&:mul(656,707)mul(173,797)}select()@]&when():mul(443,217)where()):why()who(),what()!%mul(765,579),%how()select(318,144),<'mul(377,695)from()]&mul(308,501)what()(mul(687,75)&mul(182,18)*how()/:;mul(518,469)where(215,786)]$$+!mul(959,580); from()how()how()%%mul(494,77)what()@]^>@*mul(718,497)where(){where(866,131)who()mul(415,333)})?{mul(467,647)who()who():~{how(945,509)mul(82,421)mul(438,580)!:-[+}when()!mul(583,479)@@why()-why()where()<do()#what()]why()how()mul(297,179)#how()[&}:#select(),mul(111,570)~']why(641,197)what()^mul(923,44)$where():who()^ why()?,
""";
}
