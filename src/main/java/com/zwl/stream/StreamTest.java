package com.zwl.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author  weilin_zheng
 *
 */
public class StreamTest {
/*
    Java 8 API添加了一个新的抽象称为流Stram，可以让你一种声明的方式处理数据
    Stram使用哟中类似用Sql语句从数据库查询数据的直观方式来提供一种对Java集合运算和表达的高阶抽象
    Stram API可以极大提高Java程序员的生产力，让程序员写出高效率，干净，简洁的代码
    这种风格将要处理的元素集合看作一种流，流在管道中传输，并且在管道的节点上进行处理，比如筛选，排序，聚合等
    元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作（terminal operation）得到前面得处理结果
        +--------------------+       +------+   +------+   +---+   +-------+
        | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
        +--------------------+       +------+   +------+   +---+   +-------+
 */
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
    /*
        在Java 8 中，集合接口有两个方法来生成流
            stream()--为集合创建串行流
            parallelStream（）--为集合创建并行流
     */

    // 创建一个集合
        //    使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
        //   法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
        List<String> strings = Arrays.asList("abc","","bc","efg ","abcd","","jk1");

    // 使用Stream接口,把空的字符床过滤掉
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

    //forEach
        //Stran提供了新的方法“forEach”来迭代流中的每个数据，以下代码，使用forEach输出了十个随机数
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    //map
        //map方法用于映射每个元素到对应的结果，以下代码片段使用map输出元素对应的平方数
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        //获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i-> i * i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);

    //filter
        //filter 方法用于通过设置的条件过滤出元素，以下的代码片段使用fillter方法过滤出空字符床
        List<String> strings1 = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        //获取空字符的数量
        long count = strings1.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count:"+count);

    //limit
        //limit方法用于获取指定数量的流，以下代码片段使用limit打印出10条数据
        Random random1 = new Random();
        random1.ints().limit(10).forEach(System.out::println);

    //sorted
        //sorted方法用于对流进行排序，以下代码端使用Srted方法对输出的10个随机进行排序
        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(System.out::println);

    //并行（paraller）程序
        //parallelStream是流并行处理程序的代替方法，以下实例我们使用parallelStream来输出空字符串的数量
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("count2:"+count2);

    //Collectors
        //Collectors类实现了很多归约操作，例如奖流转换成集合和聚合元素，Collectors 可用于返回列表或字符串
        List<String> strings3 =  Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered2 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表：" + filtered2);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);



    }


}
