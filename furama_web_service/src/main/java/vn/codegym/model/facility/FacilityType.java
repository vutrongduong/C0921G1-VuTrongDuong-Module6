package vn.codegym.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityTypeId;
    private String facilityTypeName;
    @JsonBackReference
    @OneToMany(mappedBy = "facilityType")
    List<Facility> facilityList;

    public FacilityType() {
    }

    public FacilityType(Long facilityTypeId, String facilityTypeName, List<Facility> facilityList) {
        this.facilityTypeId = facilityTypeId;
        this.facilityTypeName = facilityTypeName;
        this.facilityList = facilityList;
    }

    public Long getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Long facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
