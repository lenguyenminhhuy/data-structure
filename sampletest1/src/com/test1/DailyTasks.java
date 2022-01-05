//package com.test1;
//
//public class DailyTasks<T> {
//    public static int size;
//    public static Node<Task> head;
//
//    public DailyTasks() {
//        size = 0;
//    }
//
//    public static class Node<T> {
//        T data;
//        Node<T> next;
//
//        public Node(T data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    public static boolean validateTask(Task task) {
//        int endTime = task.duration + task.startTime;
//        if (endTime > 24) {
//            return false;
////
//        }
//
//        if (task.description == null) {
//            return false;
////
//        }
//        return true;
//    }
//
//
//    public boolean addTask(Task task) {
//        if (!validateTask(task)) {
//            return false;
//        }
//        Node<Task> aTask = new Node<Task>(task);
//        aTask.next = head;
//        head = aTask;
//        size++;
//        return true;
//    }
//
//
//    public String nextTask(int time) {
//        Node<Task> taskHead = head;
//        String results = "";
//        int minTime = 0;
//        boolean checked = false;
//        while (taskHead != null) {
//            if (taskHead.data.startTime >= time) {
//                if (!checked) {
//                    checked = true;
//                    minTime = taskHead.data.startTime;
//                    results = taskHead.data.description;
//                }
//                if (taskHead.data.startTime < minTime) {
//                    minTime = taskHead.data.startTime;
//                    results = taskHead.data.description;
//                }
//            }
//            taskHead = taskHead.next;
//        }
//        return results;
//    }
//    public static void main(String[] args) {
//        DailyTasks tasks = new DailyTasks(20);
//        Task task1 = new Task("Task 1", 10, 2);
//        Task task2 = new Task("Task 2", 8, 2);
//        Task task3 = new Task("Task 3", 20, 2);
//        tasks.addTask(task1);
//        tasks.addTask(task2);
//        tasks.addTask(task3);
//        tasks.validateTask(task1);
//    }
//}
//
//class Task{
//    int startTime;
//     int duration;
//     String description;
//
//    public Task(String description, int startTime,int duration){
//        this.description = description;
//        this.startTime = startTime;
//        this.duration = duration;
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" + ", description='" + description + '\'' + "startTime=" + startTime + ", duration=" + duration + '}';
//    }
//}