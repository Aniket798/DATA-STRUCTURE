import java.util.*;
import java.util.stream.Collectors;

public class Waiter {


    public static void main(String[] args) {
        List<Integer> inputList= Arrays.asList(3 ,4, 7 ,6, 5);
        List<Integer> res=waiter(inputList,1);
        System.out.println(res.stream().map(Object::toString).collect(Collectors.joining("\n"))+"\n");
    }
    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        List<Integer> result=new ArrayList<>();
        Stack<Integer> tempStack=new Stack();
        int count=1;
        for(int i=1;count<=q;i++){
            if(checkForPrime(i)){
                tempStack=new Stack();
                for(int num:number){
                    if(num%i==0){
                        result.add(num);
                    }
                    else {
                        tempStack.push(num);
                    }
                }
                number=new ArrayList<>();
                Iterator iterator = tempStack.iterator();
                while(iterator.hasNext()) {
                    int value = tempStack.pop();
                 //   System.out.println(value);
                    number.add(value);
                }
                count++;
            }
        }
        if(number.size()!=0){
                for(int j=number.size()-1;j>=0;j--){
                    result.add(number.get(j));
                }
            }

        return result;

    }
    static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;

        if(inputNumber <= 1)
        {
            isItPrime = false;

            return isItPrime;
        }
        else
        {
            for (int i = 2; i<= inputNumber/2; i++)
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;

                    break;
                }
            }
        }
        return isItPrime;

    }

}
