package com.wasoko.tech.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TechDataStore {
    TechMembers techMembers;

    private List<TechMembers> techMembersList;

    public TechDataStore() {
        this.techMembersList = new ArrayList<>();
    }


    public TechMembers addTechMember(TechMembers techMembers1){
        techMembers1.setId(UUID.randomUUID().toString());
        this.techMembers=techMembers1;
        this.techMembersList.add(techMembers);
        return techMembers1;
    }


    public TechMembers getMember(String id){
       /* for (TechMembers members:techMembers
             ) {
            if(members.getId().equalsIgnoreCase(id)){
                return  members;
            }
        }
        //return  null;*/
return techMembersList.stream().filter(techMembers1 -> techMembers1.getId().equalsIgnoreCase(id)).findAny().orElse(null);

    }



    public TechMembers updateMember(TechMembers members1){
        for (TechMembers members: techMembersList) {
            if(members.getId().equalsIgnoreCase(members1.getId())){
                members.setName(members1.getName());
                members.setPosition(members1.getPosition());
                break;
            }
        }
        return  members1;
    }


    public List<TechMembers> getMembers() {
        return techMembersList;
    }
}
