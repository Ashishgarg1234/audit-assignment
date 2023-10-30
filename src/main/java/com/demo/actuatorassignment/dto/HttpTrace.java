package com.demo.actuatorassignment.dto;
import java.util.ArrayList;
import java.util.List;

public class HttpTrace {
    private List<Trace> traces = new ArrayList<Trace>();
    public List<Trace> getTraces() {
        return traces;
    }
    public void setTraces(List<Trace> traces) {
        this.traces = traces;
    }
}
