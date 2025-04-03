package view;

import model.dto.LineDto;
import model.dto.PersonNameDto;

import java.util.List;

public class OutputView {

    public void printPersonNames(List<PersonNameDto> personNameDto) {
        for (PersonNameDto personName : personNameDto) {
            System.out.print(String.format("%5s ", personName.getPersonName()));
        }
        System.out.println();
    }

    public void printLadder(List<LineDto> linesDtos) {
        StringBuilder sb = new StringBuilder();

        for(LineDto lineDto : linesDtos){
            sb.append("     ");
            for(Boolean bridge : lineDto.getBridges()){
                if(bridge){
                    sb.append("|-----");
                }
                if(!bridge){
                    sb.append("|     ");
                }
            }
            sb.append("|");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
