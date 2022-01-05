package com.test1;

public class PeopleQueue {
    Person[] people;
    int currentSize;
    int front;
    int end;
    public PeopleQueue() {
        people = new Person[100];
        currentSize = 0;
        front = -1;
        end = - 1;
    }

    public void joinQueue(Person person){
        if(currentSize == people.length - 1){
            throw new IllegalStateException("Queue is full");
        }
        if (person.age < 65){
            people[currentSize] = person;
            currentSize++;
            return;
        }
        // find the position for person older than 65: before person younger than 65.
        int pos = currentSize;
        while (pos > 0 ){
            if (people[pos-1].age < 65){
                people[pos] = people[pos-1];
                pos--;
            }
            else {
                break;
            }
        }
        people[pos] = person;
        currentSize++;
    }

    public Person getVaccine(){
        Person personGetVaccine = people[0];
        if (currentSize != 0){
            for (int i=0; i<currentSize;i++){
                people[i] = people[i+1];
            }
            currentSize--;
        }
        else{
            System.out.println("Queue is empty");
        }
        System.out.println(personGetVaccine.ID);
        System.out.println(personGetVaccine.age);
        return personGetVaccine;
    }

    public void giveUp(String ID){
        if (currentSize == 0){
            return;
        }
        // find the position of personGiveUp
        int pos = 0;
        while (pos < currentSize){
                if (people[pos].ID.equals(ID)){
                    break;
                }
                pos++;
            }
            // check if pos index not in the queue: return nothing
            if (pos == currentSize){
                return;
            }
            for (int i = pos; i<currentSize; i++){
                people[i] = people[i+1];
            }
        currentSize--;
    }

    private void printQueue(){
        for (int i =0; i<currentSize; i++){
            System.out.println(String.format("Person %d", i+1));
            System.out.println(people[i].ID);
            System.out.println(people[i].age);
        }
    }

    public static void main(String[] args){
        PeopleQueue queue = new PeopleQueue();
        queue.joinQueue(new Person("1", 20));
        queue.joinQueue(new Person("2", 30));
        queue.joinQueue(new Person("3", 50));
//        System.out.println("Noone > 65");
        queue.printQueue();
        System.out.println("Person get vaccine: ");
        queue.getVaccine();
//        System.out.println("Having one person older than 65");
        queue.joinQueue(new Person("4", 67));
        queue.printQueue();

        System.out.println("Person get vaccine 2: ");
        queue.getVaccine();
        queue.giveUp("3");
        queue.printQueue();
        queue.joinQueue(new Person("5", 42));
        System.out.println("Person get vaccine 3: ");
        queue.getVaccine();


    }

}

class Person {
    String ID;
    int age;

    public Person(String ID, int age){
        this.ID = ID;
        this.age = age;
    }
}
