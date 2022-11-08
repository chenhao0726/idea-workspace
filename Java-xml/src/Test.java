import java.util.ArrayList;
import java.util.List;

/**
 * 1. IDEA中代码模板所处的位置Settings->liveTemplates
 * /Postfix Completion
 * 2.常⽤的模板
 */
public class Test {

    //模板prsf可⽣成private static final boolean;
    private static final boolean flag = false;
    //变形psf可⽣成public static final
    public static final int num = 1;
    //变形psfi 可⽣成 public static final int
    public static final int num2 = 2;
    //变形psfs 可⽣成 public static final String
    public static final String s = "China";

    //模板⼀psmv
    public static void main(String[] args) {
        //模板⼆sout
        System.out.println("hello");
        // 变形soutp/soutm/soutv/xxx.sout
        System.out.println("args=[" + args + "]");
        System.out.println("TestSettings.main");
        int num = 10, num2 = 20;
        System.out.println("num2=" + num2);
        System.out.println(num);
        // 模板三fori
        String[] arr = new String[]{"hanmeimei", "lilei", "angek", "安琪"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 变形iter
        for (String s : arr) {
            System.out.println(s);
        }
        // 变形itar接收赋值
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
        }
        // 模板四list.for
        List<Integer> list = new ArrayList<>();
        for (Integer integer : list) {
            System.out.println("integer=" + integer);
        }
        // 变形list.fori list.forr(逆序)
        // 模板五ifn
        if (list == null) {
        }
        // 变形inn
        if (list != null) {
        }//变形xxx.nn / xxx.null}
    }
}

