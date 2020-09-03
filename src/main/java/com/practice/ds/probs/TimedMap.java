package com.practice.ds.probs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * set(key, value, time): sets key to value for t = time.
 * get(key, time): gets the key at t = time. The map should work like this. If we set a key at a particular time,
 * it will maintain that value forever or until it gets set at a later time.
 * In other words, when we get a key at a time, it should return the value that was set for that key set
 * at the most recent time.
 */
public class TimedMap {
    @AllArgsConstructor
    @Getter
    @Setter
    static class TimedData {
        int time;
        int data;
    }

    Map<Integer, List<TimedData>> timedDataMap;

    public TimedMap() {
        this.timedDataMap = new HashMap<>();
    }

    public void setData(int key, int val, int time) {
        List<TimedData> dataList = timedDataMap.get(key);
        if (dataList == null)
            dataList = new ArrayList<>();
        for (TimedData data : dataList) {
            if (data.getTime() == time) {
                data.setData(val);
                return;
            }
        }
        TimedData timedData = new TimedData(time, val);
        dataList.add(timedData);
        dataList = dataList.stream().sorted(Comparator.comparing(TimedData::getTime)).collect(Collectors.toList());
        timedDataMap.put(key, dataList);
    }

    public Integer getData(int key, int time) {
        List<TimedData> dataList = timedDataMap.get(key);
        if (dataList == null || dataList.isEmpty())
            return null;
        TimedData prev = null;
        for (TimedData data : dataList) {
            if (data.getTime() > time)
                break;
            prev = data;
        }
        if(prev == null)
            return null;
        return prev.getData();
    }
}
