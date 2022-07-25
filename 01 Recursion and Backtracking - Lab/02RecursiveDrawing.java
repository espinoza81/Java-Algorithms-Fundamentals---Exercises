import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
      
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        draw(number, "*", "#");
    }

    private static void draw(int number, String signTop, String signBottom) {
      
        if(number == 1) {
            System.out.println(signTop);
            System.out.println(signBottom);
            return;
        }

        System.out.println(drawRow(number, signTop));

        draw(number-1, signTop, signBottom);

        System.out.println(drawRow(number, signBottom));
    }

    private static String drawRow(int number, String sign){
        //return sign.repeat(number); - не минава в judge
      
      String row = "";

        for(int i = 0; i < number; i++){
            row += sign;
        }

        return row;
    }
}
