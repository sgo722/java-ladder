package view;

import model.dto.LineDto;
import model.dto.PersonNameDto;
import model.dto.RewardDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPersonNames(List<PersonNameDto> personNameDtos) {
        System.out.println("사다리 결과\n");
        System.out.println(buildPersonNameLine(personNameDtos));
    }

    private String buildPersonNameLine(List<PersonNameDto> personNameDtos) {
        StringBuilder sb = new StringBuilder();
        for (PersonNameDto dto : personNameDtos) {
            sb.append(String.format("%5s ", dto.getPersonName()));
        }
        return sb.toString();
    }

    public void printLadder(List<LineDto> lineDtos) {
        System.out.println(buildLadderString(lineDtos));
    }

    private String buildLadderString(List<LineDto> lineDtos) {
        StringBuilder sb = new StringBuilder();
        int lastLineIdx = lineDtos.size() - 1;

        for (int lind = 0; lind < lineDtos.size(); lind++) {
            sb.append(buildLineString(lineDtos.get(lind)));
            if (lind != lastLineIdx) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String buildLineString(LineDto lineDto) {
        StringBuilder sb = new StringBuilder("     ");
        for (Boolean bridge : lineDto.getBridges()) {
            sb.append(bridge ? "|-----" : "|     ");
        }
        sb.append("|");
        return sb.toString();
    }

    public void printRewards(List<RewardDto> rewards) {
        System.out.println(buildRewardLine(rewards));
    }

    private String buildRewardLine(List<RewardDto> rewards) {
        StringBuilder sb = new StringBuilder();
        for (RewardDto reward : rewards) {
            sb.append(String.format("%5s ", reward.getReward()));
        }
        return sb.toString();
    }

    public void printResultTargetName(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public void printResultAll(Map<String, String> personNameToResult) {
        System.out.println(buildResultAllText(personNameToResult));
    }

    private String buildResultAllText(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append(" : ")
                    .append(entry.getValue())
                    .append("\n");
        }
        if (!map.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1); // 마지막 줄 개행 제거
        }
        return sb.toString();
    }
}
