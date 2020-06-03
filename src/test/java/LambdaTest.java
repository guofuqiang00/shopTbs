import com.tbs.test.TestAbstract;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {


    public int add(int x,int y){
        return x+y;
    }


    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        list.forEach(item-> System.out.println(item));

        /**过滤*/
        list.stream()
                .filter(e->e.contains("aaa"))
                .forEach(item-> System.out.println(item));

    }


}
