import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");


        File file = new File("/Users/grantsolt/Desktop/49205929/Assignment4/wordlist.10000.txt");
        Scanner sc = new Scanner(file);
        Scanner sc2= new Scanner(System.in);

        HTChainOld htOld=new HTChainOld(1000);
        HTChainOld htNew=new HTChainOld(1000);
        HTProbingOld hpOld=new HTProbingOld(20000);
        HTProbingOld hpNew=new HTProbingOld(20000);

        int count=1;
        while(sc.hasNextLine()){
            String key = sc.nextLine();
            System.out.println(key);
            htOld.put(key, count);
            htNew.put(key, count);
            hpOld.insert(key);
            hpNew.insert(key);
            count++;
        }


        for(int y=0;y<5;y++){
            System.out.println("Enter password: ");
            String test=sc2.nextLine().toLowerCase();
            String testWord="";

            for(int x=0;x<test.length();x++){
                if(Character.isLetter(test.charAt(x)))
                    testWord=testWord+test.charAt(x);
            }

            boolean test1=test.length()>=8;
            boolean test2=!(htOld.has(testWord));
            boolean test3=testWord.length()!=test.length();

//        System.out.println(test);
//        System.out.println(testWord);
//        System.out.println(test1);
//        System.out.println(test2);
//        System.out.println(test3);


            if(test1&&test2&&test3)
                System.out.println("Password is strong!");
            else
                System.out.println("Password is weak!");

            //Comparisons
            htOld.has(test);
            htNew.has(test);
            hpOld.has(test);
            hpNew.has(test);
            int comp1= htOld.getComp();
            int comp2= htNew.getComp();
            int comp3= hpOld.getComp();
            int comp4= hpNew.getComp();
            System.out.println("Comparisons for separate chaining hash table with hash function 1: "+comp1);
            System.out.println("Comparisons for separate chaining hash table with hash function 2: "+comp2);
            System.out.println("Comparisons for linear probing hash table with hash function 1: "+comp3);
            System.out.println("Comparisons for linear probing hash table with hash function 2: "+comp4);
        }
    }
}