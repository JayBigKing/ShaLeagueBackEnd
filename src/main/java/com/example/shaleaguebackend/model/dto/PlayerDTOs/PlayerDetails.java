package com.example.shaleaguebackend.model.dto.PlayerDTOs;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data

public class PlayerDetails {
    private PlayerWInLoseCountDTO playerWInLoseCountDTO;
    private PlayerRolesCountDTO playerLordCountDTO;
    private PlayerRolesCountDTO playerCourtierCountDTO;
    private PlayerRolesCountDTO playerRebelCountDTO;
    private PlayerRolesCountDTO playerTraitorCountDTO;

    //public Map<String,Object> map = new HashMap<>();
    public  Map<String,Object> getDetail(){
        Map<String,Object> map = new HashMap<>();
        double allWinProbability ;
        double allLoseProbability ;

        double lordWinProbability ;
        double lordLoseProbability ;

        double courtierWinProbability ;
        double courtierLoseProbability ;

        double rebelWinProbability ;
        double rebelLoseProbability ;

        double traitorWinProbability ;
        double traitorLoseProbability ;

        map.put("name",playerWInLoseCountDTO.getName());
        map.put("Pid",playerWInLoseCountDTO.getPid());
        if(playerWInLoseCountDTO.getTotal() != 0){
            allWinProbability = (double)playerWInLoseCountDTO.getTotalWin() / (double)playerWInLoseCountDTO.getTotal();
            allLoseProbability =(double) playerWInLoseCountDTO.getTotalLose() / (double)playerWInLoseCountDTO.getTotal();
        }else{
            allWinProbability = -1;
            allLoseProbability = -1;
        }
        map.put("allWinProbability",allWinProbability);
        map.put("allLoseProbability",allLoseProbability);

        if(playerLordCountDTO.getTotal() != 0 ){
            lordWinProbability = (double)playerLordCountDTO.getTotalRoleWin() / (double)playerLordCountDTO.getTotal();
            lordLoseProbability = (double)playerLordCountDTO.getTotalRoleLose() / (double)playerLordCountDTO.getTotal();
        }else{
            lordWinProbability = -1;
            lordLoseProbability = -1;
        }
        map.put("lordWinProbability",lordWinProbability);
        map.put("lordLoseProbability",lordLoseProbability);

        if(playerCourtierCountDTO.getTotal() != 0){
            courtierWinProbability = (double)playerCourtierCountDTO.getTotalRoleWin() / (double)playerCourtierCountDTO.getTotal();
            courtierLoseProbability = (double)playerCourtierCountDTO.getTotalRoleLose() / (double)playerCourtierCountDTO.getTotal();
        }else{
            courtierWinProbability = -1;
            courtierLoseProbability = -1;
        }
        map.put("courtierWinProbability",courtierWinProbability);
        map.put("courtierLoseProbability",courtierLoseProbability);

        if(playerRebelCountDTO.getTotal() != 0){
            rebelWinProbability = (double)playerRebelCountDTO.getTotalRoleWin() / (double)playerRebelCountDTO.getTotal();
            rebelLoseProbability = (double)playerRebelCountDTO.getTotalRoleLose() / (double)playerRebelCountDTO.getTotal();
        }else{
            rebelWinProbability = -1;
            rebelLoseProbability = -1;
        }
        map.put("rebelWinProbability",rebelWinProbability);
        map.put("rebelLoseProbability",rebelLoseProbability);

        if(playerTraitorCountDTO.getTotal() != 0){
            traitorWinProbability = (double)playerTraitorCountDTO.getTotalRoleWin() / (double)playerTraitorCountDTO.getTotal();
            traitorLoseProbability = (double)playerTraitorCountDTO.getTotalRoleLose() / (double)playerTraitorCountDTO.getTotal();
        }else{
            traitorWinProbability = traitorLoseProbability = -1;
        }
        map.put("traitorWinProbability",traitorWinProbability);
        map.put("traitorLoseProbability",traitorLoseProbability);

        return map;


    }
}
