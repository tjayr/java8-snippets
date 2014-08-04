package com.clearprecision.java8.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SentenceSplitTask extends RecursiveTask<Integer> {

    private List<List<String>> input;
    private String word;

    public SentenceSplitTask(List<List<String>> data, String word) {
        System.out.println(Thread.currentThread().getName()+" [ "+ data+" ] "+ word);
        this.input = data;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        List<SentenceSplitTask> tasks = new ArrayList<>();
        if (input.size() == 1) {
            return process(input.get(0));
        } else {
            for (List<String> list : input) {
                SentenceSplitTask task = new SentenceSplitTask(Arrays.asList(list), word);
                task.fork();
                tasks.add(task);
            }
        }
        return sumAll(tasks);
    }

    private int process(List<String> list) {
        int total = 0;
        for (String string : list) {
            if (string.equals(word)) {
                total += 1;
            }
        }
        return total;
    }

    private int sumAll(List<SentenceSplitTask> tasks) {
        int runningtotal = 0;
        for (SentenceSplitTask sentenceSplitTask : tasks) {
            runningtotal += sentenceSplitTask.join();
        }
        return runningtotal;

    }

}
