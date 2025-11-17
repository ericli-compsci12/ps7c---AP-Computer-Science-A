import java.util.ArrayList;
import java.util.Scanner;
public class ps7c {
    public static void main(String[] args) {
        //final int TEST_INT = 100;
        Scanner in = new Scanner(System.in);
        System.out.println("1. SieveofEratosthenes \n2. GoldbachConjecture \n3. AddingBigInts");
        System.out.print("Select a number: ");
        int ip = in.nextInt();
        if(ip == 1) {
        System.out.print("Input a random integer: ");
        int ipu = in.nextInt();
        ArrayPrinter(SieveofEratosthenes(ipu)); 
        }
        else if(ip == 2) {
        System.out.print("Input a random integer: ");
        int ipu = in.nextInt();
        System.out.println(GoldbachConjecture(ipu));
        }
        else if(ip == 3) {
        System.out.print("Input a string containing an integer: ");
        in.nextLine();
        String str1 = in.nextLine();
        //System.out.println(str1);
         
        System.out.print("Input another string containing an integer: ");
        String str2 = in.nextLine();
        //System.out.println(str2);
        //System.out.print("str1: ");
        
        //ArrayList<Integer> test = new ArrayList();
        //test = ArrayListConverter(str1);
        //System.out.print(test.size());
        //for(int i = 0; i <test.size(); i++) {
          //  int x = test.get(i);
            //System.out.println("x:"+x);
        //}
        //System.out.print("str2: ");
        //ArrayPrinter(ArrayListConverter(str2));
        ArrayPrinter2(AddingBigInts(ArrayListConverter(str1), ArrayListConverter(str2))); 
        }
    }
    
    public static void ArrayPrinter(ArrayList<Integer> lst) {
        for(int n : lst) {
            System.out.print(n + " ");
        }
    }
    
    public static void ArrayPrinter2(ArrayList<Integer> lst) {
        for(int n : lst) {
            System.out.print(n);
        }
    }
    
    public static ArrayList<Integer> ArrayListConverter(String str) {
        ArrayList<Integer> rtn = new ArrayList();
        for(int a = 0; a < str.length(); a++) {
            rtn.add(Integer.parseInt(str.substring(a,a+1)));
        }
        //ArrayPrinter(rtn);
        return rtn;
    }
    
    public static ArrayList<Integer> SieveofEratosthenes(int n) {
        ArrayList<Integer> rtn = new ArrayList();
        for(int i = 2; i < n+1; i++) {
            rtn.add(i);
        }
        
        int p = 2;
        int x = Integer.MAX_VALUE;
        while(p < x) {
        for(int i = 0; i < rtn.size(); i++) {
            int a = rtn.get(i);
            if(a != p && a%p == 0) {
                rtn.remove(i);
                i--;
            }
        }
        for(int i = 0; i < rtn.size(); i++) {
            int a = rtn.get(i);
            if(a > p) {
                p = a;
                break;
            }
        }
        x = rtn.get(rtn.size()-1);
    }
        return rtn;
    }
    
    public static String GoldbachConjecture (int n) {
      String rtn = "";
      for(int i = 0; i < SieveofEratosthenes(n).size(); i++) {
          int x = SieveofEratosthenes(n).get(i);
        for(int c = 0; c < SieveofEratosthenes(n).size(); c++) {
            int y = SieveofEratosthenes(n).get(c);
            if(x + y == n) {
                rtn = x + "+" + y + "=" + n + ";";
            }
      }
      }
      return rtn;
    }
    
    public static ArrayList<Integer> AddingBigInts(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> rtn = new ArrayList();
        //ArrayPrinter(a);
       // System.out.print("b: ");
        //ArrayPrinter(b);
        
        boolean increment = false;
        //System.out.print("a");
        //ArrayPrinter(a);
       // System.out.print("b");
        //ArrayPrinter(b);
        int tempb = b.size();
        int tempa = a.size();
        if(tempa < tempb) {
            for(int i = 1; i <= tempb-tempa; i++) {
                a.add(0,0);
            }
        }
        
        if(tempa > tempb) {
            for(int i = 1; i <= tempa-tempb; i++) {
                b.add(0,0);
                //System.out.println(tempa-tempb);

            }
        }
        
       // ArrayPrinter(b);
        
        for(int i = a.size()-1; i >= 0; i--) {
            int x = a.get(i);
            int y = b.get(i);
            if(!increment) {
                //System.out.println(x+","+y+","+(x+y)%10);
                rtn.add(0,(x+y)%10);
                 if(x+y >= 10) {
                    increment = true;
                }
                else {
                    increment = false;
                }
            }
            else {
                //System.out.println((x+y)%10);
                rtn.add(0,(x+y+1)%10);
                 if(x+y+1 >= 10) {
                    increment = true;
                }
                else {
                    increment = false;
                }
            }
        }
        if(increment) {
            rtn.add(0,1);
        }
         return rtn;
    }
}