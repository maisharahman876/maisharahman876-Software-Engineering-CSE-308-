import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

static final Sorting s=new Sorting();
    @Test
    void sort_blank()
    {
        int arr[]={};
        s.sort(arr);
        assertEquals(arr.length,0);
    }
    @Test
    void sort_one_number() {
        int arr[]=new int[1];

        arr[0]=100;
        int arr1[]=arr;
        s.sort(arr);
        assertEquals(arr[0],arr1[0]);
        assertEquals(arr.length,arr1.length);
    }
    @Test
    void sort_two_numbers() {

        int arr[]={100,3};
        int arr1[]=arr;
        s.sort(arr);
        assertEquals(arr.length,arr1.length);
        for (int i=0;i<arr.length;i++) {
            if(i!=arr.length-1)
            assertTrue(arr[i]<=arr[i+1]);
            assertTrue(check(arr1,arr[i]));
        }
        int arr2[]={3,100};
        arr1=arr2;
        s.sort(arr2);
        assertEquals(arr2.length,arr1.length);
        for (int i=0;i<arr2.length;i++) {
            if(i!=arr2.length-1)
                assertTrue(arr2[i]<=arr2[i+1]);
            assertTrue(check(arr1,arr2[i]));
        }
    }
    @Test
    void sort_rand_size() {
        Random rn=new Random();
        int size=rn.nextInt()%10000;
        if(size<0)
        {
            size=-size;
        }

        int arr[]=new int[size];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=rn.nextInt();
        }
        int arr1[]=arr;
        s.sort(arr);
        assertEquals(arr.length,arr1.length);
        for (int i=0;i<arr.length;i++) {
            if(i!=arr.length-1)
                assertTrue(arr[i]<=arr[i+1]);
            assertTrue(check(arr1,arr[i]));
        }
    }
    @Test
    void sort_rand_nums() {
        Random rn=new Random();
        int arr[]=new int[200];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=rn.nextInt();
        }
        int arr1[]=arr;
        s.sort(arr);
        assertEquals(arr.length,arr1.length);
        for (int i=0;i<arr.length;i++) {
            if(i!=arr.length-1)
                assertTrue(arr[i]<=arr[i+1]);
            assertTrue(check(arr1,arr[i]));
        }
    }
    @Test
    void sort_sorted_nums() {
        Random rn=new Random();
        int arr[]=new int[30];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=rn.nextInt();
        }
        Arrays.sort(arr);
        int arr1[]=arr;
        s.sort(arr);
        assertEquals(arr.length,arr1.length);
        for (int i=0;i<arr.length;i++) {
            if(i!=arr.length-1)
                assertTrue(arr[i]<=arr[i+1]);
            assertTrue(check(arr1,arr[i]));
        }
    }
    @Test
    void sort_reversed_nums() {
        Random rn=new Random();
        int arr[]=new int[30];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=rn.nextInt();
        }
        Arrays.sort(arr);
        reverse(arr);
        int arr1[]=arr;
        s.sort(arr);
        assertEquals(arr.length,arr1.length);
        for (int i=0;i<arr.length;i++) {
            if(i!=arr.length-1)
                assertTrue(arr[i]<=arr[i+1]);
            assertTrue(check(arr1,arr[i]));
        }
    }
    private static boolean check(int[] arr, int toCheckValue)
    {

        for (int element : arr) {
            if (element == toCheckValue) {
               return true;
            }
        }
    return false;
    }
    private static void reverse(int a[]) {
        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }
}