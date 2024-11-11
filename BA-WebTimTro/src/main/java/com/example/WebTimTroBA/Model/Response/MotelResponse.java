package com.example.WebTimTroBA.Model.Response;

import com.example.WebTimTroBA.Model.DTO.FileDTO;
import com.example.WebTimTroBA.Model.Entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MotelResponse implements Comparable<MotelResponse>{

    private Integer id;

    private String title;

    private String houseNumber;

    private String ward;

    private String district;

    private String province;

    private Integer area;

    private Integer price;

    private String interior;

    private String type;

    private String detail;

    private String crateAt;

    private OwnerResponse owner;

    private String address;

    private String status;

    List<FileDTO> filesDTO;


    @Override
    public int compareTo(MotelResponse o) {
        return o.status.compareTo(this.status);
    }
}
