package com.example.mid_exam_013.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prime {
    // Create Map
    private Map<Integer,Boolean> AllPrimesCheck = new HashMap<>();

    //CheckPrime
    public boolean isPrimeCheck(int num){
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void setAllPrimesCheck(int num,boolean flag){
        AllPrimesCheck.put(num,flag);
    }
    public int getCountAllIsPrime(){
        int count = 0;
        for (Map.Entry<Integer, Boolean> entry : AllPrimesCheck.entrySet()) {
            if(entry.getValue() == true){
                count++;
            }
        }
        return count;
    }
    public Map<Integer,Boolean> getAllPrimesCheck(){
        return AllPrimesCheck;
    }
}
