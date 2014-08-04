package com.clearprecision.java8.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    public List<List<String>> getDocument() {
        List<List<String>> doc = new ArrayList<List<String>>();
        List<String> first_sentence = Arrays.asList("The", "quick", "brown", "fox");
        List<String> second_sentence = Arrays.asList("Who", "ate", "all", "the", "pies");
        List<String> third_sentence = Arrays.asList("The", "quick", "brown", "fox");
        List<String> fourth_sentence = Arrays.asList("The", "quick", "brown", "fox");
        doc.add(first_sentence);
        doc.add(second_sentence);
        doc.add(third_sentence);
        doc.add(fourth_sentence);
        return doc;
    }

    public static void main(String[] args) throws Exception {
        ForkJoinExample ex = new ForkJoinExample();
        List<List<String>> doc = ex.getDocument();

        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<Integer> result = pool.submit(new SentenceSplitTask(doc, "The"));
        System.out.println(result.get());

    }

}
