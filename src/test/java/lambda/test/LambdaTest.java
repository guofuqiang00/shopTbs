package lambda.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * java8 内置四大核心函数式接口
 *
 *  Comsumer<T> :消费接口
 *     void accept(T t)
 *
 * Supplier<T> :共给型接口
 *    T get();
 *
 * Function<T,R> :函数型接口
 *    R apply(T t)
 *
 *  Predicate<T> :断言型接口
 *    boolean test(T t)
 *
 * */
public class LambdaTest {



    public void com(String str, Consumer<String> comparable){
        comparable.accept(str);
    }
    public Integer Supplier(Supplier<Integer> supplier){
        return supplier.get();
    }
    public String Function(String str, Function<String,String> function){
        return function.apply(str);
    }
    public boolean Predicate(String str, Predicate<String> function){
        return function.test(str);
    }
    public List<String> Predicate(String str, String str2, BiFunction<String,String,String> function){
        List<String> list = new ArrayList();
        String apply = function.apply(str, str2);
        list.add(apply);
        return list;
    }

    @Test
    public void comsumerTest(){

        com("abc",(x)-> System.out.println(x));

        System.out.println(Supplier(()-> (int)(Math.random()*100)));

        System.out.println(Function("abc",(x)->x));

        System.out.println(Predicate("abc",(x)->x=="000"));

        List<String> predicate = Predicate("abc", "ABC", (e, e2) -> {
            if(e.equals(e2)){
                return "true";
            }else{
                return "false";
            }
        });
        System.out.println(predicate);

    }

}
