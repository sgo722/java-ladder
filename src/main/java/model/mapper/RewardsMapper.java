package model.mapper;

import model.dto.RewardDto;
import model.result.Rewards;

import java.util.ArrayList;
import java.util.List;

public class RewardsMapper {

    public List<RewardDto> toDto(Rewards rewards) {
        List<RewardDto> rewardDtos = new ArrayList<>();

        for(String reward : rewards.getRewards()) {
            rewardDtos.add(toDto(reward));
        }

        return rewardDtos;
    }

    private RewardDto toDto(String reward) {
        return new RewardDto(reward);
    }
}
