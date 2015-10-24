package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 九龙 on 2015/10/15.
 */
public class FesivalLab {
    public static FesivalLab mInstance;
    private List<Festival> mFestivals=new ArrayList<Festival>();
    private List<Msg> mMgs=new ArrayList<Msg>();
    private FesivalLab(){
        mFestivals.add(new Festival(1,"春节"));
        mFestivals.add(new Festival(2,"中秋节"));
        mFestivals.add(new Festival(3,"元旦"));
        mFestivals.add(new Festival(4,"国庆节"));
        mFestivals.add(new Festival(5,"端午节"));
        mFestivals.add(new Festival(6,"七夕节"));
        mFestivals.add(new Festival(7,"圣诞节"));
        mFestivals.add(new Festival(8,"儿童节"));

        mMgs.add(new Msg(1,1,"新年伊始，短信传情特恭祝：大财小财意外财，财源滚滚来；官运财运桃花运" +
                "，运运总亨通；亲人爱人和友人，人人都平安。春节快乐，万事如意！"));
        mMgs.add(new Msg(2,1,"过年了，心情更好了，情人更靓了，官运更通了，财路更广了，身体更健了，朋友更多了，事儿更顺了。"));
        mMgs.add(new Msg(3,1,"今年过年不送礼，发条短信祝福你，健康快乐长伴你，幸福美满粘着你，还有我要告诉你，" +
                "财神已经盯上你！提前祝你新年快乐！富贵双全！"));
        mMgs.add(new Msg(4,1,"新年到了，衷心祝福你。祝你年年圆满如意，月月事事顺心，日日喜悦无忧，时时高兴欢喜，刻刻充满朝气！"));
        mMgs.add(new Msg(5,1,"愿你抱着平安，拥着健康，揣着幸福，携着快乐，搂着温馨，带着甜蜜，牵着财运，拽着吉祥，跨过除夕，迈入新年！新年快乐。"));
        mMgs.add(new Msg(6,1,"朋友新年短信：新春佳节不送礼，发条短信祝福你，健康快乐常伴你，好运和你不分离，财神已经跟随你，财源滚滚进袋里，好处全都送给你！"));
        mMgs.add(new Msg(7,1,"I give you endless brand-new good wishes. Please accept them as a new remembrance of our lasting friendship." +
                "给你我无尽的新的祝福，让它们成为我们永恒友谊的新的纪念。"));
        mMgs.add(new Msg(8,1,"在新年到来之际，祝你一年里365天天天开心，8760小时时时快乐，5256000分分分精彩，31536000秒秒秒幸福。"));
        mMgs.add(new Msg(9,1,"新年驾到，欢喜进门，小假来到，心情甚好；朋友祝福，添个作料，假期舒心，玩得称心；新年开始，工作顺心，薪水合心，被窝暖心。祝新年无比开心！"));

        mMgs.add(new Msg(1,2,"月饼节到了！嘘！别吱声！对着屏幕乐一下！再乐一下！呵呵！我看到了！好了！愿你快乐！"));
        mMgs.add(new Msg(2,2,"分分喜悦无忧，刻刻高兴欢喜，时时活泼开朗，日日蒸蒸日上，月月事事顺心，年年吉祥如意！金秋佳节，祝您人圆家圆，业顺事兴！"));
        mMgs.add(new Msg(3,2,"中秋来临，第一个想到的就是你，愿能在这中秋之际，与你共尝美味月饼，吃的同时也能尝到我们友情的宝贵喔！"));
        mMgs.add(new Msg(4,2,"圣旨到！奉天承运，皇帝诏曰：中秋已至，特赐短信一条。内有平安一生，快乐一世，幸福一辈子，还有话费一毛。钦此！"));
        mMgs.add(new Msg(5,2,"金秋圆月挂天边，浪子心中思念添；寂寞嫦娥空际舞，八戒被贬为那般；我予汝心天可表，千里也能共婵娟。"));
        mMgs.add(new Msg(6,2,"中秋祝福：皓月闪烁，星光闪耀，中秋佳节，美满时刻！"));

        mMgs.add(new Msg(1,3,"最幸福的时刻，是爱情如意被心上人疼爱；最欣慰的时刻，是事业有成被周围人称赞。最快乐的时刻，" +
                "就是在今天收到朋友们的祝福。愿你开心过元旦！"));
        mMgs.add(new Msg(2,3,"最幸福的时刻，是爱情如意被心上人疼爱；最欣慰的时刻，是事业有成被周围人称赞。最快乐的时刻，" +
                "就是在今天收到朋友们的祝福。愿你开心过元旦！"));
        mMgs.add(new Msg(3,3,"这条短信，收到就行；要是在忙，不回也行；今天的你，快乐就行；记得call我，偶尔就行；看完之后，笑笑就行：）[元旦]快乐！"));
        mMgs.add(new Msg(4,3,"在新的一年里，我轻轻的对你说一声，一个朋友始终在祝福你。"));
        mMgs.add(new Msg(5,3,"元旦祝福：如果感到幸福你就挥挥手，如果感到幸福你就跺跺脚，如果感到幸福你就甩甩头。元旦快乐，疯子！"));
        mMgs.add(new Msg(6,3,"新的一年里，真诚地祝福你一切都好。虎到人心到，我的祝福早到，愿你看见短信心儿乐开花，祝元旦快乐！"));

        mMgs.add(new Msg(1,4,"走遍祖国最想母亲，走遍世界最想祖国。不同的民族，同一个祖国。 母亲的生日，同喜同喜。祝福你在这个和平幸福的年代里节日快乐！"));
        mMgs.add(new Msg(2,4,"十月，良辰美景；国庆，佳节喜庆；短信，传递真情，祝福，浪漫温馨；快乐，如影随形；幸福，必须肯定。祝：国庆节快乐！"));
        mMgs.add(new Msg(3,4,"平分秋色一轮满，长伴云衢千里明；佳节祝福提前送，份份祝福表心情，短信传意又达情，国庆中秋双节庆，愿您天天乐其中，节日快乐！"));
        mMgs.add(new Msg(4,4,"早年跟着下海，赚个万把块，后来捣鼓网络，弄个十几来万，今年国庆买彩，中个五百多万！普天同庆！"));

        mMgs.add(new Msg(1,5,"端午节祝君：家庭像粽子一样圆满，生活同粽枣一样甜蜜，爱情似粽米一样粘恋，威名像粽叶一样芳香远扬，事业如赛龙舟一样突飞猛进。心情像抛粽祭屈原一样畅快。"));
        mMgs.add(new Msg(2,5,"笑一下没忧愁，快快乐乐往前走；笑二下烦恼抛，欢欢喜喜唱小调；笑三下吃粽子，香香甜甜舌尖绕；祝端午节快乐！"));
        mMgs.add(new Msg(3,5,"万水千山“粽”是情，端午节“粽”送你，愿你“粽”是微笑，“粽”是快乐，“粽”是喜悦，“粽”是好运，“粽”是成功，“粽”是幸福，“粽”是美好。"));
        mMgs.add(new Msg(4,5,"年年岁岁过端午，岁岁年年粽飘香。一年一年又一年，五月初五难忘掉。龙舟湖上来竞渡，黄酒祭奠为故人。古往今来习和俗，千万大众普同庆。端午节到了！"));

        mMgs.add(new Msg(1,6,"鹊桥是银河的传奇，你是我心中的传奇。浪漫缘分是上天的安排，爱情神话是永恒的未来。许多的奇迹只有相信才会存在。亲爱的，七夕愉快！"));
        mMgs.add(new Msg(2,6,"与你相识是一种缘，与你相恋是一种美，与你相伴是一种福，我愿和你相伴到永远。七夕情人节快乐！"));
        mMgs.add(new Msg(3,6,"在一起的日子很平淡，似乎波澜不惊，只是，这种平凡的日子是最浪漫的，对吗？亲爱的，七夕情人节快乐！"));
        mMgs.add(new Msg(4,6,"流星落了，那是天哭了；雨水下了，那是我的思念涨潮了；月亮升了，那是你我的目光交错了；人间的喜鹊飞了那是它们为爱的七夕致敬去了！祝七夕快乐！"));

        mMgs.add(new Msg(1,7,"别傻了，还等圣诞老人呢？！今年他老人家不会来了，因为去年他被你的臭袜子熏怕了！也就我能迁就你，捏着鼻子说句圣诞快乐^_^"));
        mMgs.add(new Msg(2,7,"平安夜，把祝福挂在枝头，把心愿放你心头，让好运喜你眉头，让幸福伴你运头，让希望开好年头，让快乐助你兴头，让平安陪你无尽头，愿平安夜陪你开心无厘头"));
        mMgs.add(new Msg(3,7,"用刀子捅死你，我怕见血；毒死你吧，假药太多；电死你吧，电费太贵，淹死你吧，没准你还会游泳。算了，圣诞节了，我还是想死你吧！"));
        mMgs.add(new Msg(4,7,"我的祝福是白云飘向你，我的祝福是微风吹向你，我的祝福是鲜花送给你，祝你圣诞快乐！天天开心！"));

        mMgs.add(new Msg(1,8,"唉哟，我的妈也，今天差点闹笑话了，你不知道嗷，不晓得咋的，裤裆破了，路上一大妈指着说，这么大人了，怎么不注意，我赶紧说嗷，谁叫今天是六一呢~ 人人都是儿童。"));
        mMgs.add(new Msg(2,8,"童心是帆，祝福是船；快乐的风，吹着童心的帆，载着对你这长不大的朋友的祝福，漂向美丽的海湾，轻轻地问候你：六一节快乐！^0^"));
        mMgs.add(new Msg(3,8,"今天的节日非比寻常，今天的短信非你莫属，今天的快乐让你幸福，今天的天气给你棒棒糖，今天是你的节日，今天不要尿床"));
        mMgs.add(new Msg(4,8,"今天发短信主要有两个目的：一是锻炼指法，二是联络感情。现在我很负责的告诉你：六一到了，一定要开心！另外送句有技术含量的话：天天向上！"));
        mMgs.add(new Msg(5,8,"笑一笑十年少，一声笑吓跑烦恼，二声笑忧愁绕道，三声笑快乐来扰，四声笑幸福报到，不要再笑了，比儿童小的节日祝福我没找到，只能祝你儿童节快乐了！"));

    }

    /**
     * 返回短信内容
     * @param fesId
     * @return
     */
    public  List<Msg> getmMgsByFestivalId(int fesId){
        List<Msg> msgs=new ArrayList<Msg>();
        for (Msg msg:mMgs){
            if(msg.getFestivalId()==fesId){
                msgs.add(msg);
            }
        }
        return  msgs;
    }
    public  Msg getmMgsById(int Id){
        for(Msg msg: mMgs){
            if(msg.getId()==Id){
                return  msg;
            }
        }
        return  null;

    }
    /**
     * 返回数据
     * @return
     */
    public List<Festival> getmFestivals(){
        return new ArrayList<Festival>(mFestivals);
    }

    /**
     * 通过ID
     * @return
     */
    public  Festival getFestivalById(int fesId){
        for(Festival festival :mFestivals){
            if(festival.getId()==fesId){
                return  festival;
            }
        }
        return  null;
    }

    public static FesivalLab getmInstance(){
        if(mInstance==null){
           synchronized (FesivalLab.class){
               if (mInstance==null){
                   mInstance=new FesivalLab();
               }
           }
        }
        return  mInstance;
    }



}
