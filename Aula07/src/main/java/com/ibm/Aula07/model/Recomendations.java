package com.ibm.Aula07.model;
import java.util.List;

public class Recomendations {
    private String _id;
    private String _rev;
    private String candidate;
    private String email;
    private String skills;
    private String last_job;
    private List<Compatibility> role_compatibility;
    
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_rev() {
        return _rev;
    }
    public void set_rev(String _rev) {
        this._rev = _rev;
    }
    public String getCandidate() {
        return candidate;
    }
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getLast_job() {
        return last_job;
    }
    public void setLast_job(String last_job) {
        this.last_job = last_job;
    }
    public List<Compatibility> getRole_compatibility() {
        return role_compatibility;
    }
    public void setRole_compatibility(List<Compatibility> role_compatibility) {
        this.role_compatibility = role_compatibility;
    }

    
}
