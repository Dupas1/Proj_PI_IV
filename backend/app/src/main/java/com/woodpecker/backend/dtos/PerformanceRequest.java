package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.Activity;
import com.woodpecker.backend.model.Memory;

public class PerformanceRequest {
    private Memory memory;
    private int overload;
    private Activity activity;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public int getOverload() {
        return overload;
    }

    public void setOverload(int overload) {
        this.overload = overload;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
