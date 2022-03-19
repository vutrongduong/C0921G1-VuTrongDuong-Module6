package vn.codegym.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import vn.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class Facility {
    @Id
    @GeneratedValue(generator = "id_gen_facility")
    @GenericGenerator(name = "id_gen_facility", parameters =
    @org.hibernate.annotations.Parameter(name = "prefix", value = "DV-"), strategy = "vn.codegym.model.IdGenerator")
    private String facilityId;
    private String facilityName;
    private String facilityArea;
    private String facilityCost;
    private String facilityMaxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "facilityTypeId")
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloors;
    private Integer status;
    @OneToMany(mappedBy = "facility")
    @JsonBackReference
    private List<Contract> contract;

    public Facility() {
    }

    public Facility(String facilityId, String facilityName, String facilityArea, String facilityCost, String facilityMaxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors, Integer status, List<Contract> contract) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityArea = facilityArea;
        this.facilityCost = facilityCost;
        this.facilityMaxPeople = facilityMaxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.status = status;
        this.contract = contract;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(String facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(String facilityCost) {
        this.facilityCost = facilityCost;
    }

    public String getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(String facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}
