import org.junit.Test;

import java.util.Random;

public class RnTest {

    @Test
    public void RandTest() {

        String[] str = {"数码卡", "办公卡", "健康卡", "彩妆卡", "餐具卡",
                "茶香卡", "宠物卡", "厨具卡", "床品卡", "服饰卡",
                "户外卡", "护肤卡", "家电卡", "家居卡", "家具卡",
                "建材卡", "出行卡", "美酒卡", "乐器卡", "生鲜卡",
                "美发卡", "母婴卡", "农具卡", "配饰卡", "灯具卡",
                "食品卡", "书籍卡", "童装卡", "文玩卡", "五金卡",
                "洗护卡", "植物卡", "箱包卡", "鞋履卡", "药品卡",
                "运动卡", "潮玩卡", "节庆卡", "厨电卡", "饮料卡"};

//        "数码卡", "办公卡", "健康卡", "彩妆卡", "餐具卡", "茶香卡",
//        "宠物卡", "厨具卡", "床品卡", "服饰卡", "户外卡", "护肤卡", "家电卡",
//        "家居卡", "家具卡", "建材卡", "出行卡", "美酒卡", "乐器卡", "生鲜卡", "美发卡",
//        "母婴卡", "农具卡", "配饰卡", "灯具卡", "食品卡", "书籍卡", "童装卡",
//        "文玩卡", "五金卡", "洗护卡", "植物卡", "箱包卡", "鞋履卡", "药品卡",
//        "运动卡", "潮玩卡", "节庆卡", "厨电卡", "饮料卡", "品牌卡",
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        System.out.println(str.length);
        int a = 5;
        int b = -1;
        for (int i = 0; i < a; i++) {
            int i1 = random.nextInt(str.length);
            System.out.println(i1 +"=="+ b);
            String s = str[i1];
            builder.append(s);
            if (s.equals(builder)){
                a++;
            }
            b = i1;
            System.out.println(builder);
            System.out.println("Card：" + s);
        }
    }
}
