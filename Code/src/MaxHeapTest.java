import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


class MaxHeapTest {

    @Test
    public void oneStudent()
    {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(new Student("Susan", 3.5, 60));
        assertEquals(3.5, heap.extractMax().gpa(), .000001);
        assertEquals(0, heap.size());
    }

    @Test
    public void aInsertAFewStudents()
    {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(new Student("Susan", 3.5, 60));
        heap.insert(new Student("Ben", 3.4, 70));
        heap.insert(new Student("Reed", 4.0, 120));
        heap.insert(new Student("Johnny", 1.2, 50));
        assertEquals(4.0, heap.extractMax().gpa(), .000001);
        assertEquals(3.5, heap.extractMax().gpa(), .000001);
        heap.insert(new Student("Billy", 2.7, 20));
        assertEquals(3.4, heap.extractMax().gpa(), .000001);
        assertEquals(2.7, heap.extractMax().gpa(), .000001);
        assertEquals(1.2, heap.extractMax().gpa(), .000001);
    }

    @Test
    public void exceptionTest()
    {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(new Student("Ben", 3.4, 70));
        assertEquals(3.4, heap.extractMax().gpa(), .000001);
        try {
            heap.extractMax();
            fail("You shouldn't reach this line, an IndexOutOfBoundsException should have been thrown.");
        } catch (IndexOutOfBoundsException except) {
            assertEquals(except.getMessage(), "No maximum value:  the heap is empty.");
        }

    }

    @Test
    public void changeKeyTest()
    {
        MaxHeap heap = new MaxHeap(10);
        Student susan = new Student("Susan", 3, 6);
        Student ben = new Student("Ben", 2.4, 10);
        Student reed = new Student("Reed", 3.3, 3);
        Student johnny = new Student("Johnny", 1, 4);
        heap.insert(susan);;
        heap.insert(ben);
        heap.insert(johnny);
        heap.insert(reed);
        assertEquals(reed, heap.getMax());
        heap.addGrade(susan, 4, 3);  //should give her a 3.333333333 gpa
        assertEquals(susan, heap.getMax());
        assertEquals(3.33333333, heap.extractMax().gpa(), .000001);
        heap.addGrade(reed, .7, 3);  //should give him a 2.0
        heap.addGrade(johnny,  4,  4);  //should give him a 2.5
        assertEquals(2.5, heap.extractMax().gpa(), .000001);
        assertEquals(2.4, heap.extractMax().gpa(), .000001);
        assertEquals(2.0, heap.extractMax().gpa(), .000001);
    }


    @Test
    public void SizeTest() {
        MaxHeap heap = new MaxHeap(10);
        Student susan = new Student("Susan", 3, 6);
        Student ben = new Student("Ben", 2.4, 10);
        Student reed = new Student("Reed", 3.3, 3);
        Student johnny = new Student("Johnny", 1, 4);
        heap.insert(susan);;
        heap.insert(ben);
        heap.insert(johnny);
        heap.insert(reed);

        assertEquals(4,heap.size());

        heap.extractMax();
        assertEquals(3,heap.size());
    }


    @Test
    public void GetMaxTest() {
        MaxHeap heap = new MaxHeap(10);
        Student susan = new Student("Susan", 3, 6);
        Student ben = new Student("Ben", 2.4, 10);
        Student reed = new Student("Reed", 3.3, 3);
        Student johnny = new Student("Johnny", 1, 4);
        heap.insert(susan);;
        heap.insert(ben);
        heap.insert(johnny);
        heap.insert(reed);

        assertEquals(reed,heap.getMax());
    }


    @Test
    public void DuplicateTest() {
        MaxHeap heap = new MaxHeap(10);
        Student susan = new Student("Susan", 3, 6);
        Student ben = new Student("Ben", 2.4, 10);
        Student reed = new Student("Reed", 3.3, 3);
        Student johnny = new Student("Johnny", 1, 4);
        Student sarah = new Student("Sarah",3.3,31);
        heap.insert(susan);;
        heap.insert(ben);
        heap.insert(johnny);
        heap.insert(reed);
        heap.insert(sarah);



        assertEquals(sarah,heap.extractMax());
        assertEquals(reed,heap.getMax());

    }

    @Test
    public void BigDataTest() {
        MaxHeap heap = new MaxHeap(1000);
        Student maxStudent = new Student("StudentZero", 1500, 5);
        heap.insert(maxStudent);
        Random random = new Random();
        for(int i=0; i<1000;i++) {
            heap.insert(new Student("student" + i,random.nextInt(1000), 5));

        }


        assertEquals(maxStudent,heap.getMax());

        System.out.println(heap.getMax());

        assertEquals(1001, heap.size());


    }

    @Test
    public void MaxHeapWithCollection() {
        Student susan = new Student("Susan", 3, 2);
        Student ben = new Student("Ben", 2.4, 2);
        Student reed = new Student("Reed", 3.3, 2);
        Student johnny = new Student("Johnny", 1, 2);
        Student sarah = new Student("Sarah",3.4,31);


        List<Student> students = new ArrayList<>();

        students.add(reed);
        students.add(susan);
        students.add(ben);
        students.add(sarah);
        students.add(johnny);

        MaxHeap heap = new MaxHeap(students);

        assertEquals(sarah,heap.getMax());
        assertEquals(5,heap.size());

    }



    @Test

    public void NameTest() {
        MaxHeap heap = new MaxHeap(10);
        Student susan = new Student("Susan", 4, 2);
        Student ben = new Student("Ben", 2.4, 2);
        Student sarah = new Student("Sarah",3.4,-1);

        heap.insert(susan);
        heap.insert(sarah);
        heap.insert(ben);


        assertEquals("Susan",susan.getName());

    }



}