package com.company;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.lang.Iterable;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        int sizeA = 0, sizeB =0 ;  //размеры соответствующих массивов
        int maxA, minA, maxB, minB;  //задают диапазон значений элементов
        // массивов

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите количество элементов А: ");
        sizeA = scanner.nextInt();
        int[] arrA = new int[sizeA];
        System.out.println("введите количество элементов B: ");
        sizeB = scanner.nextInt();
        int[] arrB = new int[sizeB];
        System.out.print("размер множества B = " + sizeB);
        System.out.println(" размер множества А = " + sizeA);

        System.out.println("введите минимальное значение для множ. А: ");
        minA = scanner.nextInt();
        System.out.println("введите минимальное значение для множ. В: ");
        minB = scanner.nextInt();
        System.out.println("введите максимальное значение для множ. A: ");
        maxA = scanner.nextInt();
        System.out.println("введите максимальное значение для множ. В: ");
        maxB = scanner.nextInt();

        rand(arrA, maxA, minA);
        rand(arrB, maxB, minB);

        System.out.println("Сортировка двух множеств пузырьком: ");
        sort(arrA, sizeA);
        sort(arrB, sizeB);
        System.out.println(Arrays.toString(arrA));
        System.out.println(Arrays.toString(arrB));

        System.out.println("Бинарный поиск подобных элементов: ");
        int startIndex ;
        int endIKndex ;
        int midIndexA;
        int midVal;
        int i;
        int valueB;
        int kolvo = 0;
        for (i = sizeB; 0 < i; i--) {
            valueB = arrB[i - 1];
            startIndex = 0;
            endIKndex = sizeA - 1;
            while (startIndex <= endIKndex) {
                midIndexA = (startIndex + endIKndex) / 2;
                if (midIndexA > (sizeA - 1)) {
                break;
                }
                midVal = arrA[midIndexA];
                if (midVal < valueB) {
                    startIndex = midIndexA + 1;
                }
                else if (midVal > valueB) {
                    endIKndex = midIndexA - 1;
                }
                else {
                    valueB = midVal;
                    kolvo +=1;
                    System.out.print(" " + valueB);
                    break;
                }
            }
        }System.out.println(" ");
        System.out.println("количество совпавших элементов "+ kolvo);
    }
    public static void rand(int[] Ar, int max, int min) {//создается случайный массив с определенным диапазоном
        label1:
        for ( int i = 0; i < Ar.length; ) {
            int randnumb = min + (int) (Math.random() * ((max - min) + 1));
            for (int j = 0; j < Ar.length;j++){
                if (randnumb == Ar[j]) continue label1;
            }
       Ar[i] = randnumb;
            i++;
        }
    }
    public static int[] sort(int[] Ar, int size) { //сортировка пузырьком

        for (int i = 1; i < Ar.length; i++) {
            for (int j = i; (j >= 1) && (Ar[j] < Ar[j - 1]); j--) {
                int a = Ar[j];
                Ar[j] = Ar[j - 1];
                Ar[j - 1] = a;
            }
        }
        return Ar;
    }
}

// int sizeA = 11, sizeB = 15;

