package view;

import model.dto.LineDto;
import model.dto.PersonNameDto;
import model.dto.RewardDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPersonNames(List<PersonNameDto> personNameDto) {
        System.out.println("사다리 결과");
        System.out.println();

        for (PersonNameDto personName : personNameDto) {
            System.out.print(String.format("%5s ", personName.getPersonName()));
        }
        System.out.println();
    }

    public void printLadder(List<LineDto> linesDtos) {
        StringBuilder sb = new StringBuilder();

        for(int lineIdx=0; lineIdx<linesDtos.size(); lineIdx++) {
            sb.append("     ");
            for(Boolean bridge : linesDtos.get(lineIdx).getBridges()){
                if(bridge){
                    sb.append("|-----");
                    continue;
                }
                sb.append("|     ");
            }
            sb.append("|");
            if(lineIdx != linesDtos.size() - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public void printResultTargetName(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public void printResultAll(Map<String, String> personNameToResult) {
        StringBuilder sb = new StringBuilder();
        for(String name : personNameToResult.keySet()) {
            sb.append(name);
            sb.append(" : ");
            sb.append(personNameToResult.get(name));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    public void printRewards(List<RewardDto> rewards) {
        for (RewardDto reward : rewards) {
            System.out.print(String.format("%5s ", reward.getReward()));
        }
        System.out.println();
    }
}
