public class Ejercicio2Factorial {
    
    public static void main(String[] args) {
        

        

        Integer resultardo = facto(20);

       

        System.out.println(resultardo);

    }

    public static Integer facto( Integer num){

        int res = 1;
        for (int i = 1; i <= num; ++i){

            res *=i;
        }

        return res;
    }
    
}
