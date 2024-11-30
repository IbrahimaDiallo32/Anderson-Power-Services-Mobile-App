package com.aps.restfulbackend.Dto.Responses;

import com.aps.restfulbackend.Models.Job;
import com.aps.restfulbackend.Models.Representative;

public class JobBundle {
    private Job job;
    private Representative installRep;
    private Representative salesRep;

    public JobBundle(Job job, Representative installRep, Representative salesRep) {
        this.job = job;
        this.installRep = installRep;
        this.salesRep = salesRep;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Representative getInstallRep() {
        return installRep;
    }

    public void setInstallRep(Representative installRep) {
        this.installRep = installRep;
    }

    public Representative getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Representative salesRep) {
        this.salesRep = salesRep;
    }
}