//  int[] arrA = {1,2,4,6,9,10,12,15,17,19,20};
//  int[] arrB = {0,1,2,4,6,6,9,10,11,12,15,17,19,19,20};
//(;Math.ceil((startIndex + endIKndex) / 2)
//  System.out.println("midindexA "+midIndexA+" sizeA " +sizeA);
//     System.out.println("starIndex "+startIndex);
//System.out.println("endIndex");
//    else if (midVal == valueB){
//         valueB = midVal;
//        break;
//    }
    /*  Integer[] result = new Integer[min];
        for (int i = 0; i < min; i++)
            result[i] = i + 1;

        for (int i = min; i < max; i++)
        {
            int j = random.nextInt(i + 1);
            if (j < min)
                result[j] = i + 1;
        }


        public static boolean binserch(int[] array,int[] array2,int min,int key)
    { for (i = sizeB; 0 < i; i--){
            while (midA > 0.5) {
                elemB = arr2[i];

                System.out.println("mid "+midA);
                if (elemB == arr1[midA]){
                    System.out.println(arr1[midA]);
                    break;
                }
                else if (elemB > arr1[midA])
                    minA=midA;
                else  if (elemB < arr1[midA])
                    sizeA = midA;
                else if (midA == 0.5)break;

                }
            System.out.println("числа что совпали "+arr1[midA]);
            }
        int left = min;
        int right = array.length;
        int right2 =array2.length;
        int midB =0;
        int midA = 0;

        while (left < right)
        {
            midA = left + (right - left) / 2;
            midB = key;
            if( midA == 1)midA = 0;
            else if (midA > 2 && midA < 3)midB= +1;

            if (array[midA] == array2[midB])
                return (true);

            else if (array[midA] >= array2[midB])
                right = midA;
            else if (array[midA] <= array2[midB])
                left = midA;
            else
                left = midA - 1;
        }
        return (false);
    }*/


    /* int m, left, right,n=0;
        left = 0;
        right = n-1;
        while (true)
        {
            if (left > right)
                return (-1); // значение не найдено
            m = left + (right - left) / 2;
            if (arr[m] < size)
                left = m + 1;
            if (arr[m] > size)
                right = m - 1;
            if (arr[m] == size)
                return m;
        }
    }

    while (low <= high) {
        int mid = (low + high)/2;
        int midVal = a[mid];

        if (midVal < key)
        low = mid + 1;
        else if (midVal > key)
        high = mid - 1;
        else
        return mid; // key found
    }

    1) int A = 0;
        int B = arr.length;
        while (A <= B) {
            int mid = (A + B) / 2;
            if ( mid==arr[mid])
                return true;

            else if (arr2 <arr[mid]) {
                B = mid - 1;
            }
            else {
                A = mid + 1;
            }
        }
        return false;



есть два массива arrA и arrB размером (sizeA и sizeB)=5.
пусть arrA = { 2, 3, 5, 6, 10}
arrB = { 0, 3, 4, 5, 11}
В уже отсортированом массиве,используя бинарный поиск, найти и вывести совпадающие
элементы в этих двух массивах.
sout(Общие элементы: "3","5")
    public static int binserch(int[] array,int[] array2,int min,int key)
    {
        int left = min;
        int right = array.length;
        int right2 =array2.length;
        int midB =0;
        int midA = 0;

        while (!(left >= right))
        {
            midA = left + (right - left) / 2;
            midB = key;
            if( midA == 1)midA = 0;
            else if (midA > 2 && midA < 3)midB= +1;

            if (array[midA] == array2[midB])
                return (key+1);

            else if (array[midA] >= array2[midB])
                right = midA;
            else if (array[midA] <= array2[midB])
                left = midA;
            else
                left = midA - 1;
        }
        return (key);
    }






int A, B, C;  //указатели на исходные и результирующий массивы
        int x1,x2, 			 //границы интервала неопределенности
                m;  				 //точка деления
        if (A==B) (C+sizeC++)=A;
        for (int i=0;i<sizeA;i++) {
        x1=0;
        x2=sizeB;
            while(x1<=x2){
                    m=(x1+x2)/2;
                if(A[i]==B[m]) {
                   (C+sizeC++)=(A+i);
                break;
                }
                else if (A[i] < B[m])
                    x2=m-1;
                else
                    x1=m+1;
            }
        }
*/



/*int[] arrA,int[] arrB, int mid,int sizeA,int sizeB)
 //x1,x2 границы интервала неопределенности
        //    mid точка деления
        int A= 0;
        int B = arr.length;
        while (A < B)
        {
            int mid = (A+B) / 2;
            if (arr[mid] == mid)
                return true;

           else if (key < arr[mid]) {
                B = mid -1;
            }
            else {
                A = mid + 1;
            }
        }
        return false;//
*/
