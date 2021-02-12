package com.wasoko.tech.api.controller;

import com.wasoko.tech.api.model.TechDataStore;
import com.wasoko.tech.api.model.TechMembers;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
public class MemberContoller {
   private final TechDataStore techDataStore;

    public MemberContoller() {
        techDataStore = new TechDataStore();
    }

    @PostMapping("/member")
public TechMembers addMember(@RequestBody  TechMembers techMembers){
return  techDataStore.addTechMember(techMembers);
}



    @GetMapping("/member/{id}")
    public TechMembers getMemberById(@PathVariable("memberid") String id){
        return techDataStore.getMember(id);
    }

@PutMapping("/updateMember")
    public TechMembers updateTechMembers(@RequestBody  TechMembers techMembers){
        return techDataStore.updateMember(techMembers);
}

@GetMapping("/getMembers")
    public List<TechMembers> getTechMembers(){
        return techDataStore.getMembers();
}


}
