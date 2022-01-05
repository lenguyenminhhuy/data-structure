//public class DailyTasks {
//    int maxSize;
//    int currentSize;
//    Task[] tasks;
//    public DailyTasks(){
//        maxSize = 20;
//        currentSize = 0;
//        tasks = new Task[maxSize];
//    }
//    public DailyTasks(int size){
//        maxSize = size;
//        currentSize = 0;
//        tasks = new Task[maxSize];
//    }
//
//    public boolean validateTask(Task task){
//        int endTime = task.startTime + task.duration;
//        if(task.description == null && endTime > 24){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
//    public boolean addTask(Task task){
//        if (validateTask(task)){
//            if (currentSize ==0){
//                tasks[0] = task;
//            }
//            else{
//                for (int i =0;i<currentSize; i++){
//                    int endTime2 = tasks[i].startTime + tasks[i].duration;
//                    if(task.startTime - tasks[i].startTime <= task.duration||
//                            task.startTime - endTime2 >= 0){
//                        tasks[i+1] = task;
//                        currentSize++;
//                        return true;
//                    }
//                }
//            }
////            int endTime = task.getStartTime() + task.getDuration();
//        }
//        return false;
//    }
//
//    public String nextTask(int time){
//        int minTime = 99;
//        Task aTask = null;
//        String description = null;
//        for (int i = 0; i<currentSize; i++){
//            if(minTime> tasks[i].startTime && tasks[i].startTime >= time){
//                minTime = tasks[i].startTime;
//                aTask = tasks[i];
//            }
//        }
//
//        for (int i = 0; i<currentSize; i++){
//            if(tasks[i].startTime == time){
//                description = tasks[i].description;
//            }
//            else if (time < minTime){
//                description = aTask.description;
//            }
//        }
//        return description;
//    }
//
//    public void printTask(){
//        for (int i = 0; i<currentSize; i++){
//            System.out.println(tasks[i].description);
//            System.out.println(tasks[i].startTime);
//            System.out.println(tasks[i].duration);
//        }
//    }
//
//    public static void main(String[] args){
//        DailyTasks tasks = new DailyTasks(20);
//        Task task1 = new Task("Task 1", 10, 2);
//        Task task2 = new Task("Task 2", 8, 2);
//        Task task3 = new Task("Task 3", 20, 2);
//        tasks.addTask(task1);
//        tasks.addTask(task2);
//        tasks.addTask(task3);
//        tasks.validateTask(task1);
//        tasks.nextTask(10);
//
//        tasks.printTask();
//    }
//
//
//
//}
//class Task{
//    String description;
//    int startTime;
//    int duration;
//    public Task(String description, int startTime, int duration){
//        this.description = description;
//        this.startTime = startTime;
//        this.duration = duration;
//    }
//}
