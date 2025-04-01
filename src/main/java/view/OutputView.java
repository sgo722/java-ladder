package view;

import java.util.List;

public class OutputView {

    public void printPersonNames(List<String> personNames) {
        for (String personName : personNames) {
            System.out.print(String.format("%5s ", personName));
        }
        System.out.println();
    }

    public void printSadari(List<Boolean> points) {
        System.out.print("     ");
        for(Boolean point : points) {
            if(point == true) {
                System.out.print("|-----");
            }
            if(point == false){
                System.out.print("|     ");
            }
        }
        System.out.println("|");
    }
}
