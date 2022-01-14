package com.finaltest;

public class TaskCollection {
    static final int NB_TASK = 2027;
    Task[] taskCollection;
    int size = 0;

    public TaskCollection() {
        taskCollection = new Task[NB_TASK];
    }

    public int calcLocation(Task task) {
        return calcLocation(task.name);
    }

    public int calcLocation(String taskName) {
        int location = 0;
        taskName = taskName.replace(" ", "").toUpperCase();

        for (char character : taskName.toCharArray()) {
            location += (int) character - 65; // A: 65 => character - 65 = 0
        }
        if (location > NB_TASK) {
            location = location % NB_TASK;
        }
        return location;
    }

    // add task and return its index
    public int addTask(Task t){
        int location = calcLocation(t.name);
        int idx = -1;
        Task existing = taskCollection[location];
        if (existing == null){
            taskCollection[location] = t;
            size++;
            idx = location;
        } else {
            while (location < 2027){
                location++;
                if (taskCollection[location] == null){
                    taskCollection[location] = t;
                    size++;
                    idx = location;
                    break;
                }
            }
        }
        return idx;
    }

    public Task getTask(String name){
        int location = calcLocation(name);
        do {
            if (taskCollection[location] == null)
                return null;

            if (taskCollection[location].name.equals(name))
                return taskCollection[location];
            else
                location++;
        } while (location < NB_TASK);
        return null;

    }

    public static void main(String args[]){
        Task t1 = new Task("GET DI", true);
        Task t2 = new Task("GET HD", false);
        TaskCollection taskCol = new TaskCollection();
        System.out.println(taskCol.calcLocation(t1));  // return 40
        System.out.println(taskCol.calcLocation(t2));  // return 39
        System.out.println(taskCol.calcLocation(new Task("GET D I", false)));  // return 40
        System.out.println(taskCol.addTask(t1));  // return 40
        System.out.println(taskCol.addTask(new Task("GET D I", false))); // return 41, due to collision at 40-th location
        System.out.println(taskCol.getTask("GET DI"));  // return Task t1
        System.out.println(taskCol.getTask("G E T D I")); // return null
        System.out.println(taskCol.getTask("GET HD"));  // return null
    }

}

class Task {
    String name;
    boolean status;

    public Task(String name, boolean status){
        this.name = name;
        this.status = status;
    }
}
